import java.util.ArrayList;

/**
	Describes pentomino and allows to do some manipulations on it.
*/
public class Pentomino
{
	
	/**
	 * Constructs pentomino with from predefined two-dimensional boolean array
	 * @param aState two-dimensional boolean array which represents the filled and blank fields
	 */
	public Pentomino(boolean[][] aState){
		state = aState;
	}
	
	/**
		Constructs the pentomino object from a string.
		@param aTextualRepresentation a textual representation of pentomino (e.g. ".#.\n###\n.#.")
	*/
	public Pentomino(String aTextualRepresentation)
	{
		// First, lets split the input in lines so we get a nice array of strings.
		String[] lines = aTextualRepresentation.split("\n"); // the \n is the "new line" character
		
		// Now lets initialize the grid array with the proper size.
		// lines.length is the number of lines we've got.
		// line[0].length() is the length of the first line. Right?
		state = new boolean[lines.length][lines[0].length()];
		
		// So lets iterate through the lines.
		int i = 0;
		int k = 0;
		// Lets take line by line
		for (String aLine : lines)
		{
			// Lets dive into the line itself. We divide it into characters! So we take char by char.
			for (char aChar : aLine.toCharArray())
			{
				// And this is the part where we fill the "grid", yeah.
				if (aChar == '#')
					state[i][k] = true; // if the according char is "#", than the field is filled
				else
					state[i][k] = false; // or else it's is blank
				
				k++;
			}
			k = 0; // don't forget to keep the right count!
			i++;
		}
		mutations = generateMutations();
	}
	
	private Object[] generateMutations() {
		ArrayList<Pentomino> mutationsList = new ArrayList<Pentomino>();

		// Lets get all the possible mutations, there could be some duplicates.
		boolean[][][] mutationStates = new boolean[5][][]; // 3-dimensional arrays is crazy stuff, ummm...
		mutationStates[0] = rotateMatrix(state);
		mutationStates[1] = rotateMatrix(mutationStates[0]); 
		mutationStates[2] = rotateMatrix(mutationStates[1]);
		mutationStates[3] = flipMatrixVertically(state);
		mutationStates[4] = flipMatrixVertically(mutationStates[1]);
		
		boolean[][][] uniqueMutationStates = new boolean[6][][];
		
		// Lets add the "basic" state as one of the mutations, too.
		uniqueMutationStates[0] = state;
		int uniqueStatesCount = 1;
		mutationsList.add(new Pentomino(state));
		
		for (boolean[][] aState : mutationStates) {
			// Lets assume the mutation state is unique
			boolean unique = true;
			// Check against all known unique states
			for (int i = 0; i < uniqueStatesCount; i++) {
				if (compareMatrixes(aState, uniqueMutationStates[i])) {
					// If the states are copies, then the new state is a duplicate
					unique = false;
					break;
				}
			}
			// If the state is unique, add a mutation pentomino
			if (unique) {
				uniqueMutationStates[uniqueStatesCount] = aState;
				uniqueStatesCount++;
				mutationsList.add(new Pentomino(aState));				
			}
		}
		return mutationsList.toArray();
	}
	
	/**
	 * Rotates the two-dimensional array by 90 degrees clockwise
	 * @param original the two-dimensional array
	 * @return two-dimensional array rotated by 90 degrees
	 */
	private static boolean[][] rotateMatrix(boolean[][] original)
	{
		boolean[][] rotated = new boolean[original[0].length][original.length];
		for (int i = 0; i < original[0].length; i++) {
			for (int j = 0; j < original.length; j++) {
				rotated[i][j] = original[original.length - j - 1][i];
			}
		}
		return rotated;
	}
	
	/**
	 * Flips two-dimensional array vertically
	 * @param original the two-dimensional array
	 * @return two-dimensional array flipped vertically
	 */
	private static boolean[][] flipMatrixVertically(boolean[][] original) {
		boolean[][] flipped = new boolean[original.length][original[0].length];
		for (int i = 0; i < original.length; i++) {
			flipped[i] = original[original.length - 1 - i];
		}
		return flipped;
	}
	
	/**
	 * Compares two two-dimensional arrays
	 * @param leftMatrix first array
	 * @param rightMatrix second array
	 * @return true if the arrays are the same, false if not
	 */
	private static boolean compareMatrixes(boolean[][] leftMatrix, boolean[][] rightMatrix) {
		if (leftMatrix.length != rightMatrix.length || leftMatrix[0].length != rightMatrix[0].length)
			return false;
		
		for (int i = 0; i < leftMatrix.length; i++) {
			for (int j = 0; j < leftMatrix[0].length; j++) {
				if (leftMatrix[i][j] != rightMatrix[i][j])
					return false;
			}
		}
		return true;
	}
	
	/**
		Returns the state of field at x,y
		@param x the x coordinate
		@param x the y coordinate
		@return the state of field
	*/
	public boolean isFilled(int x, int y)
	{
		if (state[y][x])
			return true;
		return false;
	}
	
	/**
		Returns the count of fields in a column
		@return the count of fields in a column
	*/
	public int height()
	{
		return state.length;
	}
	
	/**
		Returns the count of fields in a row
		@return the count of fields in a row
	*/
	public int width()
	{
		return state[0].length;
	}
	
	/**
	 * Returns all the mutations as an array of pentominoes
	 * @return array of pentominoes
	 */
	public Object[] getMutations() {
		return mutations;
	}
	
	/**
		Returns a string representation of the object.
		@return a string
	*/
	public String toString()
	{
		// This is easy, just iterate through the array. Massssssive!
		// But I belive there should be an easier way how to do this.
		char[] text = new char[state.length * (state[0].length + 1)]; // that is the length of the value we will return. The "+ 1" is for the new line chars.
		int i = 0;
		for (boolean[] gridLine : state)
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
	
	private Object[] mutations;
	private boolean[][] state;
}