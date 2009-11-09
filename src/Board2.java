/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Leoni
 */
import java.awt.*;
import javax.swing.*;

public class Board2 extends JComponent
{
    /*public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600,700);
        frame.setTitle("Pentris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board2 bord = new Board2();
        
        frame.add(bord);
        frame.setVisible(true);
    }*/
    public void paintComponent(Graphics2D g2)
    {
        Rectangle box = new Rectangle(5, 15, 10, 10);
        g2.setColor(Color.red);
	g2.fill(box);
    }
}
