import java.util.Random;

/**
 * Solver!!
 * @author Jose Sue Smith, Leoni Haagmans
 *
 */
public class BruteForce1 
{
	public BruteForce1(Truck atruck)
	{
		truck = atruck;
		Solve();
	}	

	/**
	 * puts parcel in truck if fits
	 */
	public void Solve()
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
	}

	
	private Parcel aParcel;
	private Truck truck;
	
}
