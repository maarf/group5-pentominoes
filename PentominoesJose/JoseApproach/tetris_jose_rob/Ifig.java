package tetris_jose_rob;
/**
 * interface of class figure for pentomino and rotations
 * 
 * @author Jose Sue Smith, Rob van den Oever
 *
 */
public interface Ifig 
{
	/**
	 * initialize a pentomino
	 */
	void initialize(int type);
	/**
	 * rotates the pentomino clockwise and saves new coordinates
	 */
	void rotateClockwise(Figure a);
	/**
	 * rotates the pentomino counterclockwise and saves new coordinates
	 */
	void rotateCounterClockwise(Figure a);
	/**
	 * get x1 value of pentomino
	 */
	int getXCurrent ();
	/**
	 * get y1 value of pentomino
	 */
	int getYCurrent ();
	/**
	 * Calculates the position of the X and Y in relation to X1 and Y1 so we can use this information
	 * to put the pentomino back to the original position 
	 */
	void difference();
	/**
	 * put X1 and Y1 back to original location, which was saved in current location
	 */
	void putBack();
	/**
	 * translate other pieces of pentomino using the difference
	 */
	void translate();
	
}
