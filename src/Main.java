/**
	This is the Main class of the project. Here we initialize all the pentominoes and add the to an array. We will run our solver and some other stuff here.
*/
public class Main
{
	/**
		The main method, hold on!
	*/
	public static void main(String[] args)
	{
		SuperBruteSolver solver = new SuperBruteSolver(listPentominoes(), 6, 5);
		System.out.println("Solution with mirror images: " + solver.solve());
                System.out.println("Solution without mirror images: " + (solver.solve())/4);
	}
	
	/**
	 * Defines all the twelve pentomiones
	 * @return array of pentominoes
	 */
	public static Pentomino[] listPentominoes() {
		Pentomino[] pentominoes = {
			new Pentomino("##\n" + 
			              "##\n" +
			              "#.", 1), // P
			
			new Pentomino(".##\n" + 
			              "##.\n" +
			              ".#.", 2), // F
			
			new Pentomino("#..\n" + 
			              "#..\n" +
			              "###", 3), // L
			
			new Pentomino("#..\n" + 
			              "##.\n" +
			              ".##", 4), // W
			
			new Pentomino(".#\n" + 
			              "##\n" +
			              ".#\n" +
			              ".#", 5), // Y
			
			new Pentomino("#####", 6), // I
			
			new Pentomino("###\n" + 
			              ".#.\n" +
			              ".#.", 7), // T
			
			new Pentomino("##.\n" + 
			              ".#.\n" +
			              ".##", 8), // Z
			
			new Pentomino(".#.\n" + 
			              "###\n" +
			              ".#.", 9), // X
			
			new Pentomino("#.#\n" + 
			              "###", 10), // U
			
			new Pentomino("##..\n" + 
			              ".###", 11), // N
			
			new Pentomino("#...\n" + 
			              "####", 12) // X
		};
		
		// List all the pentominoes here
		
		return pentominoes;
	}
}