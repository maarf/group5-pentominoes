
public class Truck 
{
	private int height, length, width;
	private int [][][] truck;
	private int maxX, maxY, maxZ;
	
	
	public Truck(int aHeight, int aWidth, int aLength)	
	{
		height = aHeight;
		length = aLength;
		width = aWidth;
		maxX = 0;
		maxY = 0;
		maxZ = 0;
		truck = new int[height][length][width];		
	}	
	
	/**
	 * 
	 * @param a
	 */
	public void setParcel(Parcel a)
	{
		if(isFull())
		{
			System.out.println("is full");
		}
		else
		{
			if(fitsX(a))
			{
				for (int i = 0; i<a.getParcelX();i++)
				{
					for(int j = 0; j<a.getParcelY(); j++)
					{
						for(int k = 0; k<a.getParcelZ(); k++)
						{
							truck[j][k][i+maxX] = a.getValue();
							System.out.println("fitsX");
						}
					}
				}
			}
			else if(fitsY(a))
			{
				for (int i = 0; i<a.getParcelX();i++)
				{
					for(int j = 0; j<a.getParcelY(); j++)
					{
						for(int k = 0; k<a.getParcelZ(); k++)
						{
							truck[j+maxY][k][i] = a.getValue();
							System.out.println("fitsY");
						}
					}
				}
			}
			else if(fitsZ(a))
			{
				for (int i = 0; i<a.getParcelX();i++)
				{
					for(int j = 0; j<a.getParcelY(); j++)
					{
						for(int k = 0; k<a.getParcelZ(); k++)
						{
							truck[j][k+maxZ][i] = a.getValue();
							System.out.println("fitsZ");
						}
					}
				}
			}						
	
		setMaxX(a);
		setMaxY(a);
		setMaxZ(a);
		}
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
		if(width<getMaxX()+bParcel.getParcelX())
		{
			maxX = 0;
			return false;
		}
		return true;
	}
	public boolean fitsY(Parcel bParcel)
	{
		if(height<getMaxY()+bParcel.getParcelY())
		{
			maxY = 0;
			return false;
		}
		return true;
	}
	
	public boolean fitsZ(Parcel bParcel)
	{
		if(length<getMaxZ()+bParcel.getParcelZ())
		{
			maxZ = 0;
			return false;
		}
		return true;
	}

}
