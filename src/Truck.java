
public class Truck 
{
	private int height, length, width;
	private int [][][] truck;
	private int counter;
	private int currX = 0, currY = 0, currZ = 0;
	
	
	
	public Truck(int aHeight, int aWidth, int aLength)	
	{
		height = aHeight;
		length = aLength;
		width = aWidth;
		truck = new int[height][length][width];		
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

	public boolean isFull()
	{
		
		for(int i = 0; i < truck.length; i++)
		{
			for(int j = 0; j < truck[i].length; j++)
			{
				for(int k = 0; k < truck[i][j].length; k++)
				{
					if(truck[i][j][k] == 0) 
					{
						counter++;				
					}					
				}
			}
		}
		
		if(counter<16)
		{
			counter = 0;
			return true;
		}
		
		else if(counter>1)
		{
			return false;
		}
		
		return false;
	}
	
	public boolean fits(Parcel bParcel)
	{
		if(width-currX>bParcel.getParcelX() && height-currY>bParcel.getParcelY() && length-currZ>bParcel.getParcelZ())
		{
			return true;
		}
		return false;
	}
	
	public boolean fits(Figure a)
	{
		if(width-currX>a.getWidth() && height-currY>a.getHeight() && length-currZ>a.getDepth())
		{
			return true;
		}
		return false;
	}
	
	
	public void NextBlank()
	{
		for(int i = 0; i < truck.length; i++)
		{
			for(int j = 0; j < truck[i].length; j++)
			{
				for(int k = 0; k < truck[i][j].length; k++)
				{
					if(!isfilled(i,j,k)) 
					{
						currY = j;
						currZ = k;
						currX = i;
						return;
					}					
				}		
			}		
		}
	}
	
	public int getCurrX()
	{
		return currX;
	}
	
	public int getCurrY()
	{
		return currY;
	}
	
	public int getCurrZ()
	{
		return currZ;
	}
	
	public void setParcel(Parcel a)
	{
		for (int i = 0; i<a.getParcelX();i++)
		{
			for(int j = 0; j<a.getParcelY(); j++)
			{
				for(int k = 0; k<a.getParcelZ(); k++)
				{
					truck[currY+j][currZ+k][currX+i] = a.getValue();
				}
			}
		}
	}
	
	public void setParcel(Figure b)
	{
		for (int i = 0; i<b.getWidth();i++)
		{
			for(int j = 0; j<b.getHeight(); j++)
			{
				for(int k = 0; k<b.getDepth(); k++)
				{
					truck[currY+j][currZ+k][currX+i] = b.getName();
				}
			}
		}
	}
	
	public boolean isfilled(int x, int y, int z)
	{
        if (truck[y][z][x] == 0) 
        {
            return false;
        }
    return true;
	}
	
	public void setEmpty()
	{
		truck[currY][currZ][currX] = 9;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public int getWidth()
	{
		return width;
	}
}
