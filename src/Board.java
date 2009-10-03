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
		grid = new boolean[verticalSize][horizontalSize];
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
		int verticalSizeOfPentomino = aPentomino.verticalSize();
		int horizontalSizeOfPentomino = aPentomino.horizontalSize();
		
		// Lets check if it's in the board's bounds
		if (horizontalSizeOfPentomino + x > grid[0].length || verticalSizeOfPentomino + y > grid.length)
			return false;
		
		// Lets check if it fits on the board
		for (int i = 0; i < verticalSizeOfPentomino; i++)
		{
			for (int k = 0; k < horizontalSizeOfPentomino; k++)
			{
				if (aPentomino.isFilled(k, i) && isFilled(k + x, i + y))
					return false; // If the field on board is already filled
			}
		}
		
		// If everything is ok, then we place the pentomino		
		for (int i = 0; i < verticalSizeOfPentomino; i++)
		{
			for (int k = 0; k < horizontalSizeOfPentomino; k++)
			{
				if (aPentomino.isFilled(k, i))
					fill(k + x, i + y);
			}
		}
		
		pentominoes.add(aPentomino); // TODO: it actually don't know where the pentominoes are located at, so there is no big use of this
		
		return true;
	}
	
	/**
		Sets state of field at x,y
		@param x the x coordinate
		@param y the y coordinate
	*/
	private void fill(int x, int y)
	{
		if (!grid[y][x]) { // If not filled, then fill
			grid[y][x] = true;
			return;
		}
		throw new IllegalStateException(); // There is already something in the place!
	}
	
	/**
		Returns the state of field at x,y
		@param x the x coordinate
		@param x the y coordinate
		@return the state of field
	*/
	public boolean isFilled(int x, int y)
	{
		if (grid[y][x]) {
			return true;
		}
		return false;
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
		for (boolean[] gridLine : grid)
		{
			for (boolean field : gridLine)
			{
				if (field) {
					text[i] = '#';
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
	
	private boolean[][] grid; // The state of the board
	private ArrayList<Pentomino> pentominoes = new ArrayList<Pentomino>(); // All pentominoes on the board
}