/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Leoni
 */

import javax.swing.*;

public class Board_1 extends JComponent
{
     public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("Play");
        JButton button2 = new JButton("Pause");

        //final JLabel label = new JLabel();
        Board2 bord = new Board2();

        JPanel panel = new JPanel();

        panel.add(button);
        panel.add(button2);
        //panel.add(label);
        //panel.add(bord);
        frame.add(panel);
      
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Pentris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
}

