public class ParcelTester
{
	public static void main(String[] args)
	{
		
		
		
		//System.out.println(parcelA.toString());
		
		
		System.out.println("Parcel A");
		Parcel parcelA = new Parcel(2,2,4, 3, 0);
		int[][] rotationsA = parcelA.returnRotations();
		for(int i = 0; i < rotationsA.length; i++)
		{
			System.out.println(rotationsA[i][0] + " " + rotationsA[i][1] + " " + rotationsA[i][2]);
		}
		

		System.out.println("Parcel B");
		Parcel parcelB = new Parcel(2,3,4, 4, 1);
		int[][] rotationsB = parcelB.returnRotations();
		for(int i = 0; i < rotationsB.length; i++)
		{
			System.out.println(rotationsB[i][0] + " " + rotationsB[i][1] + " " + rotationsB[i][2]);
		}

		System.out.println("Parcel C");
		Parcel parcelC = new Parcel(3,3,3, 5, 2);
		int[][] rotationsC = parcelC.returnRotations();
		for(int i = 0; i < rotationsC.length; i++)
		{
			System.out.println(rotationsC[i][0] + " " + rotationsC[i][1] + " " + rotationsC[i][2]);
		}
	}
}