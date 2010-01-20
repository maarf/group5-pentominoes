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
				if (cargoView.angle > Math.PI / 3 + 0.01) {
					cargoView.angle -= (cargoView.angle - Math.PI / 3) / 10;
					System.out.println("angling");
				}
				cargoView.repaint();
			}
			Thread.sleep(1000/30);
		}
	}
	
	static private JPanel createLeftPanel(Truck truck, CargoView cargoView) {
		BigListener bigListener = new BigListener(truck, cargoView, parcels);
		
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
		JTextField textFields[] = {parcelAValueField, parcelBValueField, parcelCValueField};
		bigListener.textFields = textFields;
		
		// Algorithms
		
		JPanel algorithmsPanel = new JPanel();
		algorithmsPanel.setLayout(new BoxLayout(algorithmsPanel, BoxLayout.Y_AXIS));

		JLabel algoritmsLabel = new JLabel("Algorithms");
		algoritmsLabel.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
		algorithmsPanel.add(algoritmsLabel);
		
		JPanel algoRadiosPanel = new JPanel();
		algoRadiosPanel.setLayout(new BoxLayout(algoRadiosPanel, BoxLayout.Y_AXIS));
		
		JRadioButton algo1Radio = new JRadioButton("Bruteforce algorithm", true);
		algo1Radio.addActionListener(bigListener);
		JRadioButton algo2Radio = new JRadioButton("Greedy algorithm");
		algo2Radio.addActionListener(bigListener);
		algo2Radio.setEnabled(false);
		JRadioButton algo3Radio = new JRadioButton("Divide and conquer algorithm");
		algo3Radio.addActionListener(bigListener);
		
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
		theButton.addActionListener(bigListener);
		buttonPanel.add(theButton);
		optionsPanel.add(buttonPanel);
				
		// Other stuff
		
		JPanel otherPanel = new JPanel();
		otherPanel.setLayout(new BoxLayout(otherPanel, BoxLayout.Y_AXIS));
		
		JPanel autoRotatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		JCheckBox autoRotateCheckbox = new JCheckBox("Rotate automatically", true);
		autoRotateCheckbox.addActionListener(bigListener);
		autoRotatePanel.add(autoRotateCheckbox);
		otherPanel.add(autoRotatePanel);
		optionsPanel.add(otherPanel);
		
		
		return optionsPanel;
	}


	
	private final static int aX = 2, aY = 2, aZ = 4, aV = 3, aI = 0;
	private final static int bX = 2, bY = 3, bZ = 4, bV = 4, bI = 1;
	private final static int cX = 3, cY = 3, cZ = 3, cV = 5, cI = 2;
	
	private static int[][] parcels = {	{aX,aY,aZ,aV,aI},
										{bX,bY,bZ,bV,bI},
										{cX,cY,cZ,cV,cI} };
	
}

class BigListener implements ActionListener {
	
	private Truck truck;
	private CargoView view;
	private int[][] parcels;
	private int algo = 0;
	
	public JTextField textFields[];
	
	public BigListener(Truck aTruck, CargoView aView, int[][] someParcels) {
		truck = aTruck;
		view = aView;
		parcels = someParcels;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Draw!")) {
			// The big button was pressed.
			
			// Set the values of boxes from text inputs.
			parcels[0][3] = Integer.parseInt(textFields[0].getText());
			parcels[1][3] = Integer.parseInt(textFields[1].getText());
			parcels[2][3] = Integer.parseInt(textFields[2].getText());
			
			// Reset the truck before filling it again. 
			truck.reset();
			
			// Fire up the proper algorithm.
			if (algo == 0) {
				// Bruteforce goes here.
				BruteForce1 solver = new BruteForce1(truck);
				solver.Solve(parcels);
			} else if (algo == 2) {
				// Divide and conquer goes here.
				Dac solver = new Dac(truck,parcels);
				solver.solver();
				truck.setParcels(solver.getBigTruck());
			}
			
		} else if (e.getActionCommand().equals("Bruteforce algorithm")) {
			// Bruteforce radio button was selected.
			algo = 0;
			
		} else if (e.getActionCommand().equals("Greedy algorithm")) {
			// Greedy radio button was selected.
			algo = 1;
			
		} else if (e.getActionCommand().equals("Divide and conquer algorithm")) {
			// DaC radio button was seletced.
			algo = 2;
			
		} else if (e.getActionCommand().equals("Rotate automatically")) {
			// Auto-rotate checkbox was toggled.
			view.autoRotate = !view.autoRotate;
		}
			
	}
}