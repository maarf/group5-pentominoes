import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PentominoTest extends TestCase
{
    
	public static Test suite(){
		return new TestSuite(PentominoTest.class);
	}
	
	public void testMutationsOnP() {
		// Just test whether there are 8 mutations for the P
		Pentomino pentominoP = new Pentomino("##\n##\n#.", 1);
		Object[] mutationsP = pentominoP.getMutations();
		
		assertEquals(mutationsP.length, 8);
	}
	
//    public PentominoTest()
//    {
//        Pentomino pentI = new Pentomino("#####\n", 1); //1
//        Pentomino pentL = new Pentomino("####\n...#\n", 2); //2
//        Pentomino pentP = new Pentomino("###\n##.\n", 3); //3
//        Pentomino pentX = new Pentomino(".#.\n###\n.#.\n", 4); //4
//        Pentomino pentF = new Pentomino(".##\n##.\n.#.\n", 5); //5
//        Pentomino pentN = new Pentomino("###.\n..##\n", 6); //6
//        Pentomino pentT = new Pentomino("###\n.#.\n.#.\n", 7); //7
//        Pentomino pentU = new Pentomino("###\n#.#\n", 8); //8
//        Pentomino pentV = new Pentomino("###\n#..\n#..\n", 9); //9
//        Pentomino pentY = new Pentomino("####\n..#.\n", 10); //10
//        Pentomino pentZ = new Pentomino("##.\n.#.\n.##\n", 11); //11
//        Pentomino pentW = new Pentomino(".##\n##.\n#..\n", 12); //12
//
//        Pentomino[] pentArray = {pentI, pentL, pentP, pentX, pentF, pentN, pentP, pentT, pentU, pentV, pentY, pentZ, pentW};
//        pentominoArray = pentArray;
//        
//        for(Pentomino pent : pentominoArray)
//        {
//            System.out.println("Basic Pentomino: " + pent.toString());
//            for(Object mutation : pent.getMutations())
//            {
//                System.out.println("Mutation: " + mutation.toString());
//            }
//        }
//    }
//    public Pentomino[] returnPentominos()
//    {
//        return pentominoArray;
//    }
//
//    private Pentomino[] pentominoArray;
}
