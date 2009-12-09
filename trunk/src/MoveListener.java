import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * 
 * @author Leoni Haagmans and Martins Spilners
 *
 */

public class MoveListener implements KeyListener {

	private TheBoard board;
	private BoardView boardView;
	
	/**
	 * constructor of MoveListener
	 * @param aBoard that adds the board
	 * @param aView adds the boardview
	 */
	public MoveListener(TheBoard aBoard, BoardView aView) {
		board = aBoard;
		boardView = aView;
	}
	
	/**
	 * all keylisteners for the game Pentris
	 */
	public void keyPressed(KeyEvent e) {
		// Slide Land!
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			board.moveLeft();			
			break;
		case KeyEvent.VK_RIGHT:
			board.moveRight();			
			break;
		case KeyEvent.VK_DOWN:
			board.moveDown();			
			break;
		case KeyEvent.VK_UP:
			board.rotateFigure();			
			break;
		case KeyEvent.VK_SPACE:
			board.moveToBottom();
			break;
		}
		
		boardView.repaint();
	}

	public void keyReleased(KeyEvent e) {
		// Do nothing
	}

	public void keyTyped(KeyEvent e) {
		// Do nothing
	}

}
