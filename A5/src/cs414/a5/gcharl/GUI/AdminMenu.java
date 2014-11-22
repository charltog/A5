package cs414.a5.gcharl.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JRadioButton;

import java.awt.Insets;

import javax.swing.ButtonModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

import cs414.a5.gcharl.common.*;


public class AdminMenu extends JFrame {

	private JPanel contentPane;
//	private Administrator _administrator;
	private static IParkingGarage _garage;
	private String adminUserName = "";
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminMenu frame = new AdminMenu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param _administrator 
	 */
	public AdminMenu(IParkingGarage _garage) {
		this._garage = _garage;
//		this.adminUserName = adminUserName;
//		_administrator = administrator;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 368, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAdministratorMenu = new JLabel("Administrator Menu");
		lblAdministratorMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAdministratorMenu = new GridBagConstraints();
		gbc_lblAdministratorMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdministratorMenu.gridx = 2;
		gbc_lblAdministratorMenu.gridy = 1;
		contentPane.add(lblAdministratorMenu, gbc_lblAdministratorMenu);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		
		final JRadioButtonMenuItem rdbtnmntmVieweditGarageSettings = new JRadioButtonMenuItem("View/Edit Garage Settings");
		buttonGroup.add(rdbtnmntmVieweditGarageSettings);
		panel.add(rdbtnmntmVieweditGarageSettings);
		
		final JRadioButtonMenuItem rdbtnmntmViewReports = new JRadioButtonMenuItem("View System Reports");
		buttonGroup.add(rdbtnmntmViewReports);
		panel.add(rdbtnmntmViewReports);
		
		final JRadioButtonMenuItem rdbtnmntmCreateNewEmployee = new JRadioButtonMenuItem("Create New Employee");
		buttonGroup.add(rdbtnmntmCreateNewEmployee);
		panel.add(rdbtnmntmCreateNewEmployee);
		
		final JRadioButtonMenuItem rdbtnmntmCreateNewAdministrator = new JRadioButtonMenuItem("Create New Administrator");
		buttonGroup.add(rdbtnmntmCreateNewAdministrator);
		panel.add(rdbtnmntmCreateNewAdministrator);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice = 0;
				if (rdbtnmntmVieweditGarageSettings.isSelected()) {
					choice = 1;
				} else if (rdbtnmntmViewReports.isSelected()) {
					choice = 2;
				} else if (rdbtnmntmCreateNewEmployee.isSelected()) {
					choice = 3;
				} else if (rdbtnmntmCreateNewAdministrator.isSelected()) {
					choice = 4;
//				} else if (rdbtnmntmSystemOverride.isSelected()) {
//					choice = 5;
				}
				pressSelect(choice);
			}
		});
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelect.gridx = 2;
		gbc_btnSelect.gridy = 3;
		contentPane.add(btnSelect, gbc_btnSelect);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pressAdminLogout();
			}
		});
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogout.gridx = 2;
		gbc_btnLogout.gridy = 4;
		contentPane.add(btnLogout, gbc_btnLogout);
	}

	protected void pressSelect(int choice) {
		switch (choice) {
		
			case 1:		GarageConfigGUI gcgui = new GarageConfigGUI(_garage);
						gcgui.setVisible(true);
						break;
			case 2: 	ViewReportsGUI vrgui = new ViewReportsGUI(_garage);
						vrgui.setVisible(true);
						break;
			case 3: 	CreateEmployeeGUI cegui = new CreateEmployeeGUI(_garage);
						cegui.setVisible(true);
						break;
			case 4: 	CreateAdminGUI cagui = new CreateAdminGUI(_garage);
						cagui.setVisible(true);
						break;
//			case 5: 	//systemOverride();
			default: 	//failure
						break;
			
		}
	}

	protected void pressAdminLogout() {
		this.dispose();
		
	}

}
