/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Beheerder
 */
public class Tester_BoardOperations
{
    public static void main(String[] args)
    {
        Figure L = new Figure(12);
        Figure I = new Figure(7);
        Figure X = new Figure(2);

        BoardOperations board = new BoardOperations(5, 15);

        System.out.println(board.checkFull(X, 0, 0));
        board.placePentomino(X, 0, 0);
        for(boolean a : board.checkBoard())
        {
            System.out.println(a);
        }
        System.out.println(board.toString());
    }
}
