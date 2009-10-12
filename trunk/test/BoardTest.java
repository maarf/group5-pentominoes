import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BoardTest extends TestCase
{
	
	public static Test suite(){
		return new TestSuite(BoardTest.class);
	}
	    
	public void testFillingTheBoard()
	{
		// The pentomino
		Pentomino pentomino1 = new Pentomino("###\n#..\n#..", 1);
		Pentomino pentomino2 = new Pentomino("..##\n###.", 2);
		Pentomino pentomino3 = new Pentomino(".#\n.#\n.#\n##", 3);
		Pentomino pentomino4 = new Pentomino("..#\n###\n#..", 4);
		Pentomino pentomino5 = new Pentomino(".#\n##\n##", 5);
		Pentomino pentomino6 = new Pentomino(".#..\n####", 6);
		
		// The board
		Board someBoard = new Board(6, 5);
		
		// Assertions
		// Lets add some pentominoes
		assertTrue(someBoard.addPentomino(pentomino1, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		assertTrue(someBoard.addPentomino(pentomino2, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		assertTrue(someBoard.addPentomino(pentomino3, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		assertTrue(someBoard.addPentomino(pentomino4, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		assertTrue(someBoard.addPentomino(pentomino5, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		assertTrue(someBoard.addPentomino(pentomino6, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		// The board should be filled
		assertTrue(someBoard.isSolved());
	}
	

//  public BoardTest(int width, int height)
//  {
//      Pentomino[] pentominos = new PentominoeTester().returnPentominos();
//      board = new Board(width, height);
//      board.addPentomino(pentominos[0], 0,0); //should return true;
//      board.addPentomino(pentominos[1], 0,0); //should return false.
//      board.addPentomino(pentominos[1], 1,0); //should return true.
//  }
//
//  public Board returnBoard()
//  {
//      return board;
//  }
//
//  private Board board;

}