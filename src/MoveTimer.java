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
	
	/**
	 * Timer that moves a pentomino down once every step in time
	 * @param aBoard
	 * @param aView
	 */
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
	/**
	 * starts the game
	 */
    public void start()
    {
        t.start();
    }
    
    /**
     * updates the delay to the level
     */
    public void update() {
    	t.setDelay(1000 - (100 * (board.getLevel() - 1)));
    }
    
    /**
     * stops the timer
     */
    public void stop() {
    	t.stop();
    }
    
    /**
     * 
     * @param someButtons
     */
    public void buttons(BoardButtons someButtons) {
    	buttons = someButtons;
    }

  
// ask the pentominoclass a random pentomino, call it ActivePentomino, and add it to the method movepentomino.
    // make sure you get the keylistener from martins.
    // ActivePentomino moveleft, moveright, movedown, rotate and keylistener, with Martins and Ronald and Seyit.
}
