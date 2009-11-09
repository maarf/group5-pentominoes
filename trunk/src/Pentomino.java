

import java.util.ArrayList;

/**
 * Describes pentomino and allows to do some manipulations on it.
 * Once the pentomino is initialized, it generates all the rotations and flips.
 *
 * 15/09/2009
 *
 * @author Martins Spilners, Roland Gerits, Leoni Haagmans
 * @version 0.1
 */

public class Pentomino
{

	/**
	 * This two-dimensional array of booleans represents the state of the pentomino.
	 */
	private boolean[][] state;

    public boolean[][] getState() {
        return state;
    }

	/**
	 * This represents the kind of the pentomino.
	 * When the pentomino is initialized this id is assigned for the pentomino's mutations
	 * too, so we can easily check whether they are basically the same pentominoes.
	 */
	private int id;

	/**
	 * Holds all the mutations of pentomino.
	 * Note: for mutations themselves this may be blank because otherwise we can run into
	 * infinite loop while trying to generete mutations for mutations for mutations and
	 * so on.
	 */
	private Object[] mutations;


	/**
	 * Constructs pentomino from predefined two-dimensional boolean array
	 * Note: this constructor _does not_ generate mutations.
	 * @param aState two-dimensional boolean array which represents the filled and blank fields
	 * @param anId some id of the pentomino
	 */
	public Pentomino(boolean[][] aState, int anId){
		state = aState;
		id = anId;
	}


	/**
	 * Constructs a pentomino object from a string.
	 * This constructor also generates all the mutations of the pentomino.
	 * @param aTextualRepresentation a textual representation of pentomino (e.g. ".#.\n###\n.#.")
	 */
	public Pentomino(String aTextualRepresentation, int anId)
	{
		id = anId;

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
					// If the according char is "#", than the field is filled.
					state[i][k] = true;
				else
					// Or else it's is blank.
					state[i][k] = false;

				k++;
			}
			k = 0; // Don't forget to keep the right count!
			i++;
		}

		// Lets generate mutations.
		mutations = generateMutations();
	}


	/**
	 * Generates all the rotations and flips of the pentomino.
	 * @return array of pentominoes
	 */
	private Object[] generateMutations() {
		ArrayList<Pentomino> mutationsList = new ArrayList<Pentomino>();

		// Lets get all the possible mutations, there could be some duplicates.
		boolean[][][] mutationStates = new boolean[7][][];
		// 3-dimensional arrays is not the nicest thing. Anyway...
		mutationStates[0] = rotateMatrix(state);
		mutationStates[1] = rotateMatrix(mutationStates[0]);
		mutationStates[2] = rotateMatrix(mutationStates[1]);
		mutationStates[3] = flipMatrixVertically(state);
		mutationStates[4] = flipMatrixVertically(mutationStates[1]);
		mutationStates[5] = flipMatrixVertically(mutationStates[0]);
		mutationStates[6] = flipMatrixVertically(mutationStates[2]);

		boolean[][][] uniqueMutationStates = new boolean[8][][];

		// Lets add the "basic" state as one of the mutations, too.
		uniqueMutationStates[0] = state;
		int uniqueStatesCount = 1;
		mutationsList.add(new Pentomino(state, id));

		for (boolean[][] aState : mutationStates) {
			// Lets assume the mutation state is unique.
			boolean unique = true;
			// Check against all known unique states.
			for (int i = 0; i < uniqueStatesCount; i++) {
				if (compareMatrixes(aState, uniqueMutationStates[i])) {
					// If the states are copies, then the new state is a duplicate.
					unique = false;
					break;
				}
			}
			// If the state is unique, add a mutation pentomino.
			if (unique) {
				uniqueMutationStates[uniqueStatesCount] = aState;
				uniqueStatesCount++;
				mutationsList.add(new Pentomino(aState, id));
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
	private static boolean[][] flipMatrixVertically(boolean[][] original)
	{
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
	private static boolean compareMatrixes(boolean[][] leftMatrix, boolean[][] rightMatrix)
	{
		// If the sizes of matrixes is not equal then the matrixes can not be equal.
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
	 * Returns the state of field at x,y.
	 * @param x the x coordinate
	 * @param x the y coordinate
	 * @return the state of field
	 */
	public boolean isFilled(int x, int y)
	{
		if (state[y][x])
			return true;
		return false;
	}


	/**
	 * Returns the number of rows.
	 * @return the number of rows
	 */
	public int height()
	{
		return state.length;
	}


	/**
	 * Returns the number of columns.
	 * @return the number of columns
	 */
	public int width()
	{
		return state[0].length;
	}


	/**
	 * Returns all the mutations as an array of pentominoes.
	 * @return array of pentominoes
	 */
	public Object[] getMutations() {
		return mutations;
	}


	/**
	 * Returns the id of the pentomino.
	 * @return the id of pentomino
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Returns textual representation of the pentomino.
	 * @return a textual representation
	 */
	public String toString()
	{
		// This is easy, just iterate through the array. Massssssive!
		// But I belive there should be an easier way how to do this.
		char[] text = new char[state.length * (state[0].length + 1)]; // that is the length of the value we will return. The "+ 1" is for the new line chars.
		// That is the length of the value we will return. The "+ 1" is for the new
		// line chars.

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

		text[i - 1] = 0; // We don't need the last new line char.

		return new String(text);
	}

}