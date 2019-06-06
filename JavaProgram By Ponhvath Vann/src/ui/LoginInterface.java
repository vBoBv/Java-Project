package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataController.DataController;
import listener.RegisterAdminActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Frame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginInterface extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxtField;
	private JPasswordField passwordField;
	///
	private JButton btnLogin;
	private JButton btnRegisterAsNew;
	
	/////
	public JTextField getUsernameTxtField() {
		return usernameTxtField;
	}
	
	public void setUsernameTxtField(JTextField usernameTxtField) {
		this.usernameTxtField = usernameTxtField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	/////
	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnRegisterAsNew() {
		return btnRegisterAsNew;
	}

	public void setBtnRegisterAsNew(JButton btnRegisterAsNew) {
		this.btnRegisterAsNew = btnRegisterAsNew;
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface frame = new LoginInterface();
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
	
	
	public LoginInterface() {
		setTitle("Customer Membership System By Ponhvath Vann");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1938, 1048);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 1001);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel backgroundPicture = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/hi.jpg")).getImage();
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(765, 258, 396, 505);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel loginPic = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/3.png")).getImage();
		loginPic.setIcon(new ImageIcon(img1));
		loginPic.setHorizontalAlignment(SwingConstants.CENTER);
		loginPic.setBounds(12, 89, 130, 127);
		panel_1.add(loginPic);
		
		JLabel pswdPic = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/5.png")).getImage();
		pswdPic.setIcon(new ImageIcon(img2));
		pswdPic.setHorizontalAlignment(SwingConstants.CENTER);
		pswdPic.setBounds(41, 201, 83, 61);
		panel_1.add(pswdPic);
		
		usernameTxtField = new JTextField();
		usernameTxtField.setToolTipText("Username");
		usernameTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameTxtField.setColumns(10);
		usernameTxtField.setBounds(123, 133, 238, 41);
		panel_1.add(usernameTxtField);
		
		btnLogin = new JButton("SIGN IN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setBackground(new Color(102, 102, 102));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogin.setBounds(41, 275, 321, 49);
		panel_1.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Member Login");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(41, 60, 321, 49);
		panel_1.add(lblNewLabel);
		
		JLabel lblNew = new JLabel("New Admin?");
		lblNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblNew.setForeground(new Color(0, 0, 0));
		lblNew.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNew.setBackground(Color.WHITE);
		lblNew.setBounds(40, 335, 321, 49);
		panel_1.add(lblNew);
		
		btnRegisterAsNew = new JButton("Register");
		btnRegisterAsNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterAdminInterface ui3 = new RegisterAdminInterface();
				ui3.setVisible(true);
				DataController dc = new DataController();
				RegisterAdminActionListener listenerForRegisterAdmin = new RegisterAdminActionListener(ui3, dc);
				JButton signUpButton = ui3.getBtnSignUp();
				signUpButton.addActionListener(listenerForRegisterAdmin);
				
			}
		});
		btnRegisterAsNew.setForeground(Color.WHITE);
		btnRegisterAsNew.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRegisterAsNew.setBackground(new Color(102, 102, 102));
		btnRegisterAsNew.setBounds(41, 376, 321, 49);
		panel_1.add(btnRegisterAsNew);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(123, 209, 238, 41);
		panel_1.add(passwordField);
		backgroundPicture.setIcon(new ImageIcon(img));
		backgroundPicture.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundPicture.setBounds(0, 0, 1920, 1001);
		panel.add(backgroundPicture);
		
	
	}
}
