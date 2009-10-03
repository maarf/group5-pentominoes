package PentominoesRonald;

/**
 *
 * @author Beheerder
 */
public class NewClass
{
    public static void main(String[] args)
    {
        Board bord = new Board(6,5);
        Pentominoes pent = new Pentominoes(0,0);

        //System.out.println(bord.Try(pent, 0, 0));
        bord.placePentominoe(pent, 0, 0);
        //System.out.println(bord.Try(pent, 0, 0));
        //bord.placePentominoe(pent, 0, 0);

        Pentominoes pentl = new Pentominoes(1,0);
        System.out.println(bord.Try(pentl, 1, 1));
        bord.Try(pentl, 2, 2);
        bord.placePentominoe(pentl, 2, 3);


        Pentominoes[][] arr = bord.returnBoard();
        String bord1 = "";
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                bord1 += arr[i][j] + " | ";
            }
        bord1 += "\n";
        }
        System.out.println(bord1);
        System.out.println(pentl.returnLength(0));
        System.out.println(pentl.returnLength(1));
        
        System.out.println("Test");
    }
}