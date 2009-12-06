import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class JohnyTheLandSlider implements KeyListener {

	private TheBoard board;
	private BoardView boardView;
	
	public JohnyTheLandSlider(TheBoard aBoard, BoardView aView) {
		board = aBoard;
		boardView = aView;
	}
	
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
		default:
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
