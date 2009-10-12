public class PentominoeTester
{
     /** This constructor inputs all the Pentominodata and stores it in an array.
      *
      *
      */
    public PentominoeTester()
    {
        Pentomino pentI = new Pentomino("#####\n"); //1
        Pentomino pentL = new Pentomino("####\n...#\n"); //2
        Pentomino pentP = new Pentomino("###\n##.\n"); //3
        Pentomino pentX = new Pentomino(".#.\n###\n.#.\n"); //4
        Pentomino pentF = new Pentomino(".##\n##.\n.#.\n"); //5
        Pentomino pentN = new Pentomino("###.\n..##\n"); //6
        Pentomino pentT = new Pentomino("###\n.#.\n.#.\n"); //7
        Pentomino pentU = new Pentomino("###\n#.#\n"); //8
        Pentomino pentV = new Pentomino("###\n#..\n#..\n"); //9
        Pentomino pentY = new Pentomino("####\n..#.\n"); //10
        Pentomino pentZ = new Pentomino("##.\n.#.\.##\n"); //11
        Pentomino pentW = new Pentomino(".##\n##.\n#..\n"); //12

        pentominoArray = new Pentomino[12];
        pentominoArray = {pentI, pentL, pentP, pentX, pentF, pentN, pentP, pentT, pentU, pentV, pentY, pentZ, pentW};

        for(Pentomino pent : pentominoArray)
        {
            System.out.println("Basic Pentomino: " + pent.toString());
            for(Object mutation : pent.generateMutations())
            {
                System.out.println("Mutation: " + mutation.toString());
            }
        }
    }
    public Pentomino[] returnPentominos()
    {
        return pentominoArray;
    }

    private Pentomino[] pentominoArray;
}
