public class GreedyTester
{
	public static void main(String[] args)
	{
		Parcel parcelA = new Parcel();
		Parcel parcelB = new Parcel();
		Parcel parcelC = new Parcel();
		
		Parcel[] parcels = {parcelA, parcelB, parcelC};
		
		Truck truck = new Truck();
		
		Greedy greedy = new Greedy(truck, parcels);
		
		greedy.makeGreedy();
		greedy.Solve();
		
	}
}