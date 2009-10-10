package dlx;

public class Tester 
{
	public static void main (String[] args)
	{
		Board boardy = new Board();
		//System.out.print(boardy.get(0, 0));
		boardy.set(0, 0, 0, "L"); // state which is the next empty box(in this case we take 0,0) third value is the pentominoe to represent
		//boardy.sety(0, 0, 0,"L");
		//boardy.set1(0, 0, 0, "L");
		//System.out.print(boardy.get(0, 3));
		System.out.println(boardy);
	}

}
