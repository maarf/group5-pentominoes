public class Greedy
{
	public Greedy(Truck aTruck, Parcel[] parcels)
	{
		aTruck = truck;
		this.parcels = parcels;
		makeGreedy();
		//Solve();
	}
	
	public Parcel[] makeGreedy()
	{
		// here the program should sort the parcels into ascending order (lowest value first).
		int max = 0;
		int numberofParcels = 0;
		for(int i = 0; i < parcels.length; i++)
		{
			if(parcels[i].getValue() > max) max = parcels[i].getValue();
		}
		
		
		Parcel[] temporaryParcels = new Parcel[max + 1];
		for(int i = 0; i < parcels.length; i++)
		{
			for(int j = 1; j <= temporaryParcels.length; j++)
			{
				if(parcels[i].getValue() == j) 
					{
						temporaryParcels[j] = parcels[i];
						numberofParcels++;
					}
			}
		}
		
		greedyParcels = new Parcel[numberofParcels];
		int j = 0;
		for(int i = 0; i < temporaryParcels.length; i++)
		{
			if(temporaryParcels[i] != null)
				{
					greedyParcels[j] = temporaryParcels[i];
					j++;
				}
			
		}
		
		return greedyParcels;
		
	}
	
	public int Solve()
	{
		int solutions = 0;
		
		for(int i = 0; i < greedyParcels.length; i++)
		{
			Parcel greedyParcel = new Parcel(greedyParcels[i].getParcelX(), greedyParcels[i].getParcelY(), greedyParcels[i].getParcelZ(), greedyParcels[i].getValue());
			if(truck.fits(greedyParcel))
			{
				truck.setParcel(greedyParcel);
				truck.NextBlank();
			}
		}

		return solutions;
		
	}
	
	private Truck truck;
	private Parcel[] parcels;
	private Parcel[] greedyParcels;
	
	
}