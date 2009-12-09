
/**
 * 
 * @author Rob van den Oever, José Sue Smith, Leoni Haagmans and Martins Spilners
 *
 */


public class Score
{
	private int score;
	private int lastTime = 0;

	/**
	 * Constructor of Score which sets the score to zero
	 */
	public Score() {
		score = 0;
	}
	
	/**
	 * returns score
	 * @return score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Increases the score
	 * @param totalLinesRemoved lines removed on board in total
	 * @param linesJustRemoved lines removed in the most recent action
	 */
	public void increaseScore(int totalLinesRemoved, int linesJustRemoved)
	{
		if (lastTime != totalLinesRemoved) {
			score += Math.pow(linesJustRemoved, linesJustRemoved) * (10 + ((getLevel() - 1) * 10));
		}
		lastTime = totalLinesRemoved;
	}
	
	/**
	 * returns the level
	 * @return level
	 */
	public int getLevel()
	{
		return 1 + (lastTime / 2);
	}
	
}
