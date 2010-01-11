import java.util.Random;

/**
 * Solver!!
 * @author Jose Sue Smith, Leoni Haagmans
 *
 */
public class BruteForce1 
{
	public BruteForce1()
	{
		//randomPicker();
	}
	/**
	 * picks a random parcel in random state
	 * @return a parcel
	 */
	public int[] randomPicker()
	{
		Parcel parcelA = new Parcel(2,2,4, 3);
		int[][] rotationsA = parcelA.returnRotations();
		Random ram = new Random();
		int a = ram.nextInt(rotationsA.length);
		int[] randomrotation = new int[3];
		for(int i = 0; i < 2; i++)
		{
			randomrotation[i] = rotationsA[a][i];
		}
		return randomrotation;
	}
	
	public int[] getParcel()
	{
		return randomPicker();
	}
	/**
	 * puts parcel in truck if fits
	 */
	/*public void Solve()
	{
		parcel = randomPicker();
		
		if(!fits(parcel))
		{
			break;
		}
		if(fits(parcel))
		{
			setParcel(parcel);
			Solve();
		}
	}*/
	/**
	 * sets parcel in truck
	 * @param aParcel
	 */
	public void setParcel(Parcel aParcel)
	{
		
	}
	/**
	 * checks if parcel fits
	 * @param bParcel
	 * @return
	 */
	public boolean fits(Parcel bParcel)
	{
		return true;
	}
	
	
}
