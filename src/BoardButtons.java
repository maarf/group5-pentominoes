
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

    public BoardButtons()
    {
        topper = new TheBoard();
        highscore = new JLabel("Highscore: " + topper.getHighscore());
        numberOfLines = new JLabel("Number of lines deleted: " + topper.getLinesRemoved());

        createButton();
        createPanel();

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

    private void createPanel()
    {
        JPanel panel = new JPanel();
        panel.add(start);
        panel.add(stop);
        panel.add(pause);

        panel.add(highscore);

        panel.add(numberOfLines);
        add(panel);
    }
}
