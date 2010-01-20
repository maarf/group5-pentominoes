import java.awt.Color;

import javax.swing.JFrame;


public class DacTester 
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		Truck truck = new Truck(8,33,5);
		
		Dac solver = new Dac(truck,parcels);
		solver.solver();
		//solver.getTruckValue();
		
		truck.setParcels(solver.getBigTruck());
		System.out.println("Number of parcels: " + truck.getParcels().length);
		System.out.println("Value: " + solver.getV());
		System.out.println("Parcels A: " + solver.getA());
		System.out.println("Parcels B: " + solver.getB());
		System.out.println("Parcels C: " + solver.getC());
		for (Object o : truck.getParcels()) {
			ParcelAtPlace p = (ParcelAtPlace)o;
			System.out.println("x: " + p.x + " y: " + p.y + " z: " + p.z + " w:" + p.parcel.getParcelX() + " h: " + p.parcel.getParcelY() + " d: " + p.parcel.getParcelZ());
		}
		
		/* Cargo view */
		CargoView cargoView = new CargoView();
		cargoView.zoom = 25.0;
		cargoView.setBackground(Color.white);
		
		cargoView.truck = truck;
		
		/* The frame */
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 700);
		frame.setTitle("Cargo");
		frame.setLocation(80, 50);

		frame.add(cargoView);
		
		frame.setVisible(true);
		

		while (true) {
			if (cargoView.autoRotate) {
				cargoView.skew += 0.007;
				if (cargoView.angle > Math.PI / 3 + 0.01) {
					cargoView.angle -= (cargoView.angle - Math.PI / 3) / 10;
					System.out.println("angling");
				}
				cargoView.repaint();
			}
			Thread.sleep(1000/30);
		}
		
	}
	private final static int aX = 2, aY = 2, aZ = 4, aV = 3;
	private final static int bX = 2, bY = 3, bZ = 4, bV = 4;
	private final static int cX = 3, cY = 3, cZ = 3, cV = 5;
	
	private static int[][] parcels = {	{aX,aY,aZ,aV},
										{bX,bY,bZ,bV},
										{cX,cY,cZ,cV} };


}
