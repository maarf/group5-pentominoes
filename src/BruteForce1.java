/**
 * Solver!!
 * @author Jose Sue Smith, Leoni Haagmans
 *
 */
public class BruteForce1 
{
	private Truck truck;
	private Parcel aParcel;
	private int counter;
	
	public BruteForce1(Truck atruck)
	{
		truck = atruck;
	}	
	public void rand()
	{
		RandParcelSelector selector = new RandParcelSelector();
		aParcel = new Parcel(selector.getParcelX(),selector.getParcelY(),selector.getParcelZ(),selector.getParcelV());

	}
	/**
	 * puts parcel in truck if fits
	 */
	public void Solve()
	{
		rand();
		
		if(truck.isFull())
		{
			reset();//just prints for the moment
		}
		else
		{
			truck.NextBlank();
			if(truck.fits(aParcel))
			{
				truck.setParcel(aParcel);
				Solve();
			}
			else
			{
				counter++;
				if(counter>10)
				{
					truck.setEmpty();
					Solve();
				}
				Solve();				
			}
		}		
	}
	
	public void reset()
	{
		truck.getTruckValue();//just prints
		//truck = new Truck(4,4,4);
	}	
}

