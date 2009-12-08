
/**
 * 
 * @author Rob van den Oever and José Sue Smith
 *
 */


public class Game
{
	private int score;
	private int level;
	private int adjustScore;
	private int addScore;
	private int counter;
	private int deletedLines; //to be added in initialize, next to counter
		
	public Game()
	{
		score = 0;
		level = 1;				
	}	
	
	public void initialize(int aCounter)
	{
		counter = aCounter;
		adding();
		increaseScore();
		increaseLevel();
		
	}
		
	public void adding()
	{
		adjustScore = (level - 1) *10;;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void increaseScore()
	{
		//addScore = Math.pow(deletedLines, deletedLines) * (10 + adjustScore)
		//to change from double to int
		score = score + addScore;
	}
	
	public void increaseLevel()
	{
		level = 1 + (counter / 10);		
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void reset()
	{
		score = 0;
		level = 1;
	}
}
