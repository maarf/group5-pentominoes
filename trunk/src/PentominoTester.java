public class PentominoTester
{
	public static void main(String[] args)
	{
		Pentomino pentominoX = new Pentomino(".#.\n###\n.#.");
		
		System.out.println("Here we go:\n" + pentominoX.toString());
//		System.out.println("The size of pentomino: [" + pentominoX.height() + "][" + pentominoX.width() + "]");
//		System.out.println("Is 0,0 filled? " + pentominoX.isFilled(0, 0));
//		System.out.println("Is 0,1 filled? " + pentominoX.isFilled(0, 1));
//		System.out.println("Is 1,0 filled? " + pentominoX.isFilled(1, 0));
//		System.out.println("Is 1,1 filled? " + pentominoX.isFilled(1, 1));
		System.out.println("The mutations:");
		for (Object mut : pentominoX.getMutations()) {
			System.out.println(mut.toString() + "\n");
		}
	}
}