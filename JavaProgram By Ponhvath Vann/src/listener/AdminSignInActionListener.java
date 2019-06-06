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
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import data.Admin;
import dataController.DataController;
import ui.LoginInterface;
import ui.RegisterAdminInterface;
import ui.RegisterMember;
import ui.ViewAndChangeCustomerDetails;


public class AdminSignInActionListener implements ActionListener {
	
	private LoginInterface ui;
	private DataController dataHandler;

	ArrayList<Admin> adminDetails = DataController.readFileAdmin("data/usernamePassword.csv");
	
	
	public AdminSignInActionListener(LoginInterface ui, DataController dataHandler )
	{
		
		this.ui = ui;
		this.dataHandler = dataHandler;
		
	}
	

	// Use to close the login interface after successfully sign in
	public void close(){
			
		WindowEvent winClosingEvent = new WindowEvent(this.ui,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == ui.getBtnLogin())
		{	
			//confirm form submission
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{	
				
				//if yes, we get data from inputs and validate it
				
				String password = ui.getPasswordField().getText();
				String username = ui.getUsernameTxtField().getText();
			    Boolean all_data_valid = true;
			    String Error_Message = "";
				
				//Data validation
			    if (username==null || password==null) {
			    	Error_Message  += "+ Username and password must be filled.\n";
			    	all_data_valid = false;
			    }
			    
			    
				if(username.length() < 3)
				{
					Error_Message  += "+ Username must be at least 4 characters.\n";
					all_data_valid = false;
				}
			
				if (password.length() < 3) {
					Error_Message += "+ Password must be at least 4 characters.\n";
					all_data_valid = false;
				}
					
				//check whether there is any error or not	
				if(all_data_valid == true)	
				{	
					
					Boolean wrongDetails = true;
					for (Admin line: adminDetails) {
						if (username.equals(line.getUsername()) && password.equals(line.getPassword())) {
							JOptionPane.showMessageDialog(ui, "Login Successful!", "Info Message", JOptionPane.INFORMATION_MESSAGE);
							wrongDetails = false;
							close(); // Close this Login GUI
							DataController dc = new DataController();
							
							//Open the Software GUI
							RegisterMember ui = new RegisterMember();
							ui.setVisible(true);
							ui.getLblAdminUsername().setText(username);
							RegisterMemberActionListener listenerForRegisterMember = new RegisterMemberActionListener(ui,dc); 
							
							//Listener for HomePage
							HomePageActionListener listenerForHomePage = new HomePageActionListener(ui,dc);
							JButton signOutAdmin = ui.getBtnSignOut();
							signOutAdmin.addActionListener(listenerForHomePage);
							
							JButton registerMember = ui.getBtnRegister();
							registerMember.addActionListener(listenerForRegisterMember);
							
							//Listener for Manage Member
							ManageMemberActionListener listenerForManageMember = new ManageMemberActionListener(ui,dc);
							JButton manageMember = ui.getBtnManageMember();
							manageMember.addActionListener(listenerForManageMember);
							
							JButton viewAndChangeMember = ui.getBtnNormalViewchangeDetails();
							viewAndChangeMember.addActionListener(listenerForManageMember);
							
							JButton viewAndChangeMemberSilver = ui.getBtnSilverViewchangeDetails();
							viewAndChangeMemberSilver.addActionListener(listenerForManageMember);
							
							JButton viewAndChangeMemberGold = ui.getBtnGoldViewchangeDetails();
							viewAndChangeMemberGold.addActionListener(listenerForManageMember);
							
							JButton removeRegularMember = ui.getBtnRemoveRegular();
							removeRegularMember.addActionListener(listenerForManageMember);
							
							JButton removeSilverMember = ui.getBtnRemoveSilver();
							removeSilverMember.addActionListener(listenerForManageMember);
							
							JButton removeGoldMember = ui.getBtnRemoveGold();
							removeGoldMember.addActionListener(listenerForManageMember);
							
							//Listener for Membership Payment
							ProcessPaymentActionListener listenerForProcessPayment = new ProcessPaymentActionListener(ui,dc);
							JButton proceedPayment = ui.getBtnProceed();
							proceedPayment.addActionListener(listenerForProcessPayment);
							
							JButton membershipPayment = ui.getBtnProcessPayment();
							membershipPayment.addActionListener(listenerForProcessPayment);
							
							JButton confirmPayment = ui.getBtnConfirmPayment();
							confirmPayment.addActionListener(listenerForProcessPayment);
							
							JButton calculatePayment = ui.getBtnCalculate();
							calculatePayment.addActionListener(listenerForProcessPayment);
							
							//Listener for Normal Payment
							NormalPaymentActionListener listenerForNormalPayment = new NormalPaymentActionListener(ui,dc);
							JButton normalPayment = ui.getBtnUpdatePromotions();
							normalPayment.addActionListener(listenerForNormalPayment);
							
							JButton checkoutPayment = ui.getBtnNormalPaymentCheckOut();
							checkoutPayment.addActionListener(listenerForNormalPayment);
							
							//Listener for Changing Member Details
							ChangeMemberDetailsActionListener listenerForChangeMemberDetails= new ChangeMemberDetailsActionListener(ui,dc);
							JButton modifyMember = ui.getBtnModifyMemberDetail();
							modifyMember.addActionListener(listenerForChangeMemberDetails);
							
							JButton editNormalMember = ui.getBtnEdit();
							editNormalMember.addActionListener(listenerForChangeMemberDetails);
							
							JButton editSilverMember = ui.getBtnEditThisSilver();
							editSilverMember.addActionListener(listenerForChangeMemberDetails);
							
							JButton editGoldMember = ui.getBtnEditThisGold();
							editGoldMember.addActionListener(listenerForChangeMemberDetails);
							
							JButton updateNormalMember = ui.getBtnUpdate();
							updateNormalMember.addActionListener(listenerForChangeMemberDetails);
							
							JButton updateSilverMember = ui.getBtnUpdateSilver();
							updateSilverMember.addActionListener(listenerForChangeMemberDetails);
							
							JButton updateGoldMember = ui.getBtnUpdateGold();
							updateGoldMember.addActionListener(listenerForChangeMemberDetails);
							
							JButton searchMember = ui.getBtnSearch();
							searchMember.addActionListener(listenerForChangeMemberDetails);
											
						}
					}
					if(wrongDetails) {
						JOptionPane.showMessageDialog(ui, "Wrong username or password!", "Info Message", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					//if there are errors, show the message
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
	}
}

