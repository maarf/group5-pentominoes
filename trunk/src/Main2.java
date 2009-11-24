import javax.swing.*;

/**
 * The Main class of the project.
 * Here we initialize all the pentominoes and add them to an array.
 * We will run our solver here.
 * 
 * @author Martins Spilners, Ronald Gerits, Leoni Haagmans, Seyit Ayas.
 * @version 0.2 17/11/(2010-1)
 */

public class Main2
{
	/**
	 * The main method, hold on yer horses!
	 */
	public static void main(String[] args)
	{
		Pentomino[] pentominoes = listPentominoes();
		
		Board board = new Board(5, 15);
		board.addPentomino(pentominoes[0], 0, 11);
		board.addPentomino(pentominoes[1], 3, 11);
		System.out.println(board);
		
		JFrame frame = new JFrame();
		frame.setSize(30 * board.getWidth(), 30 * board.getHeight());
		frame.setTitle("Pentris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new BoardPanel(board));
		frame.setVisible(true);
		
		JohnyTheLandSlider theMan = new JohnyTheLandSlider(board);
		// AMKE THE MAN WORKING!!!!
		
		// The timer
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