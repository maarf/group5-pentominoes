package dlx;

public class Board 
{
	private static final int ROWS = 5;  //Number of rows in the board.
	private static final int COLS = 6;  // Number of columns in the board.
	private int piecesNeeded; // How many pieces are needed to fill board as much as possible.  Always <= 12
	private int spareSpaces;  // Number of extra spaces after piecesNeeded pieces have been placed.
	private String [][]boardy;
	private String test1, test2;
	private int [][] pieces;
	private int x,y,z;
	private  static final int[][] pent = {
	      { 1, 0,1,0,2,0,3,0,4 },  // Describes piece 1 (the "I" pentomino) in its horizontal orientation.
	      { 1, 1,0,2,0,3,0,4,0 },  // Describes piece 1 (the "I" pentomino) in its vertical orientation.
	      { 2, 1,-1,1,0,1,1,2,0 }, // The "X" pentomino, in its only orientation.
	      { 3, 0,1,1,0,2,-1,2,0 }, // etc....
	      { 3, 1,0,1,1,1,2,2,2 },
	      { 3, 0,1,1,1,2,1,2,2 },
	      { 3, 1,-2,1,-1,1,0,2,-2 },
	      { 4, 1,0,2,0,2,1,2,2 },
	      { 4, 0,1,0,2,1,0,2,0 },
	      { 4, 1,0,2,-2,2,-1,2,0 },
	      { 4, 0,1,0,2,1,2,2,2 },
	      { 5, 0,1,0,2,1,1,2,1 },
	      { 5, 1,-2,1,-1,1,0,2,0 },
	      { 5, 1,0,2,-1,2,0,2,1 },
	      { 5, 1,0,1,1,1,2,2,0 },
	      { 6, 1,0,1,1,2,1,2,2 },
	      { 6, 1,-1,1,0,2,-2,2,-1 },
	      { 6, 0,1,1,1,1,2,2,2 },
	      { 6, 0,1,1,-1,1,0,2,-1 },
	      { 7, 0,1,0,2,1,0,1,2 },
	      { 7, 0,1,1,1,2,0,2,1 },
	      { 7, 0,2,1,0,1,1,1,2 },
	      { 7, 0,1,1,0,2,0,2,1 },
	      { 8, 1,0,1,1,1,2,1,3 },
	      { 8, 1,0,2,0,3,-1,3,0 },
	      { 8, 0,1,0,2,0,3,1,3 },
	      { 8, 0,1,1,0,2,0,3,0 },
	      { 8, 0,1,1,1,2,1,3,1 },
	      { 8, 0,1,0,2,0,3,1,0 },
	      { 8, 1,0,2,0,3,0,3,1 },
	      { 8, 1,-3,1,-2,1,-1,1,0 },
	      { 9, 0,1,1,-2,1,-1,1,0 },
	      { 9, 1,0,1,1,2,1,3,1 },
	      { 9, 0,1,0,2,1,-1,1,0 },
	      { 9, 1,0,2,0,2,1,3,1 },
	      { 9, 0,1,1,1,1,2,1,3 },
	      { 9, 1,0,2,-1,2,0,3,-1 },
	      { 9, 0,1,0,2,1,2,1,3 },
	      { 9, 1,-1,1,0,2,-1,3,-1 },
	      { 10, 1,-2,1,-1,1,0,1,1 },
	      { 10, 1,-1,1,0,2,0,3,0 },
	      { 10, 0,1,0,2,0,3,1,1 },
	      { 10, 1,0,2,0,2,1,3,0 },
	      { 10, 0,1,0,2,0,3,1,2 },
	      { 10, 1,0,1,1,2,0,3,0 },
	      { 10, 1,-1,1,0,1,1,1,2 },
	      { 10, 1,0,2,-1,2,0,3,0 },
	      { 11, 1,-1,1,0,1,1,2,1 },
	      { 11, 0,1,1,-1,1,0,2,0 },
	      { 11, 1,0,1,1,1,2,2,1 },
	      { 11, 1,0,1,1,2,-1,2,0 },
	      { 11, 1,-2,1,-1,1,0,2,-1 },
	      { 11, 0,1,1,1,1,2,2,1 },
	      { 11, 1,-1,1,0,1,1,2,-1 },
	      { 11, 1,-1,1,0,2,0,2,1 },
	      { 12, 0,1,1,0,1,1,2,1 },
	      { 12, 0,1,0,2,1,0,1,1 },
	      { 12, 1,0,1,1,2,0,2,1 },
	      { 12, 0,1,1,-1,1,0,1,1 },
	      { 12, 0,1,1,0,1,1,1,2 },
	      { 12, 1,-1,1,0,2,-1,2,0 },
	      { 12, 0,1,0,2,1,1,1,2 },
	      { 12, 0,1,1,0,1,1,2,0 }
	   };
	
	public Board()
	{
		boardy = new String [ROWS][COLS];
		//fill with spaces the board
		for (int i =0; i<ROWS; i++)
			for(int j = 0; j <COLS; j++)
				boardy[i][j] = "x";
	}
	public void set(int o, int u, int p, String f)//set content(string f will be used to mark space)
	{
		boardy [u][o] = f; // cause we know this is the first one
		
		for (int i = 1; i < 9; i+=2) // still to figure out why 9 and not 10, but with 9 is working:D
			{
			x = pent[p][i];
	
			for (int j = 2; j < 9; j +=2)
				y = pent[p][j];

			}			
		boardy [x+u][y+o] = f;
		
				
	}
	public void sety (int o, int u, int p, String f)//set content(string f will be used to mark space)
	{
		String [][] piece = new String [ROWS][COLS];
		
	
		boardy [u][o] = f; // cause we know this is the first one
		for (int i = 1; i < 9; i+=2) // still to figure out why 9 and not 10, but with 9 is working:D
		{
		x = pent[p][i];

		for (int j = 2; j < 9; j +=2)
			y = pent[p][j];
		piece [x+u][y+o] = f;
		}			
	boardy [x+u][y+o] = piece [x+u][y+o];

	}
	public void set1(int o, int u, int p, String f)
	{
		int x1 = 1;
		int y1 = 2;
		int n = 0;
		x = pent[p][y1];
		while(n<8)
		{
			//x = pent[p][x1];
			//y = pent[p][y1];
			boardy[x+u][y+o] = f;
			n++;
			x1 = x1 + 2;
			y1 = y1 + 2;
		}
	}
	public int get(int i, int j)//get contents - changed to int from string, should return boardy not pent
	{
		//return pent[i][j];
		return x;
	}
	/**
	 * public int getty(int i, int j)//get contents pentominoes
	{
		return pentominoes [i][j];
	}*/
	
	public String toString()//draws the board
	{
		String r = "";
		for (int i=0; i<ROWS; i++)
		{
			r = r+ "|";
			for (int j = 0; j<COLS; j++)
				r = r + boardy[i][j];
			r = r + "|\n";
		}
		return r;
	}

}