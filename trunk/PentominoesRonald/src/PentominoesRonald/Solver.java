/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PentominoesRonald;

/**
 *
 * @author Beheerder
 */
public class Solver
{
    /** This constructor sets the input board and the input exceptions.
     * 
     * @param board The Board on which the solver algorithm should work.
     * @param exceptions The Exceptions object with which the solver should reconcile it's solutions.
     */
    public Solver(Board board, Exceptions exceptions)
    {
        this.board = board;
        this.exceptions = exceptions;
    }

    public int solve(Pentominoes[] pentominoes)
    {
        int width = board.width();
        int height = board.height();
        for(int x = 0; x <= width; x++)
        {
            for(int y = 0; y <= height; y++)
            {
                
            }
        }


       
        
        return solutions;
    }




    /** Returns the current number of solutions
     *
     * @return Returns the current number of solutions.
     */
    public int returnsSolution()
    {
        return solutions;
    }
    private static int solutions;
    private Board board;
    private Exceptions exceptions;
}
