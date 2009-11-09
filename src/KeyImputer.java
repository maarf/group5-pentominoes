/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Leoni
 */
import javax.swing.*;

public class KeyImputer
{
    public static void main(String[] args)
    {
        
    }

    public void goingLeft()
    {
        if(keyImput == left)
        {
            repaint(pentomino X, x-1, y+1);
        }
        else
        {
            //do nothing
        }

    public void goingRight()
    {
        if(keyImput == right)
        {
            repaint(pentomino X, x+1, y+1);
        }
    }

    public void rotateKey()
    {
        if(keyImput == up)
        {
            repaint(pentomino X, x, y+1, state+1);
        }
    }

    public void goingDown()
    {
        if(keyImput == spacebar)
        {
            repaint(pentomino X, x, y+n);
        }
    }

}
