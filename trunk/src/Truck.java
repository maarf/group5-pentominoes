
public class Truck 
{
	private int height, length, width;
	private int [][][] truck;
	private int maxX, maxY, maxZ;
	
	
	public Truck(int aHeight, int aLength, int aWidth)	
	{
		height = aHeight;
		length = aLength;
		width = aWidth;
		maxX = 0;
		maxY = 0;
		maxZ = 0;
		truck = new int[height][length][width];		
	}	
	
	public void setParcel(Parcel a)
	{
		for (int i = 0; i<a.getParcelX();i++)
		{
			for(int j = 0; j<a.getParcelY(); j++)
			{
				for(int k = 0; k<a.getParcelY(); k++)
				{
					truck[i+maxX][j+maxY][k+maxZ] = a.returnValue();
				}
			}
		}
		setMaxX(a);
		setMaxY(a);
		setMaxZ(a);
	}
	
	public void getTruckValue()
	{
		 for(int i=0; i<truck.length; i++)
		        for(int j=0; j<truck[i].length; j++){
		        for (int k=0; k<truck[i][j].length; k++ )
		        {
		               System.out.print(truck[i][j][k]);   
		        }
		         System.out.println();
		    }
		    System.out.println();
	}
	
	public void setMaxX(Parcel b)
	{
		maxX = maxX + b.getParcelX();		
	}
	
	public void setMaxY(Parcel b)
	{
		maxY = maxY + b.getParcelY();	
	}
	
	public void setMaxZ(Parcel b)
	{
		maxZ = maxZ + b.getParcelZ();
	}
	

}
