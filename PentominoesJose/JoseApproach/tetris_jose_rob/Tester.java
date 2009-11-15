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
		
		Figure x = new Figure(1);
		//Figure y = x.randomPicker(figures);
		System.out.println("name: " + x.getName());
		//y.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		x.rotateClockwise();
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		x.rotateClockwise();
		x.rotateCounterClockwise();
		x.rotateCounterClockwise();
		x.rotateCounterClockwise();
		//x.rotateClockwise();
		//x.rotateClockwise();
		System.out.println("orientation: " + x.getOrientation());

		//System.out.println(y.getOrientation());
		
		
	  for (int i = 0; i<5 ; i++)
	   { 
	   System.out.println("x: " + x.getX(i));
	   System.out.println("y: " + x.getY(i));
	   }

	}

}
