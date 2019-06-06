package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dataController.DataController;
import ui.RegisterMember;
import data.RegularCustomer;
import data.SilverCustomer;

public class CheckLoyaltyPointActionListener implements ActionListener {
	
	private RegisterMember ui;
	private DataController dataHandler;
	double normalBlueRayTotalPrice;
	double normalDvdTotalPrice;
	double sumTotalPrice;
	ArrayList<RegularCustomer> customerDetails = DataController.readFile("data/customerDetails.csv");
	
	
	
	
	public CheckLoyaltyPointActionListener(RegisterMember ui, DataController dataHandler )
	{
		
		this.ui = ui;
		this.dataHandler = dataHandler;
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ui.getBtnCheck()) {
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION ) {
				String comboBoxMembership = (String) ui.getComboBoxMembershipClass().getSelectedItem();
				String fullName = ui.getTxtFieldFullName().getText();
				String mobileNumber = ui.getTxtFieldPhoneNumber().getText();
				int mobileNumber1 = 0;
				Boolean all_data_valid = true;
				String Error_Message = "";
			
				//Data Validation
				if (comboBoxMembership==null) {
			    	Error_Message  += "+ Membership Class must be filled.\n";
			    	all_data_valid = false;
			    }
			    
				if (fullName.length() <= 0) {
					Error_Message  += "+ Full Name(First Name and Last Name) must be filled.\n";
			    	all_data_valid = false;
				}
				
				if(mobileNumber.length()>0) {
					try {
					  mobileNumber1 = Integer.parseInt(mobileNumber);
					}catch(NumberFormatException ex) {
						Error_Message += "+ Phone number must be numbers.\n";
						all_data_valid = false;
					}			
				}else if(mobileNumber == "" || mobileNumber.length() <= 0) {
					Error_Message += "+ Phone number must be filled.\n";
					all_data_valid = false;
				}else {
					Error_Message += "+ Phone number must be filled.\n";
					all_data_valid = false;
				}
				
				for(RegularCustomer membershipClass: customerDetails) {
					if (all_data_valid = true && membershipClass.getMembershipClass().equalsIgnoreCase("Silver") && (fullName.equalsIgnoreCase(membershipClass.getFirstName()+" "+membershipClass.getlastName()) && mobileNumber1 == membershipClass.getPhoneNumber())) {
						
					}
					else if (all_data_valid = true && membershipClass.getMembershipClass().equalsIgnoreCase("Gold") && (fullName.equalsIgnoreCase(membershipClass.getFirstName()+" "+membershipClass.getlastName()) && mobileNumber1 == membershipClass.getPhoneNumber())) {
						
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
}
