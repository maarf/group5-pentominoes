import java.util.Arrays;

public class Greedy
{
	public Greedy(Truck aTruck, Parcel[] parcels)
	{
		this.truck = aTruck;
		this.parcels = parcels;
		makeGreedy();
		Solve();
	}
	
	public Parcel[] makeGreedy()
	{
		Arrays.sort(parcels);
		greedyParcels = parcels;
		
		return greedyParcels;		
	}
	
	public Truck Solve()
	{
		
		System.out.println("START");
		int sets = 0;
		int nodes = 0;
			for(int i = greedyParcels.length - 1; i >= 0; i--)
			//for(int i = 0; i < greedyParcels.length; i++)
				{
					System.out.println("  Fits: " + greedyParcels[i].getValue() + " " + truck.fits(greedyParcels[i]));
					while(truck.fits(greedyParcels[i]) && !truck.isFull())
					{				
						truck.setParcel(greedyParcels[i]);
						truck.NextBlank();
						sets++;
						System.out.println("   Sets: " + greedyParcels[i].getValue() + " " + sets);
	
						nodes++;				
					}
				}
		
			System.out.println("END");
		//truck.getTruckValue();
		return truck;
		
	}
	

	private Truck truck;
	private Parcel[] parcels;
	private Parcel[] greedyParcels;

	
}