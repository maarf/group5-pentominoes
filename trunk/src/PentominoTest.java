/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Leoni
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class PentominoTest extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        Pentomino p = new Pentomino("##\n" +"##\n" +"#.", 1);
        Pentomino f = new Pentomino(".##\n" +"##.\n" +".#.", 2);
        Pentomino l = new Pentomino("#..\n" +"#..\n" +"###", 3);
        Pentomino w = new Pentomino("#..\n" +"##.\n" +".##", 4);
        Pentomino y = new Pentomino(".#\n" +"##\n" +".#\n" +".#", 5);
        Pentomino I = new Pentomino("#####", 6);
        Pentomino t = new Pentomino("###\n" +".#.\n" +".#.", 7);
        Pentomino z = new Pentomino("##.\n" +".#.\n" +".##", 8);
        Pentomino x = new Pentomino(".#.\n" +"###\n" +".#.", 9);
        Pentomino u = new Pentomino("#.#\n" +"###", 10);
        Pentomino n = new Pentomino("##..\n" +".###", 11);
        Pentomino X = new Pentomino("#...\n" +"####", 12);

        for (int i = 0; i < p.getMutations().length; i++)
        {
            drawPentomino(i*50,10,(Pentomino)p.getMutations()[i],g2, Color.green);
        }
        for (int i = 0; i < f.getMutations().length; i++)
        {
            drawPentomino(i*50,60,(Pentomino)f.getMutations()[i],g2, Color.blue);
        }
        for (int i = 0; i < l.getMutations().length; i++)
        {
            drawPentomino(i*50,110,(Pentomino)l.getMutations()[i],g2, Color.orange);
        }
        for (int i = 0; i < w.getMutations().length; i++)
        {
            drawPentomino(i*50,160,(Pentomino)w.getMutations()[i],g2, Color.BLACK);
        }
        for (int i = 0; i < y.getMutations().length; i++)
        {
            drawPentomino(i*50,210,(Pentomino)y.getMutations()[i],g2, Color.CYAN);
        }
        for (int i = 0; i < I.getMutations().length; i++)
        {
            drawPentomino(i*50,260,(Pentomino)I.getMutations()[i],g2, Color.DARK_GRAY);
        }
        for (int i = 0; i < t.getMutations().length; i++)
        {
            drawPentomino(i*50,320,(Pentomino)t.getMutations()[i],g2, Color.GRAY);
        }
        for (int i = 0; i < z.getMutations().length; i++)
        {
            drawPentomino(i*50,360,(Pentomino)z.getMutations()[i],g2, Color.MAGENTA);
        }
        for (int i = 0; i < x.getMutations().length; i++)
        {
            drawPentomino(i*50,410,(Pentomino)x.getMutations()[i],g2, Color.PINK);
        }
        for (int i = 0; i < u.getMutations().length; i++)
        {
            drawPentomino(i*50,460,(Pentomino)u.getMutations()[i],g2, Color.RED);
        }
        for (int i = 0; i < n.getMutations().length; i++)
        {
            drawPentomino(i*50,510,(Pentomino)n.getMutations()[i],g2, Color.YELLOW);
        }
        for (int i = 0; i < X.getMutations().length; i++)
        {
            drawPentomino(i*50,560,(Pentomino)X.getMutations()[i],g2, Color.WHITE);
        }

    }

    public void drawPentomino(int x, int y, Pentomino p, Graphics2D g2, Color c)
    {
        g2.setColor(c);

        boolean[][] pentomino = p.getState();
        for (int q = 0; q < pentomino.length; q++)
        {
            for (int r = 0; r < pentomino[q].length; r++)
            {
                if(pentomino[q][r]==true)
                {
                  g2.draw3DRect(x+q*10, y+r*10, 10, 10, true);

                  g2.fill3DRect(x+q*10, y+r*10, 10, 10, true);
                }
            }

        }
    }
/*
        boolean[][] L = new boolean[][]{{true,false},{true,false},{true,false},{true,true},{false,false}};
        int x=10, y=10;
        for (int i = 0; i < L.length; i++)
        {
            for (int j = 0; j < L[i].length; j++)
            {
                if(L[i][j]==true)
                {
                    // maak een vierkantje
                    g2.fillRect(x+i*20, y+j*20, 20, 20);
                } 
                else
                {
                    // doe niets
                }
            }
        }

       boolean[][] I = new boolean[][]{{true, false},{true,false},{true,false},{true,false},{true,false}};
       int a = 10, b = 50;
       for (int k = 0; k < I.length; k++)
       {
            for (int l = 0; l < I[k].length; l++)
            {
                if(I[k][l]==true)
                {
                    // maak een vierkantje
                    g2.setColor(Color.blue);
                    g2.fillRect(a+k*20, b+l*20, 20, 20);
                }
                else
                {
                    // doe niets
                }
            }
       }

        boolean[][] P = new boolean[][]{{true, true, false},{true,true, false},{true,false,false}};
        int c = 10, d = 90;
        for (int m = 0; m < P.length; m++)
        {
            for (int n = 0; n < P[m].length; n++)
            {
                if(P[m][n]==true)
                {
                    g2.setColor(Color.red);
                    g2.fillRect(c+m*20, d+n*20, 20, 20);
                }
                else
                {
                    //doe niets
                }
            }

        }

        boolean[][] plus = new boolean[][]{{false,true,false},{true,true,true},{false,true,false}};
        int e = 10, f = 130;
        for (int o = 0; o < plus.length; o++)
        {
            for (int p = 0; p < plus[o].length; p++)
            {
                if(plus[o][p]==true)
                {
                    g2.setColor(Color.CYAN);
                    g2.fillRect(e+o*20, f+p*20, 20, 20);
                }
            }

        }

        boolean[][] F = new boolean[][]{{false, true, false},{true,true,true},{true,false,false}};
        int s = 10, h = 220;
 * */

        
}

    

