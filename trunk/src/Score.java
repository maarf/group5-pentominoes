
/**
 * 
 * @author Rob van den Oever and José Sue Smith
 *
 */


public class Score
{
	private int score;
	private int lastTime = 0;

	public Score() {
		score = 0;
	}
			
	public int getScore()
	{
		return score;
	}
	
	public void increaseScore(int totalLinesRemoved, int linesJustRemoved)
	{
		if (lastTime != totalLinesRemoved) {
			score += Math.pow(linesJustRemoved, linesJustRemoved) * (10 + ((getLevel() - 1) * 10));
		}
		lastTime = totalLinesRemoved;
	}
	
	public int getLevel()
	{
		return 1 + (lastTime / 10);
	}
	
}
