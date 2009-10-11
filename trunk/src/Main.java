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
		Solver solver = new Solver(listPentominoes(), 6, 5);
		System.out.println(solver.solve());
	}
	
	/**
	 * Defines all the twelve pentomiones
	 * @return array of pentominoes
	 */
	public static Pentomino[] listPentominoes() {
		Pentomino[] pentominoes = {
			new Pentomino("##\n" + 
			              "##\n" +
			              "#."), // P
			
			new Pentomino(".##\n" + 
			              "##.\n" +
			              ".#."), // F
			
			new Pentomino("#..\n" + 
			              "#..\n" +
			              "###"), // L
			
			new Pentomino("#..\n" + 
			              "##.\n" +
			              ".##"), // W
			
			new Pentomino(".#\n" + 
			              "##\n" +
			              ".#\n" +
			              ".#"), // Y
			
			new Pentomino("#####"), // I
			
			new Pentomino("###\n" + 
			              ".#.\n" +
			              ".#."), // T
			
			new Pentomino("##.\n" + 
			              ".#.\n" +
			              ".##"), // Z
			
			new Pentomino(".#.\n" + 
			              "###\n" +
			              ".#."), // X
			
			new Pentomino("#.#\n" + 
			              "###"), // U
			
			new Pentomino("##..\n" + 
			              ".###"), // N
			
			new Pentomino("#...\n" + 
			              "####") // X
		};
		
		// List all the pentominoes here
		
		return pentominoes;
	}
}