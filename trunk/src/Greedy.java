public class Greedy
{
	public Greedy(Truck aTruck, Parcel[] parcels)
	{
		this.truck = aTruck;
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
	
	public Truck Solve()
	{
		int sets = 0;
		for(int i = 0; i < greedyParcels.length; i++)
		{
			truck.NextBlank();
			System.out.println(truck.fits(greedyParcels[i]));
			while(truck.fits(greedyParcels[i]))
			{
				truck.setParcel(greedyParcels[i]);
				
				sets++;
				System.out.println(sets + " " + greedyParcels[i].getValue());
			}
		}
		System.out.println("END");
		return truck;
	}
	

	private Truck truck;
	private Parcel[] parcels;
	private Parcel[] greedyParcels;

	
}