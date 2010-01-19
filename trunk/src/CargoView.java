import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;


public class CargoView extends JComponent {

	private static final long serialVersionUID = -8546231042854359675L;
	public double skew;
	public boolean autoRotate = true;
	public double zoom;
	
	public Truck truck;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);		
		
		g2.setColor(getBackground());
		g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
		
		// Lets draw the truck
		drawCube(g2, 0.0, 0.0, 0.0, (double)truck.getHeight(), (double)truck.getLength(), (double)truck.getWidth(), Color.lightGray);
		
		// Lets draw parcels
		for (Object aP : truck.getParcels()) {
			ParcelAtPlace p = (ParcelAtPlace)aP;
			drawCube(
					g2,
					(-((double)truck.getLength())/2 + ((double)p.parcel.getParcelY())/2 + (double)p.y),
					(-((double)truck.getWidth())/2 + ((double)p.parcel.getParcelX())/2 + (double)p.x),
					(-((double)truck.getHeight())/2 + ((double)p.parcel.getParcelZ())/2 + (double)p.z),
					(double)p.parcel.getParcelX() - 0.2,
					(double)p.parcel.getParcelY() - 0.2,
					(double)p.parcel.getParcelZ() - 0.2,
					Color.orange.darker()
					);
		}

		// zero point
//		drawCube(g2, (-33.0/2 + 1.0/2), (-5.0/2 + 1.0/2), (-8.0/2 + 1.0/2), 1.0, 1.0, 1.0, Color.red.darker());

//		drawCube(g2, (-165.0/2 + 10.0/2), (-25.0/2 + 10.0/2), (-40.0/2 + 20.0/2), 20.0-1, 10.0-1, 10.0-1, Color.orange.darker());
//		drawCube(g2, (-165.0/2 + 10.0/2), (-25.0/2 + 10.0/2) + 10, (-40.0/2 + 20.0/2), 20.0-1, 10.0-1, 10.0-1, Color.orange.darker());
//		
//		drawCube(g2, (-165.0/2 + 15.0/2) + 10, (-25.0/2 + 10.0/2), (-40.0/2 + 20.0/2), 20.0-1, 15.0-1, 10.0-1, Color.orange.darker().darker());
//
//		drawCube(g2, (-165.0/2 + 15.0/2) + 10, (-25.0/2 + 15.0/2) + 10, (-40.0/2 + 15.0/2), 15.0-1, 15.0-1, 15.0-1, Color.orange.darker().darker().darker());

	}
	
	private void drawCube(Graphics2D g2, double startX, double startY, double startZ, double height, double width, double depth, Color color) {
		
		double angle = Math.PI / 3;
		
		double centerX = (double)getWidth() / 2;
		double centerY = (double)getHeight() / 2;
		Point2D center = new Point2D.Double(centerX, centerY);
		
		Point2D points[] = {
				new Point2D.Double(centerX + (startX - (width / 2)) * zoom, centerY + (startY - (depth / 2)) * zoom),
				new Point2D.Double(centerX + (startX - (width / 2)) * zoom, centerY + (startY + (depth / 2)) * zoom),
				new Point2D.Double(centerX + (startX + (width / 2)) * zoom, centerY + (startY + (depth / 2)) * zoom),
				new Point2D.Double(centerX + (startX + (width / 2)) * zoom, centerY + (startY - (depth / 2)) * zoom)
		};

		Point2D translatedPoints[] = new Point2D[4];
		for (int i = 0; i < points.length; i++) {
			double diffX = points[i].getX() - center.getX();
			double diffY = points[i].getY() - center.getY();
			double newAngle = Math.atan2(diffX, diffY) + skew;
			double distance = Math.sqrt(diffX * diffX + diffY * diffY);
			double newX = center.getX() + (distance * Math.sin(newAngle)) * Math.sin(angle);
			double newY = center.getY() + (distance * Math.cos(newAngle)) * Math.cos(angle);
			translatedPoints[i] = new Point2D.Double(newX, newY);
		}
		
		Point2D bottom0 = new Point2D.Double(translatedPoints[0].getX(), translatedPoints[0].getY() - startZ * zoom + (height * 0.5 * zoom));
		Point2D bottom1 = new Point2D.Double(translatedPoints[1].getX(), translatedPoints[1].getY() - startZ * zoom + (height * 0.5 * zoom));
		Point2D bottom2 = new Point2D.Double(translatedPoints[2].getX(), translatedPoints[2].getY() - startZ * zoom + (height * 0.5 * zoom));
		Point2D bottom3 = new Point2D.Double(translatedPoints[3].getX(), translatedPoints[3].getY() - startZ * zoom + (height * 0.5 * zoom));
		Point2D top0 = new Point2D.Double(bottom0.getX(), bottom0.getY() - height * zoom);
		Point2D top1 = new Point2D.Double(bottom1.getX(), bottom1.getY() - height * zoom);
		Point2D top2 = new Point2D.Double(bottom2.getX(), bottom2.getY() - height * zoom);
		Point2D top3 = new Point2D.Double(bottom3.getX(), bottom3.getY() - height * zoom);

		

		
		
		g2.setColor(color);

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		
		GeneralPath shape1 = new GeneralPath();
		shape1.moveTo(bottom0.getX(), bottom0.getY());
		shape1.lineTo(bottom1.getX(), bottom1.getY());
		shape1.lineTo(bottom2.getX(), bottom2.getY());
		shape1.lineTo(bottom3.getX(), bottom3.getY());
		shape1.lineTo(bottom0.getX(), bottom0.getY());
		g2.fill(shape1);

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
		
		GeneralPath shape3 = new GeneralPath();
		shape3.moveTo(bottom0.getX(), bottom0.getY());
		shape3.lineTo(top0.getX(), top0.getY());
		shape3.lineTo(top1.getX(), top1.getY());
		shape3.lineTo(bottom1.getX(), bottom1.getY());
		shape3.lineTo(bottom0.getX(), bottom0.getY());
		g2.fill(shape3);

		GeneralPath shape4 = new GeneralPath();
		shape4.moveTo(bottom1.getX(), bottom1.getY());
		shape4.lineTo(top1.getX(), top1.getY());
		shape4.lineTo(top2.getX(), top2.getY());
		shape4.lineTo(bottom2.getX(), bottom2.getY());
		shape4.lineTo(bottom1.getX(), bottom1.getY());
		g2.fill(shape4);

		GeneralPath shape5 = new GeneralPath();
		shape5.moveTo(bottom2.getX(), bottom2.getY());
		shape5.lineTo(top2.getX(), top2.getY());
		shape5.lineTo(top3.getX(), top3.getY());
		shape5.lineTo(bottom3.getX(), bottom3.getY());
		shape5.lineTo(bottom2.getX(), bottom2.getY());
		g2.fill(shape5);

		GeneralPath shape6 = new GeneralPath();
		shape6.moveTo(bottom3.getX(), bottom3.getY());
		shape6.lineTo(top3.getX(), top3.getY());
		shape6.lineTo(top0.getX(), top0.getY());
		shape6.lineTo(bottom0.getX(), bottom0.getY());
		shape6.lineTo(bottom3.getX(), bottom3.getY());
		g2.fill(shape6);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
		
		GeneralPath shape2 = new GeneralPath();
		shape2.moveTo(top0.getX(), top0.getY());
		shape2.lineTo(top1.getX(), top1.getY());
		shape2.lineTo(top2.getX(), top2.getY());
		shape2.lineTo(top3.getX(), top3.getY());
		shape2.lineTo(top0.getX(), top0.getY());
		g2.fill(shape2);
		

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		
		g2.draw(new Line2D.Double(bottom0.getX(), bottom0.getY(), bottom1.getX(), bottom1.getY()));
		g2.draw(new Line2D.Double(bottom1.getX(), bottom1.getY(), bottom2.getX(), bottom2.getY()));
		g2.draw(new Line2D.Double(bottom2.getX(), bottom2.getY(), bottom3.getX(), bottom3.getY()));
		g2.draw(new Line2D.Double(bottom3.getX(), bottom3.getY(), bottom0.getX(), bottom0.getY()));
		g2.draw(new Line2D.Double(top0.getX(), top0.getY(), top1.getX(), top1.getY()));
		g2.draw(new Line2D.Double(top1.getX(), top1.getY(), top2.getX(), top2.getY()));
		g2.draw(new Line2D.Double(top2.getX(), top2.getY(), top3.getX(), top3.getY()));
		g2.draw(new Line2D.Double(top3.getX(), top3.getY(), top0.getX(), top0.getY()));
		g2.draw(new Line2D.Double(bottom0.getX(), bottom0.getY(), top0.getX(), top0.getY()));
		g2.draw(new Line2D.Double(bottom1.getX(), bottom1.getY(), top1.getX(), top1.getY()));
		g2.draw(new Line2D.Double(bottom2.getX(), bottom2.getY(), top2.getX(), top2.getY()));
		g2.draw(new Line2D.Double(bottom3.getX(), bottom3.getY(), top3.getX(), top3.getY()));
		
	}
	
	
}
