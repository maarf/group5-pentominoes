import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Main class of the project.
 * Sets up the whole game
 * 
 * 09/12/09
 * 
 * @author Martins Spilners, Roland Gerits, Leoni Haagmans, José Sue Smith, Rob van den Oever, Seyit Ayas
 * @version 0.1
 */

public class Main
{
	/**
	 * The main method, hold on yer horses!
	 */
	public static void main(String[] args)
	{	
		
		HighScoreKeeper highScores;
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("highscores.dat"));
			highScores = (HighScoreKeeper)in.readObject();
		} catch (Exception e) {
			highScores = new HighScoreKeeper();
		}
		
		
		NextFigureBoard nextFigureBoard = new NextFigureBoard(5, 5, listPentominoes());
		BoardView nextFigureBoardView = new BoardView(nextFigureBoard, 10);
		
		TheBoard board = new TheBoard(5, 15, nextFigureBoard);
		board.addActiveFigure(listPentominoes()[0].randomPicker(listPentominoes()));
		board.highScores = highScores;
		
		BoardView boardView = new BoardView(board);
		
		MoveListener keyListener = new MoveListener(board, boardView);
		MoveTimer mover = new MoveTimer(board, boardView);

		JFrame frame = new JFrame();
		
		board.frame = frame;
		
        BoardButtons buttons = new BoardButtons(board, mover, nextFigureBoardView, frame);
        buttons.setBackground(Color.white);
        buttons.highScores = highScores;
        buttons.update();

        mover.buttons(buttons);
		mover.start();
        
		frame.setSize(new Dimension(board.getWidth() * 30 + 180, board.getHeight() * 30 + 50));
		frame.setTitle("Pentris");
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(keyListener);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
//		panel.setAlignmentX(-1);
		panel.add(boardView);
		panel.add(buttons.panel);
		frame.add(panel);
		
		frame.setVisible(true);
		frame.requestFocusInWindow();
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