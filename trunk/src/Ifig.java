


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
	 * gets current orientation of pentomino could go from 0 to 3, used to avoid unnecessary
	 * rotations
	 * 
	 */
	int getOrientation();
	/**
	 * rotates the pentomino clockwise and gets new coordinates but out of bounds
	 */
	void startRotateClockwise();
	/**
	 * rotates the pentomino counterclockwise and gets new coordinates but out of bounds
	 */
	void startRotateCounterClockwise();
	/**
	 * saves x1 and y1 value of pentomino(coordinates), main values for putting pentomino back to main position
	 */
	void saveCurrentCor ();
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
	/**
	 * calls all methods needed to get pentomino rotated clockwise in good position
	 */
	void rotateClockwise();
	/**
	 * calls all methods needed to get pentomino rotated counterclockwise in good position
	 */
	void rotateCounterClockwise();
	/**
	 * returns the int representing a certain pentomino
	 */
	int getName();
	/**
	 * returns a random pentomino
	 * @param a array of pentominoes
	 * @return a random pentomino
	 */
	Figure randomPicker(Figure [] a);
	
}
