import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Main class of the project.
 * Sets up the whole game
 * 
 * 09/12/09
 * 
 * @author Martins Spilners, Roland Gerits, Leoni Haagmans, José Sue Smith, Rob van den Oever, Seyit Ayas
 * @version 0.1
 */

public class Main
{
	/**
	 * The main method, hold on yer horses!
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{	

		Parcel parcelA = new Parcel(2, 2, 4, 3);
		Truck truck = new Truck(8, 5, 33);
		
		// Lets put some parcels on truck
		int parcelsOnTruck = 0;
		while (parcelsOnTruck < 5) {
			truck.NextBlank();
			if (truck.fits(parcelA)) {
				truck.setParcel(parcelA);
				parcelsOnTruck++;
			} else {
				truck.setEmpty();
			}
			System.out.println(truck.getParcels().length);
			System.out.println("1");
		}
		
		for (Object aP : truck.getParcels()) {
			ParcelAtPlace p = (ParcelAtPlace)aP;
			System.out.println("x: " + p.z + " y: " + p.y + " z: " + p.x + " w:" + p.parcel.getParcelX() + " h: " + p.parcel.getParcelY() + " d: " + p.parcel.getParcelZ());
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
				cargoView.repaint();
				Thread.sleep(1000/30);
			}
		}
	}
	
}