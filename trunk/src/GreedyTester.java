public class GreedyTester
{
	public static void main(String[] args)
	{
		Parcel parcelA = new Parcel(2,2,4,3,0);
		Parcel parcelB = new Parcel(2,3,4,4,1);
		Parcel parcelC = new Parcel(3,3,3,5,2);
		
		Parcel[] parcels = {parcelC, parcelB, parcelA};
		
		Truck truck = new Truck(5,8,33);
	
		/**
		System.out.println(truck.fits(parcelC));
		truck.setParcel(parcelC);
		//truck.NextBlank();
		System.out.println(truck.fits(parcelC));
		truck.setParcel(parcelC);
		System.out.println(truck.fits(parcelC));
		**/
		
		
		
		Greedy greedy = new Greedy(truck, parcels);		
		Truck solvedtruck = greedy.Solve();
		System.out.println("Number of A boxes: " + solvedtruck.getABoxes());
		System.out.println("Number of B boxes: " + solvedtruck.getBBoxes());
		System.out.println("Number of C boxes: " + solvedtruck.getCBoxes());
		System.out.println("Total value of the truck: " + solvedtruck.getValue());
		
		
	
	}
}