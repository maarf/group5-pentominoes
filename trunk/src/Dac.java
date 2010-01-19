import java.lang.reflect.Array;

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
	
	public Dac(Truck aTruck, int [][] a)
	{
		truck = aTruck;
		parcels = a;
	}
	
	public void solver()
	{
		int newLength = truck.getLength()/11;
		bTruck = new Truck(truck.getHeight(),truck.getWidth(),newLength);
		BruteForce1 solver = new BruteForce1(bTruck);
		solver.Solve(parcels);
		smallTruck = bTruck.getTruck();
		newTruck = new int[truck.getHeight()][truck.getLength()][truck.getWidth()];
		for(int i = 0; i<11; i++)
		{
			
		}
		
	}
	
	public void concatenate()
	{
		for(int i = 0; i < newTruck.length; i++)
		{
			for(int j = 0; j < newTruck[i].length; j++)
			{
				for(int k = 0; k < newTruck[i][j].length; k++)
				{
					newTruck[i][j][k] = smallTruck [i][j][k];				
				}
			}
		}
	}

	
	
}
