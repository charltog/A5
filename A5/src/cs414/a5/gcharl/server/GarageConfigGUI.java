package cs414.a5.gcharl.server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import cs414.a5.gcharl.common.*;

public class GarageConfigGUI extends JFrame {

	private JPanel contentPane;
	private JTextField displayMax;
	private JTextField editMax;
	private JTextField displayCur;
	private JTextField editCur;
	private JTextField displayBuf;
	private JTextField editBuf;
	private JTextField displayHpr;
	private JTextField editHpr;
	private JTextField displaySS;
	private JComboBox editSS;
	
	private Garage _garage;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GarageConfig frame = new GarageConfig();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GarageConfigGUI(Garage g) {
		_garage = g;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblGarageConfigurationSettings = new JLabel("Garage Configuration Settings");
		lblGarageConfigurationSettings.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblGarageConfigurationSettings = new GridBagConstraints();
		gbc_lblGarageConfigurationSettings.gridwidth = 5;
		gbc_lblGarageConfigurationSettings.insets = new Insets(0, 0, 5, 0);
		gbc_lblGarageConfigurationSettings.gridx = 0;
		gbc_lblGarageConfigurationSettings.gridy = 0;
		contentPane.add(lblGarageConfigurationSettings, gbc_lblGarageConfigurationSettings);
		
		JLabel lblCurrent = new JLabel("Current");
		GridBagConstraints gbc_lblCurrent = new GridBagConstraints();
		gbc_lblCurrent.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrent.gridx = 2;
		gbc_lblCurrent.gridy = 2;
		contentPane.add(lblCurrent, gbc_lblCurrent);
		
		JLabel lblEdit = new JLabel("Edit");
		GridBagConstraints gbc_lblEdit = new GridBagConstraints();
		gbc_lblEdit.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdit.gridx = 3;
		gbc_lblEdit.gridy = 2;
		contentPane.add(lblEdit, gbc_lblEdit);
		
		JLabel lblMaxOccupancy = new JLabel("Max Occupancy:");
		GridBagConstraints gbc_lblMaxOccupancy = new GridBagConstraints();
		gbc_lblMaxOccupancy.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxOccupancy.anchor = GridBagConstraints.EAST;
		gbc_lblMaxOccupancy.gridx = 1;
		gbc_lblMaxOccupancy.gridy = 3;
		contentPane.add(lblMaxOccupancy, gbc_lblMaxOccupancy);
		
		displayMax = new JTextField();
		displayMax.setEditable(false);		
		GridBagConstraints gbc_displayMax = new GridBagConstraints();
		gbc_displayMax.insets = new Insets(0, 0, 5, 5);
		gbc_displayMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_displayMax.gridx = 2;
		gbc_displayMax.gridy = 3;
		contentPane.add(displayMax, gbc_displayMax);
		displayMax.setColumns(10);		
		
		editMax = new JTextField();
		GridBagConstraints gbc_editMax = new GridBagConstraints();
		gbc_editMax.insets = new Insets(0, 0, 5, 5);
		gbc_editMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_editMax.gridx = 3;
		gbc_editMax.gridy = 3;
		contentPane.add(editMax, gbc_editMax);
		editMax.setColumns(10);
		
		JLabel lblCurrentOccupancy = new JLabel("Current Occupancy:");
		GridBagConstraints gbc_lblCurrentOccupancy = new GridBagConstraints();
		gbc_lblCurrentOccupancy.anchor = GridBagConstraints.EAST;
		gbc_lblCurrentOccupancy.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentOccupancy.gridx = 1;
		gbc_lblCurrentOccupancy.gridy = 4;
		contentPane.add(lblCurrentOccupancy, gbc_lblCurrentOccupancy);
		
		displayCur = new JTextField();
		displayCur.setEditable(false);
		GridBagConstraints gbc_displayCur = new GridBagConstraints();
		gbc_displayCur.insets = new Insets(0, 0, 5, 5);
		gbc_displayCur.fill = GridBagConstraints.HORIZONTAL;
		gbc_displayCur.gridx = 2;
		gbc_displayCur.gridy = 4;
		contentPane.add(displayCur, gbc_displayCur);
		displayCur.setColumns(10);
		
		editCur = new JTextField();
		GridBagConstraints gbc_editCur = new GridBagConstraints();
		gbc_editCur.insets = new Insets(0, 0, 5, 5);
		gbc_editCur.fill = GridBagConstraints.HORIZONTAL;
		gbc_editCur.gridx = 3;
		gbc_editCur.gridy = 4;
		contentPane.add(editCur, gbc_editCur);
		editCur.setColumns(10);
		
		JLabel lblCapacityBuffer = new JLabel("Capacity Buffer:");
		GridBagConstraints gbc_lblCapacityBuffer = new GridBagConstraints();
		gbc_lblCapacityBuffer.anchor = GridBagConstraints.EAST;
		gbc_lblCapacityBuffer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacityBuffer.gridx = 1;
		gbc_lblCapacityBuffer.gridy = 5;
		contentPane.add(lblCapacityBuffer, gbc_lblCapacityBuffer);
		
		displayBuf = new JTextField();
		displayBuf.setEditable(false);
		GridBagConstraints gbc_displayBuf = new GridBagConstraints();
		gbc_displayBuf.insets = new Insets(0, 0, 5, 5);
		gbc_displayBuf.fill = GridBagConstraints.HORIZONTAL;
		gbc_displayBuf.gridx = 2;
		gbc_displayBuf.gridy = 5;
		contentPane.add(displayBuf, gbc_displayBuf);
		displayBuf.setColumns(10);
		
		editBuf = new JTextField();
		GridBagConstraints gbc_editBuf = new GridBagConstraints();
		gbc_editBuf.insets = new Insets(0, 0, 5, 5);
		gbc_editBuf.fill = GridBagConstraints.HORIZONTAL;
		gbc_editBuf.gridx = 3;
		gbc_editBuf.gridy = 5;
		contentPane.add(editBuf, gbc_editBuf);
		editBuf.setColumns(10);
		
		JLabel lblHourlyParkingRate = new JLabel("Hourly Parking Rate:");
		GridBagConstraints gbc_lblHourlyParkingRate = new GridBagConstraints();
		gbc_lblHourlyParkingRate.anchor = GridBagConstraints.EAST;
		gbc_lblHourlyParkingRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblHourlyParkingRate.gridx = 1;
		gbc_lblHourlyParkingRate.gridy = 6;
		contentPane.add(lblHourlyParkingRate, gbc_lblHourlyParkingRate);
		
		displayHpr = new JTextField();
		displayHpr.setEditable(false);
		GridBagConstraints gbc_displayHpr = new GridBagConstraints();
		gbc_displayHpr.insets = new Insets(0, 0, 5, 5);
		gbc_displayHpr.fill = GridBagConstraints.HORIZONTAL;
		gbc_displayHpr.gridx = 2;
		gbc_displayHpr.gridy = 6;
		contentPane.add(displayHpr, gbc_displayHpr);
		displayHpr.setColumns(10);
		
		editHpr = new JTextField();
		GridBagConstraints gbc_editHpr = new GridBagConstraints();
		gbc_editHpr.insets = new Insets(0, 0, 5, 5);
		gbc_editHpr.fill = GridBagConstraints.HORIZONTAL;
		gbc_editHpr.gridx = 3;
		gbc_editHpr.gridy = 6;
		contentPane.add(editHpr, gbc_editHpr);
		editHpr.setColumns(10);
		
		JLabel lblSystemStatus = new JLabel("System Status:");
		GridBagConstraints gbc_lblSystemStatus = new GridBagConstraints();
		gbc_lblSystemStatus.anchor = GridBagConstraints.EAST;
		gbc_lblSystemStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblSystemStatus.gridx = 1;
		gbc_lblSystemStatus.gridy = 7;
		contentPane.add(lblSystemStatus, gbc_lblSystemStatus);
		
		displaySS = new JTextField();
		displaySS.setEditable(false);
		GridBagConstraints gbc_displaySS = new GridBagConstraints();
		gbc_displaySS.insets = new Insets(0, 0, 5, 5);
		gbc_displaySS.fill = GridBagConstraints.HORIZONTAL;
		gbc_displaySS.gridx = 2;
		gbc_displaySS.gridy = 7;
		contentPane.add(displaySS, gbc_displaySS);
		displaySS.setColumns(10);
		
		editSS = new JComboBox();
		editSS.setModel(new DefaultComboBoxModel(SystemStatus.values()));
		GridBagConstraints gbc_editSS = new GridBagConstraints();
		gbc_editSS.insets = new Insets(0, 0, 5, 5);
		gbc_editSS.fill = GridBagConstraints.HORIZONTAL;
		gbc_editSS.gridx = 3;
		gbc_editSS.gridy = 7;
		contentPane.add(editSS, gbc_editSS);
		
		JButton btnViewCurrent = new JButton("View Current");
		btnViewCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pressViewCurrent();
			}
		});
		GridBagConstraints gbc_btnViewCurrent = new GridBagConstraints();
		gbc_btnViewCurrent.fill = GridBagConstraints.BOTH;
		gbc_btnViewCurrent.insets = new Insets(0, 0, 0, 5);
		gbc_btnViewCurrent.gridx = 2;
		gbc_btnViewCurrent.gridy = 10;
		contentPane.add(btnViewCurrent, gbc_btnViewCurrent);
		
		JButton btnSet = new JButton("Set ");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pressSet();
			}
		});
		GridBagConstraints gbc_btnSet = new GridBagConstraints();
		gbc_btnSet.insets = new Insets(0, 0, 0, 5);
		gbc_btnSet.gridx = 3;
		gbc_btnSet.gridy = 10;
		contentPane.add(btnSet, gbc_btnSet);
		
		//Initialize - should replace this with a listener?
		pressViewCurrent();
	}

	protected void pressSet() {
		try {
			_garage.viewConfig().maxOccupancy = Integer.parseInt(editMax.getText());
			_garage.viewConfig().currentOccupancy = Integer.parseInt(editCur.getText());
			_garage.viewConfig().buffer = Integer.parseInt(editBuf.getText());
			_garage.viewConfig().hourlyParkingRate = Double.parseDouble(editHpr.getText());
			_garage.viewConfig().status = (SystemStatus)editSS.getSelectedItem();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void pressViewCurrent() {
		displayMax.setText("" + _garage.viewConfig().maxOccupancy);
		displayCur.setText("" + _garage.viewConfig().currentOccupancy);
		displayBuf.setText("" + _garage.viewConfig().buffer);
		displayHpr.setText("" + _garage.viewConfig().hourlyParkingRate);
		displaySS.setText(_garage.viewConfig().status.toString());
	}

}
