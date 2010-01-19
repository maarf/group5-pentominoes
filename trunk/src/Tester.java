
public class Tester 
{
	public static void main(String[]args)
	{
		/*RandParcelSelector selector = new RandParcelSelector();
		Parcel aParcel = new Parcel(selector.getParcelX(),selector.getParcelY(),selector.getParcelZ(),selector.getParcelV());
		System.out.println("Actual value: " + aParcel.getValue());
		System.out.println("X: " + aParcel.getParcelX());
		System.out.println("Y: " + aParcel.getParcelY());
		System.out.println("Z: " + aParcel.getParcelZ());
		RandParcelSelector selector1 = new RandParcelSelector();
		Parcel bParcel = new Parcel(selector1.getParcelX(),selector1.getParcelY(),selector1.getParcelZ(),selector1.getParcelV());
		System.out.println("Actual value 2: " + bParcel.getValue());
		System.out.println("X: " + bParcel.getParcelX());
		System.out.println("Y: " + bParcel.getParcelY());
		System.out.println("Z: " + bParcel.getParcelZ());
		RandParcelSelector selector2 = new RandParcelSelector();
		Parcel cParcel = new Parcel(selector2.getParcelX(),selector2.getParcelY(),selector2.getParcelZ(),selector2.getParcelV());
		System.out.println("Actual value 3: " + cParcel.getValue());
		System.out.println("X: " + cParcel.getParcelX());
		System.out.println("Y: " + cParcel.getParcelY());
		System.out.println("Z: " + cParcel.getParcelZ());
		Truck truck = new Truck(4,3,8);//33,5,8
		truck.NextBlank();
		if(truck.fits(aParcel))
		{
			truck.setParcel(aParcel);
		}
		truck.NextBlank();
		if(truck.fits(bParcel))
		{
			truck.setParcel(bParcel);
		}
		truck.NextBlank();
		if(truck.fits(cParcel))
		{
			truck.setParcel(cParcel);
		}
		else
		{
			truck.NextBlank();
			if(truck.fits(aParcel))
			{
				truck.setParcel(aParcel);
			}
			else
			{
				truck.NextBlank();
				if(truck.fits(bParcel))
				{
					truck.setParcel(bParcel);
				}
			}
		}
		truck.getTruckValue();*/
		//System.out.println(truck.fits(aParcel));
		//System.out.println(truck.getCurrX());
		//System.out.println(truck.getCurrY());
		//System.out.println(truck.getCurrZ());
		Truck truck = new Truck(4,3,8);
		BruteForce1 solver = new BruteForce1(truck);
		//solver.randomPicker(parcels);
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

