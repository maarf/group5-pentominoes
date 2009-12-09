/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leoni
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class MoveTimer
{
    /**
     * Method that makes every new pentomino move one line every step in time.
     * @param new
     */
	private TheBoard board;
	private BoardView boardView;
	private Timer t;
	private BoardButtons buttons;
	
	public MoveTimer(TheBoard aBoard, BoardView aView) {
		board = aBoard;
		boardView = aView;
        TimerListener listener = new TimerListener();
        t = new Timer(1000 - (100 * (board.getLevel() - 1)), listener);
	}

    class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            board.moveDown();
            boardView.repaint();
            buttons.update();
            update();
        }
    }
	
    public void start()
    {
        t.start();
    }
    
    public void update() {
    	t.setDelay(1000 - (100 * (board.getLevel() - 1)));
    }
    
    public void stop() {
    	t.stop();
    }
    
    public void buttons(BoardButtons someButtons) {
    	buttons = someButtons;
    }

  
// ask the pentominoclass a random pentomino, call it ActivePentomino, and add it to the method movepentomino.
    // make sure you get the keylistener from martins.
    // ActivePentomino moveleft, moveright, movedown, rotate and keylistener, with Martins and Ronald and Seyit.
}
