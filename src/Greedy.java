public class Greedy
{
	public Greedy(Truck aTruck, Parcel[] parcels)
	{
		aTruck = truck;
		this.parcels = parcels;
		makeGreedy();
		Solve();
	}
	
	public void makeGreedy()
	{
		// here the program should sort the parcels into descending order (highest value first).
		Parcel maxParcel = new Parcel(0,0,0,0);
		for(int i = 0; i < parcels.length; i++)
		{
			if(parcels[i].getValue() > maxParcel.getValue()) maxParcel = parcels[i];
		}
		greedyParcels = new Parcel[parcels.length];
		greedyParcels[0] = maxParcel;
		for(int i = 1; i < parcels.length - 1; i++)
		{
			for(int j = maxParcel.getValue(); j > 0; j--)
			{
				
			}
		}
	}
	
	public boolean Solve()
	{
		for(int i = 0; i < greedyParcels.length; i++)
		{
			Parcel parcel = greedyParcels[i];
			if(truck.fits(parcel) == true) truck.setParcel(parcel);
		}
		if(truck.isFull() == true) return true;
		else return false;
	}
	
	private Truck truck;
	private Parcel[] parcels;
	private Parcel[] greedyParcels;
	
	
}