
public class Truck 
{
	private int height, length, width;
	private int [][][] truck;
	private int counter;
	private int currX = 0, currY = 0, currZ = 0;
	
	
	
	public Truck(int aHeight, int aLength, int aWidth)	
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
		if(width-1-currX>bParcel.getParcelX() && height-1-currY>bParcel.getParcelY() && length-1-currZ>bParcel.getParcelZ())
		{
			return true;
		}
		return false;
	}
	
	public boolean fits(Figure a)
	{
		if(width-1-currX>a.getWidth() && height-1-currY>a.getHeight() && length-1-currZ>a.getDepth())
		{
			return true;
		}
		return false;
	}
	
	
	public void NextBlank()
	{
		for(int i = 0; i < truck.length -1; i++)
		{
			for(int j = 0; j < truck[i].length-1; j++)
			{
				for(int k = 0; k < truck[i][j].length-1; k++)//msschn niet goed
				{
					if(!isfilled(i,j,k)) 
					{
						currY = i;
						currZ = j;
						currX = k;
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
		for (int i = 0; i<a.getParcelY();i++)
		{
			for(int j = 0; j<a.getParcelZ(); j++)
			{
				for(int k = 0; k<a.getParcelX(); k++)
				{
					truck[currY+i][currZ+j][currX+k] = a.getValue();
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
	
	public boolean isfilled(int y, int z, int x)
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
