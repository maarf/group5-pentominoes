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
	private int value, a, b, c;
	
	
	public Dac(Truck aTruck, int [][] a)
	{
		truck = aTruck;
		parcels = a;
	}
	
	public void solver()
	{
		int newLength = 4;
		bTruck = new Truck(truck.getHeight(),newLength, truck.getWidth());
		BruteForce1 solver = new BruteForce1(bTruck);
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

		for (int i = 0; i < 8; i++) {
			for (Object o : bTruck.getParcels()) {
				ParcelAtPlace p = (ParcelAtPlace)o;
				parcelsAtPlace.add(new ParcelAtPlace(p.parcel, p.x, p.y, p.z + (4 * i)));
			}
		}
		
		return parcelsAtPlace;
	}
	
	public int getA()
	{
		return a * 11;
	}
	
	public int getB()
	{
		return b * 11;
	}
	
	public int getC()
	{
		return c * 11;
	}
	
	public int getV()
	{
		return value * 11;
	}
}
