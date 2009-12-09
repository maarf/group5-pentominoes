import java.util.Random;

/**
 *
 * @author Rob van den Oever, Jos� Sue Smith and Leoni Haagmans
 * This class creates all the figures and calculates the clockwise and counterclockwise rotation
 *
 */
public class Figure
{
        public static final int P_FIGURE = 1;
       
        public static final int X_FIGURE = 2;
       
        public static final int F_FIGURE = 3;
       
        public static final int V_FIGURE = 4;
       
        public static final int W_FIGURE = 5;
       
        public static final int Y_FIGURE = 6;
       
        public static final int I_FIGURE = 7;
       
        public static final int T_FIGURE = 8;
       
        public static final int Z_FIGURE = 9;
       
        public static final int U_FIGURE = 10;
       
        public static final int N_FIGURE = 11;
       
        public static final int L_FIGURE = 12;
       
        private int [] shapeX = new int[5];
       
        private int [] shapeY = new int[5];
       
        private int orientation;
       
        private final int maxOrientation = 4;
       
        private int x1;
       
        private int y1;
       
        private int x2diff;
       
        private int y2diff;
       
        private int x3diff;
       
        private int x4diff;
       
        private int x5diff;
       
        private int y3diff;
       
        private int y4diff;
       
        private int y5diff;
       
        private int name;
       
        /**
         *  constructor of the pentominoes      
         * @param type
         */
        public Figure (int type)
        {
                initialize(type);
        }
       
       /**
        *  initializes all the pentominoes with x and y-coordinates
        */
       
        public void initialize(int type)
        {
                orientation = 1;
                x1 = 0;
                y1 = 0;
               
                switch(type)
                {
                case P_FIGURE:
                        //maxOrientation = 4;
                        name = 1;
                       
                shapeX[0] = 1;
                shapeY[0] = 1;
                shapeX[1] = 0;
                shapeY[1] = 1;
                shapeX[2] = 0;
                shapeY[2] = 2;
                shapeX[3] = 0;
                shapeY[3] = 0;
                shapeX[4] = 1;
                shapeY[4] = 2;
                break;
                case X_FIGURE:
                        //maxOrientation = 1;
                        name = 2;
                       
                shapeX[0] = 1;
                shapeY[0] = 1;
                shapeX[1] = 1;
                shapeY[1] = 0;
                shapeX[2] = 1;
                shapeY[2] = 2;
                shapeX[3] = 2;
                shapeY[3] = 1;
                shapeX[4] = 0;
                shapeY[4] = 1;
                        break;
                       
                case F_FIGURE:
                        //maxOrientation = 4;
                        name = 3;
                       
                shapeX[0] = 1;
                shapeY[0] = 1;
                shapeX[1] = 1;
                shapeY[1] = 0;
                shapeX[2] = 1;
                shapeY[2] = 2;
                shapeX[3] = 0;
                shapeY[3] = 1;
                shapeX[4] = 2;
                shapeY[4] = 2;
                break;
               
                case V_FIGURE:
                        //maxOrientation = 4;
                        name = 4;
                       
                shapeX[0] = 1;
                shapeY[0] = 0;
                shapeX[1] = 2;
                shapeY[1] = 0;
                shapeX[2] = 0;
                shapeY[2] = 0;
                shapeX[3] = 0;
                shapeY[3] = 1;
                shapeX[4] = 0;
                shapeY[4] = 2;
                break;
                case W_FIGURE:
                        //maxOrientation = 4;
                        name = 5;
                       
                shapeX[0] = 1;
                shapeY[0] = 1;
                shapeX[1] = 1;
                shapeY[1] = 0;
                shapeX[2] = 2;
                shapeY[2] = 0;
                shapeX[3] = 0;
                shapeY[3] = 1;
                shapeX[4] = 0;
                shapeY[4] = 2;
                break;
                case Y_FIGURE:
                        //maxOrientation = 4;
                        name = 6;
                       
                shapeX[0] = 1;
                shapeY[0] = 1;
                shapeX[1] = 1;
                shapeY[1] = 0;
                shapeX[2] = 1;
                shapeY[2] = 2;
                shapeX[3] = 1;
                shapeY[3] = 3;
                shapeX[4] = 0;
                shapeY[4] = 2;
                break;
                case I_FIGURE:
                        //maxOrientation = 2;
                        name = 7;
                       
                shapeX[0] = 0;
                shapeY[0] = 2;
                shapeX[1] = 0;
                shapeY[1] = 0;
                shapeX[2] = 0;
                shapeY[2] = 1;
                shapeX[3] = 0;
                shapeY[3] = 3;
                shapeX[4] = 0;
                shapeY[4] = 4;
                break;
                case T_FIGURE:
                        //maxOrientation = 4;
                        name = 8;
                       
                shapeX[0] = 1;
                shapeY[0] = 1;
                shapeX[1] = 1;
                shapeY[1] = 0;
                shapeX[2] = 1;
                shapeY[2] = 2;
                shapeX[3] = 0;
                shapeY[3] = 2;
                shapeX[4] = 2;
                shapeY[4] = 2;
                break;
                case Z_FIGURE:
                        //maxOrientation = 4;
                        name = 9;
                       
                shapeX[0] = 1;
                shapeY[0] = 1;
                shapeX[1] = 1;
                shapeY[1] = 0;
                shapeX[2] = 2;
                shapeY[2] = 0;
                shapeX[3] = 0;
                shapeY[3] = 2;
                shapeX[4] = 1;
                shapeY[4] = 2;
                break;
                case U_FIGURE:
                        //maxOrientation = 4;
                        name = 10;
                       
                shapeX[0] = 1;
                shapeY[0] = 0;
                shapeX[1] = 2;
                shapeY[1] = 0;
                shapeX[2] = 2;
                shapeY[2] = 1;
                shapeX[3] = 0;
                shapeY[3] = 0;
                shapeX[4] = 0;
                shapeY[4] = 1;
                break;
                case N_FIGURE:
                        //maxOrientation = 4;
                        name = 11;
                       
                shapeX[0] = 2;
                shapeY[0] = 0;
                shapeX[1] = 3;
                shapeY[1] = 0;
                shapeX[2] = 1;
                shapeY[2] = 0;
                shapeX[3] = 1;
                shapeY[3] = 1;
                shapeX[4] = 0;
                shapeY[4] = 1;
                break;
                case L_FIGURE:
                        //maxOrientation = 4;
                        name = 12;
                       
                shapeX[0] = 2;
                shapeY[0] = 0;
                shapeX[1] = 3;
                shapeY[1] = 0;
                shapeX[2] = 3;
                shapeY[2] = 1;
                shapeX[3] = 1;
                shapeY[3] = 0;
                shapeX[4] = 0;
                shapeY[4] = 0;
                break;


        default :
            throw new IllegalArgumentException("No figure constant: " +
                                               type);
                }
        }
       
        /**
         * returns the position of the pentominoe
         * @return orientation
         */
        public int getOrientation()
        {
                return orientation;
        }
       
        /**
         * makes sure of clockwise rotation
         */
        public void startRotateClockwise()
        {
                if(orientation<maxOrientation)
                {
                        for(int i = 0; i<5; i++)
                        {
                                int x = shapeX[i];
                                int y = shapeY[i];
                       
                                int f = y;
                                y = -1 * x;
                                x = f;
                               
                                shapeX[i] = x;
                                shapeY[i] = y;                          
                        }
                        orientation++;
                }
                else
                {
                        for(int i = 0; i<5; i++)
                        {
                                Figure a = new Figure(getName());
                                shapeX[i] = a.shapeX[i] + x1;
                                shapeY[i] = a.shapeY[i] + y1;
                        }
                        orientation = 1;
                }
        }
       /**
        * makes the counterclockwiserotation!
        */
        public void startRotateCounterClockwise()//still to work on orientation/ rotations, but works
        {
               
                        for(int i = 0; i<5; i++)
                        {
                                int x = shapeX[i];
                                int y = shapeY[i];
                       
                                int f = y;
                                y = x;
                                x = -1 * f;
                       
                                shapeX[i] = x;
                                shapeY[i] = y;                          
                        }
                        if(orientation == 1)
                        {
                                orientation = 4;
                        }
                        else
                        {
                                orientation--;
                        }
        }
               
       
       /**
        * saves the current coordinates of the pentominoe!
        */
        public void saveCurrentCor()
        {
                x1 = shapeX[0];
                y1 = shapeY[0];
        }
       
        /**
         * makes sure that the difference between the coordinates is saved such that
         * if the rotation is done it doesn't mean that the pentominoe moves a lot
         *
         */
        public void difference()
        {
                x2diff = shapeX[1] - shapeX[0];
                y2diff = shapeY[1] - shapeY[0];
                x3diff = shapeX[2] - shapeX[0];
                y3diff = shapeY[2] - shapeY[0];
                x4diff = shapeX[3] - shapeX[0];
                y4diff = shapeY[3] - shapeY[0];
                x5diff = shapeX[4] - shapeX[0];
                y5diff = shapeY[4] - shapeY[0];
        }
       
        /**
         * puts the pentominoe after rotation back at the original position
         */
        public void putBack()
        {

                shapeX[0] = x1;
                shapeY[0] = y1;
        }
        
        /**
         * translates our pentominoe!!!
         */
        public void translate()
        {
                shapeX[1] = shapeX[0] + x2diff;
                shapeY[1] = shapeY[0] + y2diff;
                shapeX[2] = shapeX[0] + x3diff;
                shapeY[2] = shapeY[0] + y3diff;
                shapeX[3] = shapeX[0] + x4diff;
                shapeY[3] = shapeY[0] + y4diff;
                shapeX[4] = shapeX[0] + x5diff;
                shapeY[4] = shapeY[0] + y5diff;
        }
       
        /**
         * random picks a pentominoe
         * @param a a figure from the figure array
         */
        public Figure randomPicker(Figure [] a)
        {
                Random ram = new Random();
                Figure b = a[ram.nextInt(a.length)];
                return b;
        }
       
        /**
         * takes all the methods and rotates the pentominoe and
         * puts it then back to its original place!
         */
        public void rotateClockwise()
        {
                saveCurrentCor();
                startRotateClockwise();
                difference();
                putBack();
                translate();
        }
        /**
         * takes all the methods and rotates the pentominoe and
         * puts it then back to its original place!
         */
        public void rotateCounterClockwise()
        {
                saveCurrentCor();
                startRotateCounterClockwise();
                difference();
                putBack();
                translate();
        }
       
        /**
         * get the x and returns it
         * @param b
         * @return
         */
        public int getX(int b)
        {
                return shapeX[b];
        }
       
        /**
         * get the Y and returns it
         * @param b
         * @return
         */
        public int getY (int b)
        {
                return shapeY[b];
        }
        
        /**
         * returns the name
         */
        public int getName()
        {
                return name;
        }
       
        /**
         * returns the width
         * @return
         */
        public int getWidth() {
                int minX = Integer.MAX_VALUE;
                int maxX = Integer.MIN_VALUE;
                for (int i = 0; i < 5; i++) {
                        if (shapeX[i] < minX) {
                                minX = shapeX[i];
                        }
                        if (shapeX[i] > maxX) {
                                maxX = shapeX[i];
                        }
                }
                return maxX - minX + 1;
        }
        
        /**
         *returns the height
         * @return
         */
        public int getHeight() {
                int minY = Integer.MAX_VALUE;
                int maxY = Integer.MIN_VALUE;
                for (int i = 0; i < 5; i++) {
                        if (shapeY[i] < minY) {
                                minY = shapeY[i];
                        }
                        if (shapeY[i] > maxY) {
                                maxY = shapeY[i];
                        }
                }
                return maxY - minY + 1;
        }

}