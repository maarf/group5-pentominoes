
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leoni
 */
public class BoardButtons extends JComponent
{
    private TheBoard topper;
    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 100;
    private JLabel highscore;
    private JLabel numberOfLines;
    private JButton start;
    private JButton pause;
    private JButton stop;
    private JFrame frame;
    //private JMenuBar bar;
    
    public BoardButtons(JFrame framepje)
    {
        frame = framepje;
        topper = new TheBoard();
        highscore = new JLabel("Highscore: " + topper.getHighscore());
        numberOfLines = new JLabel("Number of lines deleted: " + topper.getLinesRemoved());

        createButton();
        createPanel(frame);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createButton()
    {
        start = new JButton("Play");
        stop = new JButton("Stop");
        pause = new JButton("Pause");
    
        class StopListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                topper.Stop();
            }
        }
        class StartListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                topper.Start();
            }
        }
        class PauseListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                topper.Pause();
            }
        }

    ActionListener listener = new StartListener();
    start.addActionListener(listener);
    ActionListener listener2 = new PauseListener();
    pause.addActionListener(listener2);
    ActionListener listener3 = new StopListener();
    stop.addActionListener(listener3);
    
    }

    private void createPanel(JFrame frame)
    {
        JPanel controlPanel = new JPanel();
        
        controlPanel.add(start);
        controlPanel.add(stop);
        controlPanel.add(pause);
        
        controlPanel.add(highscore);
        controlPanel.add(numberOfLines);

        frame.add(controlPanel, BorderLayout.EAST);
        
    }
}
