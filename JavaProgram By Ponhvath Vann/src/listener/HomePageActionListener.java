package listener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import dataController.DataController;
import ui.LoginInterface;
import ui.RegisterMember;

public class HomePageActionListener implements ActionListener {
	
	private RegisterMember ui;
	private DataController dataHandler;

	public HomePageActionListener(RegisterMember ui, DataController dataHandler )
	{
		
		this.ui = ui;
		this.dataHandler = dataHandler;
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == ui.getBtnSignOut())
		{
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to sign out?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{	
			// If user click on sign out button, set the visibility of this interface to false
			this.ui.setVisible(false);
			// Make the Login Interface to display
			LoginInterface ui2 = new LoginInterface();
			ui2.setVisible(true);
			
			DataController dc = new DataController();
			
			//Listener for Sign In
			AdminSignInActionListener listenerForAdminSignIn = new AdminSignInActionListener(ui2,dc);
			JButton signInButton = ui2.getBtnLogin();
			signInButton.addActionListener(listenerForAdminSignIn);
			
			//Listener for software GUI
			RegisterMember ui1 = new RegisterMember();
			RegisterMemberActionListener listenerForRegisterMember = new RegisterMemberActionListener(ui1,dc); 
			
			//Listener for HomePage
			HomePageActionListener listenerForHomePage = new HomePageActionListener(ui1,dc);
			JButton signOutAdmin = ui1.getBtnSignOut();
			signOutAdmin.addActionListener(listenerForHomePage);
			
			JButton registerMember = ui1.getBtnRegister();
			registerMember.addActionListener(listenerForRegisterMember);
			
			//Listener for Manage Member
			ManageMemberActionListener listenerForManageMember = new ManageMemberActionListener(ui1,dc);
			JButton manageMember = ui1.getBtnManageMember();
			manageMember.addActionListener(listenerForManageMember);
			
			JButton viewAndChangeMember = ui1.getBtnNormalViewchangeDetails();
			viewAndChangeMember.addActionListener(listenerForManageMember);
			
			JButton viewAndChangeMemberSilver = ui1.getBtnSilverViewchangeDetails();
			viewAndChangeMemberSilver.addActionListener(listenerForManageMember);
			
			JButton viewAndChangeMemberGold = ui1.getBtnGoldViewchangeDetails();
			viewAndChangeMemberGold.addActionListener(listenerForManageMember);
			
			JButton removeRegularMember = ui1.getBtnRemoveRegular();
			removeRegularMember.addActionListener(listenerForManageMember);
			
			JButton removeSilverMember = ui1.getBtnRemoveSilver();
			removeSilverMember.addActionListener(listenerForManageMember);
			
			JButton removeGoldMember = ui1.getBtnRemoveGold();
			removeGoldMember.addActionListener(listenerForManageMember);
			
			// Listener for Membership Payment
			ProcessPaymentActionListener listenerForProcessPayment = new ProcessPaymentActionListener(ui1,dc);
			JButton proceedPayment = ui1.getBtnProceed();
			proceedPayment.addActionListener(listenerForProcessPayment);
			
			JButton membershipPayment = ui1.getBtnProcessPayment();
			membershipPayment.addActionListener(listenerForProcessPayment);
			
			JButton confirmPayment = ui1.getBtnConfirmPayment();
			confirmPayment.addActionListener(listenerForProcessPayment);
			
			JButton calculatePayment = ui1.getBtnCalculate();
			calculatePayment.addActionListener(listenerForProcessPayment);
			
			//Listener for Normal Payment
			NormalPaymentActionListener listenerForNormalPayment = new NormalPaymentActionListener(ui1,dc);
			JButton normalPayment = ui1.getBtnUpdatePromotions();
			normalPayment.addActionListener(listenerForNormalPayment);
			
			JButton checkoutPayment = ui1.getBtnNormalPaymentCheckOut();
			checkoutPayment.addActionListener(listenerForNormalPayment);
			
			//Listener for Changing Member Details
			ChangeMemberDetailsActionListener listenerForChangeMemberDetails= new ChangeMemberDetailsActionListener(ui,dc);
			JButton modifyMember = ui1.getBtnModifyMemberDetail();
			modifyMember.addActionListener(listenerForChangeMemberDetails);
			
			JButton editNormalMember = ui1.getBtnEdit();
			editNormalMember.addActionListener(listenerForChangeMemberDetails);
			
			JButton editSilverMember = ui1.getBtnEditThisSilver();
			editSilverMember.addActionListener(listenerForChangeMemberDetails);
			
			JButton editGoldMember = ui1.getBtnEditThisGold();
			editGoldMember.addActionListener(listenerForChangeMemberDetails);
			
			JButton updateNormalMember = ui1.getBtnUpdate();
			updateNormalMember.addActionListener(listenerForChangeMemberDetails);
			
			JButton updateSilverMember = ui1.getBtnUpdateSilver();
			updateSilverMember.addActionListener(listenerForChangeMemberDetails);
			
			JButton updateGoldMember = ui1.getBtnUpdateGold();
			updateGoldMember.addActionListener(listenerForChangeMemberDetails);
			
			JButton searchMember = ui1.getBtnSearch();
			searchMember.addActionListener(listenerForChangeMemberDetails);
			}
		}
	}
}
