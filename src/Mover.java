/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leoni
 */

import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Mover
{
    /**
     * Method that makes every new pentomino move one line every step in time.
     * @param new
     */
	private final TheBoard board;
	private final BoardView boardView;
	
	public Mover(TheBoard aBoard, BoardView aView) {
		board = aBoard;
		boardView = aView;
	}
	
    public void movePentomino()
    {
        class MyListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                board.moveDown();
                boardView.repaint();
            }
        }
        MyListener listener = new MyListener();
        final int DELAY = 1000 - (100 * (1 - 1));
        Timer t = new Timer(DELAY, listener);
        t.start();
    }
    
   

  
// ask the pentominoclass a random pentomino, call it ActivePentomino, and add it to the method movepentomino.
    // make sure you get the keylistener from martins.
    // ActivePentomino moveleft, moveright, movedown, rotate and keylistener, with Martins and Ronald and Seyit.
}
