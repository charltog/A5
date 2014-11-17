package cs414.a5.gcharl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class AdminMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JRadioButton rdbtnViewGarageSettings = new JRadioButton("View/Edit Garage Settings");
		GridBagConstraints gbc_rdbtnViewGarageSettings = new GridBagConstraints();
		gbc_rdbtnViewGarageSettings.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnViewGarageSettings.gridx = 2;
		gbc_rdbtnViewGarageSettings.gridy = 2;
		contentPane.add(rdbtnViewGarageSettings, gbc_rdbtnViewGarageSettings);
		
		JRadioButton rdbtnViewSystemLog = new JRadioButton("View System Log");
		GridBagConstraints gbc_rdbtnViewSystemLog = new GridBagConstraints();
		gbc_rdbtnViewSystemLog.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnViewSystemLog.gridx = 2;
		gbc_rdbtnViewSystemLog.gridy = 3;
		contentPane.add(rdbtnViewSystemLog, gbc_rdbtnViewSystemLog);
		
		JButton btnSelect = new JButton("Select");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelect.gridx = 2;
		gbc_btnSelect.gridy = 9;
		contentPane.add(btnSelect, gbc_btnSelect);
		
		JButton btnLogout = new JButton("Logout");
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.gridx = 2;
		gbc_btnLogout.gridy = 10;
		contentPane.add(btnLogout, gbc_btnLogout);
	}

}
