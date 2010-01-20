import java.awt.Color;
import java.util.Date;
import javax.swing.JFrame;

public class LeoniTester2 {
	
		public static void main(String[]args) throws InterruptedException
	{
		int i = 0;
		int average = 0;
		int newScore = 0;
		int highest = -1;
		Truck maxTruck = null;
		Truck truck = null;
		
		Date starttime;
		Date endtime;
		
		starttime = new Date();
		
		for(i=0; i<1 ;i++)
		{
			truck = new Truck(8, 33, 5);// 4 5 8
			
			//Parcel a = new Parcel(7,7,7,5);
			//System.out.println(truck.fits(a));
			//truck.setParcel(a);
			BruteForce1 solver = new BruteForce1(truck);
			//System.out.println(solver.getParcelV());
			solver.Solve(parcels);
			
			//truck.getTruckValue();
			
			newScore = solver.getValue();
			
			if(newScore > highest || highest == -1)
			{
				highest = newScore;
				maxTruck = truck;
			}
			System.out.println("Highest value: " + highest);
			average = ((average*i)+ solver.getValue())/(i+1);
			System.out.println("Avarage: " + average);
			
			System.out.println("Number of parcels: " + truck.getParcels().length);
			System.out.println("Value: " + solver.getValue());
			System.out.println("Parcels A: " + solver.getBoxA());
			System.out.println("Parcels B: " + solver.getBoxB());
			System.out.println("Parcels C: " + solver.getBoxC());
			
			for (Object o : truck.getParcels()) {
				ParcelAtPlace p = (ParcelAtPlace)o;
				//System.out.println("x: " + p.x + " y: " + p.y + " z: " + p.z + " w:" + p.parcel.getParcelX() + " h: " + p.parcel.getParcelY() + " d: " + p.parcel.getParcelZ());
			}
					
		}
		endtime = new Date();	
		long timespan = endtime.getTime() - starttime.getTime();
		System.out.println("Time: " + timespan);
		
		/* Cargo view */
		CargoView cargoView = new CargoView();
		cargoView.zoom = 25.0;
		cargoView.setBackground(Color.white);
		
		cargoView.truck = maxTruck;
		
		/* The frame */
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 700);
		frame.setTitle("Cargo");
		frame.setLocation(80, 50);

		frame.add(cargoView);
		
		//frame.setVisible(true);
			
		while (true) {
			if (cargoView.autoRotate) {
				cargoView.skew += 0.007;
				if (cargoView.angle > Math.PI / 3 + 0.01) {
					cargoView.angle -= (cargoView.angle - Math.PI / 3) / 10;
					//System.out.println("angling");
				}
				cargoView.repaint();
			}
			Thread.sleep(1000/30);
		}
	}
	private final static int aX = 2, aY = 2, aZ = 4, aV = 3;
	private final static int bX = 2, bY = 3, bZ = 4, bV = 4;
	private final static int cX = 3, cY = 3, cZ = 3, cV = 5;
	
	private static int[][] parcels = {	{aX,aY,aZ,aV, 0},
										{bX,bY,bZ,bV, 1},
										{cX,cY,cZ,cV, 2} };

}