import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

import javax.swing.JComponent;


public class BoardView extends JComponent {
	
	private static final long serialVersionUID = 1L;
	private TheBoard board;
	public int figureSize = 30;
	
	public BoardView(TheBoard aBoard) {
		board = aBoard;
		setPreferredSize(new Dimension(board.getWidth() * figureSize + 5, board.getHeight() * figureSize + 5));
	}

	public BoardView(TheBoard aBoard, int size) {
		this(aBoard);
		figureSize = size;
		setPreferredSize(new Dimension(board.getWidth() * figureSize + 5, board.getHeight() * figureSize + 5));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		draw(g2);
	}
	
	public void draw(Graphics2D g2) {
		// Lets draw some nice borders!!!!
		g2.setColor(Color.white);
		g2.draw(new Line2D.Double(
				new Point(0, 0),
				new Point(0, board.getHeight() * figureSize + 2)
			));
		g2.draw(new Line2D.Double(
				new Point(0, board.getHeight() * figureSize + 2),
				new Point(board.getWidth() * figureSize + 2, board.getHeight() * figureSize + 2)
			));
		g2.draw(new Line2D.Double(
				new Point(board.getWidth() * figureSize + 2, board.getHeight() * figureSize + 2),
				new Point(board.getWidth() * figureSize + 2, 0)
			));
		g2.draw(new Line2D.Double(
				new Point(board.getWidth() * figureSize + 2, 0),
				new Point(0, 0)
			));
		
		
		int[][] boardState = board.returnBoard();
		
		int rowNumber = 0;
		int columnNumber = 0;
		for (int[] row : boardState) {
			for (int field : row) {
				if (field != 0) {
					g2.setColor(colors[field - 1]);
					g2.fill(new Rectangle(rowNumber * figureSize + 2, columnNumber * figureSize + 2, figureSize - 1, figureSize - 1));
				}
				columnNumber++;
			}
			columnNumber = 0;
			rowNumber++;
		}
	}
	
	private Color[] colors = { Color.white, Color.blue, Color.cyan, Color.GREEN, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow };

	
}
