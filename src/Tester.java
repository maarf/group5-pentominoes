
public class Tester 
{
	public static void main(String[]args)
	{
		RandParcelSelector selector = new RandParcelSelector();
		Parcel aParcel = new Parcel(selector.getParcelX(),selector.getParcelY(),selector.getParcelZ(),selector.getParcelV());
		System.out.println("X = " + aParcel.getParcelX());
		System.out.println("Y = " + aParcel.getParcelY());
		System.out.println("Z = " + aParcel.getParcelZ());
		System.out.println("Value = " + aParcel.returnValue());
		
	}
}
