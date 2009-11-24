import java.awt.*;
import javax.swing.*;


public class BoardPanel extends JComponent {
	
	private Board board;
	
	public BoardPanel(Board aBoard) {
		board = aBoard;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		draw(g2);
	}
	
	public void draw(Graphics2D g2) {
		int[][] boardState = board.getGrid();
		Color[] colors = listColors();
		
		int rowNumber = 0;
		int columnNumber = 0;
		for (int[] row : boardState) {
			for (int field : row) {
				if (field != 0) {
					g2.setColor(listColors()[field - 1]);
					g2.fill(new Rectangle(columnNumber * 30, rowNumber * 30, 29, 29));
				}
				columnNumber++;
			}
			columnNumber = 0;
			rowNumber++;
		}
	}
	
	private Color[] listColors() {
		Color[] colors = { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow };
		return colors;
	}
	
}
