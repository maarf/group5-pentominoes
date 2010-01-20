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
	private int value;
	private int boxA = 0, boxB = 0, boxC = 0;
	private int counter;
	
	public BruteForce1(Truck atruck)
	{
		truck = atruck;
	}	
	
    public void randomPicker(int [][] a)
    {
            Random ram = new Random();
            parcel = a[ram.nextInt(a.length)];
    	aParcel = new Parcel(parcel[0],parcel[1],parcel[2],parcel[3],parcel[4]);
    	
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
			return;
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
				value = value + aParcel.getValue();
				//counter = 0;
				truck.NextBlank();
				if(aParcel.getValue() == 3)
				{
					boxA++;
				}
				if(aParcel.getValue() == 4)
				{
					boxB++;
				}
				if(aParcel.getValue() == 5)
				{
					boxC++;
				}
				System.out.println("set");
				Solve(a);
			}
			else
			{

			
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
	
	public int getValue()
	{
		return value;
	}
	public int getBoxA()
	{
		return boxA;
	}
	public int getBoxB()
	{
		return boxB;		
	}
	public int getBoxC()
	{
		return boxC;
	}
	
	public int Nodes()
	{
		return someCounter;
	}
}

