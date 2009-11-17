package tetris_jose_rob;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Figure y = new Figure();
		Figure x = y.randomPicker();
		//Figure y = x.randomPicker(figures);
		System.out.println("name: " + x.getName());
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		//x.rotateClockwise();
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		//x.rotateClockwise();
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		//x.rotateCounterClockwise();
		//x.rotateClockwise();
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
