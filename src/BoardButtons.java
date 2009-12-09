
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

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
	private static final long serialVersionUID = 2906078564924014395L;
	
	private JLabel scoreLabel;
    private JLabel linesLabel;
    private JLabel levelLabel;
    private JButton start;
//    private JButton pause;
    private JButton stop;
    private TheBoard board;
    private MoveTimer moveTimer;
    private JFrame frame;
    public JPanel panel = new JPanel();
    private BoardView nextFiguereBoardView;
    public HighScoreKeeper highScores;
    private JTextPane highScoreLabel;

    public BoardButtons(TheBoard aBoard, MoveTimer aMoveTimer, BoardView next, JFrame aFrame)
    {
        board = aBoard;
        moveTimer = aMoveTimer;
        nextFiguereBoardView = next;
        frame = aFrame;
        
        scoreLabel = new JLabel();
        scoreLabel.setForeground(Color.white);
        scoreLabel.setPreferredSize(new Dimension(100, 20));
        linesLabel = new JLabel();
        linesLabel.setForeground(Color.white);
        linesLabel.setPreferredSize(new Dimension(100, 20));
        levelLabel = new JLabel();
        levelLabel.setForeground(Color.white);
        levelLabel.setPreferredSize(new Dimension(100, 20));
        highScoreLabel = new JTextPane();
        highScoreLabel.setForeground(Color.white);
        highScoreLabel.setBackground(Color.black);
        highScoreLabel.setPreferredSize(new Dimension(100, 150));

        createButton();
        createPanel();
        
        panel.setBackground(Color.black);
        panel.setPreferredSize(new Dimension(120, 400));
    }

    private void createButton()
    {
        start = new JButton("Play");
        stop = new JButton("Stop");
//        pause = new JButton("Pause");

        class StopListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                moveTimer.stop();
                frame.requestFocus();
            }
        }
        class StartListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                moveTimer.start();
                frame.requestFocus();
            }
        }
//        class PauseListener implements ActionListener
//        {
//            public void actionPerformed(ActionEvent event)
//            {
//                moveTimer.stop();
//            }
//        }

	    ActionListener listener = new StartListener();
	    start.addActionListener(listener);
	    ActionListener listener3 = new StopListener();
	    stop.addActionListener(listener3);
//	    ActionListener listener2 = new PauseListener();
//	    pause.addActionListener(listener2);
    }

    private void createPanel()
    {
    	panel.add(nextFiguereBoardView);
        panel.add(start);
        panel.add(stop);
//        panel.add(pause);

        panel.add(scoreLabel);
        panel.add(linesLabel);
        panel.add(levelLabel);
        panel.add(highScoreLabel);
    }
    
    public void update() {
    	scoreLabel.setText("Score: " + board.getScore());
    	linesLabel.setText("Lines: " + board.getLinesRemoved());
    	levelLabel.setText("Level: " + board.getLevel());
    	
    	int[] scores = highScores.getScores();
    	String[] names = highScores.getNames();
    	String text = "Highscores:";
    	for (int i = 0; i < scores.length - 1; i++) {
			text = new String(text + "\n" + (i + 1) + ": " + (names[i] != null ? names[i] : "No name") + " " + scores[i]);
		}
    	highScoreLabel.setText(text);			
    	
    	nextFiguereBoardView.repaint();
    }
}
