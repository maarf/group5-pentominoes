import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

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

		Truck truck = new Truck(8, 33, 5);
				
		/* Cargo view */
		CargoView cargoView = new CargoView();
		cargoView.zoom = 25.0;
		cargoView.setBackground(Color.white);
		
		cargoView.truck = truck;
		
		/* Split pane */
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createLeftPanel(truck, cargoView), cargoView);
		splitPane.setBorder(null);
		splitPane.setDividerLocation(250);

		
		/* The frame */
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 700);
		frame.setTitle("Cargo");
		frame.setLocation(80, 50);

		frame.add(splitPane);
		frame.setVisible(true);
		
		
		/* This loop makes things rotate */
		while (true) {
			if (cargoView.autoRotate) {
				cargoView.skew += 0.007;
				cargoView.repaint();
				Thread.sleep(1000/30);
			}
		}
	}
	
	static private JPanel createLeftPanel(Truck truck, CargoView cargoView) {
		/* All the options */
		JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		
		/* Values */
		
		JPanel valuesPanel = new JPanel();
		valuesPanel.setLayout(new BoxLayout(valuesPanel, BoxLayout.Y_AXIS));

		JLabel valuesLabel = new JLabel("Parcel values");
		Font f = valuesLabel.getFont();
		valuesLabel.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
		valuesPanel.add(valuesLabel);
				
		JPanel parcelAValuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
		JLabel parcelAValueLabel = new JLabel("Parcel A value:");
		JTextField parcelAValueField = new JTextField("3", 5);
		parcelAValueLabel.setPreferredSize(new Dimension(100, 20));
		parcelAValueLabel.setLabelFor(parcelAValueField);
		parcelAValuePanel.add(parcelAValueLabel);
		parcelAValuePanel.add(parcelAValueField);
		valuesPanel.add(parcelAValuePanel);

		JPanel parcelBValuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
		JLabel parcelBValueLabel = new JLabel("Parcel B value:");
		JTextField parcelBValueField = new JTextField("4", 5);
		parcelBValueLabel.setPreferredSize(new Dimension(100, 20));
		parcelBValueLabel.setLabelFor(parcelBValueField);
		parcelBValuePanel.add(parcelBValueLabel);
		parcelBValuePanel.add(parcelBValueField);
		valuesPanel.add(parcelBValuePanel);

		JPanel parcelCValuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
		JLabel parcelCValueLabel = new JLabel("Parcel C value:");
		JTextField parcelCValueField = new JTextField("5", 5);
		parcelCValueLabel.setPreferredSize(new Dimension(100, 20));
		parcelCValueLabel.setLabelFor(parcelCValueField);
		parcelCValuePanel.add(parcelCValueLabel);
		parcelCValuePanel.add(parcelCValueField);
		valuesPanel.add(parcelCValuePanel);
		
		optionsPanel.add(valuesPanel);
		
		// Algorithms
		
		JPanel algorithmsPanel = new JPanel();
		algorithmsPanel.setLayout(new BoxLayout(algorithmsPanel, BoxLayout.Y_AXIS));

		JLabel algoritmsLabel = new JLabel("Algorithms");
		algoritmsLabel.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
		algorithmsPanel.add(algoritmsLabel);
		
		JPanel algoRadiosPanel = new JPanel();
		algoRadiosPanel.setLayout(new BoxLayout(algoRadiosPanel, BoxLayout.Y_AXIS));
		
		JRadioButton algo1Radio = new JRadioButton("Random algorithm", true);
		JRadioButton algo2Radio = new JRadioButton("Greedy algorithm");
		algo2Radio.setEnabled(false);
		JRadioButton algo3Radio = new JRadioButton("Divide and conquere algorithm");
		
		ButtonGroup algoRadios = new ButtonGroup();
		algoRadios.add(algo1Radio);
		algoRadios.add(algo2Radio);
		algoRadios.add(algo3Radio);
		
		algoRadiosPanel.add(algo1Radio);
		algoRadiosPanel.add(algo2Radio);
		algoRadiosPanel.add(algo3Radio);
		algorithmsPanel.add(algoRadiosPanel);
		optionsPanel.add(algorithmsPanel);
		
		// Button
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		JButton theButton = new JButton("Draw!");
		theButton.addActionListener(new BigListener(truck, cargoView, parcels));
		buttonPanel.add(theButton);
		optionsPanel.add(buttonPanel);
				
		// Other stuff
		
		JPanel otherPanel = new JPanel();
		otherPanel.setLayout(new BoxLayout(otherPanel, BoxLayout.Y_AXIS));
		
		JPanel autoRotatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		JCheckBox autoRotateCheckbox = new JCheckBox("Rotate automatically", true);
		autoRotatePanel.add(autoRotateCheckbox);
		otherPanel.add(autoRotatePanel);
		optionsPanel.add(otherPanel);
		
		
		return optionsPanel;
	}


	
	private final static int aX = 2, aY = 2, aZ = 4, aV = 3;
	private final static int bX = 2, bY = 3, bZ = 4, bV = 4;
	private final static int cX = 3, cY = 3, cZ = 3, cV = 5;
	
	private static int[][] parcels = {	{aX,aY,aZ,aV},
										{bX,bY,bZ,bV},
										{cX,cY,cZ,cV} };
	
}

class BigListener implements ActionListener {
	
	private Truck truck;
	private CargoView view;
	private int[][] parcels;
	
	public BigListener(Truck aTruck, CargoView aView, int[][] someParcels) {
		truck = aTruck;
		view = aView;
		parcels = someParcels;
	}
	
	public void actionPerformed(ActionEvent e) {
		truck.reset();
		Dac solver = new Dac(truck,parcels);
		solver.solver();
		//solver.getTruckValue();
		
		truck.setParcels(solver.getBigTruck());
	}
	
}