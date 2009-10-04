package PentominoesRonald;

/**
 *
 * @author Beheerder
 */
public class Pentominoes
{
    /** This constructor sets the 2D Pentominoe array (which can be returned by using the returnPentominoe()-method) with the appropriate Pentominoe coordinates.
     *
     * @param P This integer selects the Pentominoe chosen.
     * @param S This integer selects the state of Pentominoe P chosen.
     */
    public Pentominoes(int P, int S)
    {
        if(P >= 0 && P <= maxP && S >= 00 && S <= maxS)
        {
        for(int R = 0; R < maxR; R++)
        {
            for(int C = 0; C < maxC; C++)
            {
                Pentominoe[R][C] = Pentominoes[P][S][R][C];
            }
        }
        }
        else System.out.println("No valid Pentominoe has been chosen");
    }

    /** This method rotates a Pentominoe by adding one to the state. Note that it's the same object that encompasses the Pentominoe,
     * rather than making a new object that represents a rotated pentominoe.
     * @project If we were to apply a 3D array that also contained the State(s), then obviously a Rotationmethod would be obsolete.
     */
    public boolean takeRotatedPentominoe()
    {
        if(Pentominoes[P][S + 1][1][0] == 0 && Pentominoes[P][S + 1][1][1] == 0)
        {
            return false;
        }
        S++;
        for(int R = 0; R < maxR; R++)
            {
                for(int C = 0; C < maxC; C++)
                {
                    Pentominoe[R][C] = Pentominoes[P][S][R][C];
                }
            }
        return true;
    }

    /** This method returns the number of rotations of a certain Pentominoe are available.
     *
     * @return Returns an int which represents the number of rotations available.
     */
    public int returnRotations()
    {
        int rotations = 0;
        boolean moreRotations = true;
        while(!moreRotations)
        {
            if(Pentominoes[P][rotations + 1][1][0] == 0 && Pentominoes[P][rotations + 1][1][1] == 0)
            {
                moreRotations = false;
            }
            else rotations++;
        }
        return rotations;
    }
    /** This method returns the Pentominoe-array that holds all the coordinates for the rectangles of the Pentominoe.
     * 
     * @return Returns an 2 dimensional array that contains all the coordinates of the Pentominoe, without supplying mirrorimages of rotations.
     */
    public int[][] returnPentominoe()
    {
        return Pentominoe;
    }

    /** This method fills the Pentominoesarray with preconditioned coordinates, it describes all the coordinates of the Rectangles of a Pentominoe.
     *
     * @param maximum Required for return, P = 0, S = 1, R = 2, C = 3.
     * @project If we want to implement a dynamic-rotation/mirror method, this is usefull; with a static predescription of the Pentominoes it would be obsolete.
     * @return Returns the maximum value of a specific parameter, if no valid maximum is entered the return is 0.
     */
    public int returnMax(int maximum)
    {
        if(maximum >=0 && maximum <=3)
        {
        int[] max = { maxP, maxS, maxR, maxC };
        return max[maximum];
        }
        return 0;
    }

    /** This method returns the absolute length of the Pentominoe.
     *
     * @param C If the lenght in the x-direction is needed C should be 1, if the length in the y-direction is needed C should be 0.
     * @return Returns the length of a Pentominoe, counted in coordinates, if no valid C is entered the return is 0.
     */
    public int returnLength(int C)
    {
        if(C >= 0 && C <= 1)
        {
        int[] lengthArray = {0,0,0,0,0};
        for(int R = 0; R < maxR; R++)
        {
            lengthArray[Pentominoe[R][C]]++;
        }
        int max = 0;
        for(int i = 0; i < lengthArray.length; i++)
        {
            if(max < lengthArray[i]) max = lengthArray[i];
        }
        return max;
        }
        else return 0;
    }




    private static int P;
    private static int S;
    private static final int maxP = 12; //Number of different Pentominoes.
    private static final int maxS = 8; // Number of maximum different States (rotations).
    private static final int maxR = 5; // Number of Rectangles contained wihtin a Pentominoe.
    private static final int maxC = 2; // Number of coordinates (2: X & Y).
    private static int[][][][] Pentominoes = {{{ {0,0},{0,1},{0,2},{0,3},{1,3}}},{ { {0,0},{1,0},{2,0},{3,0},{3,1}}}}; //An array that contains 12 Pentominoes, 8 States and 8 Coordinates, where 0 is x, 1 is y etc..
    private int[][] Pentominoe = new int[maxR][maxC];
}
