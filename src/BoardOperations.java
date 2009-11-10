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
    }

    /** Moves a line to another place
     * 
     * @param line Defines the line that has to be moved
     * @param newLocation The new location of the line
     */
    public void MoveLine(int line, int newLocation)
    {
        for (int i = 0; i < board.length; i++)
        {
            board[i][newLocation] = board[i][line];
        }
    }

    /**
     * Returns the board
     * @return Returns the Pentomino[][].
     */
    public Pentomino[][] returnBoard()
    {
        return board;
    }

    private Pentomino[][] board;
}
