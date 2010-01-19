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
           // parcel = a[ram.nextInt(a.length)];
    	parcel = a[2];
    	aParcel = new Parcel(getParcelX(),getParcelY(),getParcelZ(),getParcelV());
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
	/**
	 * puts parcel in truck if fits
	 */
	public void Solve(int [][] a)
	{
		randomPicker(a);
		
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
				Solve(a);
			}
			else
			{
				counter++;
				if(counter>10)
				{
					truck.setEmpty();
					counter = 0;
				}	
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

