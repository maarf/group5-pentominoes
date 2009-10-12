

public class BoardTester
{
	public static void main(String[] args)
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
		System.out.println("Initial state:\n" + someBoard.toString());
		System.out.println("First pentomino? " + 
				someBoard.addPentomino(pentomino1, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		System.out.println(someBoard.getNextBlankX() + ":" + someBoard.getNextBlankY());
		System.out.println("Second pentomino? " +
				someBoard.addPentomino(pentomino2, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		System.out.println("Third pentomino? " +
				someBoard.addPentomino(pentomino3, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		System.out.println("Fourth pentomino? " +
				someBoard.addPentomino(pentomino4, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		System.out.println("Fifth pentomino? " +
				someBoard.addPentomino(pentomino5, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		System.out.println("Sixth pentomino? " +
				someBoard.addPentomino(pentomino6, someBoard.getNextBlankX(), someBoard.getNextBlankY()));
		System.out.println("State one:\n" + someBoard.toString());
		someBoard.removePentomino(pentomino5);
		System.out.println("State two:\n" + someBoard.toString());
	}
}