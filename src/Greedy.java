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
		int max = 0;
		for(int i = 0; i < parcels.length; i++)
		{
			if(parcels[i].getValue() > max) max = parcels[i].getValue();
		}
		Parcel[] temporaryParcels = new Parcel[max];
		
		for(int i = 0; i < temporaryParcels.length; i++)
		{
			for(int j = 0; j < parcels.length;  j++)
			{
				if(parcels[j].getValue() == i) temporaryParcels[i] = parcels[j];
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