import java.util.ArrayList;

/**
	Describes a board
*/
public class Board
{
	/**
		Constructs a blank board of certain size
		@param horizontalSize the number of columns
		@param verticalSize the number of rows
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
		int verticalSizeOfPentomino = aPentomino.height();
		int horizontalSizeOfPentomino = aPentomino.width();
		
		int calculatedX = x;
		int calculatedY = y;
		// Lets look for the first filled field in the pentomino and shift the coordinates if necessary
		blankSearch:
		for (int i = 0; i < aPentomino.height(); i++) {
			for (int j = 0; j < aPentomino.width(); j++) {
				if (aPentomino.isFilled(j, i)) {
					calculatedX = x - j;
					calculatedY = y - i;
					break blankSearch;
				}
			}
		}
		
		// Lets check if it's in the board's bounds
		if (horizontalSizeOfPentomino + calculatedX > grid[0].length ||
				verticalSizeOfPentomino + calculatedY > grid.length ||
				calculatedX < 0 || calculatedY < 0)
			return false;
		
		// Lets check if it fits on the board
		for (int i = 0; i < verticalSizeOfPentomino; i++)
		{
			for (int k = 0; k < horizontalSizeOfPentomino; k++)
			{
				if (aPentomino.isFilled(k, i) && isFilled(k + calculatedX, i + calculatedY))
					return false; // If the field on board is already filled
			}
		}
		
		// Lets add the pentomino to the list and get its index
		pentominoes.add(aPentomino);
		
		// If everything is ok, then we place the pentomino		
		for (int i = 0; i < verticalSizeOfPentomino; i++)
		{
			for (int k = 0; k < horizontalSizeOfPentomino; k++)
			{
				if (aPentomino.isFilled(k, i))
					fill(aPentomino.getId(), k + calculatedX, i + calculatedY);
			}
		}
		
		
		// Lets search for the next blank spot
		searchNextBlankField();
		
		return true;
	}
	
	private void searchNextBlankField() {
		for (int i = nextBlankY; i < grid.length; i++) {
			for (int j = nextBlankX; j < grid[0].length; j++) {
				if (!isFilled(j, i)) {
					nextBlankY = i;
					nextBlankX = j;
					return;
				}
			}
			nextBlankX = 0;
		}
	}
	
	public int getNextBlankX() {
		return nextBlankX;
	}

	public int getNextBlankY() {
		return nextBlankY;
	}
	
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
		Sets state of field at x,y
		@param x the x coordinate
		@param y the y coordinate
	*/
	private void fill(int p, int x, int y)
	{
		if (grid[y][x] == 0) { // If not filled, then fill
			grid[y][x] = p;
			return;
		}
		throw new IllegalStateException(); // There is already something in the place!
	}
	
	public void removePentomino(Pentomino aPentomino)
	{
		int pentominoId = aPentomino.getId();
		for (int[] line : grid) {
			for (int i : line) {
				if (i == pentominoId)
					i = 0; // TODO: We can optimize a lot here!
			}
		}
	}
	
	/**
		Returns the state of field at x,y
		@param x the x coordinate
		@param x the y coordinate
		@return the state of field
	*/
	public boolean isFilled(int x, int y)
	{
		if (grid[y][x] == 0) {
			return false;
		}
		return true;
	}
	
	/**
		Returns textual representation of the board
		@return textual representation of board
	*/
	public String toString()
	{
		// I just copied the code from Pentomio's toString()
		char[] text = new char[grid.length * (grid[0].length + 1)]; // that is the length of the value we will return. The "+ 1" is for the new line chars.
		int i = 0;
		for (int[] gridLine : grid)
		{
			for (int field : gridLine)
			{
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
		text[i - 1] = 0; // we don't need the last new line char, aik!
		return new String(text);
	}
	
	public void clear() {
		nextBlankX = 0;
		nextBlankY = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = 0;
			}
		}
		pentominoes.clear();
	}
	
	private int nextBlankX = 0;
	private int nextBlankY = 0;
	private int[][] grid; // The state of the board
	private ArrayList<Pentomino> pentominoes = new ArrayList<Pentomino>(); // All pentominoes on the board
}