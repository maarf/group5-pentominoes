import java.util.ArrayList;


public class Truck 
{
	private int height, length, width;
	private int [][][] truck;
	private int counter = 0, count = 0;
	private int currX = 0, currY = 0, currZ = 0;

	
	/*
	 * List of all parcels in the truck.
	 */
	private ArrayList<ParcelAtPlace> parcels = new ArrayList<ParcelAtPlace>();
	
	
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
		
		if(counter == 0)
		{
			counter = 0;
			return true;
		}
		
		return false;
	}
	
	public boolean stillFits()
	{
		Parcel a = new Parcel(2,2,4,3,0);
		if(fits(a))
		{
			return true;
		}
		return false;
	}
	
	public boolean fits(Parcel bParcel)
	{
		if(width-currX-1>=bParcel.getParcelX() && height-currY-1>=bParcel.getParcelY() && length-currZ-1>=bParcel.getParcelZ() && !isEmpty(bParcel))
		{
			return true;
		}
		return false;
	}
	
	public boolean fits(Figure a)
	{
		if(width-1-currX>=a.getWidth() && height-1-currY>=a.getHeight() && length-1-currZ>a.getDepth() )
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(Parcel a)
	{
		for (int i = 0; i<a.getParcelY();i++)
		{
			for(int j = 0; j<a.getParcelZ(); j++)
			{
				for(int k = 0; k<a.getParcelX(); k++)
				{
					if(	truck[currY+i][currZ+j][currX+k] == 0)
					{
						count++;
					}
				}
			}
		}
		if(count>1)
		{
			return false;
		}
		return true;
	}
	
	public void NextBlank()
	{
		for(int i = 0; i < truck.length-1; i++)
		{
			for(int j = 0; j < truck[i].length-1; j++)
			{
				for(int k = 0; k < truck[i][j].length-1; k++)
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
		parcels.add(new ParcelAtPlace(a, currX, currY, currZ));
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
		System.out.println("empty used");
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
	
	public Object[] getParcels() {
		return parcels.toArray();
	}

	public ArrayList<ParcelAtPlace> getRawParcels() {
		return parcels;
	}

	
	public int[][][] getTruck()
	{
		return truck;
	}
	
	/**
	 * Use very very carefully
	 * @param a
	 */
	public void setParcels(ArrayList<ParcelAtPlace> a) {
		parcels = a;
	}
	
	public void reset() {
		truck = new int[height][length][width];
		counter = 0;
		currX = 0;
		currY = 0;
		currZ = 0;
		
		parcels = new ArrayList<ParcelAtPlace>();
	}
	
	public int getValue() {
		int value = 0;
		for (ParcelAtPlace p : parcels) {
			value += p.parcel.getValue();
		}
		return value;
	}
	
	public int getBoxesById(int anId) {
		int count = 0;
		for (ParcelAtPlace p : parcels) {
			if (p.parcel.getId() == anId) {
				count++;				
			}
		}
		return count;
	}

	public int getABoxes() {
		return getBoxesById(0);
	}
	
	public int getBBoxes() {
		return getBoxesById(1);
	}

	public int getCBoxes() {
		return getBoxesById(2);
	}

}
