
/**
 * 
 * @author Rob van den Oever and José Sue Smith
 *
 */


public class Game extends BoardOperations implements IGame
{
	private int multiplier;
	private int score;
	private int level;
	private int adjustScore;
	private int addScore;
	
	public Game()
	{
		score = 0;
		level = 1;
		
	}
	
		
	public void adding()
	{
		adjustScore = (level - 1) *5;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void increaseScore()
	{
		multiplier = BoardOperations.numberofFullLines();
		addScore = (Counter() - (level-1) * 10) * (10 + adjustScore)* multiplier;
		score = score + addScore;
	}
	
	public void increaseLevel()
	{
		level = 1 + (Counter() / 10);
		
	}
	
	public int getLevel()
	{
		return level;
	}
}
