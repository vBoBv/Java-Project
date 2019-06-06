package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import data.RegularCustomer;
import data.SilverCustomer;
import dataController.DataController;

public class RegisterMember extends JFrame { 
	ArrayList<RegularCustomer> customerDetails = DataController.readFile("data/customerDetails.csv");
	private JPanel contentPane;
	private JPanel adminInformation;
	private JTextField registerTxtFieldFirstName;
	private JTextField registerTextFieldLastName;
	private JTextField registerTextFieldAge;
	private JTextField registerTextFieldPhoneNumber;
	private JTextField registerTextFieldEmailAddress;
	private JButton btnRegister;
	private JComboBox comboBoxMembership;
	private JComboBox comboBoxGender;
	private JTextField txtCheckMemberhsipName;
	private JTextField txtMembershipPhoneNumber;
	private JTextField txtFieldFullName;
	private JTextField txtFieldPhoneNumber;
	///
	private JLabel lblAdminUsername;
	private JButton btnSignOut;
	
	
	
	public JLabel getLblAdminUsername() {
		return lblAdminUsername;
	}

	public void setLblAdminUsername(JLabel lblAdminUsername) {
		this.lblAdminUsername = lblAdminUsername;
	}

	public JButton getBtnSignOut() {
		return btnSignOut;
	}

	public void setBtnSignOut(JButton btnSignOut) {
		this.btnSignOut = btnSignOut;
	}
	
	

	////
	private JButton btnManageMember;
	private JList regularCustomerJList;
	private JList silverCustomerJList;
	private JList goldCustomerJList;
	private JButton btnNormalViewchangeDetails;
	private JButton btnSilverViewchangeDetails;
	private JButton btnGoldViewchangeDetails;
	private JButton btnRemoveRegular;
	private JButton btnRemoveSilver;
	private JButton btnRemoveGold;
	
	
	
	///
	private JButton btnProceed;
	private JButton btnConfirmPayment;
	private JButton btnCalculate;
	
	///Spinner
	private JSpinner blueRayJSpinner;
	private JSpinner dvdJSpinner;
	private JLabel lblBlueRayQuantity;
	private JLabel lblDvdQuantity;
	private JLabel lblBlueRayTotalPrice;
	private JLabel lblDvdTotalPrice;
	private JLabel lblSumTotalPrice;
	
	////
	private double normalBlueRayTotalPrice;
	private double normalDvdTotalPrice;
	private double sumTotalPrice;
	
	////
	private JComboBox comboBoxMembershipClass;
	private JButton btnCheck;
	
	//ArrayList<Member> data;
	
	public JTextField getRegisterTxtFieldFirstName() {
		return registerTxtFieldFirstName;
	}

	public void setRegisterTxtFieldFirstName(JTextField registerTxtFieldFirstName) {
		this.registerTxtFieldFirstName = registerTxtFieldFirstName;
	}

	public JTextField getRegisterTextFieldLastName() {
		return registerTextFieldLastName;
	}

	public void setRegisterTextFieldLastName(JTextField registerTextFieldLastName) {
		this.registerTextFieldLastName = registerTextFieldLastName;
	}

	public JTextField getRegisterTextFieldAge() {
		return registerTextFieldAge;
	}

	public void setRegisterTextFieldAge(JTextField registerTextFieldAge) {
		this.registerTextFieldAge = registerTextFieldAge;
	}

	public JTextField getRegisterTextFieldPhoneNumber() {
		return registerTextFieldPhoneNumber;
	}

	public void setRegisterTextFieldPhoneNumber(JTextField registerTextFieldPhoneNumber) {
		this.registerTextFieldPhoneNumber = registerTextFieldPhoneNumber;
	}

	public JTextField getRegisterTextFieldEmailAddress() {
		return registerTextFieldEmailAddress;
	}

	public void setRegisterTextFieldEmailAddress(JTextField registerTextFieldEmailAddress) {
		this.registerTextFieldEmailAddress = registerTextFieldEmailAddress;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}

	
	public JComboBox getComboBoxMembership() {
		return comboBoxMembership;
	}

	public void setComboBoxMembership(JComboBox comboBoxMembership) {
		this.comboBoxMembership = comboBoxMembership;
	}

	public JComboBox getComboBoxGender() {
		return comboBoxGender;
	}

	public void setComboBoxGender(JComboBox comboBoxGender) {
		this.comboBoxGender = comboBoxGender;
	}

	
	////// Manage Member
	public JButton getBtnManageMember() {
		return btnManageMember;
	}

	public void setBtnManageMember(JButton btnManageMember) {
		this.btnManageMember = btnManageMember;
	}
	


	public JButton getBtnNormalViewchangeDetails() {
		return btnNormalViewchangeDetails;
	}

	public void setBtnNormalViewchangeDetails(JButton btnViewchangeDetails) {
		this.btnNormalViewchangeDetails = btnViewchangeDetails;
	}
	
	public JButton getBtnSilverViewchangeDetails() {
		return btnSilverViewchangeDetails;
	}

	public void setBtnSilverViewchangeDetails(JButton btnSilverViewchangeDetails) {
		this.btnSilverViewchangeDetails = btnSilverViewchangeDetails;
	}

	public JButton getBtnGoldViewchangeDetails() {
		return btnGoldViewchangeDetails;
	}

	public void setBtnGoldViewchangeDetails(JButton btnGoldViewchangeDetails) {
		this.btnGoldViewchangeDetails = btnGoldViewchangeDetails;
	}

	public JButton getBtnRemoveRegular() {
		return btnRemoveRegular;
	}

	public void setBtnRemoveRegular(JButton btnRemove) {
		this.btnRemoveRegular = btnRemove;
	}

	public JList getRegularCustomerJList() {
		return regularCustomerJList;
	}

	public void setRegularCustomerJList(JList regularCustomerName) {
		this.regularCustomerJList = regularCustomerName;
	}
	
	public JList getSilverCustomerJList() {
		return silverCustomerJList;
	}

	public void setSilverCustomerJList(JList silverCustomerJList) {
		this.silverCustomerJList = silverCustomerJList;
	}

	public JList getGoldCustomerJList() {
		return goldCustomerJList;
	}

	public void setGoldCustomerJList(JList goldCustomerJList) {
		this.goldCustomerJList = goldCustomerJList;
	}
	
	public JButton getBtnRemoveSilver() {
		return btnRemoveSilver;
	}

	public void setBtnRemoveSilver(JButton btnRemoveSilver) {
		this.btnRemoveSilver = btnRemoveSilver;
	}

	public JButton getBtnRemoveGold() {
		return btnRemoveGold;
	}

	public void setBtnRemoveGold(JButton btnRemoveGold) {
		this.btnRemoveGold = btnRemoveGold;
	}

	////
	public JButton getBtnProceed() {
		return btnProceed;
	}

	public void setBtnProceed(JButton btnProceed) {
		this.btnProceed = btnProceed;
	}
	


	////
	public JSpinner getBlueRayJSpinner() {
		return blueRayJSpinner;
	}

	public void setBlueRayJSpinner(JSpinner blueRayJSpinner) {
		this.blueRayJSpinner = blueRayJSpinner;
	}
	
	public JSpinner getDvdJSpinner() {
		return dvdJSpinner;
	}

	public void setDvdJSpinner(JSpinner dvdJSpinner) {
		this.dvdJSpinner = dvdJSpinner;
	}
	
	public JLabel getLblBlueRayQuantity() {
		return lblBlueRayQuantity;
	}

	public void setLblBlueRayQuantity(JLabel lblBlueRayQuantity) {
		this.lblBlueRayQuantity = lblBlueRayQuantity;
	}

	public JLabel getLblDvdQuantity() {
		return lblDvdQuantity;
	}

	public void setLblDvdQuantity(JLabel lblDvdQuantity) {
		this.lblDvdQuantity = lblDvdQuantity;
	}

	public JLabel getLblBlueRayTotalPrice() {
		return lblBlueRayTotalPrice;
	}

	public void setLblBlueRayTotalPrice(JLabel lblBlueRayTotalPrice) {
		this.lblBlueRayTotalPrice = lblBlueRayTotalPrice;
	}

	public JLabel getLblDvdTotalPrice() {
		return lblDvdTotalPrice;
	}

	public void setLblDvdTotalPrice(JLabel lblDvdTotalPrice) {
		this.lblDvdTotalPrice = lblDvdTotalPrice;
	}

	public JLabel getLblSumTotalPrice() {
		return lblSumTotalPrice;
	}

	public void setLblSumTotalPrice(JLabel lblSumTotalPrice) {
		this.lblSumTotalPrice = lblSumTotalPrice;
	}
	
	/////
	public JTextField getTxtCheckMemberhsipName() {
		return txtCheckMemberhsipName;
	}

	public void setTxtCheckMemberhsipName(JTextField txtCheckMemberhsipName) {
		this.txtCheckMemberhsipName = txtCheckMemberhsipName;
	}

	public JTextField getTxtMembershipPhoneNumber() {
		return txtMembershipPhoneNumber;
	}

	public void setTxtMembershipPhoneNumber(JTextField txtMembershipPhoneNumber) {
		this.txtMembershipPhoneNumber = txtMembershipPhoneNumber;
	}

	/////
	public double getNormalBlueRayTotalPrice() {
		return normalBlueRayTotalPrice;
	}

	public void setNormalBlueRayTotalPrice(double normalBlueRayTotalPrice) {
		this.normalBlueRayTotalPrice = normalBlueRayTotalPrice;
	}

	public double getNormalDvdTotalPrice() {
		return normalDvdTotalPrice;
	}

	public void setNormalDvdTotalPrice(double normalDvdTotalPrice) {
		this.normalDvdTotalPrice = normalDvdTotalPrice;
	}

	public double getSumTotalPrice() {
		return sumTotalPrice;
	}

	public void setSumTotalPrice(double sumTotalPrice) {
		this.sumTotalPrice = sumTotalPrice;
	}
	
	////////////
	public JButton getBtnCheck() {
		return btnCheck;
	}

	public void setBtnCheck(JButton btnCheck) {
		this.btnCheck = btnCheck;
	}
	
	///////////
	public JTextField getTxtFieldFullName() {
		return txtFieldFullName;
	}

	public void setTxtFieldFullName(JTextField txtFieldFullName) {
		this.txtFieldFullName = txtFieldFullName;
	}

	public JTextField getTxtFieldPhoneNumber() {
		return txtFieldPhoneNumber;
	}

	public void setTxtFieldPhoneNumber(JTextField txtFieldPhoneNumber) {
		this.txtFieldPhoneNumber = txtFieldPhoneNumber;
	}
	

	public JComboBox getComboBoxMembershipClass() {
		return comboBoxMembershipClass;
	}

	public void setComboBoxMembershipClass(JComboBox comboBoxMembershipClass) {
		this.comboBoxMembershipClass = comboBoxMembershipClass;
	}

	
	public JButton getBtnConfirmPayment() {
		return btnConfirmPayment;
	}

	public void setBtnConfirmPayment(JButton btnConfirmPayment) {
		this.btnConfirmPayment = btnConfirmPayment;
	}
	
	

	public JButton getBtnCalculate() {
		return btnCalculate;
	}

	public void setBtnCalculate(JButton btnCalculate) {
		this.btnCalculate = btnCalculate;
	}

	/////
	private JButton btnUpdatePromotions;
	private JButton btnNormalPaymentCheckOut;
	private JSpinner blueRaySpinner;
	private JSpinner dvdSpinner;
	private JLabel blueRayQuan;
	private JLabel dvdQuan;
	private JLabel blueRaySumPrice;
	private JLabel dvdSumPrice;
	private JLabel discSumPrice;
	
	public JButton getBtnNormalPaymentCheckOut() {
		return btnNormalPaymentCheckOut;
	}

	public void setBtnNormalPaymentCheckOut(JButton btnNormalPaymentCheckOut) {
		this.btnNormalPaymentCheckOut = btnNormalPaymentCheckOut;
	}

	
	
	
	public JSpinner getBlueRaySpinner() {
		return blueRaySpinner;
	}

	public void setBlueRaySpinner(JSpinner blueRaySpinner) {
		this.blueRaySpinner = blueRaySpinner;
	}
	
	
	

	public JSpinner getDvdSpinner() {
		return dvdSpinner;
	}

	public void setDvdSpinner(JSpinner dvdSpinner) {
		this.dvdSpinner = dvdSpinner;
	}

	
	
	
	public JLabel getBlueRayQuan() {
		return blueRayQuan;
	}

	public void setBlueRayQuan(JLabel blueRayQuan) {
		this.blueRayQuan = blueRayQuan;
	}

	public JLabel getDvdQuan() {
		return dvdQuan;
	}

	public void setDvdQuan(JLabel dvdQuan) {
		this.dvdQuan = dvdQuan;
	}
	
	

	public JLabel getBlueRaySumPrice() {
		return blueRaySumPrice;
	}

	public void setBlueRaySumPrice(JLabel blueRaySumPrice) {
		this.blueRaySumPrice = blueRaySumPrice;
	}

	public JLabel getDvdSumPrice() {
		return dvdSumPrice;
	}

	public void setDvdSumPrice(JLabel dvdSumPrice) {
		this.dvdSumPrice = dvdSumPrice;
	}

	public JLabel getDiscSumPrice() {
		return discSumPrice;
	}

	public void setDiscSumPrice(JLabel discSumPrice) {
		this.discSumPrice = discSumPrice;
	}
	
	

	public JButton getBtnUpdatePromotions() {
		return btnUpdatePromotions;
	}

	public void setBtnUpdatePromotions(JButton btnUpdatePromotions) {
		this.btnUpdatePromotions = btnUpdatePromotions;
	}
	
	////
	private JLabel labelDate;
	private JLabel labelTime;
	private JTextField modifyMemberClassTxt;
	private JTextField modifyFirstNameTxt;
	private JTextField modifyLastNameTxt;
	private JTextField modifyAgeTxt;
	private JTextField modifyGenderTxt;
	private JTextField modifyPhoneTxt;
	private JTextField modifyEmailTxt;
	
	

	public JLabel getLabelDate() {
		return labelDate;
	}

	public void setLabelDate(JLabel labelDate) {
		this.labelDate = labelDate;
	}

	public JLabel getLabelTime() {
		return labelTime;
	}

	public void setLabelTime(JLabel labelTime) {
		this.labelTime = labelTime;
	}
	
	
	
	
	//////
	private JComboBox comboBoxModifyMember;
	private JButton btnEdit;
	private JButton btnUpdate;
	private JButton btnModifyMemberDetail;
	private JList listModifyMember;
	private JButton btnSearch;

	
	
	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public JList getListModifyMember() {
		return listModifyMember;
	}

	public void setListModifyMember(JList listModifyMember) {
		this.listModifyMember = listModifyMember;
	}

	public JTextField getModifyMemberClassTxt() {
		return modifyMemberClassTxt;
	}

	public void setModifyMemberClassTxt(JTextField modifyMemberClassTxt) {
		this.modifyMemberClassTxt = modifyMemberClassTxt;
	}

	public JTextField getModifyFirstNameTxt() {
		return modifyFirstNameTxt;
	}

	public void setModifyFirstNameTxt(JTextField modifyFirstNameTxt) {
		this.modifyFirstNameTxt = modifyFirstNameTxt;
	}

	public JTextField getModifyLastNameTxt() {
		return modifyLastNameTxt;
	}

	public void setModifyLastNameTxt(JTextField modifyLastNameTxt) {
		this.modifyLastNameTxt = modifyLastNameTxt;
	}

	public JTextField getModifyAgeTxt() {
		return modifyAgeTxt;
	}

	public void setModifyAgeTxt(JTextField modifyAgeTxt) {
		this.modifyAgeTxt = modifyAgeTxt;
	}

	public JTextField getModifyGenderTxt() {
		return modifyGenderTxt;
	}

	public void setModifyGenderTxt(JTextField modifyGenderTxt) {
		this.modifyGenderTxt = modifyGenderTxt;
	}

	public JTextField getModifyPhoneTxt() {
		return modifyPhoneTxt;
	}

	public void setModifyPhoneTxt(JTextField modifyPhoneTxt) {
		this.modifyPhoneTxt = modifyPhoneTxt;
	}

	public JTextField getModifyEmailTxt() {
		return modifyEmailTxt;
	}

	public void setModifyEmailTxt(JTextField modifyEmailTxt) {
		this.modifyEmailTxt = modifyEmailTxt;
	}

	public JComboBox getComboBoxModifyMember() {
		return comboBoxModifyMember;
	}

	public void setComboBoxModifyMember(JComboBox comboBoxModifyMember) {
		this.comboBoxModifyMember = comboBoxModifyMember;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	
	
	
	public JButton getBtnModifyMemberDetail() {
		return btnModifyMemberDetail;
	}

	public void setBtnModifyMemberDetail(JButton btnModifyMemberDetail) {
		this.btnModifyMemberDetail = btnModifyMemberDetail;
	}
	
	
	private JButton btnEditThisSilver;
	private JButton btnEditThisGold;
	
	

	public JButton getBtnEditThisSilver() {
		return btnEditThisSilver;
	}

	public void setBtnEditThisSilver(JButton btnEditThisSilver) {
		this.btnEditThisSilver = btnEditThisSilver;
	}

	public JButton getBtnEditThisGold() {
		return btnEditThisGold;
	}

	public void setBtnEditThisGold(JButton btnEditThisGold) {
		this.btnEditThisGold = btnEditThisGold;
	}
	
	private JButton btnUpdateGold;
	private JButton btnUpdateSilver;
	
	

	public JButton getBtnUpdateGold() {
		return btnUpdateGold;
	}

	public void setBtnUpdateGold(JButton btnUpdateGold) {
		this.btnUpdateGold = btnUpdateGold;
	}

	public JButton getBtnUpdateSilver() {
		return btnUpdateSilver;
	}

	public void setBtnUpdateSilver(JButton btnUpdateSilver) {
		this.btnUpdateSilver = btnUpdateSilver;
	}

	
	private JButton btnProcessPayment;
	
	
	public JButton getBtnProcessPayment() {
		return btnProcessPayment;
	}

	public void setBtnProcessPayment(JButton btnProcessPayment) {
		this.btnProcessPayment = btnProcessPayment;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterMember frame = new RegisterMember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	

	public void clock() {
		Thread clock = new Thread() 
		{
			public void run( ) {
				try {
					for(;;) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH) + 1;
						int year = cal.get(Calendar.YEAR);
						
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						
						labelDate.setText("Date: " + year + "/" + month + "/" + day);
						labelTime.setText("Time: " + hour + ":" + minute + ":" + second);
						sleep(1000);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	

	

	


	/**
	 * Create the frame.
	 */
	public RegisterMember() {
		setTitle("Entertainment Plus Movie Rental By Ponvath Vann");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1148, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.WHITE, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(286, 0, 844, 533);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		/*
		 * 
		 * Admin Information
		 * 
		 * 
		 */
		adminInformation = new JPanel();
		layeredPane.add(adminInformation, "name_110568413762357");
		adminInformation.setBackground(SystemColor.control);
		adminInformation.setLayout(null);
		Image admin = new ImageIcon(this.getClass().getResource("/manager.png")).getImage();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(526, 13, 306, 507);
		adminInformation.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel adminImg = new JLabel("");
		adminImg.setBounds(104, 70, 111, 208);
		panel_2.add(adminImg);
		adminImg.setIcon(new ImageIcon(admin));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.GRAY);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsername.setBounds(62, 250, 77, 28);
		panel_2.add(lblUsername);
		
		lblAdminUsername = new JLabel("Username");
		lblAdminUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminUsername.setForeground(Color.GRAY);
		lblAdminUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAdminUsername.setBounds(167, 250, 77, 28);
		panel_2.add(lblAdminUsername);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(27, 299, 250, 96);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblRoleInThe = new JLabel("Role in the company");
		lblRoleInThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoleInThe.setForeground(Color.GRAY);
		lblRoleInThe.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRoleInThe.setBounds(48, 13, 159, 28);
		panel_3.add(lblRoleInThe);
		
		JLabel lblManagerOfCustomer = new JLabel("Manager of CSM");
		lblManagerOfCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerOfCustomer.setForeground(Color.BLACK);
		lblManagerOfCustomer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblManagerOfCustomer.setBounds(0, 54, 258, 28);
		panel_3.add(lblManagerOfCustomer);
		
		btnSignOut = new JButton("Sign Out");
		btnSignOut.setForeground(Color.WHITE);
		btnSignOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSignOut.setBackground(new Color(51, 51, 51));
		btnSignOut.setBounds(104, 408, 111, 28);
		panel_2.add(btnSignOut);
		
		labelDate = new JLabel("Date");
		labelDate.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDate.setForeground(Color.GRAY);
		labelDate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelDate.setBounds(137, 13, 157, 28);
		panel_2.add(labelDate);
		
		labelTime = new JLabel("Time");
		labelTime.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTime.setForeground(Color.GRAY);
		labelTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelTime.setBounds(137, 40, 157, 28);
		panel_2.add(labelTime);
		
		JLabel lblWelcomeTo = new JLabel("ntertainment Plus");
		lblWelcomeTo.setFont(new Font("Calibri", Font.BOLD, 40));
		lblWelcomeTo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWelcomeTo.setBounds(21, 63, 493, 103);
		adminInformation.add(lblWelcomeTo);
		
		JLabel lblCustomer = new JLabel("ovie Rental");
		lblCustomer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomer.setFont(new Font("Calibri", Font.BOLD, 40));
		lblCustomer.setBounds(21, 116, 493, 103);
		adminInformation.add(lblCustomer);
		
		JLabel lblWelcomeTo_1 = new JLabel("Welcome to");
		lblWelcomeTo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWelcomeTo_1.setFont(new Font("Calibri", Font.BOLD, 40));
		lblWelcomeTo_1.setBounds(21, 13, 493, 103);
		adminInformation.add(lblWelcomeTo_1);
		
		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("Goudy Stout", Font.BOLD, 40));
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setBounds(160, 61, 63, 105);
		adminInformation.add(lblE);
		
		JLabel lblM = new JLabel("M");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setFont(new Font("Goudy Stout", Font.BOLD, 40));
		lblM.setBounds(262, 114, 75, 105);
		adminInformation.add(lblM);
		
		JLabel lblInstruction = new JLabel("Guidelines");
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setFont(new Font("Calibri", Font.BOLD, 20));
		lblInstruction.setBounds(0, 224, 526, 26);
		adminInformation.add(lblInstruction);
		
		JLabel lblRegisterAMember = new JLabel("Register a Member:");
		lblRegisterAMember.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegisterAMember.setFont(new Font("Calibri", Font.BOLD, 17));
		lblRegisterAMember.setBounds(41, 279, 148, 26);
		adminInformation.add(lblRegisterAMember);
		
		JLabel lblUsedToRegister = new JLabel("Register all type of customers.");
		lblUsedToRegister.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsedToRegister.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblUsedToRegister.setBounds(200, 279, 332, 26);
		adminInformation.add(lblUsedToRegister);
		
		JLabel lblManageMember = new JLabel("Manage Member:");
		lblManageMember.setHorizontalAlignment(SwingConstants.RIGHT);
		lblManageMember.setFont(new Font("Calibri", Font.BOLD, 17));
		lblManageMember.setBounds(41, 307, 142, 26);
		adminInformation.add(lblManageMember);
		
		JLabel lblUsedToEdit = new JLabel("View and remove customers.");
		lblUsedToEdit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsedToEdit.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblUsedToEdit.setBounds(200, 307, 332, 26);
		adminInformation.add(lblUsedToEdit);
		
		JLabel lblMembershipPayment = new JLabel("Membership Payment:");
		lblMembershipPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMembershipPayment.setFont(new Font("Calibri", Font.BOLD, 17));
		lblMembershipPayment.setBounds(20, 334, 163, 26);
		adminInformation.add(lblMembershipPayment);
		
		JLabel lblUsedToProcess = new JLabel("Process payment for registerd customers.");
		lblUsedToProcess.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsedToProcess.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblUsedToProcess.setBounds(200, 334, 332, 26);
		adminInformation.add(lblUsedToProcess);
		
		JLabel lblNormalPayment = new JLabel("Normal Payment:");
		lblNormalPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNormalPayment.setFont(new Font("Calibri", Font.BOLD, 17));
		lblNormalPayment.setBounds(21, 360, 163, 26);
		adminInformation.add(lblNormalPayment);
		
		JLabel lblProcessPaymentFor = new JLabel("Process payment for unregisterd customers.");
		lblProcessPaymentFor.setHorizontalAlignment(SwingConstants.LEFT);
		lblProcessPaymentFor.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblProcessPaymentFor.setBounds(200, 360, 332, 26);
		adminInformation.add(lblProcessPaymentFor);
		
		JLabel lblCheckLoyaltypoint = new JLabel("Check Loyalty Points:");
		lblCheckLoyaltypoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCheckLoyaltypoint.setFont(new Font("Calibri", Font.BOLD, 17));
		lblCheckLoyaltypoint.setBounds(21, 387, 163, 26);
		adminInformation.add(lblCheckLoyaltypoint);
		
		JLabel lblCheckPointsFor = new JLabel("Check points for all type of customers.");
		lblCheckPointsFor.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckPointsFor.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblCheckPointsFor.setBounds(200, 387, 332, 26);
		adminInformation.add(lblCheckPointsFor);
		
		JLabel lblHomepage = new JLabel("Homepage:");
		lblHomepage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomepage.setFont(new Font("Calibri", Font.BOLD, 17));
		lblHomepage.setBounds(41, 253, 142, 26);
		adminInformation.add(lblHomepage);
		
		JLabel lblSignOut = new JLabel("Sign out / Sign In for admin.");
		lblSignOut.setHorizontalAlignment(SwingConstants.LEFT);
		lblSignOut.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblSignOut.setBounds(200, 253, 332, 26);
		adminInformation.add(lblSignOut);
		
		JLabel lblChangeMemberDetails = new JLabel("Change Member Details:");
		lblChangeMemberDetails.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChangeMemberDetails.setFont(new Font("Calibri", Font.BOLD, 17));
		lblChangeMemberDetails.setBounds(0, 413, 184, 26);
		adminInformation.add(lblChangeMemberDetails);
		
		JLabel lblEditAndUpdate = new JLabel("Edit and update customer details.");
		lblEditAndUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditAndUpdate.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblEditAndUpdate.setBounds(200, 413, 332, 26);
		adminInformation.add(lblEditAndUpdate);
		Image img1 = new ImageIcon(this.getClass().getResource("/popcorn.jpg")).getImage();
		
		
		
		/*
		 * 
		 * Manage Members
		 * 
		 * 
		 */
		JPanel manageMembers = new JPanel();
		layeredPane.add(manageMembers, "name_110614429296657");
		manageMembers.setLayout(null);
		
		JPanel regularCustomerPanel = new JPanel();
		regularCustomerPanel.setBounds(0, 0, 286, 533);
		manageMembers.add(regularCustomerPanel);
		regularCustomerPanel.setLayout(null);
		
		JLabel lblRegularCusotmer = new JLabel("Regular Cusotmer");
		lblRegularCusotmer.setBounds(76, 13, 130, 42);
		lblRegularCusotmer.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegularCusotmer.setForeground(new Color(102, 102, 102));
		lblRegularCusotmer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		regularCustomerPanel.add(lblRegularCusotmer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 53, 198, 388);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		regularCustomerPanel.add(scrollPane);
		
		regularCustomerJList = new JList();
		regularCustomerJList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		regularCustomerJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(regularCustomerJList);
		
		btnNormalViewchangeDetails = new JButton("View Details");
		btnNormalViewchangeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNormalViewchangeDetails.setBounds(41, 457, 198, 25);
		btnNormalViewchangeDetails.setForeground(Color.WHITE);
		btnNormalViewchangeDetails.setBackground(new Color(51, 51, 51));
		regularCustomerPanel.add(btnNormalViewchangeDetails);
		
		btnRemoveRegular = new JButton("Remove");
		btnRemoveRegular.setBounds(41, 495, 198, 25);
		btnRemoveRegular.setForeground(Color.WHITE);
		btnRemoveRegular.setBackground(new Color(51, 51, 51));
		regularCustomerPanel.add(btnRemoveRegular);
		
		JPanel silverCustomerPanel = new JPanel();
		silverCustomerPanel.setBounds(286, 0, 286, 533);
		manageMembers.add(silverCustomerPanel);
		silverCustomerPanel.setLayout(null);
		
		JLabel lblSilverCustomer = new JLabel("Silver Customer");
		lblSilverCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		lblSilverCustomer.setForeground(new Color(102, 102, 102));
		lblSilverCustomer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSilverCustomer.setBounds(97, 13, 130, 42);
		silverCustomerPanel.add(lblSilverCustomer);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(48, 53, 198, 391);
		silverCustomerPanel.add(scrollPane_1);
		
		silverCustomerJList = new JList();
		silverCustomerJList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		silverCustomerJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(silverCustomerJList);
		
		btnSilverViewchangeDetails = new JButton("View Details");
		btnSilverViewchangeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSilverViewchangeDetails.setForeground(Color.WHITE);
		btnSilverViewchangeDetails.setBackground(new Color(51, 51, 51));
		btnSilverViewchangeDetails.setBounds(48, 457, 198, 25);
		silverCustomerPanel.add(btnSilverViewchangeDetails);
		
		btnRemoveSilver = new JButton("Remove");
		btnRemoveSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemoveSilver.setForeground(Color.WHITE);
		btnRemoveSilver.setBackground(new Color(51, 51, 51));
		btnRemoveSilver.setBounds(48, 495, 198, 25);
		silverCustomerPanel.add(btnRemoveSilver);
		
		JPanel goldCustomerPanel = new JPanel();
		goldCustomerPanel.setBounds(572, 0, 272, 533);
		manageMembers.add(goldCustomerPanel);
		goldCustomerPanel.setLayout(null);
		
		JLabel lblGoldCustomer = new JLabel("Gold Customer");
		lblGoldCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		lblGoldCustomer.setForeground(new Color(102, 102, 102));
		lblGoldCustomer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGoldCustomer.setBounds(87, 13, 130, 42);
		goldCustomerPanel.add(lblGoldCustomer);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(41, 52, 198, 392);
		goldCustomerPanel.add(scrollPane_2);
		
		goldCustomerJList = new JList();
		goldCustomerJList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		goldCustomerJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(goldCustomerJList);
		
		btnGoldViewchangeDetails = new JButton("View Details");
		btnGoldViewchangeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGoldViewchangeDetails.setForeground(Color.WHITE);
		btnGoldViewchangeDetails.setBackground(new Color(51, 51, 51));
		btnGoldViewchangeDetails.setBounds(41, 457, 198, 25);
		goldCustomerPanel.add(btnGoldViewchangeDetails);
		
		btnRemoveGold = new JButton("Remove");
		btnRemoveGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveGold.setForeground(Color.WHITE);
		btnRemoveGold.setBackground(new Color(51, 51, 51));
		btnRemoveGold.setBounds(41, 495, 198, 25);
		goldCustomerPanel.add(btnRemoveGold);
		
		
		
		
		
		/*
		 * 
		 * Register a Member
		 * 
		 * 
		 */
		JPanel registerAMember = new JPanel();
		layeredPane.add(registerAMember, "name_110587064434630");
		registerAMember.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(53, 115, 747, 269);
		registerAMember.add(panel);
		panel.setLayout(null);
		
		comboBoxMembership = new JComboBox();
		comboBoxMembership.setBackground(new Color(255, 255, 255));
		comboBoxMembership.setModel(new DefaultComboBoxModel(new String[] {"Regular", "Silver", "Gold"}));
		comboBoxMembership.setSelectedItem(null);
		comboBoxMembership.setBounds(188, 37, 154, 30);
		panel.add(comboBoxMembership);
		
		JLabel lblMembershipClass = new JLabel("Membership Class:");
		lblMembershipClass.setHorizontalAlignment(SwingConstants.LEFT);
		lblMembershipClass.setForeground(new Color(102, 102, 102));
		lblMembershipClass.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMembershipClass.setBounds(29, 31, 130, 42);
		panel.add(lblMembershipClass);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setForeground(new Color(102, 102, 102));
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFirstName.setBounds(29, 86, 130, 42);
		panel.add(lblFirstName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setForeground(new Color(102, 102, 102));
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAge.setBounds(29, 170, 130, 42);
		panel.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setForeground(new Color(102, 102, 102));
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGender.setBounds(349, 86, 130, 42);
		panel.add(lblGender);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setForeground(new Color(102, 102, 102));
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhoneNumber.setBounds(349, 127, 130, 42);
		panel.add(lblPhoneNumber);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAddress.setForeground(new Color(102, 102, 102));
		lblEmailAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmailAddress.setBounds(349, 170, 130, 42);
		panel.add(lblEmailAddress);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setForeground(new Color(102, 102, 102));
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLastName.setBounds(29, 127, 130, 42);
		panel.add(lblLastName);
		
		registerTxtFieldFirstName = new JTextField();
		registerTxtFieldFirstName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		registerTxtFieldFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		registerTxtFieldFirstName.setBounds(188, 96, 146, 22);
		panel.add(registerTxtFieldFirstName);
		registerTxtFieldFirstName.setColumns(10);
		
		registerTextFieldLastName = new JTextField();
		registerTextFieldLastName.setHorizontalAlignment(SwingConstants.CENTER);
		registerTextFieldLastName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		registerTextFieldLastName.setColumns(10);
		registerTextFieldLastName.setBounds(188, 137, 146, 22);
		panel.add(registerTextFieldLastName);
		
		registerTextFieldPhoneNumber = new JTextField();
		registerTextFieldPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		registerTextFieldPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		registerTextFieldPhoneNumber.setColumns(10);
		registerTextFieldPhoneNumber.setBounds(511, 137, 154, 22);
		panel.add(registerTextFieldPhoneNumber);
		
		registerTextFieldEmailAddress = new JTextField();
		registerTextFieldEmailAddress.setHorizontalAlignment(SwingConstants.CENTER);
		registerTextFieldEmailAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		registerTextFieldEmailAddress.setColumns(10);
		registerTextFieldEmailAddress.setBounds(511, 180, 154, 22);
		panel.add(registerTextFieldEmailAddress);
		
		comboBoxGender = new JComboBox();
		comboBoxGender.setBackground(new Color(255, 255, 255));
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBoxGender.setSelectedItem(null);
		comboBoxGender.setBounds(511, 92, 154, 30);
		panel.add(comboBoxGender);
		
		registerTextFieldAge = new JTextField();
		registerTextFieldAge.setHorizontalAlignment(SwingConstants.CENTER);
		registerTextFieldAge.setFont(new Font("Times New Roman", Font.BOLD, 15));
		registerTextFieldAge.setColumns(10);
		registerTextFieldAge.setBounds(188, 180, 146, 22);
		panel.add(registerTextFieldAge);
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBackground(new Color(51, 51, 51));
		btnRegister.setBounds(353, 397, 123, 25);
		registerAMember.add(btnRegister);
		
		JLabel lblRegisterInstruction = new JLabel("Please fill in the following information:");
		lblRegisterInstruction.setBounds(53, 78, 258, 42);
		registerAMember.add(lblRegisterInstruction);
		lblRegisterInstruction.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegisterInstruction.setForeground(new Color(102, 102, 102));
		lblRegisterInstruction.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
	
		
		/*
		 * 
		 * Process Payment
		 * 
		 * 
		 */
		
		JPanel processPayment = new JPanel();
		layeredPane.add(processPayment, "name_110642222470725");
		processPayment.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(211, 211, 211)));
		panel_7.setBounds(0, 0, 844, 155);
		processPayment.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblCheckMembershipType = new JLabel("Check Membership Type:");
		lblCheckMembershipType.setBounds(123, 5, 173, 18);
		lblCheckMembershipType.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckMembershipType.setForeground(new Color(102, 102, 102));
		lblCheckMembershipType.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_7.add(lblCheckMembershipType);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setForeground(new Color(102, 102, 102));
		lblName_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName_1.setBounds(0, 36, 127, 18);
		panel_7.add(lblName_1);
		
		JLabel lblPhoneNumber_2 = new JLabel("Phone number:");
		lblPhoneNumber_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber_2.setForeground(new Color(102, 102, 102));
		lblPhoneNumber_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhoneNumber_2.setBounds(0, 67, 127, 18);
		panel_7.add(lblPhoneNumber_2);
		
		txtCheckMemberhsipName = new JTextField();
		txtCheckMemberhsipName.setToolTipText("First Name + Last Name");
		txtCheckMemberhsipName.setBounds(154, 34, 178, 22);
		panel_7.add(txtCheckMemberhsipName);
		txtCheckMemberhsipName.setColumns(10);
		
		txtMembershipPhoneNumber = new JTextField();
		txtMembershipPhoneNumber.setColumns(10);
		txtMembershipPhoneNumber.setBounds(154, 65, 178, 22);
		panel_7.add(txtMembershipPhoneNumber);
		
		btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProceed.setForeground(Color.WHITE);
		btnProceed.setBackground(new Color(51, 51, 51));
		btnProceed.setBounds(196, 100, 100, 25);
		panel_7.add(btnProceed);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(372, 0, 472, 155);
		panel_7.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRegularMember = new JLabel("Regular Member:");
		lblRegularMember.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegularMember.setForeground(new Color(102, 102, 102));
		lblRegularMember.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRegularMember.setBounds(12, 31, 124, 18);
		panel_1.add(lblRegularMember);
		
		JLabel lblDiscountWil = new JLabel("10% Discount wil be applied to the total price.");
		lblDiscountWil.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiscountWil.setForeground(new Color(102, 102, 102));
		lblDiscountWil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiscountWil.setBounds(142, 62, 310, 18);
		panel_1.add(lblDiscountWil);
		
		JLabel lblSilverMember = new JLabel("Silver Member:");
		lblSilverMember.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSilverMember.setForeground(new Color(102, 102, 102));
		lblSilverMember.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSilverMember.setBounds(22, 62, 112, 18);
		panel_1.add(lblSilverMember);
		
		JLabel lblDiscountWil_1 = new JLabel("15% Discount wil be applied to the total price.");
		lblDiscountWil_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiscountWil_1.setForeground(new Color(102, 102, 102));
		lblDiscountWil_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiscountWil_1.setBounds(142, 93, 310, 18);
		panel_1.add(lblDiscountWil_1);
		
		JLabel lblGoldMember = new JLabel("Gold Member:");
		lblGoldMember.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGoldMember.setForeground(new Color(102, 102, 102));
		lblGoldMember.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGoldMember.setBounds(24, 93, 112, 18);
		panel_1.add(lblGoldMember);
		
		JLabel lblNormalPriceWill = new JLabel("Normal price will be applied.");
		lblNormalPriceWill.setHorizontalAlignment(SwingConstants.LEFT);
		lblNormalPriceWill.setForeground(new Color(102, 102, 102));
		lblNormalPriceWill.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNormalPriceWill.setBounds(142, 32, 298, 18);
		panel_1.add(lblNormalPriceWill);
		
		JLabel lblPriceInfo = new JLabel("Price Information");
		lblPriceInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriceInfo.setForeground(new Color(102, 102, 102));
		lblPriceInfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPriceInfo.setBounds(163, 1, 136, 18);
		panel_1.add(lblPriceInfo);
		
		JLabel lblNote = new JLabel("Note:");
		lblNote.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNote.setForeground(new Color(255, 0, 0));
		lblNote.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNote.setBounds(12, 124, 45, 18);
		panel_1.add(lblNote);
		
		JLabel lblUnregisteredCustomerIs = new JLabel("Unregistered Customer is required to complete the form.");
		lblUnregisteredCustomerIs.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnregisteredCustomerIs.setForeground(new Color(102, 102, 102));
		lblUnregisteredCustomerIs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUnregisteredCustomerIs.setBounds(67, 124, 405, 18);
		panel_1.add(lblUnregisteredCustomerIs);
		
		JLabel lblRequiredField1 = new JLabel("*");
		lblRequiredField1.setToolTipText("Required Field");
		lblRequiredField1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRequiredField1.setForeground(new Color(255, 0, 0));
		lblRequiredField1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRequiredField1.setBounds(344, 37, 36, 18);
		panel_7.add(lblRequiredField1);
		
		JLabel label_4 = new JLabel("*");
		label_4.setToolTipText("Required Field");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(new Color(255, 0, 0));
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_4.setBounds(344, 68, 36, 18);
		panel_7.add(label_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBounds(32, 168, 783, 352);
		processPayment.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblChooseTheType = new JLabel("Choose the type of DVD:");
		lblChooseTheType.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseTheType.setForeground(new Color(102, 102, 102));
		lblChooseTheType.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblChooseTheType.setBounds(12, 13, 173, 18);
		panel_8.add(lblChooseTheType);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(54, 42, 678, 45);
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblBlueray = new JLabel("Blue-Ray");
		lblBlueray.setHorizontalAlignment(SwingConstants.LEFT);
		lblBlueray.setForeground(new Color(102, 102, 102));
		lblBlueray.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBlueray.setBounds(12, 13, 88, 18);
		panel_9.add(lblBlueray);
		
		JLabel label_1 = new JLabel("$8.00");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(102, 102, 102));
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_1.setBounds(442, 13, 60, 18);
		panel_9.add(label_1);
		
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(211, 211, 211));
		panel_10.setBounds(54, 87, 678, 45);
		panel_8.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblDvd = new JLabel("DVD");
		lblDvd.setHorizontalAlignment(SwingConstants.LEFT);
		lblDvd.setForeground(new Color(102, 102, 102));
		lblDvd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDvd.setBounds(12, 13, 87, 18);
		panel_10.add(lblDvd);
		
		JLabel label_2 = new JLabel("$5.00");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(102, 102, 102));
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_2.setBounds(441, 13, 56, 18);
		panel_10.add(label_2);
		
		
		
		JLabel lblPaymentSummary = new JLabel("Payment Summary:");
		lblPaymentSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentSummary.setForeground(new Color(102, 102, 102));
		lblPaymentSummary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPaymentSummary.setBounds(304, 175, 173, 18);
		panel_8.add(lblPaymentSummary);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(54, 172, 678, 142);
		panel_8.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblBluray = new JLabel("Blue-Ray");
		lblBluray.setHorizontalAlignment(SwingConstants.CENTER);
		lblBluray.setForeground(new Color(102, 102, 102));
		lblBluray.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBluray.setBounds(42, 61, 87, 18);
		panel_11.add(lblBluray);
		
		JLabel lblDvd_1 = new JLabel("DVD");
		lblDvd_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDvd_1.setForeground(new Color(102, 102, 102));
		lblDvd_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDvd_1.setBounds(42, 92, 87, 18);
		panel_11.add(lblDvd_1);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(new Color(102, 102, 102));
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBounds(384, 27, 87, 18);
		panel_11.add(lblQuantity);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setForeground(new Color(102, 102, 102));
		lblTotalPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalPrice.setBounds(520, 27, 87, 18);
		panel_11.add(lblTotalPrice);
		
		lblBlueRayQuantity = new JLabel("0");
		lblBlueRayQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlueRayQuantity.setForeground(new Color(102, 102, 102));
		lblBlueRayQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBlueRayQuantity.setBounds(384, 62, 87, 18);
		panel_11.add(lblBlueRayQuantity);
		
		lblDvdQuantity = new JLabel("0");
		lblDvdQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblDvdQuantity.setForeground(new Color(102, 102, 102));
		lblDvdQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDvdQuantity.setBounds(384, 92, 87, 18);
		panel_11.add(lblDvdQuantity);
		
		lblBlueRayTotalPrice = new JLabel("$0.00");
		lblBlueRayTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlueRayTotalPrice.setForeground(new Color(102, 102, 102));
		lblBlueRayTotalPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBlueRayTotalPrice.setBounds(520, 62, 87, 18);
		panel_11.add(lblBlueRayTotalPrice);
		
		lblDvdTotalPrice = new JLabel("$0.00");
		lblDvdTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblDvdTotalPrice.setForeground(new Color(102, 102, 102));
		lblDvdTotalPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDvdTotalPrice.setBounds(520, 93, 87, 18);
		panel_11.add(lblDvdTotalPrice);
		
		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnitPrice.setForeground(new Color(102, 102, 102));
		lblUnitPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUnitPrice.setBounds(249, 27, 87, 18);
		panel_11.add(lblUnitPrice);
		
		JLabel label_8 = new JLabel("$8.00");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(new Color(102, 102, 102));
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_8.setBounds(249, 62, 87, 18);
		panel_11.add(label_8);
		
		JLabel label_9 = new JLabel("$5.00");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(new Color(102, 102, 102));
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_9.setBounds(249, 93, 87, 18);
		panel_11.add(label_9);
		
		JLabel label_10 = new JLabel("----------");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(new Color(102, 102, 102));
		label_10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_10.setBounds(520, 109, 87, 18);
		panel_11.add(label_10);
		
		lblSumTotalPrice = new JLabel("$0.00");
		lblSumTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblSumTotalPrice.setForeground(new Color(102, 102, 102));
		lblSumTotalPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSumTotalPrice.setBounds(520, 124, 87, 18);
		panel_11.add(lblSumTotalPrice);
		
		
		
		
		
		
		
		blueRayJSpinner = new JSpinner();
		/*blueRayJSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				String blueRaySelectedQuantity = blueRayJSpinner.getValue().toString();
				lblBlueRayQuantity.setText(String.valueOf(blueRaySelectedQuantity));
				
				// Quantity + Price Variables
				Integer blueRaySelectedQuantityDouble = (Integer) blueRayJSpinner.getValue();
				//Calculate the price for normal customer
				
				double blueRayPrice = 8.00;
				
				normalBlueRayTotalPrice = blueRayPrice * blueRaySelectedQuantityDouble;
				lblBlueRayTotalPrice.setText(String.valueOf("$" + normalBlueRayTotalPrice + "0"));
				setNormalBlueRayTotalPrice(normalBlueRayTotalPrice);
				sumTotalPrice =  normalBlueRayTotalPrice + normalDvdTotalPrice;
				lblSumTotalPrice.setText(String.valueOf("$" + sumTotalPrice + "0"));
				setSumTotalPrice(sumTotalPrice);
				//System.out.println(getSumTotalPrice());
				///////////////////////////////////////////////
				String fullName = txtCheckMemberhsipName.getText();
				//System.out.println(fullName);
				String mobileNumber = txtMembershipPhoneNumber.getText();
				int mobileNumber1 = Integer.parseInt(mobileNumber);
				for (RegularCustomer membershipClass: customerDetails) {
					if (membershipClass.getMembershipClass().equalsIgnoreCase("Regular") && (fullName.equalsIgnoreCase(membershipClass.getFirstName()+" "+membershipClass.getlastName()) && mobileNumber1 == membershipClass.getPhoneNumber())) {
						System.out.println("Customer is Regular");
						double regularCustomerTotalPrice = sumTotalPrice;
						lblSumTotalPrice.setText("$"+regularCustomerTotalPrice+"0");
				
					}
				}
				for (RegularCustomer membershipClass: customerDetails) {
					if (membershipClass.getMembershipClass().equalsIgnoreCase("Silver") && (fullName.equalsIgnoreCase(membershipClass.getFirstName()+" "+membershipClass.getlastName()) && mobileNumber1 == membershipClass.getPhoneNumber())) {
						System.out.println("Customer is Silver");
						double silverDiscount = 10;
						double silverCustomerTotalPrice = (sumTotalPrice - (sumTotalPrice * (silverDiscount/100)));
						System.out.println(silverCustomerTotalPrice);
						lblSumTotalPrice.setText("$"+silverCustomerTotalPrice+"0");
					}
				}
				for (RegularCustomer membershipClass: customerDetails) {
					if (membershipClass.getMembershipClass().equalsIgnoreCase("Gold") && (fullName.equalsIgnoreCase(membershipClass.getFirstName()+" "+membershipClass.getlastName()) && mobileNumber1 == membershipClass.getPhoneNumber())) {
						System.out.println("Customer is Gold");
						double goldDiscount = 15;
						double goldCustomerTotalPrice = (sumTotalPrice - (sumTotalPrice * (goldDiscount/100)));
						System.out.println(goldCustomerTotalPrice);
						lblSumTotalPrice.setText("$"+goldCustomerTotalPrice+"0");
					}
				}
				/////////////////////////////////////
			}
		});*/
		blueRayJSpinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		blueRayJSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		blueRayJSpinner.setBounds(514, 11, 141, 21);
		panel_9.add(blueRayJSpinner);
		
		dvdJSpinner = new JSpinner();
		/*dvdJSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String dvdSelectedQuantity = dvdJSpinner.getValue().toString();
				lblDvdQuantity.setText(String.valueOf(dvdSelectedQuantity));
				
				// Quantity + Price Variables
				Integer dvdSelectedQuantityDouble = (Integer) dvdJSpinner.getValue();
				
				
				//Calculate the price for normal customer
				
				double dvdPrice = 5.00;
				
				normalDvdTotalPrice = dvdPrice * dvdSelectedQuantityDouble;
				lblDvdTotalPrice.setText(String.valueOf("$" + normalDvdTotalPrice + "0"));
				setNormalDvdTotalPrice(normalDvdTotalPrice);
				sumTotalPrice =  normalBlueRayTotalPrice + normalDvdTotalPrice;
				lblSumTotalPrice.setText(String.valueOf("$" + sumTotalPrice + "0"));
				setSumTotalPrice(sumTotalPrice);
				//System.out.println(getSumTotalPrice());
				
			}
		});*/
		dvdJSpinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		dvdJSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dvdJSpinner.setBounds(513, 11, 141, 21);
		panel_10.add(dvdJSpinner);
		
		JLabel lblPleaseFillIn = new JLabel("*Please fill in the information above to use the calculation function*");
		lblPleaseFillIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseFillIn.setForeground(new Color(255, 0, 0));
		lblPleaseFillIn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPleaseFillIn.setBounds(195, 13, 537, 18);
		panel_8.add(lblPleaseFillIn);
		
		btnConfirmPayment = new JButton("Check Out");
		btnConfirmPayment.setBounds(339, 314, 100, 25);
		panel_8.add(btnConfirmPayment);
		btnConfirmPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmPayment.setForeground(Color.WHITE);
		btnConfirmPayment.setBackground(new Color(51, 51, 51));
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(339, 137, 100, 25);
		panel_8.add(btnCalculate);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalculate.setForeground(Color.WHITE);
		btnCalculate.setBackground(new Color(51, 51, 51));
		
		/*
		 * 
		 * Check Loyalty Points
		 * 
		 * 
		 */
		
		JPanel checkLoyaltyPoints = new JPanel();
		layeredPane.add(checkLoyaltyPoints, "name_110783392997202");
		checkLoyaltyPoints.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_12.setBounds(41, 40, 470, 270);
		checkLoyaltyPoints.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblCheckLoyaltyPoints = new JLabel("Check Loyalty Points:");
		lblCheckLoyaltyPoints.setBounds(12, 13, 164, 18);
		lblCheckLoyaltyPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckLoyaltyPoints.setForeground(new Color(102, 102, 102));
		lblCheckLoyaltyPoints.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_12.add(lblCheckLoyaltyPoints);
		
		JLabel label_12 = new JLabel("Membership Class:");
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setForeground(new Color(102, 102, 102));
		label_12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_12.setBounds(44, 71, 130, 42);
		panel_12.add(label_12);
		
		comboBoxMembershipClass = new JComboBox();
		comboBoxMembershipClass.setBackground(new Color(255, 255, 255));
		comboBoxMembershipClass.setModel(new DefaultComboBoxModel(new String[] {"Silver", "Gold"}));
		comboBoxMembershipClass.setSelectedItem(null);
		comboBoxMembershipClass.setBounds(201, 77, 154, 30);
		panel_12.add(comboBoxMembershipClass);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullName.setForeground(new Color(102, 102, 102));
		lblFullName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFullName.setBounds(44, 126, 130, 42);
		panel_12.add(lblFullName);
		
		txtFieldFullName = new JTextField();
		txtFieldFullName.setToolTipText("FirstName + LastName");
		txtFieldFullName.setBounds(201, 136, 154, 22);
		panel_12.add(txtFieldFullName);
		txtFieldFullName.setColumns(10);
		
		JLabel lblPhoneNumberLoyaltyPoint = new JLabel("Phone number:");
		lblPhoneNumberLoyaltyPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumberLoyaltyPoint.setForeground(new Color(102, 102, 102));
		lblPhoneNumberLoyaltyPoint.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhoneNumberLoyaltyPoint.setBounds(46, 177, 130, 42);
		panel_12.add(lblPhoneNumberLoyaltyPoint);
		
		txtFieldPhoneNumber = new JTextField();
		txtFieldPhoneNumber.setColumns(10);
		txtFieldPhoneNumber.setBounds(201, 187, 154, 22);
		panel_12.add(txtFieldPhoneNumber);
		
		btnCheck = new JButton("Check");
		btnCheck.setForeground(Color.WHITE);
		btnCheck.setBackground(new Color(51, 51, 51));
		btnCheck.setBounds(234, 235, 81, 22);
		panel_12.add(btnCheck);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		panel_13.setBounds(41, 342, 470, 165);
		checkLoyaltyPoints.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblTermsConditions = new JLabel("Terms & Conditions:");
		lblTermsConditions.setHorizontalAlignment(SwingConstants.CENTER);
		lblTermsConditions.setForeground(new Color(102, 102, 102));
		lblTermsConditions.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTermsConditions.setBounds(26, 13, 164, 18);
		panel_13.add(lblTermsConditions);
		
		JLabel lblForSilverMembership = new JLabel("For Silver Membership:");
		lblForSilverMembership.setHorizontalAlignment(SwingConstants.LEFT);
		lblForSilverMembership.setForeground(new Color(102, 102, 102));
		lblForSilverMembership.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblForSilverMembership.setBounds(73, 37, 164, 18);
		panel_13.add(lblForSilverMembership);
		
		JLabel lblForGoldMembership = new JLabel("For Gold Membership:");
		lblForGoldMembership.setHorizontalAlignment(SwingConstants.LEFT);
		lblForGoldMembership.setForeground(new Color(102, 102, 102));
		lblForGoldMembership.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblForGoldMembership.setBounds(73, 95, 164, 18);
		panel_13.add(lblForGoldMembership);
		
		JLabel lblLoyaltyPoints = new JLabel("30 Loyalty Points = %5 Discount");
		lblLoyaltyPoints.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoyaltyPoints.setForeground(new Color(102, 102, 102));
		lblLoyaltyPoints.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLoyaltyPoints.setBounds(118, 68, 243, 18);
		panel_13.add(lblLoyaltyPoints);
		
		JLabel lblLoyaltyPoints_1 = new JLabel("30 Loyalty Points = %10 Discount");
		lblLoyaltyPoints_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoyaltyPoints_1.setForeground(new Color(102, 102, 102));
		lblLoyaltyPoints_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLoyaltyPoints_1.setBounds(118, 126, 243, 18);
		panel_13.add(lblLoyaltyPoints_1);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		panel_14.setBounds(558, 135, 249, 248);
		checkLoyaltyPoints.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblCustomerPoints = new JLabel("Customer Points:");
		lblCustomerPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerPoints.setForeground(new Color(102, 102, 102));
		lblCustomerPoints.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCustomerPoints.setBounds(39, 13, 164, 18);
		panel_14.add(lblCustomerPoints);
		
		JLabel lblCustomerHas = new JLabel("Customer has");
		lblCustomerHas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerHas.setForeground(new Color(102, 102, 102));
		lblCustomerHas.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCustomerHas.setBounds(39, 67, 164, 18);
		panel_14.add(lblCustomerHas);
		
		JLabel label_13 = new JLabel("0");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(new Color(102, 102, 102));
		label_13.setFont(new Font("Times New Roman", Font.BOLD, 87));
		label_13.setBounds(39, 83, 164, 122);
		panel_14.add(label_13);
		
		JLabel lblPoints = new JLabel("points!");
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(new Color(102, 102, 102));
		lblPoints.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPoints.setBounds(73, 198, 97, 18);
		panel_14.add(lblPoints);
		
		JLabel label_14 = new JLabel("-------------------------------------");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(new Color(102, 102, 102));
		label_14.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_14.setBounds(26, 36, 198, 18);
		panel_14.add(label_14);
		
		
		/*
		 * 
		 * Update Promotion
		 * 
		 * 
		 */
		JPanel normalPayment = new JPanel();
		layeredPane.add(normalPayment, "name_110805138519212");
		normalPayment.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(44, 38, 767, 458);
		normalPayment.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_5 = new JLabel("Choose the type of DVD:");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(102, 102, 102));
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_5.setBounds(296, 13, 173, 18);
		panel_5.add(label_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(52, 44, 678, 45);
		panel_5.add(panel_6);
		
		JLabel label_6 = new JLabel("Blue-Ray");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setForeground(new Color(102, 102, 102));
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_6.setBounds(12, 13, 88, 18);
		panel_6.add(label_6);
		
		JLabel label_7 = new JLabel("$8.00");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(new Color(102, 102, 102));
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_7.setBounds(442, 13, 60, 18);
		panel_6.add(label_7);
		
		blueRaySpinner = new JSpinner();
		blueRaySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		blueRaySpinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		blueRaySpinner.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		blueRaySpinner.setBounds(514, 11, 141, 21);
		panel_6.add(blueRaySpinner);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(new Color(211, 211, 211));
		panel_15.setBounds(52, 89, 678, 45);
		panel_5.add(panel_15);
		
		JLabel label_11 = new JLabel("DVD");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setForeground(new Color(102, 102, 102));
		label_11.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_11.setBounds(12, 13, 87, 18);
		panel_15.add(label_11);
		
		JLabel label_15 = new JLabel("$5.00");
		label_15.setHorizontalAlignment(SwingConstants.LEFT);
		label_15.setForeground(new Color(102, 102, 102));
		label_15.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_15.setBounds(441, 13, 56, 18);
		panel_15.add(label_15);
		
		dvdSpinner = new JSpinner();
		dvdSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		dvdSpinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		dvdSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dvdSpinner.setBounds(513, 11, 141, 21);
		panel_15.add(dvdSpinner);
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBounds(52, 180, 678, 142);
		panel_5.add(panel_16);
		
		JLabel label_16 = new JLabel("Blue-Ray");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(new Color(102, 102, 102));
		label_16.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_16.setBounds(42, 61, 87, 18);
		panel_16.add(label_16);
		
		JLabel label_17 = new JLabel("DVD");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(new Color(102, 102, 102));
		label_17.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_17.setBounds(42, 92, 87, 18);
		panel_16.add(label_17);
		
		JLabel label_18 = new JLabel("Quantity");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(new Color(102, 102, 102));
		label_18.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_18.setBounds(384, 27, 87, 18);
		panel_16.add(label_18);
		
		JLabel label_19 = new JLabel("Total Price");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(new Color(102, 102, 102));
		label_19.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_19.setBounds(520, 27, 87, 18);
		panel_16.add(label_19);
		
		blueRayQuan = new JLabel("0");
		blueRayQuan.setHorizontalAlignment(SwingConstants.CENTER);
		blueRayQuan.setForeground(new Color(102, 102, 102));
		blueRayQuan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		blueRayQuan.setBounds(384, 62, 87, 18);
		panel_16.add(blueRayQuan);
		
		dvdQuan = new JLabel("0");
		dvdQuan.setHorizontalAlignment(SwingConstants.CENTER);
		dvdQuan.setForeground(new Color(102, 102, 102));
		dvdQuan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		dvdQuan.setBounds(384, 92, 87, 18);
		panel_16.add(dvdQuan);
		
		blueRaySumPrice = new JLabel("$0.00");
		blueRaySumPrice.setHorizontalAlignment(SwingConstants.CENTER);
		blueRaySumPrice.setForeground(new Color(102, 102, 102));
		blueRaySumPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		blueRaySumPrice.setBounds(520, 62, 87, 18);
		panel_16.add(blueRaySumPrice);
		
		dvdSumPrice = new JLabel("$0.00");
		dvdSumPrice.setHorizontalAlignment(SwingConstants.CENTER);
		dvdSumPrice.setForeground(new Color(102, 102, 102));
		dvdSumPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		dvdSumPrice.setBounds(520, 93, 87, 18);
		panel_16.add(dvdSumPrice);
		
		JLabel label_24 = new JLabel("Unit Price");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setForeground(new Color(102, 102, 102));
		label_24.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_24.setBounds(249, 27, 87, 18);
		panel_16.add(label_24);
		
		JLabel label_25 = new JLabel("$8.00");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setForeground(new Color(102, 102, 102));
		label_25.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_25.setBounds(249, 62, 87, 18);
		panel_16.add(label_25);
		
		JLabel label_26 = new JLabel("$5.00");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setForeground(new Color(102, 102, 102));
		label_26.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_26.setBounds(249, 93, 87, 18);
		panel_16.add(label_26);
		
		JLabel label_27 = new JLabel("----------");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setForeground(new Color(102, 102, 102));
		label_27.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_27.setBounds(520, 109, 87, 18);
		panel_16.add(label_27);
		
		discSumPrice = new JLabel("$0.00");
		discSumPrice.setHorizontalAlignment(SwingConstants.CENTER);
		discSumPrice.setForeground(new Color(102, 102, 102));
		discSumPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		discSumPrice.setBounds(520, 124, 87, 18);
		panel_16.add(discSumPrice);
		
		JLabel label_29 = new JLabel("Payment Summary:");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setForeground(new Color(102, 102, 102));
		label_29.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_29.setBounds(296, 147, 173, 18);
		panel_5.add(label_29);
		
		btnNormalPaymentCheckOut = new JButton("Check Out");
		btnNormalPaymentCheckOut.setForeground(Color.WHITE);
		btnNormalPaymentCheckOut.setBackground(new Color(51, 51, 51));
		btnNormalPaymentCheckOut.setBounds(345, 335, 100, 25);
		panel_5.add(btnNormalPaymentCheckOut);
		
		JPanel modifyMember = new JPanel();
		layeredPane.add(modifyMember, "name_106511791654252");
		modifyMember.setLayout(null);
		
		comboBoxModifyMember = new JComboBox();
		comboBoxModifyMember.setBackground(new Color(255, 255, 255));
		comboBoxModifyMember.setForeground(new Color(0, 0, 0));
		comboBoxModifyMember.setModel(new DefaultComboBoxModel(new String[] {"Regular", "Silver", "Gold"}));
		comboBoxModifyMember.setBounds(44, 38, 322, 36);
		modifyMember.add(comboBoxModifyMember);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(44, 119, 322, 312);
		modifyMember.add(scrollPane_3);
		
		listModifyMember = new JList();
		scrollPane_3.setViewportView(listModifyMember);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(399, 13, 433, 490);
		modifyMember.add(panel_17);
		panel_17.setLayout(null);
		panel_17.setBackground(new Color(211, 211, 211));
		
		JLabel label = new JLabel("First Name:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(102, 102, 102));
		label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label.setBounds(25, 107, 130, 42);
		panel_17.add(label);
		
		JLabel label_3 = new JLabel("Membership Class:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(new Color(102, 102, 102));
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_3.setBounds(25, 64, 130, 42);
		panel_17.add(label_3);
		
		JLabel label_20 = new JLabel("Last Name:");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setForeground(new Color(102, 102, 102));
		label_20.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_20.setBounds(25, 150, 130, 42);
		panel_17.add(label_20);
		
		JLabel label_21 = new JLabel("Age:");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		label_21.setForeground(new Color(102, 102, 102));
		label_21.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_21.setBounds(25, 193, 130, 42);
		panel_17.add(label_21);
		
		JLabel label_22 = new JLabel("Gender:");
		label_22.setHorizontalAlignment(SwingConstants.RIGHT);
		label_22.setForeground(new Color(102, 102, 102));
		label_22.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_22.setBounds(25, 235, 130, 42);
		panel_17.add(label_22);
		
		JLabel label_23 = new JLabel("Phone number:");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setForeground(new Color(102, 102, 102));
		label_23.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_23.setBounds(25, 278, 130, 42);
		panel_17.add(label_23);
		
		JLabel label_28 = new JLabel("Email Address:");
		label_28.setHorizontalAlignment(SwingConstants.RIGHT);
		label_28.setForeground(new Color(102, 102, 102));
		label_28.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_28.setBounds(25, 321, 130, 42);
		panel_17.add(label_28);
		
		modifyMemberClassTxt = new JTextField();
		modifyMemberClassTxt.setHorizontalAlignment(SwingConstants.CENTER);
		modifyMemberClassTxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modifyMemberClassTxt.setEditable(false);
		modifyMemberClassTxt.setColumns(10);
		modifyMemberClassTxt.setBounds(231, 74, 146, 22);
		panel_17.add(modifyMemberClassTxt);
		
		modifyFirstNameTxt = new JTextField();
		modifyFirstNameTxt.setHorizontalAlignment(SwingConstants.CENTER);
		modifyFirstNameTxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modifyFirstNameTxt.setColumns(10);
		modifyFirstNameTxt.setBounds(231, 117, 146, 22);
		panel_17.add(modifyFirstNameTxt);
		
		modifyLastNameTxt = new JTextField();
		modifyLastNameTxt.setHorizontalAlignment(SwingConstants.CENTER);
		modifyLastNameTxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modifyLastNameTxt.setColumns(10);
		modifyLastNameTxt.setBounds(231, 160, 146, 22);
		panel_17.add(modifyLastNameTxt);
		
		modifyAgeTxt = new JTextField();
		modifyAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
		modifyAgeTxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modifyAgeTxt.setColumns(10);
		modifyAgeTxt.setBounds(231, 203, 146, 22);
		panel_17.add(modifyAgeTxt);
		
		modifyGenderTxt = new JTextField();
		modifyGenderTxt.setHorizontalAlignment(SwingConstants.CENTER);
		modifyGenderTxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modifyGenderTxt.setColumns(10);
		modifyGenderTxt.setBounds(231, 245, 146, 22);
		panel_17.add(modifyGenderTxt);
		
		modifyPhoneTxt = new JTextField();
		modifyPhoneTxt.setHorizontalAlignment(SwingConstants.CENTER);
		modifyPhoneTxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modifyPhoneTxt.setColumns(10);
		modifyPhoneTxt.setBounds(231, 288, 146, 22);
		panel_17.add(modifyPhoneTxt);
		
		modifyEmailTxt = new JTextField();
		modifyEmailTxt.setHorizontalAlignment(SwingConstants.CENTER);
		modifyEmailTxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modifyEmailTxt.setColumns(10);
		modifyEmailTxt.setBounds(231, 331, 146, 22);
		panel_17.add(modifyEmailTxt);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(51, 51, 51));
		btnUpdate.setBounds(184, 432, 97, 22);
		panel_17.add(btnUpdate);
		
		JLabel label_30 = new JLabel("Change Details");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setForeground(new Color(102, 102, 102));
		label_30.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_30.setBounds(0, 0, 433, 42);
		panel_17.add(label_30);
		
		btnUpdateSilver = new JButton("Update");
		btnUpdateSilver.setForeground(Color.WHITE);
		btnUpdateSilver.setBackground(new Color(51, 51, 51));
		btnUpdateSilver.setBounds(184, 432, 97, 22);
		panel_17.add(btnUpdateSilver);
		
		btnUpdateGold = new JButton("Update");
		btnUpdateGold.setForeground(Color.WHITE);
		btnUpdateGold.setBackground(new Color(51, 51, 51));
		btnUpdateGold.setBounds(184, 432, 97, 22);
		panel_17.add(btnUpdateGold);
		
		JLabel lblPleaseChooseThe = new JLabel("Please choose the membership type:");
		lblPleaseChooseThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseChooseThe.setForeground(new Color(102, 102, 102));
		lblPleaseChooseThe.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPleaseChooseThe.setBounds(44, 4, 271, 42);
		modifyMember.add(lblPleaseChooseThe);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(90, 453, 239, 27);
		modifyMember.add(btnEdit);
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEdit.setBackground(new Color(51, 51, 51));
		
		btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.setBackground(new Color(51, 51, 51));
		btnSearch.setBounds(149, 79, 92, 27);
		modifyMember.add(btnSearch);
		
		btnEditThisSilver = new JButton("Edit");
		btnEditThisSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditThisSilver.setForeground(Color.WHITE);
		btnEditThisSilver.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEditThisSilver.setBackground(new Color(51, 51, 51));
		btnEditThisSilver.setBounds(90, 453, 239, 27);
		modifyMember.add(btnEditThisSilver);
		
		btnEditThisGold = new JButton("Edit");
		btnEditThisGold.setForeground(Color.WHITE);
		btnEditThisGold.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEditThisGold.setBackground(new Color(51, 51, 51));
		btnEditThisGold.setBounds(90, 453, 239, 27);
		modifyMember.add(btnEditThisGold);
		
		JPanel FunctionsPanel = new JPanel();
		FunctionsPanel.setBackground(new Color(51, 51, 51));
		FunctionsPanel.setBounds(0, 0, 287, 533);
		contentPane.add(FunctionsPanel);
		FunctionsPanel.setLayout(null);
		
		
		
		/*
		 * 
		 * Interaction Buttons
		 * 
		 * 
		 */
		
		JLabel lblEntertainmentPlusMovie = new JLabel("Customer Membership System");
		lblEntertainmentPlusMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntertainmentPlusMovie.setForeground(new Color(255, 255, 255));
		lblEntertainmentPlusMovie.setBounds(12, 13, 264, 28);
		lblEntertainmentPlusMovie.setFont(new Font("Times New Roman", Font.BOLD, 18));
		FunctionsPanel.add(lblEntertainmentPlusMovie);
		/*
		 * 
		 * Admin Information Button
		 * 
		 * 
		 */
		JButton btnAdminInfo = new JButton("Home");
		btnAdminInfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdminInfo.setForeground(new Color(255, 255, 255));
		btnAdminInfo.setBackground(new Color(51, 51, 51));
		btnAdminInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(adminInformation);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				
			}
		});
		btnAdminInfo.setBounds(-1, 114, 288, 42);
		FunctionsPanel.add(btnAdminInfo);
		/*
		 * 
		 * Register a Member Button
		 * 
		 * 
		 */
		JButton btnRegisterMember = new JButton("Register a Member");
		btnRegisterMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(registerAMember);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnRegisterMember.setForeground(Color.WHITE);
		btnRegisterMember.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnRegisterMember.setBackground(new Color(51, 51, 51));
		btnRegisterMember.setBounds(-1, 155, 288, 42);
		FunctionsPanel.add(btnRegisterMember);
		/*
		 * 
		 * Manage members button
		 * 
		 * 
		 */
		btnManageMember = new JButton("Manage Members");
		btnManageMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(manageMembers);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnManageMember.setForeground(Color.WHITE);
		btnManageMember.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnManageMember.setBackground(new Color(51, 51, 51));
		btnManageMember.setBounds(-1, 196, 288, 42);
		FunctionsPanel.add(btnManageMember);
		/*
		 * 
		 * Process Payments Button
		 * 
		 * 
		 */
		btnProcessPayment = new JButton("Membership Payment");
		btnProcessPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(processPayment);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnProcessPayment.setForeground(Color.WHITE);
		btnProcessPayment.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnProcessPayment.setBackground(new Color(51, 51, 51));
		btnProcessPayment.setBounds(-1, 318, 288, 42);
		FunctionsPanel.add(btnProcessPayment);
		/*
		 * 
		 * Check Loyalty Points Button
		 * 
		 * 
		 */
		JButton btnCheckLoyaltyPoints = new JButton("Check Loyalty Points");
		btnCheckLoyaltyPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(checkLoyaltyPoints);
				layeredPane.repaint();
				layeredPane.revalidate();
				JOptionPane.showMessageDialog(null,"Sorry, this function is still under construction. \n", "Info Message", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnCheckLoyaltyPoints.setForeground(Color.WHITE);
		btnCheckLoyaltyPoints.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCheckLoyaltyPoints.setBackground(new Color(51, 51, 51));
		btnCheckLoyaltyPoints.setBounds(-1, 359, 288, 42);
		FunctionsPanel.add(btnCheckLoyaltyPoints);
		/*
		 * 
		 * Update Promotion Button
		 * 
		 * 
		 */
		btnUpdatePromotions = new JButton("Normal Payment");
		btnUpdatePromotions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(normalPayment);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnUpdatePromotions.setForeground(Color.WHITE);
		btnUpdatePromotions.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdatePromotions.setBackground(new Color(51, 51, 51));
		btnUpdatePromotions.setBounds(-1, 277, 288, 42);
		FunctionsPanel.add(btnUpdatePromotions);
		
		JLabel lblVersionByPonhvath = new JLabel("V.1 CSM");
		lblVersionByPonhvath.setHorizontalAlignment(SwingConstants.LEFT);
		lblVersionByPonhvath.setForeground(Color.WHITE);
		lblVersionByPonhvath.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblVersionByPonhvath.setBounds(12, 505, 104, 28);
		FunctionsPanel.add(lblVersionByPonhvath);
		
		btnModifyMemberDetail = new JButton("Change Member Details");
		btnModifyMemberDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(modifyMember);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnModifyMemberDetail.setForeground(Color.WHITE);
		btnModifyMemberDetail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnModifyMemberDetail.setBackground(new Color(51, 51, 51));
		btnModifyMemberDetail.setBounds(-1, 236, 288, 42);
		FunctionsPanel.add(btnModifyMemberDetail);
		
		clock();
		
	}
}
