
public class Tester 
{
	public static void main(String[]args)
	{

		Truck truck = new Truck(6,6,6);// 4 5 8
		//Parcel a = new Parcel(7,7,7,5);
		//System.out.println(truck.fits(a));
		//truck.setParcel(a);
		BruteForce1 solver = new BruteForce1(truck);
		//System.out.println(solver.getParcelV());
		solver.Solve(parcels);
		truck.getTruckValue();
		
	}
	private final static int aX = 2, aY = 2, aZ = 4, aV = 3;
	private final static int bX = 2, bY = 3, bZ = 4, bV = 4;
	private final static int cX = 3, cY = 3, cZ = 3, cV = 5;
	
	private static int[][] parcels = {	{aX,aY,aZ,aV},
										{bX,bY,bZ,bV},
										{cX,cY,cZ,cV} };

}

