package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class ViewAndChangeSilverDetails extends JFrame {

	private JPanel contentPane;
	private JTextField memberTxtField;
	private JTextField firstNameTxtField;
	private JTextField lastNameTxtField;
	private JTextField ageTxtField;
	private JTextField genderTxtField;
	private JTextField phoneNumberTxtField;
	private JTextField emailTxtField;

	
	
	
	
	public JTextField getMemberTxtField() {
		return memberTxtField;
	}

	public void setMemberTxtField(JTextField memberTxtField) {
		this.memberTxtField = memberTxtField;
	}

	public JTextField getFirstNameTxtField() {
		return firstNameTxtField;
	}

	public void setFirstNameTxtField(JTextField firstNameTxtField) {
		this.firstNameTxtField = firstNameTxtField;
	}

	public JTextField getLastNameTxtField() {
		return lastNameTxtField;
	}

	public void setLastNameTxtField(JTextField lastNameTxtField) {
		this.lastNameTxtField = lastNameTxtField;
	}

	public JTextField getAgeTxtField() {
		return ageTxtField;
	}

	public void setAgeTxtField(JTextField ageTxtField) {
		this.ageTxtField = ageTxtField;
	}

	public JTextField getGenderTxtField() {
		return genderTxtField;
	}

	public void setGenderTxtField(JTextField genderTxtField) {
		this.genderTxtField = genderTxtField;
	}

	public JTextField getPhoneNumberTxtField() {
		return phoneNumberTxtField;
	}

	public void setPhoneNumberTxtField(JTextField phoneNumberTxtField) {
		this.phoneNumberTxtField = phoneNumberTxtField;
	}

	public JTextField getEmailTxtField() {
		return emailTxtField;
	}

	public void setEmailTxtField(JTextField emailTxtField) {
		this.emailTxtField = emailTxtField;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAndChangeSilverDetails frame = new ViewAndChangeSilverDetails();
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
	public ViewAndChangeSilverDetails() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 47, 500, 443);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel viewDetailsPanel = new JPanel();
		viewDetailsPanel.setBounds(0, 0, 500, 490);
		contentPane.add(viewDetailsPanel);
		viewDetailsPanel.setBackground(new Color(220, 220, 220));
		viewDetailsPanel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setForeground(new Color(102, 102, 102));
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFirstName.setBounds(25, 107, 130, 42);
		viewDetailsPanel.add(lblFirstName);
		
		JLabel lblMembershipClass = new JLabel("Membership Class:");
		lblMembershipClass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMembershipClass.setForeground(new Color(102, 102, 102));
		lblMembershipClass.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMembershipClass.setBounds(25, 64, 130, 42);
		viewDetailsPanel.add(lblMembershipClass);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setForeground(new Color(102, 102, 102));
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLastName.setBounds(25, 150, 130, 42);
		viewDetailsPanel.add(lblLastName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setForeground(new Color(102, 102, 102));
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAge.setBounds(25, 193, 130, 42);
		viewDetailsPanel.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setForeground(new Color(102, 102, 102));
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGender.setBounds(25, 235, 130, 42);
		viewDetailsPanel.add(lblGender);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setForeground(new Color(102, 102, 102));
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhoneNumber.setBounds(25, 278, 130, 42);
		viewDetailsPanel.add(lblPhoneNumber);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAddress.setForeground(new Color(102, 102, 102));
		lblEmailAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmailAddress.setBounds(25, 321, 130, 42);
		viewDetailsPanel.add(lblEmailAddress);
		
		memberTxtField = new JTextField();
		memberTxtField.setEditable(false);
		memberTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		memberTxtField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		memberTxtField.setColumns(10);
		memberTxtField.setBounds(231, 74, 146, 22);
		viewDetailsPanel.add(memberTxtField);
		
		firstNameTxtField = new JTextField();
		firstNameTxtField.setEditable(false);
		firstNameTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameTxtField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		firstNameTxtField.setColumns(10);
		firstNameTxtField.setBounds(231, 117, 146, 22);
		viewDetailsPanel.add(firstNameTxtField);
		
		lastNameTxtField = new JTextField();
		lastNameTxtField.setEditable(false);
		lastNameTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameTxtField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lastNameTxtField.setColumns(10);
		lastNameTxtField.setBounds(231, 160, 146, 22);
		viewDetailsPanel.add(lastNameTxtField);
		
		ageTxtField = new JTextField();
		ageTxtField.setEditable(false);
		ageTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		ageTxtField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ageTxtField.setColumns(10);
		ageTxtField.setBounds(231, 203, 146, 22);
		viewDetailsPanel.add(ageTxtField);
		
		genderTxtField = new JTextField();
		genderTxtField.setEditable(false);
		genderTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		genderTxtField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		genderTxtField.setColumns(10);
		genderTxtField.setBounds(231, 245, 146, 22);
		viewDetailsPanel.add(genderTxtField);
		
		phoneNumberTxtField = new JTextField();
		phoneNumberTxtField.setEditable(false);
		phoneNumberTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNumberTxtField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phoneNumberTxtField.setColumns(10);
		phoneNumberTxtField.setBounds(231, 288, 146, 22);
		viewDetailsPanel.add(phoneNumberTxtField);
		
		emailTxtField = new JTextField();
		emailTxtField.setEditable(false);
		emailTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		emailTxtField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		emailTxtField.setColumns(10);
		emailTxtField.setBounds(231, 331, 146, 22);
		viewDetailsPanel.add(emailTxtField);
		
		JLabel lblViewSilverDetails = new JLabel("View Details");
		lblViewSilverDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewSilverDetails.setForeground(new Color(102, 102, 102));
		lblViewSilverDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblViewSilverDetails.setBounds(0, 0, 500, 49);
		viewDetailsPanel.add(lblViewSilverDetails);
	}
}
