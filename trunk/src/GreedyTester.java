public class GreedyTester
{
	public static void main(String[] args)
	{
		Parcel parcelA = new Parcel(2,2,4,3);
		Parcel parcelB = new Parcel(2,3,4,4);
		Parcel parcelC = new Parcel(3,3,3,5);
		
		Parcel[] parcels = {parcelA, parcelB, parcelC};
		
		Truck truck = new Truck(8,7,10);
		
		Greedy greedy = new Greedy(truck, parcels);
		
		Parcel[] greedyParcels = greedy.makeGreedy();
		
		for(int i = 0; i < greedyParcels.length; i++)
		{
			System.out.println(greedyParcels[i].toString());
		}
		
		greedy.Solve();
		
	}
}