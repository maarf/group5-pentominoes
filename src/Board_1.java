/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Leoni Haagmans & Ronald Gerits
 */

import javax.swing.*;

public class Board_1 extends JComponent
{
     public static void main(String[] args)
     {
        JFrame frame = new JFrame();
        JButton button = new JButton("Play");
        JButton button2 = new JButton("Pause");

        Board2 bord = new Board2();

        JPanel panel = new JPanel();

        panel.add(button);
        panel.add(button2);
        frame.add(panel);
      
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Pentris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
     }

     /**This method returns the height
      *
      * @return int
      */
     public int getHeight()
     {
         return height;
     }

     /** Returns width
      *
      * @return int
      */
     public int getWidth()
     {
         return width;
     }

     private int width;
     private int height;
     public Pentomino NextPent;
     private static final int FRAME_WIDTH = 400;
     private static final int FRAME_HEIGHT = 400;
}

