package cs414.a5.gcharl.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

//import cs414.a5.gcharl.Garage;
import cs414.a5.gcharl.common.*;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateEmployeeGUI extends JFrame {

	//private Garage _garage;
	
	private JPanel contentPane;
	private JTextField uName;

	private IParkingGarage _garage;
	private String employeePassword = "";
	private JTextField createInfo;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateEmployeeGUI frame = new CreateEmployeeGUI();
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
	public CreateEmployeeGUI(IParkingGarage g) {
		_garage = g;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCreateNewEmployee = new JLabel("Create New Employee");
		lblCreateNewEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblCreateNewEmployee = new GridBagConstraints();
		gbc_lblCreateNewEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateNewEmployee.gridx = 2;
		gbc_lblCreateNewEmployee.gridy = 0;
		contentPane.add(lblCreateNewEmployee, gbc_lblCreateNewEmployee);
		
		JLabel lblId = new JLabel("User Name");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 3;
		contentPane.add(lblId, gbc_lblId);
		
		uName = new JTextField();
		GridBagConstraints gbc_uName = new GridBagConstraints();
		gbc_uName.insets = new Insets(0, 0, 5, 5);
		gbc_uName.fill = GridBagConstraints.HORIZONTAL;
		gbc_uName.gridx = 2;
		gbc_uName.gridy = 3;
		contentPane.add(uName, gbc_uName);
		uName.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pressCreate();
			}
		});
		
		createInfo = new JTextField();
		createInfo.setFont(new Font("Courier New", Font.PLAIN, 14));
		createInfo.setEditable(false);
		GridBagConstraints gbc_createInfo = new GridBagConstraints();
		gbc_createInfo.gridwidth = 4;
		gbc_createInfo.insets = new Insets(0, 0, 5, 5);
		gbc_createInfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_createInfo.gridx = 0;
		gbc_createInfo.gridy = 5;
		contentPane.add(createInfo, gbc_createInfo);
		createInfo.setColumns(10);
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreate.gridx = 2;
		gbc_btnCreate.gridy = 6;
		contentPane.add(btnCreate, gbc_btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pressCancel();
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 7;
		contentPane.add(btnCancel, gbc_btnCancel);
	}

	protected void pressCreate() {
		try {
			String userName = uName.getText();
			boolean result = _garage.createEmployee(userName, employeePassword);
			if (result) {
				createInfo.setText("Created " + userName + " Successfully!");
				uName.setText("");
			} else {
				createInfo.setText("Employee " + userName + "Already Exists");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void pressCancel() {
		try {
			this.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
