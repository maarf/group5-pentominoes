
public class Tester 
{
	public static void main(String[]args)
	{
		//RandParcelSelector selector = new RandParcelSelector();
	//	Parcel aParcel = new Parcel(selector.getParcelX(),selector.getParcelY(),selector.getParcelZ(),selector.getParcelV());
	//	System.out.println("Actual value: " + aParcel.getValue());
	//	System.out.println("X: " + aParcel.getParcelX());
	//	System.out.println("Y: " + aParcel.getParcelY());
	//	System.out.println("Z: " + aParcel.getParcelZ());
		//Truck truck = new Truck(4,4,4);//33,5,8
		//truck.setParcel(aParcel);
	//	truck.getTruckValue();
		//System.out.println("Value: " + truck.getTruckValue());
		
		Truck truck = new Truck(33,5,8);
		BruteForce1 solver1 = new BruteForce1(truck);
		solver1.Solve();
	}
}
