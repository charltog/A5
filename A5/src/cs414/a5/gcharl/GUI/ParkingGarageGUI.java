package cs414.a5.gcharl.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSplitPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

//import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageHandler;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JMenuItem;

import cs414.a5.gcharl.common.*;
import cs414.a5.gcharl.server.*;

public class ParkingGarageGUI extends JFrame {

	private JPanel contentPane;
	private JTextPane assignedTicketNumber;
	private JTextField exitTicketNum;
	private JTextPane totalText;
	private JTextField adminID;
	private JTextField adminPassword;
	private FormOfPayment FOP;
	
	private static IParkingGarage _garage;
	private static IEntryGate _entryGate;
	
	private String hostname = "localhost";
	private int portnum = 8000;
	
	private int totalAmt = 0;
	private double payAmt = 0.0;
	private JTextField paymentAmount;
	private GridBagConstraints gbc_paymentAmount;
	private JTextField exitInformation;
	private JTextField changeAmount;

	final JTextPane entryGatePane = new JTextPane();
	final JTextPane vacancyPane = new JTextPane();
	final JTextPane exitGatePane = new JTextPane();

	final JButton btnGetTicket = new JButton("Get Ticket");
	
	final JButton btnEnterGarage = new JButton("Enter Garage");
	//btnEnterGarage.setEnabled(false);
	
	final JButton btnMakePayment = new JButton("Make Payment");
	//btnMakePayment.setEnabled(false);
	
	final JButton btnGetTotal = new JButton("Get Total");
	//btnGetTotal.setEnabled(false);
	
	final JButton btnExitGarage = new JButton("Exit Garage");
	//btnExitGarage.setEnabled(false);
	
	final JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
	final JRadioButton rdbtnCash = new JRadioButton("Cash");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			_garage = (IParkingGarage)		
				Naming.lookup("rmi://" + args[0] + ":" + args[1]  + "/GarageService");
			
//			_entryGate = (IEntryGate)		
//					Naming.lookup("rmi://" + args[0] + ":" + args[1]  + "/GarageService");	
			
		} 
		catch (MalformedURLException murle) {
			System.out.println("MalformedURLException");
		    System.out.println(murle);
		} catch (RemoteException re) {
		    System.out.println("RemoteException"); 
		    System.out.println(re);
		} catch (NotBoundException nbe) {
		    System.out.println("NotBoundException");
		    System.out.println(nbe);
		} catch (java.lang.ArithmeticException ae) {
		     System.out.println("java.lang.ArithmeticException");
		     System.out.println(ae);
		} 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					ParkingGarageGUI frame = new ParkingGarageGUI();					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
//				try {
//					_garage = (IParkingGarage)
//							Naming.lookup("rmi://" + "localhost" + ":" + "8000"  + "/CalculatorService");
//				} 
//				catch (MalformedURLException murle) {
//                     System.out.println("MalformedURLException");
//                     System.out.println(murle);
//                 } catch (RemoteException re) {
//                     System.out.println("RemoteException"); 
//                     System.out.println(re);
//                 } catch (NotBoundException nbe) {
//                     System.out.println("NotBoundException");
//                     System.out.println(nbe);
//                 } catch (java.lang.ArithmeticException ae) {
//                      System.out.println("java.lang.ArithmeticException");
//                      System.out.println(ae);
//                 }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ParkingGarageGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {150, 150, 150, 150, 150};
		gbl_contentPane.rowHeights = new int[]{28, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEntryGate = new JLabel("Entry Gate:");
		GridBagConstraints gbc_lblEntryGate = new GridBagConstraints();
		gbc_lblEntryGate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntryGate.gridx = 0;
		gbc_lblEntryGate.gridy = 0;
		contentPane.add(lblEntryGate, gbc_lblEntryGate);
		
		//final JTextPane entryGatePane = new JTextPane();
		entryGatePane.setText("Closed");
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_1.gridx = 1;
		gbc_textPane_1.gridy = 0;
		contentPane.add(entryGatePane, gbc_textPane_1);
		
		JLabel lblVacancy = new JLabel("Vacancy:");
		GridBagConstraints gbc_lblVacancy = new GridBagConstraints();
		gbc_lblVacancy.anchor = GridBagConstraints.EAST;
		gbc_lblVacancy.insets = new Insets(0, 0, 5, 5);
		gbc_lblVacancy.gridx = 2;
		gbc_lblVacancy.gridy = 0;
		contentPane.add(lblVacancy, gbc_lblVacancy);
		
		//final JTextPane vacancyPane = new JTextPane();
		GridBagConstraints gbc_vacancyPane = new GridBagConstraints();
		gbc_vacancyPane.insets = new Insets(0, 0, 5, 0);
		gbc_vacancyPane.gridx = 3;
		gbc_vacancyPane.gridy = 0;
		contentPane.add(vacancyPane, gbc_vacancyPane);
		vacancyPane.setText("Yes");
		
		//final JTextPane exitGatePane = new JTextPane();
		exitGatePane.setEditable(false);
		exitGatePane.setText("Closed");
		GridBagConstraints gbc_exitGatePane = new GridBagConstraints();
		gbc_exitGatePane.gridheight = 2;
		gbc_exitGatePane.insets = new Insets(0, 0, 0, 5);
		gbc_exitGatePane.gridx = 1;
		gbc_exitGatePane.gridy = 16;
		contentPane.add(exitGatePane, gbc_exitGatePane);
		
//		
//		final JButton btnGetTicket = new JButton("Get Ticket");
//		
//		final JButton btnEnterGarage = new JButton("Enter Garage");
		btnEnterGarage.setEnabled(false);
//		
//		final JButton btnMakePayment = new JButton("Make Payment");
		btnMakePayment.setEnabled(false);
//		
//		final JButton btnGetTotal = new JButton("Get Total");
		btnGetTotal.setEnabled(false);
//		
//		final JButton btnExitGarage = new JButton("Exit Garage");
		btnExitGarage.setEnabled(false);
//		
//		final JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
//		final JRadioButton rdbtnCash = new JRadioButton("Cash");
//		
				
		btnGetTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pressGetTicket();								
			}
		});
		
		btnEnterGarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressEnterGarage();
			}
		});
		
		GridBagConstraints gbc_btnGetTicket = new GridBagConstraints();
		gbc_btnGetTicket.gridwidth = 2;
		gbc_btnGetTicket.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetTicket.gridx = 0;
		gbc_btnGetTicket.gridy = 1;
		contentPane.add(btnGetTicket, gbc_btnGetTicket);
		
		JLabel lblYourAssignedTicket = new JLabel("Your Assigned Ticket Number:");
		GridBagConstraints gbc_lblYourAssignedTicket = new GridBagConstraints();
		gbc_lblYourAssignedTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblYourAssignedTicket.anchor = GridBagConstraints.EAST;
		gbc_lblYourAssignedTicket.gridx = 0;
		gbc_lblYourAssignedTicket.gridy = 2;
		contentPane.add(lblYourAssignedTicket, gbc_lblYourAssignedTicket);
		
		assignedTicketNumber = new JTextPane();
		assignedTicketNumber.setBackground(Color.LIGHT_GRAY);
		assignedTicketNumber.setForeground(Color.BLACK);
		assignedTicketNumber.setEditable(false);
		GridBagConstraints gbc_exitGarageSign = new GridBagConstraints();
		gbc_exitGarageSign.insets = new Insets(0, 0, 5, 5);
		gbc_exitGarageSign.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitGarageSign.gridx = 1;
		gbc_exitGarageSign.gridy = 2;
		contentPane.add(assignedTicketNumber, gbc_exitGarageSign);
				
		GridBagConstraints gbc_btnEnterGarage = new GridBagConstraints();
		gbc_btnEnterGarage.fill = GridBagConstraints.BOTH;
		gbc_btnEnterGarage.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterGarage.gridx = 0;
		gbc_btnEnterGarage.gridy = 3;
		contentPane.add(btnEnterGarage, gbc_btnEnterGarage);
		
		exitTicketNum = new JTextField();
		exitTicketNum.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				updateExitTicketNum();
			}
		});
		
		JLabel lblAdministratorLogin = new JLabel("Administrator Login");
		GridBagConstraints gbc_lblAdministratorLogin = new GridBagConstraints();
		gbc_lblAdministratorLogin.insets = new Insets(0, 0, 5, 0);
		gbc_lblAdministratorLogin.gridx = 3;
		gbc_lblAdministratorLogin.gridy = 4;
		contentPane.add(lblAdministratorLogin, gbc_lblAdministratorLogin);
		
		JLabel lblNewLabel_2 = new JLabel("User Name:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		adminID = new JTextField();
		GridBagConstraints gbc_adminID = new GridBagConstraints();
		gbc_adminID.insets = new Insets(0, 0, 5, 0);
		gbc_adminID.fill = GridBagConstraints.HORIZONTAL;
		gbc_adminID.gridx = 3;
		gbc_adminID.gridy = 5;
		contentPane.add(adminID, gbc_adminID);
		adminID.setColumns(10);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 6;
		contentPane.add(exitTicketNum, gbc_textField_1);
		exitTicketNum.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 6;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		adminPassword = new JTextField();
		GridBagConstraints gbc_adminPassword = new GridBagConstraints();
		gbc_adminPassword.insets = new Insets(0, 0, 5, 0);
		gbc_adminPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_adminPassword.gridx = 3;
		gbc_adminPassword.gridy = 6;
		contentPane.add(adminPassword, gbc_adminPassword);
		adminPassword.setColumns(10);
		
		JLabel lblTicketId = new JLabel("Ticket ID:");
		GridBagConstraints gbc_lblTicketId = new GridBagConstraints();
		gbc_lblTicketId.insets = new Insets(0, 0, 5, 5);
		gbc_lblTicketId.anchor = GridBagConstraints.EAST;
		gbc_lblTicketId.gridx = 0;
		gbc_lblTicketId.gridy = 7;
		contentPane.add(lblTicketId, gbc_lblTicketId);
		
		GridBagConstraints gbc_btnGetTotal = new GridBagConstraints();
		gbc_btnGetTotal.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetTotal.gridx = 1;
		gbc_btnGetTotal.gridy = 7;
		contentPane.add(btnGetTotal, gbc_btnGetTotal);
		
		btnGetTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pressGetTotal();
			}
		});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pressAdminLogin();
			}
		});
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnLogin, popupMenu);
		
		JMenuItem mntmVieweditGarageSettings = new JMenuItem("View/Edit Garage Settings");
		popupMenu.add(mntmVieweditGarageSettings);
		
		JMenuItem mntmViewSystemLog = new JMenuItem("View System Log");
		popupMenu.add(mntmViewSystemLog);
		
		JMenuItem mntmCreateNewEmployee = new JMenuItem("Create New Employee");
		popupMenu.add(mntmCreateNewEmployee);
		
		JMenuItem mntmCreateNewAdministrator = new JMenuItem("Create New Administrator");
		popupMenu.add(mntmCreateNewAdministrator);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin.gridx = 3;
		gbc_btnLogin.gridy = 7;
		contentPane.add(btnLogin, gbc_btnLogin);
		
		JLabel lblTotal = new JLabel("Remaining Total you owe:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 8;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		totalText = new JTextPane();
		totalText.setBackground(Color.LIGHT_GRAY);
		totalText.setEditable(false);
		GridBagConstraints gbc_totalText = new GridBagConstraints();
		gbc_totalText.insets = new Insets(0, 0, 5, 5);
		gbc_totalText.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalText.gridx = 1;
		gbc_totalText.gridy = 8;
		contentPane.add(totalText, gbc_totalText);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Type:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 9;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblPaymentAmount = new JLabel("Payment Amount:");
		GridBagConstraints gbc_lblPaymentAmount = new GridBagConstraints();
		gbc_lblPaymentAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaymentAmount.gridx = 1;
		gbc_lblPaymentAmount.gridy = 9;
		contentPane.add(lblPaymentAmount, gbc_lblPaymentAmount);
		
		rdbtnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FOP = FormOfPayment.Cash;				
				rdbtnCreditCard.setSelected(false);
			}
		});
		
		GridBagConstraints gbc_rdbtnCash = new GridBagConstraints();
		gbc_rdbtnCash.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCash.gridx = 0;
		gbc_rdbtnCash.gridy = 10;
		contentPane.add(rdbtnCash, gbc_rdbtnCash);
		
		
		paymentAmount = new JTextField();
		gbc_paymentAmount = new GridBagConstraints();
		gbc_paymentAmount.insets = new Insets(0, 0, 5, 5);
		gbc_paymentAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_paymentAmount.gridx = 1;
		gbc_paymentAmount.gridy = 10;
		contentPane.add(paymentAmount, gbc_paymentAmount);
		paymentAmount.setColumns(10);
		
		
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressMakePayment();
			}
		});
		
		rdbtnCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FOP = FormOfPayment.CreditCard;
				rdbtnCash.setSelected(false);
			}
		});
		
		exitInformation = new JTextField();
		
		
		exitInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		exitInformation.setBackground(Color.LIGHT_GRAY);
		exitInformation.setEditable(false);
		GridBagConstraints gbc_exitInformation = new GridBagConstraints();
		gbc_exitInformation.insets = new Insets(0, 0, 5, 5);
		gbc_exitInformation.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitInformation.gridx = 2;
		gbc_exitInformation.gridy = 10;
		contentPane.add(exitInformation, gbc_exitInformation);
		exitInformation.setColumns(10);
		
		GridBagConstraints gbc_rdbtnCreditCard = new GridBagConstraints();
		gbc_rdbtnCreditCard.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCreditCard.gridx = 0;
		gbc_rdbtnCreditCard.gridy = 11;
		contentPane.add(rdbtnCreditCard, gbc_rdbtnCreditCard);
		
		GridBagConstraints gbc_btnMakePayment = new GridBagConstraints();
		gbc_btnMakePayment.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakePayment.gridx = 1;
		gbc_btnMakePayment.gridy = 11;
		contentPane.add(btnMakePayment, gbc_btnMakePayment);
		
		btnExitGarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressExitGarage();
			}
		});
		
		GridBagConstraints gbc_btnExitGarage = new GridBagConstraints();
		gbc_btnExitGarage.fill = GridBagConstraints.BOTH;
		gbc_btnExitGarage.gridheight = 3;
		gbc_btnExitGarage.insets = new Insets(0, 0, 5, 5);
		gbc_btnExitGarage.gridx = 2;
		gbc_btnExitGarage.gridy = 11;
		contentPane.add(btnExitGarage, gbc_btnExitGarage);
		
		JLabel lblChange = new JLabel("Change:");
		lblChange.setEnabled(false);
		GridBagConstraints gbc_lblChange = new GridBagConstraints();
		gbc_lblChange.insets = new Insets(0, 0, 5, 5);
		gbc_lblChange.gridx = 1;
		gbc_lblChange.gridy = 12;
		contentPane.add(lblChange, gbc_lblChange);
		
		changeAmount = new JTextField();
		changeAmount.setBackground(Color.LIGHT_GRAY);
		changeAmount.setEditable(false);
		GridBagConstraints gbc_changeAmount = new GridBagConstraints();
		gbc_changeAmount.insets = new Insets(0, 0, 5, 5);
		gbc_changeAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_changeAmount.gridx = 1;
		gbc_changeAmount.gridy = 13;
		contentPane.add(changeAmount, gbc_changeAmount);
		changeAmount.setColumns(10);
		
		JLabel lblExitGate = new JLabel("Exit Gate:");
		GridBagConstraints gbc_lblExitGate = new GridBagConstraints();
		gbc_lblExitGate.gridheight = 2;
		gbc_lblExitGate.insets = new Insets(0, 0, 0, 5);
		gbc_lblExitGate.gridx = 0;
		gbc_lblExitGate.gridy = 16;
		contentPane.add(lblExitGate, gbc_lblExitGate);
		
		
	}

	protected void pressMakePayment() {
		try {
			exitInformation.setText("");
			String ticketNum = exitTicketNum.getText();
			int fopCode = 0;
			double changeAmt = -1.0;
					
			if (FOP == FormOfPayment.Cash) {
				fopCode = 1;
			} else if (FOP == FormOfPayment.CreditCard) {
				fopCode = 2;
			}
			
			try {
				payAmt = Double.parseDouble(paymentAmount.getText());
			} 
			catch(NumberFormatException e1) {
				exitInformation.setText("Invalid payment amount");
				paymentAmount.setText("");
			}
				
			changeAmt = _garage.makePayment(ticketNum, payAmt, fopCode);
			
			if (changeAmt >= 0.0) {
				totalText.setText("");
				paymentAmount.setText("");
				rdbtnCash.setSelected(false);
				rdbtnCreditCard.setSelected(false);
				payAmt = 0.0;
				FOP = null;
				String s = String.format("$ %.2f", changeAmt);
				changeAmount.setText(s);
			} else {
				exitInformation.setText("Payment Failed");
			}
			
			exitGatePane.setText(_garage.getExitGateStatus()); 
			if (_garage.isValidTicket(ticketNum)) {
				btnExitGarage.setEnabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void pressAdminLogin() {
		try {
			String name = adminID.getText();
			String pw = adminPassword.getText();
			if (_garage.administratorLogin(name, pw)) {
				AdminMenu aMenu = new AdminMenu(_garage);
				aMenu.setVisible(true);
			}
		} catch (RemoteException re) {
            System.out.println("RemoteException"); 
            System.out.println(re);
        } catch (java.lang.ArithmeticException ae) {
             System.out.println("java.lang.ArithmeticException");
             System.out.println(ae);
        }
	}

	protected void pressGetTotal() {
		try {
			exitInformation.setText("");
			String ticketNum = exitTicketNum.getText();
			boolean isValidTicket = _garage.isValidTicket(ticketNum);
			
			if (!isValidTicket) {
				totalText.setText("Invalid Ticket");
			} else {
				double saleTotal = _garage.getSaleTotal(ticketNum); 
				String s = String.format("$ %.2f", saleTotal);
				totalText.setText(s);
				btnMakePayment.setEnabled(true);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void updateExitTicketNum() {
		try {
			String ticketNum = exitTicketNum.getText();
			boolean isValidTicket = _garage.isValidTicket(ticketNum); 
			
			if (isValidTicket) {
				btnGetTotal.setEnabled(true);	
				btnExitGarage.setEnabled(true);
			} else {
				btnGetTotal.setEnabled(false);
				btnExitGarage.setEnabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	protected void pressEnterGarage() {
		try {
			exitInformation.setText("");
			entryGatePane.setText("Closed");		
			assignedTicketNumber.setText("");
			
			_garage.pressEnterGarage();
			
			btnEnterGarage.setEnabled(false);
			btnGetTicket.setEnabled(true);
			
			if (_garage.isGarageAcceptingVehicles()) {
				vacancyPane.setText("Yes");
			} else {
				vacancyPane.setText("No");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void pressGetTicket() {
		try {
			exitInformation.setText("");
			int ticketId = _garage.pressGetTicket();
			if (ticketId != -1) {
				assignedTicketNumber.setText(String.valueOf(ticketId));
				entryGatePane.setText("Open");	
				btnEnterGarage.setEnabled(true);
				btnGetTicket.setEnabled(false);
			} else {
				assignedTicketNumber.setText("Sorry, Garage is Full");
				entryGatePane.setText("Closed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void pressExitGarage() {
		try {
			String ticketNum = exitTicketNum.getText();
			//Ticket t1 = _garage.getEntryGate().findTicketByID(testString);
			
			//if (!_garage.isValidTicket(ticketNum)) {
			try {
				Integer.parseInt(ticketNum);
			
				if (_garage.isValidTicket(ticketNum)) {
					exitInformation.setText("Pay before exiting please");
					btnExitGarage.setEnabled(false);
				} else {
					
					_garage.exitGarage(ticketNum);
					
//					Sale s1 = _garage.getExitGate().findSaleByTicketId(t1);
								
					totalText.setText("");
					exitTicketNum.setText("");
					exitInformation.setText("Goodbye");
					btnMakePayment.setEnabled(false);
					btnExitGarage.setEnabled(false);
					changeAmount.setText("");
					
//					_garage.getExitGate().exitGarage(s1);	
					
				
				}
			} catch (NumberFormatException nfe) {
				exitInformation.setText("Invalid Ticket #");
				btnExitGarage.setEnabled(false);
			}
			
			
			if (_garage.isGarageAcceptingVehicles()) {
				vacancyPane.setText("Yes");
			} else {
				vacancyPane.setText("No");
			}	
			exitGatePane.setText(_garage.getExitGateStatus()); // .getStatus().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	
		private static void addPopup(Component component, final JPopupMenu popup) {
			component.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}
				public void mouseReleased(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}
				private void showMenu(MouseEvent e) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			});
		}
}
