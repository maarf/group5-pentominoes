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
    public Solver(Board board)
    {
        this.board = board;
        Exceptions exceptions = new Exceptions();
    }

    public boolean solve()
    {
        boolean solution = false;

        // set P
        // check for exceptions P
        //set S
        //check for exceptions S.
        // try

        if(board.boardFull() == true) solution = true;
        return solution;
    }

    
    private static int solutions = 0;
    private int P;
    private Board board;
}
