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
import data.GoldCustomer;
import data.RegularCustomer;
import data.SilverCustomer;

public class CheckLoyaltyPointActionListener implements ActionListener {
	
	private RegisterMember ui;
	private DataController dataHandler;
	double normalBlueRayTotalPrice;
	double normalDvdTotalPrice;
	double sumTotalPrice;
	
	public CheckLoyaltyPointActionListener(RegisterMember ui, DataController dataHandler )
	{
		
		this.ui = ui;
		this.dataHandler = dataHandler;
		
	}

	ArrayList<RegularCustomer> customerDetails = DataController.readFile("data/customerDetails.csv");
	ArrayList<SilverCustomer> silverCustomerDetails = DataController.readFile1("data/silverCustomerDetails.csv");
	ArrayList<GoldCustomer> goldCustomerDetails = DataController.readFile2("data/goldCustomerDetails.csv");
	SilverCustomer silverCst;
	GoldCustomer goldCst;
	RegularCustomer cst;
	
	void refreshDatat() {
		 customerDetails = DataController.readFile("data/customerDetails.csv");
		 silverCustomerDetails = DataController.readFile1("data/silverCustomerDetails.csv");
		 goldCustomerDetails = DataController.readFile2("data/goldCustomerDetails.csv");
	}
	
	RegularCustomer getCustomer(String name, int number ) {
		
		refreshDatat();
		RegularCustomer cst=null;
		System.out.println(name);
		for (RegularCustomer c: customerDetails) {
			if(c.getName().equalsIgnoreCase(name) && number == c.getPhoneNumber()) {
				cst=c;
				break;
			}
		}
		return cst;
	}
	
	SilverCustomer getSilverCustomer(String name, int number ) {
		
		refreshDatat();
		SilverCustomer silverCst=null;
		System.out.println(name);
		for (SilverCustomer silverC: silverCustomerDetails) {
			if(silverC.getName().equalsIgnoreCase(name) && number == silverC.getPhoneNumber()) {
				silverCst=silverC;
				break;
			}
		}
		return silverCst;
	}

	GoldCustomer getGoldCustomer(String name, int number ) {
		
		refreshDatat();
		GoldCustomer goldCst=null;
		System.out.println(name);
		for (GoldCustomer goldC: goldCustomerDetails) {
			if(goldC.getName().equalsIgnoreCase(name) && number == goldC.getPhoneNumber()) {
				goldCst=goldC;
				break;
			}
		}
		return goldCst;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ui.getBtnCheck()) {
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION ) {
				String fullName = ui.getTxtFieldFullName().getText();
				String mobileNumber = ui.getTxtFieldPhoneNumber().getText();
				int mobileNumber1 = 0;
				Boolean all_data_valid = true;
				String Error_Message = "";
			
				//Data Validation
				
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
				
				if (all_data_valid == true)	{
					cst = getCustomer(fullName, mobileNumber1);
					try {
						if(cst.getMembershipClass().equals("Silver")) {
							silverCst = getSilverCustomer(fullName, mobileNumber1);
							if(silverCst.getMembershipClass().equals("Silver")) {
								
								int c1 = silverCustomerDetails.indexOf(silverCst);
								int custPoint = silverCustomerDetails.get(c1).getSilverLoyaltyPoints();
								
								ui.getLoyaltyPoint().setText(custPoint+"");
								
							}
						}
						else if (cst.getMembershipClass().equals("Gold")) {
							goldCst = getGoldCustomer(fullName, mobileNumber1);
							
							if(goldCst.getMembershipClass().equals("Gold")) {
								
								int c1 = goldCustomerDetails.indexOf(goldCst);
								int custPoint = goldCustomerDetails.get(c1).getGoldLoyaltyPoints();
								ui.getLoyaltyPoint().setText(custPoint+"");
								
							}
						}
						else if(cst.getMembershipClass().equals("Regular")){
							JOptionPane.showMessageDialog(ui, "+ Customer is registered as Regular. \n+ There is no loyalty point available for Regular customer.", "Info Message", JOptionPane.INFORMATION_MESSAGE);
						}
					}catch(NullPointerException e1) {
						JOptionPane.showMessageDialog(ui, "+ Customer cannot be found.", "Info Message", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
//					JOptionPane.showMessageDialog(ui, "+ Payment has been completed.", "Info Message", JOptionPane.INFORMATION_MESSAGE);
//					//Reset the form
//					ui.getTxtCheckMemberhsipName().setText(null);
//					ui.getTxtMembershipPhoneNumber().setText(null);
//					ui.getBlueRayJSpinner().setValue(0);
//					ui.getDvdJSpinner().setValue(0);
//					ui.getLblBlueRayQuantity().setText("0");
//					ui.getLblDvdQuantity().setText("0");
//					ui.getLblBlueRayTotalPrice().setText("$0.00");
//					ui.getLblDvdTotalPrice().setText("$0.00");
//					ui.getLblSumTotalPrice().setText("$0.00");
				
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
