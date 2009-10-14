
/**
 * The Main class of the project.
 * Here we initialize all the pentominoes and add them to an array.
 * We will run our solver here.
 * 
 * 15/09/2009
 * 
 * @author Martins Spilners, Roland Gerits, Leoni Haagmans
 * @version 0.1
 */

public class Main
{
	/**
	 * The main method, hold on yer horses!
	 */
	public static void main(String[] args)
	{
		SuperBruteSolver solver = new SuperBruteSolver(listPentominoes(), 6, 5);
		int solutions = solver.solve();
		System.out.println("Solution with mirror images: " + solutions);
		System.out.println("Solution without mirror images: " + (solutions)/4);
	}
	
	/**
	 * Defines all the twelve pentomiones.
	 * @return array of pentominoes
	 */
	public static Pentomino[] listPentominoes() {

		// List all the pentominoes here
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
		
		return pentominoes;
	}
}