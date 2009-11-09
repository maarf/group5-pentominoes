/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Leoni
 */

import javax.swing.JFrame;

public class PentominoViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600,700);
        frame.setTitle("Pentris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PentominoTest moeder = new PentominoTest();
        frame.add(moeder);
                
        frame.setVisible(true);
    }
}
