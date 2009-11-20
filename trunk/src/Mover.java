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

public class Mover extends Game
{
    /**
     * Method that makes every new pentomino move one line every step in time.
     * @param new
     */
    public void movePentomino(final Figure b)
    {
        class MyListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                BoardOperations bla = new BoardOperations();
                bla.moveDown(b);
            }
        }
        MyListener listener = new MyListener();
        final int DELAY = 1000 - (100 * (getLevel() - 1));
        Timer t = new Timer(DELAY, listener);
        t.start();
    }
    
   

  
// ask the pentominoclass a random pentomino, call it ActivePentomino, and add it to the method movepentomino.
    // make sure you get the keylistener from martins.
    // ActivePentomino moveleft, moveright, movedown, rotate and keylistener, with Martins and Ronald and Seyit.
}
