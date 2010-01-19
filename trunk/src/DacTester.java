
public class DacTester 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Truck truck = new Truck(8,33,5);
		
		Dac solver = new Dac(truck,parcels);
		solver.solver();
		//solver.getTruckValue();
		

	}
	private final static int aX = 2, aY = 2, aZ = 4, aV = 3;
	private final static int bX = 2, bY = 3, bZ = 4, bV = 4;
	private final static int cX = 3, cY = 3, cZ = 3, cV = 5;
	
	private static int[][] parcels = {	{aX,aY,aZ,aV},
										{bX,bY,bZ,bV},
										{cX,cY,cZ,cV} };


}
