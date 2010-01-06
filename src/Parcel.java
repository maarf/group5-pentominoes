public class Parcel
{
	public Parcel(int aHeight, int aWidth, int aLength, int aValue)
	{
		height = aHeight;
		width = aWidth;
		length = aLength;
		value = aValue;
		initialize();
	}
	
	public void initialize()
	{
		/** rotations = new int[6][3];
		rotations[0][0] = height;
		rotations[0][1] = width;
		rotations[0][2] = length;
		
		rotations[1][0] = height;
		rotations[1][1] = length;
		rotations[1][2] = width;
		
		rotations[2][0] = width;
		rotations[2][1] = length;
		rotations[2][2] = height;
		
		rotations[3][0] = width;
		rotations[3][1] = height;
		rotations[3][2] = length;
		
		rotations[4][0] = length;
		rotations[4][1] = height;
		rotations[4][2] = width;
		
		rotations[5][0] = length;
		rotations[5][1] = width;
		rotations[5][2] = height;		
		
		*/
		
		if(height == width && height == length) 
		{
			rotations = new int[1][3]; 
			rotations[0][0] = height;
			rotations[0][1] = width;
			rotations[0][2] = length;
		}
		
		if(height == width )
	}
	

	
	public int[][] returnRotations()
	{
		return rotations;
	}
	
	/**
	 * Returns the value of the Parcel.
	 * @return An integer.
	 */
	public int returnValue()
	{
		return value;
	}
	
	/**
	 * Returns the original height, width and length of the Parcel.
	 * @return A String.
	 */
	public String toString()
	{
		return "Parcel[" + height + "][" + width + "][" + length + "]";
	}
	// We doubled the height, width and length of the parcels
	private int height;
	private int width;
	private int length;
	private int value;
	private int[][] rotations;
}