public class PentominoTester {

    public static void main(String[] args)
    {
        Pentomino I = new Pentomino("#####\n");
        Pentomino L = new Pentomino("####\n...#\n");
        Pentomino P = new Pentomino("##.\n##.\n#.\n");
        Pentomino fout = new Pentomino("##\n###\n");

        Pentomino[] array = new Pentomino[11];
        array[0] = I;
        array[1] = L;
        array[2] = P;
        array[3] = fout;

        for (Pentomino pentominoes : array)
        {
            System.out.println("Pentominoe: \n" + pentominoes.toString());

	        for (Object mutations : pentominoes.getMutations())
	        {
	            System.out.println(mutations.toString());
	        }
        }
    }
}