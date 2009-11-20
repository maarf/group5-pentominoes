

public interface IGame 
{
	/**
	 * Adding makes sure that everytime we level-up in the game the number of points
	 *  you get per line is also leveled up!
	 */
	void adding();
	
	/**
	 * returns the score
	 * @return
	 */
	int getScore();
	
	/**
	 * Increases the score everytime you get a full line that is deleted
	 */
	void increaseScore();
	
	/**
	 * Increases the level every n-lines that are deleted
	 */
	void increaseLevel();
	
	/**
	 * returns the level!
	 * @return
	 */
	int getLevel();
	
}
