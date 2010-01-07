import java.util.Random;


public class RandParcelSelector 
{
	private final int aX = 2, aY = 2, aZ = 4, aV = 3;
	private final int bX = 2, bY = 3, bZ = 4, bV = 4;
	private final int cX = 3, cY = 3, cZ = 3, cV = 5;
	
	private int[][] parcels = {	{aX,aY,aZ,aV},
								{bX,bY,bZ,bV},
								{cX,cY,cZ,cV} };
	private int [] parcel;
	
	public RandParcelSelector()
	{
		initialize(parcels);
	}
	
	public void initialize(int[][] listParcels)
	{
        Random ram = new Random();
        parcel = listParcels[ram.nextInt(listParcels.length)];
	}
	
	public int getParcelX()
	{
		return parcel[0];
	}
	
	public int getParcelY()
	{
		return parcel[1];
	}
	
	public int getParcelZ()
	{
		return parcel[2];
	}
	
	public int getParcelV()
	{
		return parcel[3];
	}
}
