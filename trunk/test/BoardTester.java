public class BoardTester
{
    public BoardTester(int width, int height)
    {
        Pentomino[] pentominos = new PentominoeTester().returnPentominos();
        board = new Board(width, height);
        board.addPentomino(pentominos[0], 0,0); //should return true;
        board.addPentomino(pentominos[1], 0,0); //should return false.
        board.addPentomino(pentominos[1], 1,0); //should return true.
    }

    public Board returnBoard()
    {
        return board;
    }

    private Board board;
}