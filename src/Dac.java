import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Divide and Conque Solver
 * @author Jose Sue Smith, Ronald Gerits
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
	
	
	public Dac(Truck aTruck, int [][] a)
	{
		truck = aTruck;
		parcels = a;
	}
	
	public void solver()
	{
		int newLength = truck.getLength()/11;
		bTruck = new Truck(truck.getHeight(),newLength, truck.getWidth());
		BruteForce1 solver = new BruteForce1(bTruck);
		solver.Solve(parcels);
		smallTruck = bTruck.getTruck();
		newTruck = new int[truck.getHeight()][truck.getLength()][truck.getWidth()];
		for(int s = 0; s<11; s++)
		{
			concatenate();
			for(int i = 0; i < newTruck.length; i++)
			{
				for(int j = 0; j < newTruck[i].length; j++)
				{
					for(int k = 0; k < newTruck[i][j].length; k++)//msschn niet goed
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
	
	public void concatenate()
	{
		for(int i = 0; i < smallTruck.length-1; i++)
		{
			for(int j = 0; j < smallTruck[i].length-1; j++)
			{
				for(int k = 0; k < smallTruck[i][j].length-1; k++)
				{
					newTruck[currY+i][currZ+j][currX+k] = smallTruck [i][j][k];				
				}
			}
		}
	}

	public boolean isfilled(int y, int z, int x)
	{
        if (newTruck[y][z][x] == 0) 
        {
            return false;
        }
        return true;
	}
	
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
	
	public ArrayList<ParcelAtPlace> getBigTruck() {
		ArrayList<ParcelAtPlace> parcelsAtPlace = new ArrayList<ParcelAtPlace>();

		for (int i = 0; i < 11; i++) {
			for (Object o : bTruck.getParcels()) {
				ParcelAtPlace p = (ParcelAtPlace)o;
				parcelsAtPlace.add(new ParcelAtPlace(p.parcel, p.x, p.y, p.z + (3 * i)));
			}
		}
		
		return parcelsAtPlace;
	}
}
