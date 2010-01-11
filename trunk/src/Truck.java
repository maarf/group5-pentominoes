
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
		truck = new int[height][width][length];		
	}	
	
	/**
	 * 
	 * @param a
	 */
	public void setParcel(Parcel a)
	{
		for (int i = 0; i<a.getParcelX();i++)
		{
			for(int j = 0; j<a.getParcelY(); j++)
			{
				for(int k = 0; k<a.getParcelY(); k++)
				{
					if(fitsX(a))
						{truck[i+maxX][j][k] = a.getValue();}
					else if(fitsY(a))
						{truck[i][j+maxY][k] = a.getValue();}
					else if(fitsZ(a))
						{truck[i][j][k+maxZ] = a.getValue();}
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
		maxX = maxX + b.getParcelX() - 1;		
	}
	
	public void setMaxY(Parcel b)
	{
		maxY = maxY + b.getParcelY() - 1;	
	}
	
	public void setMaxZ(Parcel b)
	{
		maxZ = maxZ + b.getParcelZ() - 1;
	}
	
	public int getTrucklength()
	{
		return length;
	}
	
	public int getTruckHeight()
	{
		return height;		
	}
	
	public int getTruckWidth()
	{
		return width;
	}
	
	public int getMaxX()
	{
		return maxX;
	}
	public int getMaxY()
	{
		return maxY;
	}
	
	public int getMaxZ()
	{
		return maxZ;
	}

	public boolean isFull()
	{
		
		for(int i = 0; i < truck.length; i++)
		{
			for(int j = 0; j < truck[i].length; j++)
			{
				for(int k = 0; k < truck[i][j].length; k++)
				{
					if(truck[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}
	
	public boolean fitsX(Parcel bParcel)
	{
		if(length<getMaxX())
		{
			return false;
		}
		return true;
	}
	public boolean fitsY(Parcel bParcel)
	{
		if(height<getMaxY())
		{
			return false;
		}
		return true;
	}
	
	public boolean fitsZ(Parcel bParcel)
	{
		if(width<getMaxZ())
		{
			return false;
		}
		return true;
	}

}
