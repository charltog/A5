package cs414.a5.gcharl;

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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu extends JFrame {

	private JPanel contentPane;

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
	 */
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JRadioButtonMenuItem rdbtnmntmVieweditGarageSettings = new JRadioButtonMenuItem("View/Edit Garage Settings");
		panel.add(rdbtnmntmVieweditGarageSettings);
		
		JRadioButtonMenuItem rdbtnmntmViewSystemLog = new JRadioButtonMenuItem("View System Log");
		panel.add(rdbtnmntmViewSystemLog);
		
		JRadioButtonMenuItem rdbtnmntmCreateNewEmployee = new JRadioButtonMenuItem("Create New Employee");
		panel.add(rdbtnmntmCreateNewEmployee);
		
		JRadioButtonMenuItem rdbtnmntmCreateNewAdministrator = new JRadioButtonMenuItem("Create New Administrator");
		panel.add(rdbtnmntmCreateNewAdministrator);
		
		JRadioButtonMenuItem rdbtnmntmSystemOverride = new JRadioButtonMenuItem("System Override");
		panel.add(rdbtnmntmSystemOverride);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pressSelect();
			}
		});
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelect.gridx = 2;
		gbc_btnSelect.gridy = 3;
		contentPane.add(btnSelect, gbc_btnSelect);
		
		JButton btnLogout = new JButton("Logout");
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogout.gridx = 2;
		gbc_btnLogout.gridy = 4;
		contentPane.add(btnLogout, gbc_btnLogout);
	}

	protected void pressSelect() {
		
		
	}

}
