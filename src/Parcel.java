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
		// Returns only one parcel dimension when the three variables are equal.
		if(height == width && height == length) 
		{
			System.out.println("3 the same");
			rotations = new int[1][3]; 
			rotations[0][0] = height;
			rotations[0][1] = width;
			rotations[0][2] = length;
		}
		
		// Returns three parcel dimensions when there are two different numbers. 
		else if(height == width || height == length || width == length)
		{
			System.out.println("2 the same");
			rotations = new int[3][3];
			int different;
			int same;
			if(height == width)
			{
				different = length;
				same = height;
			}
			else if(height == length)
			{
				different = width;
				same = height;
			}
			
			else if(width == length)
			{
				different = height;
				same = length;
			}
			
			else
			{
				different = 911987;
				same = 789119;
			}

			
			rotations[0][0] = different;
			rotations[0][1] = same;
			rotations[0][2] = same;
			
			rotations[1][0] = same;
			rotations[1][1] = different;
			rotations[1][2] = same;
			
			rotations[2][0] = same;
			rotations[2][1] = same;
			rotations[2][2] = different;
			
		}
		
		// Returns the six different rotations in case of three different values.
		else if(height != width && height != length && width != length)
		{
			System.out.println("0 the same");
		rotations = new int[6][3];
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
		}

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