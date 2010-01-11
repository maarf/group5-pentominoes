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
		//Solve();
	}	

	/**
	 * puts parcel in truck if fits
	 */
	public void Solve()
	{
		RandParcelSelector selector = new RandParcelSelector();
		Parcel aParcel = new Parcel(selector.getParcelX(),selector.getParcelY(),selector.getParcelZ(),selector.getParcelV());
		
		if(truck.isFull())
		{
			reset();
		}
		else
		{
			truck.setParcel(aParcel);
			Solve();
		}
	}
	
	public void reset()
	{
		truck.getTruckValue();
		//truck = new Truck(4,4,4);
	}

	
	private Parcel aParcel;
	private Truck truck;
	
}

