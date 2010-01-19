public class GreedyTester
{
	public static void main(String[] args)
	{
		Parcel parcelA = new Parcel(2,2,4,3);
		Parcel parcelB = new Parcel(2,3,4,4);
		Parcel parcelC = new Parcel(3,3,3,5);
		
		Parcel[] parcels = {parcelC, parcelB, parcelA};
		
		Truck truck = new Truck(8,5,33);
		
		Greedy greedy = new Greedy(truck, parcels);		
		
		Truck solvedtruck = greedy.Solve();
		solvedtruck.toString();
		
	
	}
}