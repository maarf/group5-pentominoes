import java.util.ArrayList;

/**
 * A board describes a single two-dimensional space with defined width and height.
 * Board can hold some number of pentominoes or other figures. It is responsible for
 * placing these figures if they fit.
 * 
 * 15/09/2009
 * 
 * @author Martins Spilners, Roland Gerits, Leoni Haagmans
 * @version 0.1
 */

public class Board
{

	private int nextBlankX = 0;
	private int nextBlankY = 0;
	
	/**
	 * This two-dimensional array of integers represents the state of the board.
	 */
	private int[][] grid;
	
	/**
	 * Holds all pentominoes that are on the board.
	 */
	private ArrayList<Pentomino> pentominoes = new ArrayList<Pentomino>();

	
	/**
	 * Constructs a blank board of certain size
	 * @param horizontalSize the number of columns
	 * @param verticalSize the number of rows
	 */
	public Board(int horizontalSize, int verticalSize)
	{
		grid = new int[verticalSize][horizontalSize];
	}
	
	
	/**
		Adds a pentomino to the board at x,y coordinates
		@param aPentomino pentomino to be added
		@param x the x coordiante where to place the pentomino on the board
		@param y the y coordinate where to place the pentomino on the board
		@return returns true if pentomino is added successfully, otherwise false
	*/
	public boolean addPentomino(Pentomino aPentomino, int x, int y)
	{
		
		// We don't want to place a blank field on x,y so we shift the pentomino in a way
		// that there is a filled field on the pentomino to be placed at x,y.
		int calculatedX = x;
		int calculatedY = y;
		// Lets look for the first filled field in the pentomino.
		filledFieldSearch:
		for (int i = 0; i < aPentomino.height(); i++) {
			for (int j = 0; j < aPentomino.width(); j++) {
				// Lets change the x and y coordinates
				if (aPentomino.isFilled(j, i)) {
					calculatedX = x - j;
					calculatedY = y - i;
					break filledFieldSearch;
				}
			}
		}
		
		// Lets check whether pentomino fits in the board's bounds.
		int verticalSizeOfPentomino = aPentomino.height();
		int horizontalSizeOfPentomino = aPentomino.width();
		if (horizontalSizeOfPentomino + calculatedX > grid[0].length ||
				verticalSizeOfPentomino + calculatedY > grid.length ||
				calculatedX < 0 || calculatedY < 0)
			return false;
		
		// Lets check whether the pentomino fits on the board and does not overlap
		// something else.
		for (int i = 0; i < verticalSizeOfPentomino; i++)
		{
			for (int k = 0; k < horizontalSizeOfPentomino; k++)
			{
				if (aPentomino.isFilled(k, i) && isFilled(k + calculatedX, i + calculatedY))
					return false; // If the field on board is already filled.
			}
		}
				
		// If everything is ok, then we place the pentomino		
		for (int i = 0; i < verticalSizeOfPentomino; i++)
		{
			for (int k = 0; k < horizontalSizeOfPentomino; k++)
			{
				if (aPentomino.isFilled(k, i))
					fill(aPentomino.getId(), k + calculatedX, i + calculatedY);
			}
		}
		
		// Lets add the pentomino to the list
		pentominoes.add(aPentomino);
		
		// Lets search for the next blank spot
		searchNextBlankField();
		
		return true;
	}
	
	
	/**
	 * Looks for the first blank field on the board.
	 */
	private void searchNextBlankField() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!isFilled(j, i)) {
					nextBlankY = i;
					nextBlankX = j;
					return;
				}
			}
		}
	}
	
	
	/**
	 * Getter for the next blank field's X coordinate.
	 * @return next blank fields x coordinate
	 */
	public int getNextBlankX() {
		return nextBlankX;
	}
	

	/**
	 * Getter for the next blank fields Y coordinate.
	 * @return next blank fields y coordinate
	 */
	public int getNextBlankY() {
		return nextBlankY;
	}
	
	
	/**
	 * Looks wether there are any blank spots on the board.
	 * If there is none then the board is "solved".
	 * @return returns true if board is completely filled, false if not
	 */
	public boolean isSolved() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Sets state of field at x,y.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	private void fill(int p, int x, int y)
	{
		// TODO: We need a better way to represent which pentomino belongs to that field.
		// The integer is not the right thing. Maybe we want to put multiple mutations
		// of the same pentomino, what then? They will look the same.
		if (grid[y][x] == 0) { // If not filled, then fill
			grid[y][x] = p;
			return;
		}
		throw new IllegalStateException(); // There is already something in the place!
	}
	
	
	/**
	 * Removes pentomino from the board.
	 * @param aPentomino pentomino to be removed
	 */
	public void removePentomino(Pentomino aPentomino)
	{
		// This searches for all the occurrences of pentominoes id on the board and resets
		// those fields as zeros.
		int pentominoId = aPentomino.getId();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == pentominoId) {
					grid[i][j] = 0;
				}
			}
		}
		
		// The board has changed so we need to update the next blank field's coordinates.
		searchNextBlankField();
	}
	
	
	/**
	 * Returns the state of field at x,y
	 * @param x the x coordinate
	 * @param x the y coordinate
	 * @return true if field if filled, false if not
	 */
	public boolean isFilled(int x, int y)
	{
		if (grid[y][x] == 0) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Returns textual representation of the board
	 * @return textual representation of board
	 */
	public String toString()
	{
		// I just copied the code from Pentomio's toString()
		char[] text = new char[grid.length * (grid[0].length + 1)];
		// That is the length of the value we will return. The "+ 1" is for the new
		// line chars.
		
		int i = 0;
		for (int[] gridLine : grid) {
			for (int field : gridLine) {
				if (field != 0) {
					text[i] = (char) (field + '0');
				} else {
					text[i] = '.';
				}
				i++;
			}
			text[i] = '\n';
			i++;
		}
		
		text[i - 1] = 0; // We don't need the last new line char.
		
		return new String(text);
	}
	
	
	/**
	 * Clears the board by erasing state of all fields. 
	 */
	public void clear()
	{
		nextBlankX = 0;
		nextBlankY = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = 0;
			}
		}
		
		pentominoes.clear();
	}
	
}