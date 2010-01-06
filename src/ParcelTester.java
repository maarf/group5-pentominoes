public class ParcelTester
{
	public static void main(String[] args)
	{
		Parcel parcelA = new Parcel(3, 3, 6
				, 0);	
		System.out.println(parcelA.toString());
		
		int[][] rotationsA = parcelA.returnRotations();
		for(int i = 0; i < 5; i++)
		{
			System.out.println(rotationsA[i][0] + " " + rotationsA[i][1] + " " + rotationsA[i][2]);
		}
		
	}
}