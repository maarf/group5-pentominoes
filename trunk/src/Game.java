


public class Game extends BoardOperations implements IGame
{
	private int counter;
	private int score;
	private int level;
	private int adjustScore;
	
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
		score = Counter() * (10 + adjustScore);
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
