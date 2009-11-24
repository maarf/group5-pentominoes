import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class JohnyTheLandSlider implements KeyListener {

	private Board board;
	
	public JohnyTheLandSlider(Board aBoard) {
		board = aBoard;
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
//		case KeyEvent.VK_SPACE:
//			board.moveToTheBottom();
//			break;
		default:
			break;
		}

	}

	public void keyReleased(KeyEvent e) {
		// Do nothing
	}

	public void keyTyped(KeyEvent e) {
		// Do nothing
	}

}
