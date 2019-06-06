package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Admin;
import dataController.DataController;
import listener.AdminSignInActionListener;
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
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


import javax.swing.JPasswordField;

public class RegisterAdminInterface extends JFrame {

	private JPanel contentPane;
	private JTextField registerUsernameTxtField;
	private JPasswordField registerPasswordField;
	
	
	////
	private JButton btnSignUp;
	private JButton btnSignIn;
	
	///
	
	public JTextField getRegisterUsernameTxtField() {
		return registerUsernameTxtField;
	}

	public void setRegisterUsernameTxtField(JTextField registerUsernameTxtField) {
		this.registerUsernameTxtField = registerUsernameTxtField;
	}


	public JPasswordField getRegisterPasswordField() {
		return registerPasswordField;
	}


	public void setRegisterPasswordField(JPasswordField registerPasswordField) {
		this.registerPasswordField = registerPasswordField;
	}


	


	
	///////
	public JButton getBtnSignUp() {
		return btnSignUp;
	}

	
	
	
	
	////
	
	public JButton getBtnSignIn() {
		return btnSignIn;
	}

	public void setBtnSignIn(JButton btnSignIn) {
		this.btnSignIn = btnSignIn;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterAdminInterface frame = new RegisterAdminInterface();
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
	public RegisterAdminInterface() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		registerUsernameTxtField = new JTextField();
		registerUsernameTxtField.setToolTipText("Username");
		registerUsernameTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		registerUsernameTxtField.setColumns(10);
		registerUsernameTxtField.setBounds(123, 135, 238, 41);
		panel_1.add(registerUsernameTxtField);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.setBackground(new Color(102, 102, 102));
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSignUp.setBounds(41, 275, 321, 49);
		panel_1.add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("Register ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(41, 60, 321, 49);
		panel_1.add(lblNewLabel);
		
		JLabel lblReadyToUse = new JLabel("Ready to use?");
		lblReadyToUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblReadyToUse.setForeground(new Color(0, 0, 0));
		lblReadyToUse.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblReadyToUse.setBackground(Color.WHITE);
		lblReadyToUse.setBounds(40, 335, 321, 49);
		panel_1.add(lblReadyToUse);
		
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginInterface ui = new LoginInterface();
				ui.setVisible(true);
				DataController dc = new DataController();
				AdminSignInActionListener listenerForAdminSignIn = new AdminSignInActionListener(ui,dc);
				JButton signInButton = ui.getBtnLogin();
				signInButton.addActionListener(listenerForAdminSignIn);
			}
		});
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSignIn.setBackground(new Color(102, 102, 102));
		btnSignIn.setBounds(123, 384, 239, 41);
		panel_1.add(btnSignIn);
		
		JLabel backPic = new JLabel("");
		backPic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				LoginInterface ui = new LoginInterface();
				ui.setVisible(true);
				DataController dc = new DataController();
				AdminSignInActionListener listenerForAdminSignIn = new AdminSignInActionListener(ui,dc);
				JButton signInButton = ui.getBtnLogin();
				signInButton.addActionListener(listenerForAdminSignIn);
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/6.png")).getImage();
		backPic.setIcon(new ImageIcon(img3));
		backPic.setHorizontalAlignment(SwingConstants.CENTER);
		backPic.setBounds(41, 376, 83, 61);
		panel_1.add(backPic);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		registerPasswordField.setBounds(123, 209, 238, 41);
		panel_1.add(registerPasswordField);
		backgroundPicture.setIcon(new ImageIcon(img));
		backgroundPicture.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundPicture.setBounds(0, 0, 1920, 1001);
		panel.add(backgroundPicture);
		
		
	}
}
