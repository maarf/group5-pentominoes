public class GreedyTester
{
	public static void main(String[] args)
	{
		Parcel parcelA = new Parcel(2,4,1,3);
		Parcel parcelB = new Parcel(2,4,4,4);
		Parcel parcelC = new Parcel(3,3,3,5);
		
		Parcel[] parcels = {parcelA, parcelB, parcelC};
		
		Truck truck = new Truck(33,6,2);
		
		Greedy greedy = new Greedy(truck, parcels);
		
		greedy.makeGreedy();
		greedy.Solve();
		
	}
}