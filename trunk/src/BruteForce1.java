import java.util.Random;

/**
 * Solver!!
 * @author Jose Sue Smith, Leoni Haagmans
 *
 */
public class BruteForce1 
{
	private Truck truck;
	private Parcel aParcel;
	private int [] parcel;
	private int counter;
	
	public BruteForce1(Truck atruck)
	{
		truck = atruck;
	}	
	
    public void randomPicker(int [][] a)
    {
            Random ram = new Random();
            parcel = a[ram.nextInt(a.length)];
    	aParcel = new Parcel(parcel[0],parcel[1],parcel[2],parcel[3]);
    	
    }
 
	public int getParcelX()
	{
		return parcel[0];
	}
	
	public int getParcelY()
	{
		return parcel[1];
	}
	
	public int getParcelZ()
	{
		return parcel[2];
	}
	
	public int getParcelV()
	{
		return parcel[3];
	}
	
	private int someCounter = 0;
	
	/**
	 * puts parcel in truck if fits
	 */
	public void Solve(int [][] a)
	{
		someCounter++;
		if (someCounter > 100) {
			return;
		}
		
		randomPicker(a);
		
		System.out.println("parcel " + aParcel.getValue()); 
		System.out.println("full " + truck.isFull());
		System.out.println("still " + truck.stillFits());
		
		if(truck.isFull())
		{
			reset();//just prints for the moment
		}
		else
		{
			
			System.out.println("fits " + truck.fits(aParcel));
			System.out.println("currX " + truck.getCurrX());
			System.out.println("currY " + truck.getCurrY());
			System.out.println("currZ " + truck.getCurrZ());
			if(truck.fits(aParcel))
			{
				truck.setParcel(aParcel);
				//counter = 0;
				truck.NextBlank();
				System.out.println("set");
				Solve(a);
			}
			else
			{
				/*counter++;
				System.out.println("counter " + counter);
				if(counter == 10)
				{
					truck.setEmpty();
					counter = 0;
				}	*/
				truck.setEmpty();
				truck.NextBlank();
				Solve(a);				
			}
		}		
	}
	
	public void reset()
	{
		truck.getTruckValue();//just prints
		//truck = new Truck(4,4,4);
	}	
}

