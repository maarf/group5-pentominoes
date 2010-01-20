import java.util.Random;

/**
 * Solves selecting random parcels and random rotations
 * @author Jose Sue Smith, Martins Spilners
 *
 */
public class RandomSolver 
{
	private Truck truck;
	private Parcel aParcel;
	private int [] parcel;
	private int value;
	private int boxA = 0, boxB = 0, boxC = 0;
	
	/**
	 * constructor for a specific truck
	 * @param atruck
	 */
	public RandomSolver(Truck atruck)
	{
		truck = atruck;
	}	
	/**
	 * picks randomly a parcel from a list of parcels
	 * @param a list of parcels
	 */
    public void randomPicker(int [][] a)
    {
            Random ram = new Random();
            parcel = a[ram.nextInt(a.length)];
    	aParcel = new Parcel(parcel[0],parcel[1],parcel[2],parcel[3],parcel[4]);
    	
    }
	
	private int someCounter = 0;

	/**
	 * picks a random parcel from a list, check if it fits and sets it, if not
	 * sets an empty space and solve again
	 * @param a array containing the possible parcels
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
	
	/**
	 * gets the total value
	 * @return total value
	 */	
	public int getValue()
	{
		return value;
	}
	
	/**
	 * gets the amount of parcels A used
	 * @return amount of parcels A
	 */
	public int getBoxA()
	{
		return boxA;
	}
	
	/**
	 * gets the amount of parcels B used
	 * @return amount of parcels B
	 */
	public int getBoxB()
	{
		return boxB;		
	}
	
	/**
	 * gets the amount of parcels C used
	 * @return amount of parcels C
	 */
	public int getBoxC()
	{
		return boxC;
	}
}

