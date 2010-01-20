import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Solver using the principle of Divide and Conquer
 * it creates a smaller truck and then multiplies it to create a new normal truck
 * @author Jose Sue Smith, Martins Spilners
 *
 */

public class Dac
{
	private Truck truck;
	private Truck bTruck;
	private int [][] parcels;
	private int [][][] smallTruck;
	private int [][][] newTruck;
	private int currX = 0, currY = 0, currZ = 0;
	private int value, a, b, c;
	
/**
 * Constructs the solver for a specific truck, with a list of specific parcels
 * @param aTruck truck used to take the dimensions
 * @param a array containing the parcels
 */
	public Dac(Truck aTruck, int [][] a)
	{
		truck = aTruck;
		parcels = a;
	}
	/**
	 * creates a smaller truck and solves it. later it multiplies itself until a
	 * new normal truck is created.
	 */
	public void solver()
	{
		int newLength = 4;
		bTruck = new Truck(truck.getHeight(),newLength, truck.getWidth());
		RandomSolver solver = new RandomSolver(bTruck);
		solver.Solve(parcels);
		value = solver.getValue();
		a = solver.getBoxA();
		b = solver.getBoxB();
		c = solver.getBoxC();
		smallTruck = bTruck.getTruck();
		newTruck = new int[truck.getHeight()][truck.getLength()][truck.getWidth()];
		for(int s = 0; s<8; s++)
		{
			concatenate();
			for(int i = 0; i < newTruck.length; i++)
			{
				for(int j = 0; j < newTruck[i].length; j++)
				{
					for(int k = 0; k < newTruck[i][j].length; k++)
					{
						if(!isfilled(i,j,k)) 
						{
							currY = i;
							currZ = j;
							currX = k;
							return;
						}					
					}		
				}		
			}
		}
		
	}
	/**
	 * it multiplies the smaller truck by copying its elements into the new truck
	 * taking advantage of the current position to place
	 */
	public void concatenate()
	{
		for(int i = 0; i < smallTruck.length; i++)
		{
			for(int j = 0; j < smallTruck[i].length; j++)
			{
				for(int k = 0; k < smallTruck[i][j].length; k++)
				{
					newTruck[currY+i][currZ+j][currX+k] = smallTruck [i][j][k];				
				}
			}
		}
	}
	/**
	 * controls if a specific space is filled
	 * @param y y to be checked
	 * @param z z to be checked
	 * @param x x to be checked
	 * @return true if its not empty
	 */
	public boolean isfilled(int y, int z, int x)
	{
        if (newTruck[y][z][x] == 0) 
        {
            return false;
        }
        return true;
	}
	/**
	 * prints out in console the values in new truck
	 */
	public void getTruckValue()
	{
		for(int i = 0; i < newTruck.length; i++)
		{
			for(int j = 0; j < newTruck[i].length; j++)
			{
				for(int k = 0; k < newTruck[i][j].length; k++)
		        {
		               System.out.print(newTruck[i][j][k]);   
		        }
		         System.out.println();
		    }
		    System.out.println();
		}
	
	}
	/**
	 * takes the small truck and multiplies by 8
	 * @return a truck with all parcels thats in the size of original truck
	 */
	public ArrayList<ParcelAtPlace> getBigTruck() {
		ArrayList<ParcelAtPlace> parcelsAtPlace = new ArrayList<ParcelAtPlace>();

		for (int i = 0; i < 8; i++) {
			for (Object o : bTruck.getParcels()) {
				ParcelAtPlace p = (ParcelAtPlace)o;
				parcelsAtPlace.add(new ParcelAtPlace(p.parcel, p.x, p.y, p.z + (4 * i)));
			}
		}
		
		return parcelsAtPlace;
	}
	/**
	 * provides the amount of parcels A used and multiplies by amount of copies
	 * @return amount of parcels A
	 */
	public int getA()
	{
		return a * 8;
	}
	/**
	 * provides the amount of parcels B used and multiplies by amount of copies
	 * @return amount of parcels B
	 */
	public int getB()
	{
		return b * 8;
	}
	/**
	 * provides the amount of parcels C used and multiplies by amount of copies
	 * @return amount of parcels C
	 */
	public int getC()
	{
		return c * 8;
	}
	/**
	 * provides the total value and multiplies by amount of copies
	 * @return total value
	 */
	public int getV()
	{
		return value * 8;
	}
}
