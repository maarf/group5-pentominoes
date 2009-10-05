import java.util.ArrayList;

/**
	Describes pentomino and allows to do some manipulations on it.
*/
public class Pentomino
{
	/**
		Constructs the pentomino object with some stuff.
		@param aTextualRepresentation a textual representation of pentomino (e.g. ".#.\n###\n.#.")
	*/
	public Pentomino(String aTextualRepresentation)
	{
		// First, lets split the input in lines so we get a nice array of strings.
		String[] lines = aTextualRepresentation.split("\n"); // the \n is the "new line" character
		
		// Now lets initialize the grid array with the propper size.
		// lines.length is the number of lines we've got.
		// line[0].length() is the length of the first line. Right?
		grid = new boolean[lines.length][lines[0].length()];
		
		// So lets iterate through the lines. The "for each" loops is a nice thing to for that.
		// You can read more about for each loops here: http://java.sun.com/j2se/1.5.0/docs/guide/language/foreach.html
		int i = 0;
		int k = 0;
		// Lets take line by line
		for (String aLine : lines)
		{
			// Lets dive into the line itself. We devide it into characters! So we take char by char.
			for (char aChar : aLine.toCharArray())
			{
				// And this is the part where we fill the "grid", yeah.
				if (aChar == '#')
					grid[i][k] = true; // if the according char is "#", than the field is filled
				else
					grid[i][k] = false; // or else it's is blank
				
				k++;
			}
			k = 0; // don't forget to keep the right count!
			i++;
		}
	}
	
	/**
	 * Constructs pentomino with all the mutations
	 * @param aTextualRepresentation
	 * @param rotations
	 */
	public Pentomino(String aTextualRepresentation, String[] someMutations){
		this(aTextualRepresentation);
		mutations = new ArrayList<Pentomino>();
		for(String pent : someMutations) {
			mutations.add(new Pentomino(pent));
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
		if (grid[y][x])
			return true;
		return false;
	}
	
	/**
		Returns the count of fields in a column
		@return the count of fields in a column
	*/
	public int verticalSize()
	{
		return grid.length;
	}
	
	/**
		Returns the count of fields in a row
		@return the count of fields in a row
	*/
	public int horizontalSize()
	{
		return grid[0].length;
	}
	
	/**
		Returns a string representation of the object.
		@return a string
	*/
	public String toString()
	{
		// This is easy, just iterate through the array. Massssssive!
		// But I belive there should be an easier way how to do this.
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
	
	private ArrayList<Pentomino> mutations;
	private boolean[][] grid;
}