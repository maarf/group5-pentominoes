/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leoni Haagmans & Ronald Gerits
 */
public class BoardOperations
{
    public BoardOperations(int x, int y)
    {
        board = new Figure[x][y];
    }

    public void placePentomino(Figure b, int x, int y)
    {
        if (checkFull(b, x, y) == true)
        {
        int[][] bArray = new int[5][2];
        for(int i = 0; i < 5; i++)
        {
            bArray[i][0] = b.getX(i);
            bArray[i][1] = b.getY(i);
        }
               
       for(int i = 0; i < 5; i++)
       {
         board[bArray[i][0] + x][bArray[i][1] + y] = b;
        }
        }
        
    }

    /**
     * Checks whether a certain Figure fits on the board.
     * @param b Figure
     * @param x
     * @param y
     * @return Returns true if the board isn't full at x,y.
     */
    public boolean checkFull(Figure b, int x, int y)
    {
       int[][] bArray = new int[5][2];
       for(int i = 0; i < 5; i++)
       {
           bArray[i][0] = b.getX(i);
           bArray[i][1] = b.getY(i);
       }

       for(int i = 0; i < 5; i++)
       {
           if(bArray[i][0] + x <= getWidth() && bArray[i][1] + y <= getHeight())
           {
               if(board[bArray[i][0] + x ][bArray[i][1] + y] != null)
               {
                    return false;
               }
           }
       }
       return true;
    }
    

    /**
     * Checks on which lines the board is full.
     * @return Returns an boolean-array. F.e. if [1] = true; line 1 is filled.
     */
    public boolean[] checkBoard()
    {

        boolean[] lines = new boolean[board[0].length];
        for(int i = 0; i < board[0].length; i++)
        {
            if(Checker(i) == true) lines[i] = true;
            else lines[i] = false;

        }
        return lines;
    }

    /**
     * Returns the number of full lines.
     * @return An int.
     */
    public int numberOfFullLines()
    {
        int numberoffulllines = 0;
        for(int i = 0; i < checkBoard().length; i++)
        {
            if(checkBoard()[i] == true) numberoffulllines++;
        }
        return numberoffulllines;
    }

    /**
     * Checks whether there is a line full.
     * @param line
     * @return
     */
    public boolean Checker(int line)
    {
        boolean check = false;

        for (int i = 0; i < board.length; i++)
        {
            Boolean end = false;
            while(!end)
            {
              if(board[i][line] != null)
                {
                 check = true;
                 
                 if(i == board.length)
                 {
                     end = true;
                 }
              }
             else
              {
                 check = false;
                 end = true;
              }
            }

        }
        return check;
    }

    /**
     * Method that deletes every filled line the checker found
     * @param line Line that has to be deleted
    */
    public void Deleter(int line)
    {
        for (int i = 0; i < board.length; i++)
        {
            board[i][line] = null;
        }
        lineCounter++;
    }

    /** Moves a line to another place
     * 
     * @param line Defines the line that has to be moved
     * @param newLocation The new location of the line
     */
    public void moveLine(int line, int newLocation)
    {
        for (int i = 0; i < board.length; i++)
        {
            board[i][newLocation] = board[i][line];
        }
    }

    public void moveDown(Figure b)
    {
        int[][] bArray = returnFigure(b);
        for(int x = 0; x < bArray.length; x++)
        {
          board[bArray[x][0]][bArray[x][1]] = null;
          board[bArray[x][0]][bArray[x][1] + 1] = b;
        }
    }

    public void moveMaxDown(Figure b)
    {
        int[][] bArray = returnFigure(b);
        int[] distances = new int[5];
        for(int i = 0; i < bArray.length; i++)
        {
            distances[i] = supremumX(bArray[i][0]) - bArray[i][1];
        }
        int min = 0;

        for(int i = 0; i < distances.length; i++)
        {
       
            if(distances[i] < min) distances[i] = min;
        }

        for(int x = 0; x < bArray.length; x++)
        {
          board[bArray[x][0]][bArray[x][1]] = null;
          board[bArray[x][0]][bArray[x][1] + min] = b;
        }
    }

    public int supremumX(int x)
    {
        int supremumX = 0;
        for(int y = 0; y < board[x].length; y++)
        {
            if(board[x][y] != null)
            {
                supremumX = y; 
            }
        }
        return supremumX;
    }

    public void moveLeft(Figure b)
    {
        int[][] bArray = returnFigure(b);
        for(int x = 0; x < bArray.length; x++)
        {
          board[bArray[x][0]][bArray[x][1]] = null;
          board[bArray[x][0] - 1][bArray[x][1]] = b;
        }

    }

    public void moveRight(Figure b)
    {
        int[][] bArray = returnFigure(b);
        for(int x = 0; x < bArray.length; x++)
        {
          board[bArray[x][0]][bArray[x][1]] = null;
          board[bArray[x][0] + 1][bArray[x][1]] = b;
        }

    }

    /**
     * Returns the coordinates of a certain Figure on the board.
     * @param b
     * @return A 2D int array of coordinates. x = int[x][0] and y = int[x][1].
     */
    public int[][] returnFigure(Figure b)
    {
        int last = 0;
        int[][] returnArray = new int[5][2];
        for(int x = 0; x < board.length; x++)
        {
            for(int y = 0; y < board[x].length; y++)
            {
                if(board[x][y] == b)
                {
                    returnArray[last][0] = x;
                    returnArray[last][1] = y;
                }
            }
        }
        return returnArray;
    }

    /**
     * Returns the board
     * @return Returns the Pentomino[][].
     */
    public Figure[][] returnBoard()
    {
        return board;
    }

    /** Returns the board as a String
     *
     * @return A string.
     */
    public String toString()
    {
        String output = "";
        for(int x = 0; x < board.length; x++)
        {
            for(int y = 0; y < board[x].length; y++)
            {
                output += " | " + board[x][y];
            }
            output += " | \n";
        }
        return output;
        
    }

    public int Counter()
    {
        return lineCounter;
    }

    public int getHeight()
     {
         return height;
     }

     /** Returns width
      *
      * @return int
      */
     public int getWidth()
     {
         return width;
     }

     
     private int width;
     private int height;

    private Figure[][] board;
    private int lineCounter;
}
