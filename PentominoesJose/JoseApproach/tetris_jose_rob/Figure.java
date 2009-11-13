package tetris_jose_rob;

public class Figure implements Ifig
{
	public static final int P_Figure = 1;
	
	public static final int X_Figure = 2;
	
	private int [] shapeX = new int[5];
	
	private int [] shapeY = new int[5];
	
	private int orientation = 0;
	
	private int maxOrientation = 4;
	
	public int x1;
	
	public int y1;
	
	public Figure (int type)
	{
		initialize(type);
	}
	
	public void initialize(int type)
	{
		orientation = 0;
		
		switch(type)
		{
		case P_Figure:
			maxOrientation = 4;
			
        	shapeX[0] = -1;
        	shapeY[0] = 0;
        	shapeX[1] = -1;
        	shapeY[1] = 1;
        	shapeX[2] = -1;
        	shapeY[2] = 2;
        	shapeX[3] = 0;
        	shapeY[3] = 1;
        	shapeX[4] = 0;
        	shapeY[4] = 2;
        	break;
		case X_Figure:
			maxOrientation = 1;
        	shapeX[0] = 0;
        	shapeY[0] = 0;
        	shapeX[1] = 0;
        	shapeY[1] = 1;
        	shapeX[2] = 0;
        	shapeY[2] = 2;
        	shapeX[3] = 1;
        	shapeY[3] = 1;
        	shapeX[4] = -1;
        	shapeY[4] = 1;
			
        default :
            throw new IllegalArgumentException("No figure constant: " + 
                                               type);
		}
	}
	
	public int getOrientation()
	{
		return orientation;
	}
	
	public void rotateClockwise(Figure a)
	{
		for(int i = 0; i<4; i++)
		{
			int x = shapeX[i];
			int y = shapeY[i];
			
			y1 = y;
			y = x;
			x = -1 * y1;
		}
	}
	
	public void rotateCounterClockwise(Figure a)
	{
		for(int i = 0; i<4; i++)
		{
			int x = shapeX[i];
			int y = shapeY[i];
			
			x1 = x;
			x = y;
			y = -1 * x1;
		}
	}
	
	public void getLowestX()
	{
		
	}
}
