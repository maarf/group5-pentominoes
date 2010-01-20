import java.util.Random;

public class Parcel implements Comparable
{
	/**
	 * Constructs a Parcel with a certain height, width, length and a certain value.
	 * @param aHeight An integer which represents the height of the parcel.
	 * @param aWidth An integer which represents the width of the parcel.
	 * @param aLength An integer which represents the length of the parcel.
	 * @param aValue An integer which represents the value of a parcel.
	 */
	public Parcel(int aHeight, int aWidth, int aLength, int aValue, int anId)
	{
		height = aHeight;
		width = aWidth;
		length = aLength;
		value = aValue;
		id = anId;
		initialize();
	}
	
	/**
	 * This method initializes the rotations of a certain parcel and stores the results in the rotations-array.
	 */
	public void initialize()
	{
		// Returns only one parcel dimension when the three variables are equal.
		if(height == width && height == length) 
		{
			//System.out.println("3 the same");
			rotations = new int[1][3]; 
			rotations[0][0] = height;
			rotations[0][1] = width;
			rotations[0][2] = length;
		}
		
		// Returns three parcel dimensions when there are two different numbers. 
		else if(height == width || height == length || width == length)
		{
			//System.out.println("2 the same");
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
			//System.out.println("0 the same");
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
		
		randParcel(returnRotations()); //selects randomly one rotation of the parcel

	}
	

	/**
	 * Returns the dimensions of the parcel and it's rotations. 
	 * @return A 2-dimensional array with at least one and at most six values in the first dimension and always with three values in the second dimension.
	 */
	public int[][] returnRotations()
	{
		return rotations;
	}
	
	/**
	 * Returns the value of the Parcel.
	 * @return An integer the represents the value of a Parcel.
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * Returns the original height, width and length of the Parcel.
	 * @return A String.
	 */
	public String toString()
	{
		return "Parcel[" + height + "][" + width + "][" + length + "][" + value + "]";
	}
	/**
	 * randomly selects a rotation from all possible rotations
	 * @param listRotations list of all possible rotations
	 */
	public void randParcel(int [][] listRotations)
	{
        Random ram = new Random();
        parcel = listRotations[ram.nextInt(listRotations.length)];
	}
	/**
	 * returns the X from the parcel
	 * @return length of parcel
	 */
	public int getParcelX()
	{
		return parcel[1];
	}
	/**
	 * returns the Y from the parcel
	 * @return height of parcel
	 */
	public int getParcelY()
	{
		return parcel[0];
	}
	/**
	 * returns the Z from the parcel
	 * @return width of parcel
	 */
	public int getParcelZ()
	{
		return parcel[2];
	}
	
	/**
	 * Returns the ID of the Parcel.
	 * @return Returns the ID (int)
	 */
	public int getId() {
		return id;
	}
	
	// We doubled the height, width and length of the parcels as to only use integers.
	private int height;
	private int width;
	private int length;
	private int value;
	private int[][] rotations;
	private int [] parcel;
	private int id;
	
	public double getRelativeValue(){
		return ((double)this.getValue()) / (this.height*this.width*this.length);
	}

	@Override
	
	public int compareTo(Object arg0) {
		if(arg0 instanceof Parcel){
			Parcel p = (Parcel)arg0;
			if(p.getRelativeValue() == this.getRelativeValue()){
				return 0;
			} else if (p.getRelativeValue() > this.getRelativeValue()){
				return -1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}