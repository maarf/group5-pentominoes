import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		TheBoard board = new TheBoard(10, 15, listPentominoes());
		board.addActiveFigure(listPentominoes()[0].randomPicker(listPentominoes()));
		
		BoardView boardView = new BoardView(board);

		JohnyTheLandSlider keyListener = new JohnyTheLandSlider(board, boardView);
		Mover mover = new Mover(board, boardView);
		mover.movePentomino();
		
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(board.getWidth() * 30 + 50, board.getHeight() * 30 + 50));
		frame.setSize(new Dimension(500, 500));
                frame.setTitle("Pentris");
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(keyListener);
		frame.add(boardView);
                //BoardButtons buttons = new BoardButtons(frame);
                frame.setVisible(true);
	}
	
	/**
	 * Defines all the twelve pentomiones.
	 * @return array of pentominoes
	 */
	public static Figure[] listPentominoes() {
		// List all the pentominoes here
		Figure[] pentominoes = {
				new Figure(1),
				new Figure(2),
				new Figure(3),
				new Figure(4),
				new Figure(5),
				new Figure(6),
				new Figure(7),
				new Figure(8),
				new Figure(9),
				new Figure(10),
				new Figure(11),
				new Figure(12),
		};
		return pentominoes;
	}
}