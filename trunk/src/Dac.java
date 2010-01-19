/**
 * Divide and Conque Solver
 * @author Jose Sue Smith, Ronald Gerits
 *
 */
public class Dac
{
	private Truck truck;
	
	public Dac(Truck aTruck)
	{
		truck = aTruck;
	}
	
	public void div()
	{
		int newLength = truck.getLength()/11;
		Truck bTruck = new Truck(truck.getHeight(),truck.getWidth(),newLength);
		BruteForce1 solver = new BruteForce1(bTruck);
		
	}
	
}
