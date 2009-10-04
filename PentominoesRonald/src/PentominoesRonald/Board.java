/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PentominoesRonald;

/**
 *
 * @author Beheerder
 */
public class Board
{
    /** This constructer creates a board with a certain width and a certain height.
     *
     * @param width The maximum width of the board.
     * @param height The maximum height of the board.
     */
    public Board(int width, int height)
    {
        this.width = width;
        this.height = height;
        board = new Pentominoes[width][height];
    }

    /** This method try's to fit a certain pentominoe onto the board.
     *
     * @param tryPentominoe Requires a Pentominoe-object that is going to be tryied. 
     * @param x The x-coordinate of the location to be tryied.
     * @param y The y-coordinate of the location to be tryied.
     * @return Returns the value false if the Try was unsuccesfull, but returns true if the board leaves room for placement.
     *
     */
    public boolean Try(Pentominoes tryPentominoe, int x, int y)
    {
        boolean room = false;
        if(tryPentominoe.returnLength(1) + x <= width && tryPentominoe.returnLength(0) + y <= height && x >= 0 && y >= 0)
        {
        room = true;
        int C = 0;
        boolean end = false;
        while(room && !end)
        {
            for(int R = 0; R < tryPentominoe.returnMax(2); R++)
            {
                if(board[tryPentominoe.returnPentominoe()[R][C] + x][tryPentominoe.returnPentominoe()[R][C + 1] + y] == null);
                else room = false;
            }
            end = true;
        }

        }
        return room;
        
    }

    /** This method places a certain Pentominoe on the board.
     *
     * @param placePentominoe Requirers a Pentominoe-object to be placed.
     * @param x The x-coordinate of the location to be tryied.
     * @param y The y-coordinate of the location to be tryied.
     * @return Returns true if the Pentominoe is placed, returns false if the pentominoe wasn't placed.
     */
    public boolean placePentominoe(Pentominoes placePentominoe, int x, int y)
    {
        if(Try(placePentominoe, x, y) == true)
        {
            int C = 0;
            for(int R = 0; R < placePentominoe.returnMax(2); R++)
            {
                board[placePentominoe.returnPentominoe()[R][C] + x][placePentominoe.returnPentominoe()[R][C + 1] + y] = placePentominoe;
            }
            return true;
        }
        return false;

    }

    /** This method returns the current board as an Pentominoe[][].
     *
     * @return An 2D Pentominoe array of the board.
     */
     public Pentominoes[][] returnBoard()
     {
         return board;
     }

     public boolean boardFull()
     {
         boolean full = true;
         boolean end = false;
         while(full && !end)
         {
         for(int x = 0; x <= width; x++)
         {
             for(int y = 0; y <= height; y++)
             {
                 if(board[x][y] == null) full = false;
                 if(x == width && y == height) end = true;
             }
         }
         }
         return full;
     }

     /** This method returns whether or not a certain row is full
      *
      * @param y The number of the line that is to be checked.
      * @return Returns true if the row is full, returns false if the line is not full.
      */
     public boolean rowFull(int y)
     {
         boolean full = true;
         while(!full)
         for(int x = 0; x <= width; x++)
         {
             if(board[x][y] == null) full = false;
         }
         return full;
     }

    /** Returns the current width of the board
     *
     * @return Returns the current width of the board in x.
     */
    public int width()
    {
        return width;
    }

    /** Returns the current height of the board
     *
     * @return Returns the current height of the board in y values.
     */
    public int height()
    {
        return height;
    }
    
    private int width;
    private int height;
    private Pentominoes[][] board;
    
}
