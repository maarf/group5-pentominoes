package tetris_jose_rob;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Figure[] figures = {
	            new Figure(Figure.P_FIGURE),
	            new Figure(Figure.X_FIGURE),
	            new Figure(Figure.F_FIGURE),
	            new Figure(Figure.V_FIGURE),
	            new Figure(Figure.W_FIGURE),
	            new Figure(Figure.Y_FIGURE),
	            new Figure(Figure.I_FIGURE),
	            new Figure(Figure.T_FIGURE),
	            new Figure(Figure.Z_FIGURE),
	            new Figure(Figure.U_FIGURE),
	            new Figure(Figure.N_FIGURE),
	            new Figure(Figure.L_FIGURE)
	        };
		
		Figure x = new Figure();
		Figure y = x.randomPicker(figures);
		//y.rotateCounterClockwise();
		y.rotateClockwise();


		//System.out.println("x1: " + x.test1());
		//System.out.println("y1: " + x.test2());
		//System.out.println(y.getOrientation());
		
		
	  for (int i = 0; i<5 ; i++)
	   { 
	   System.out.println("x: " + y.getX(i));
	   System.out.println("y: " + y.getY(i));
	   }

	}

}
