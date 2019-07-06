
package listener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dataController.DataController;
import ui.RegisterMember;
import data.GoldCustomer;
import data.NormalCustomer;
import data.RegularCustomer;
import data.SilverCustomer;


public class ProcessPaymentActionListener implements ActionListener {
	
	private RegisterMember ui;
	private DataController dataHandler;
	

	double blueRayPrice = 8.00;
	double dvdPrice = 5.00;
	double silverDiscount = 10;
	double goldDiscount = 15;
	static double blueRayTotalPrice;
	double dvdTotalPrice;
	static double discTotalPrice;
	static double sumSilverPrice;
	static double sumGoldPrice;
	int totalSilverPoint;
	int totalGoldPoint;
	
	public static double calculateBlueRayTotalPrice(double blueRayPrice, double quantity) {
		blueRayTotalPrice = blueRayPrice * quantity;
		return blueRayTotalPrice;
	}
	
	public double calculateDvdTotalPrice(double dvdPrice, double quantity) {
		dvdTotalPrice = dvdPrice * quantity;
		return dvdTotalPrice;
	}
	
	public static double sumTotalPrice(double blueRayTotalPrice, double dvdTotalPrice) {
		discTotalPrice = blueRayTotalPrice + dvdTotalPrice;
		return discTotalPrice;
	}
	
	public static double sumSilverDiscountPrice(double silverDiscountPrice, double totalPrice) {
		sumSilverPrice = totalPrice - (totalPrice * (silverDiscountPrice/100));
		return sumSilverPrice;
	}
	
	public static double sumGoldDiscountPrice(double goldDiscountPrice, double totalPrice) {
		sumGoldPrice = totalPrice - (totalPrice * (goldDiscountPrice/100));
		return sumGoldPrice;
	}
	
	public int calculateSilverPoint(int silverLoyaltyPoint) {
		totalSilverPoint += silverLoyaltyPoint;
		return totalSilverPoint;
	}
	
	public int calculateGoldPoint(int goldLoyaltyPoint) {
		totalGoldPoint += goldLoyaltyPoint;
		return totalGoldPoint;
	}

	
	
	public ProcessPaymentActionListener(RegisterMember ui, DataController dataHandler )
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
		
		if(e.getSource() == ui.getBtnProcessPayment()) {
			ArrayList<RegularCustomer> customerDetails = DataController.readFile("data/customerDetails.csv");
			System.out.println(customerDetails);
			
		}
		
		if(e.getSource() == ui.getBtnProceed()) {
			ArrayList<RegularCustomer> customerDetails = DataController.readFile("data/customerDetails.csv");
			System.out.println(customerDetails);
//			ArrayList<NormalCustomer> normalCustomerDetails = DataController.readFile3("data/normalCustomerDetails.csv");
//			ArrayList<SilverCustomer> silverCustomerDetails = DataController.readFile1("data/silverCustomerDetails.csv");
//			ArrayList<GoldCustomer> goldCustomerDetails = DataController.readFile2("data/goldCustomerDetails.csv");
			
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			if(confirmation == JOptionPane.YES_OPTION ) {
				
				String fullName = ui.getTxtCheckMemberhsipName().getText();
				String mobileNumber = ui.getTxtMembershipPhoneNumber().getText();
				int mobileNumber1 = 0; //Initialize the mobileNumber variable to convert it into int
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
					
					ui.getBlueRayJSpinner().setValue(0);
					ui.getDvdJSpinner().setValue(0);
					ui.getLblBlueRayQuantity().setText("0");
					ui.getLblDvdQuantity().setText("0");
					ui.getLblBlueRayTotalPrice().setText("$0.00");
					ui.getLblDvdTotalPrice().setText("$0.00");
					ui.getLblSumTotalPrice().setText("$0.00");
					
					cst = getCustomer(fullName, mobileNumber1);
					

					
					try {
						
						if(cst.getMembershipClass().equals("Silver")) {
							
							JOptionPane.showMessageDialog(ui, "+ Customer is registered as Silver Member.\n + %10 Discount will be applied.", "Info Message", JOptionPane.INFORMATION_MESSAGE);
							ui.getBtnCalculate().setEnabled(true);
							ui.getBtnConfirmPayment().setEnabled(true);
						}
						else if (cst.getMembershipClass().equals("Gold")) {
							
							JOptionPane.showMessageDialog(ui, "+ Customer is registered as Gold Member.\n + %15 Discount will be applied.", "Info Message", JOptionPane.INFORMATION_MESSAGE);
							ui.getBtnCalculate().setEnabled(true);
							ui.getBtnConfirmPayment().setEnabled(true);
							
						}
						else if (cst.getMembershipClass().equals("Regular")) {
							JOptionPane.showMessageDialog(ui, "+ Customer is registered as Regular.\n + Normal price will be applied.", "Info Message", JOptionPane.INFORMATION_MESSAGE);
							ui.getBtnCalculate().setEnabled(true);
							ui.getBtnConfirmPayment().setEnabled(true);
						}
					}catch (NullPointerException event) {
						JOptionPane.showMessageDialog(ui, "+This function is for registerd members only. \n + Please go to Normal Payment for non-registered members." , "Info Message", JOptionPane.ERROR_MESSAGE);
						//event.printStackTrace();
						ui.getBtnCalculate().setEnabled(false);
						ui.getBtnConfirmPayment().setEnabled(false);
					}
				}	
				else
				{
					//If there are errors, show the message
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//Calculate the price
		else if (e.getSource() == ui.getBtnCalculate()) {
			
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			if(confirmation == JOptionPane.YES_OPTION ) {
				String fullName = ui.getTxtCheckMemberhsipName().getText();
				String mobileNumber = ui.getTxtMembershipPhoneNumber().getText();
				int mobileNumber1 = 0; //Initialize the mobileNumber variable to convert it into int
				String blueRaySelectedQuantity = ui.getBlueRayJSpinner().getValue().toString();
				String dvdSelectedQuantity = ui.getDvdJSpinner().getValue().toString();
				Integer blueRaySelectedQuantityDouble = (Integer) ui.getBlueRayJSpinner().getValue();
				Integer dvdSelectedQuantityDouble = (Integer) ui.getDvdJSpinner().getValue();
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
				
				if(blueRaySelectedQuantityDouble == 0 && dvdSelectedQuantityDouble == 0) {
					Error_Message  += "+ Both DVD types cannot be empty.\n";
			    	all_data_valid = false;
				}
					
				
				if (all_data_valid == true)	{
				
					//Setting the selected quantity to the label quantity
					ui.getLblBlueRayQuantity().setText(String.valueOf(blueRaySelectedQuantity));
					ui.getLblDvdQuantity().setText(String.valueOf(dvdSelectedQuantity));
				
					//Calculate BlueRay Total Price
					calculateBlueRayTotalPrice(blueRayPrice,blueRaySelectedQuantityDouble);
					ui.getLblBlueRayTotalPrice().setText(String.valueOf("$" + blueRayTotalPrice));
					
					//Calculate Dvd Total Price
					calculateDvdTotalPrice(dvdPrice,dvdSelectedQuantityDouble);
					ui.getLblDvdTotalPrice().setText(String.valueOf("$" + dvdTotalPrice));
					
					//Sum Total Price
					sumTotalPrice(blueRayTotalPrice,dvdTotalPrice);
					
					
					if(cst.getMembershipClass().equals("Silver")) {
						//Calculate discount Price
						sumSilverDiscountPrice(silverDiscount, discTotalPrice);
						//Setting the discountPrice to the total price label
						ui.getLblSumTotalPrice().setText(String.valueOf("$"+ sumSilverPrice));
					}
					
					else if(cst.getMembershipClass().equals("Gold")) {
						//Calculate discount Price
						sumGoldDiscountPrice(goldDiscount, discTotalPrice);
						//Setting the discountPrice to the total price label
						ui.getLblSumTotalPrice().setText(String.valueOf("$"+ sumGoldPrice));
					}
					else if (cst.getMembershipClass().equals("Regular")) {
						ui.getLblSumTotalPrice().setText(String.valueOf("$"+discTotalPrice));
					}
				}
				else
				{
					//if there are errors, show the message
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			
				
			}
		}
		
		//Confirm Payment and set loyalty points
		else if(e.getSource() == ui.getBtnConfirmPayment()) {
			
			//Reset Form
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
			if(confirmation == JOptionPane.YES_OPTION ) {
				
				String fullName = ui.getTxtCheckMemberhsipName().getText();
				String mobileNumber = ui.getTxtMembershipPhoneNumber().getText();
				int mobileNumber1 = 0;
				Boolean all_data_valid = true;
				String Error_Message = "";
				
				//Data Validation
				if (fullName.length() <= 0) {
					Error_Message  += "+ Full Name(First Name and Last Name) must be filled.\n";
			    	all_data_valid = false;
				}
				
				if (ui.getLblSumTotalPrice().getText().equals("$0.00")) {
					Error_Message  += "+ Total price cannot be $0.00.\n";
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
					
					
					if(cst.getMembershipClass().equals("Silver")) {
						silverCst = getSilverCustomer(fullName, mobileNumber1);
						if(silverCst.getMembershipClass().equals("Silver")) {
							
							int c1 = silverCustomerDetails.indexOf(silverCst);
							//System.out.println(c1);
							SilverCustomer cust = silverCustomerDetails.get(c1);
							int custPoint = silverCustomerDetails.get(c1).getSilverLoyaltyPoints();
							//System.out.println(custPoint);
							int setPoint = custPoint + 1;
							//System.out.println(setPoint);
							cust.setSilverLoyaltyPoints(setPoint);
							//System.out.println(cust.getSilverLoyaltyPoints());
	//						System.out.println(silverCustomerDetails.toString());
							
							
							String membershipClass = silverCustomerDetails.get(c1).getMembershipClass();
							String firstName = silverCustomerDetails.get(c1).getFirstName();
							String lastName = silverCustomerDetails.get(c1).getlastName();
							int age = silverCustomerDetails.get(c1).getAge();
							String gender = silverCustomerDetails.get(c1).getGender();
							int phoneNumber = silverCustomerDetails.get(c1).getPhoneNumber();
							String email = silverCustomerDetails.get(c1).getEmailAddress();
							int point = silverCustomerDetails.get(c1).getSilverLoyaltyPoints();
							
							ArrayList<String> newSilverCustomerDetails = new ArrayList<String>();
							String CSV_Silver_String = membershipClass +","+firstName+","+lastName+","+age+","+gender+","+phoneNumber+","+email+","+point;
							silverCustomerDetails.remove(c1); // Remove the customer records at the selected index from the array list
							newSilverCustomerDetails.add(CSV_Silver_String); // Add the modified customer into the new array list
							
			
							String CSV_newSilver_String;
							for(SilverCustomer customer: silverCustomerDetails) {				
								String newMembershipClass = customer.getMembershipClass();
								String newFirstName = customer.getFirstName();
								String newLastName = customer.getlastName();
								int newAge = customer.getAge();
								String newGender = customer.getGender();
								int newPhoneNumber = customer.getPhoneNumber();
								String newEmailAddress = customer.getEmailAddress();
								int newPoint = customer.getSilverLoyaltyPoints();
								
								CSV_newSilver_String = newMembershipClass +","+newFirstName+","+newLastName+","+newAge+","+newGender+","+newPhoneNumber+","+newEmailAddress+","+newPoint;;
								newSilverCustomerDetails.add(CSV_newSilver_String); // Add the updated array list into the new ArrayList
							}
							
					
							this.dataHandler.overwriteSilverData(); // Overwrite the data with blank
							for(String cst: newSilverCustomerDetails) { // Add the new array list to the silverCustomer Details file
								this.dataHandler.writeSilverData(cst);
							}
							//System.out.println(newSilverCustomerDetails.toString());
							
						}
					}
					else if (cst.getMembershipClass().equals("Gold")) {
						goldCst = getGoldCustomer(fullName, mobileNumber1);
						
						if(goldCst.getMembershipClass().equals("Gold")) {
							
							int c1 = goldCustomerDetails.indexOf(goldCst);
							GoldCustomer cust = goldCustomerDetails.get(c1);
							int custPoint = goldCustomerDetails.get(c1).getGoldLoyaltyPoints();
							int setPoint = custPoint + 2;
							cust.setGoldLoyaltyPoints(setPoint);
							
							
							String membershipClass = goldCustomerDetails.get(c1).getMembershipClass();
							String firstName = goldCustomerDetails.get(c1).getFirstName();
							String lastName = goldCustomerDetails.get(c1).getlastName();
							int age = goldCustomerDetails.get(c1).getAge();
							String gender = goldCustomerDetails.get(c1).getGender();
							int phoneNumber = goldCustomerDetails.get(c1).getPhoneNumber();
							String email = goldCustomerDetails.get(c1).getEmailAddress();
							int point = goldCustomerDetails.get(c1).getGoldLoyaltyPoints();
							
							ArrayList<String> newGoldCustomerDetails = new ArrayList<String>();
							String CSV_Gold_String = membershipClass +","+firstName+","+lastName+","+age+","+gender+","+phoneNumber+","+email+","+point;
							goldCustomerDetails.remove(c1); // Remove the customer records at the selected index from the array list
							newGoldCustomerDetails.add(CSV_Gold_String); // Add the modified customer into the new array list
							
			
							String CSV_newGold_String;
							for(GoldCustomer customer: goldCustomerDetails) {				
								String newMembershipClass = customer.getMembershipClass();
								String newFirstName = customer.getFirstName();
								String newLastName = customer.getlastName();
								int newAge = customer.getAge();
								String newGender = customer.getGender();
								int newPhoneNumber = customer.getPhoneNumber();
								String newEmailAddress = customer.getEmailAddress();
								int newPoint = customer.getGoldLoyaltyPoints();
								
								CSV_newGold_String = newMembershipClass +","+newFirstName+","+newLastName+","+newAge+","+newGender+","+newPhoneNumber+","+newEmailAddress+","+newPoint;
								newGoldCustomerDetails.add(CSV_newGold_String); // Add the updated array list into the new ArrayList
							}
							
							this.dataHandler.overwriteGoldData(); // Overwrite the data with blank
							for(String cst: newGoldCustomerDetails) { // Add the new array list to the goldCustomer Details file
								this.dataHandler.writeGoldData(cst);
							}
						}
					}
					
					JOptionPane.showMessageDialog(ui, "+ Payment has been completed.", "Info Message", JOptionPane.INFORMATION_MESSAGE);
					//Reset the form
					ui.getTxtCheckMemberhsipName().setText(null);
					ui.getTxtMembershipPhoneNumber().setText(null);
					ui.getBlueRayJSpinner().setValue(0);
					ui.getDvdJSpinner().setValue(0);
					ui.getLblBlueRayQuantity().setText("0");
					ui.getLblDvdQuantity().setText("0");
					ui.getLblBlueRayTotalPrice().setText("$0.00");
					ui.getLblDvdTotalPrice().setText("$0.00");
					ui.getLblSumTotalPrice().setText("$0.00");
				
				}
				else
				{
					//if there are errors, show the message
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		//Setting the changes to customDetails file by overwriting and appending the new array lists from Regular, Silver, Gold customers
		ArrayList<NormalCustomer> normalCustomerDetails1 = DataController.readFile3("data/normalCustomerDetails.csv");
		ArrayList<SilverCustomer> silverCustomerDetails1 = DataController.readFile1("data/silverCustomerDetails.csv");
		ArrayList<GoldCustomer> goldCustomerDetails1 = DataController.readFile2("data/goldCustomerDetails.csv");
		
		this.dataHandler.overwriteAllCustomerData();
		
		ArrayList<String> newNormalCustomerDetails = new ArrayList<String>(); 
		String CSV_Regular_String;
		for(NormalCustomer customer: normalCustomerDetails1) {				
			String membershipClass = customer.getMembershipClass();
			String firstName = customer.getFirstName();
			String lastName = customer.getlastName();
			int age = customer.getAge();
			String gender = customer.getGender();
			int phoneNumber = customer.getPhoneNumber();
			String emailAddress = customer.getEmailAddress();
			
			CSV_Regular_String = membershipClass +","+firstName+","+lastName+","+age+","+gender+","+phoneNumber+","+emailAddress;
			newNormalCustomerDetails.add(CSV_Regular_String); //Add the updated array list into the new array list
		}
		//System.out.println(newNormalCustomerDetails);
		for(String normalCst: newNormalCustomerDetails) {
			this.dataHandler.writeData(normalCst);
		}
		
		
		ArrayList<String> newSilverCustomerDetails = new ArrayList<String>();
		String CSV_Silver_String;
		for(SilverCustomer customer: silverCustomerDetails1) {				
			String membershipClass = customer.getMembershipClass();
			String firstName = customer.getFirstName();
			String lastName = customer.getlastName();
			int age = customer.getAge();
			String gender = customer.getGender();
			int phoneNumber = customer.getPhoneNumber();
			String emailAddress = customer.getEmailAddress();
			
			CSV_Silver_String = membershipClass +","+firstName+","+lastName+","+age+","+gender+","+phoneNumber+","+emailAddress;
			newSilverCustomerDetails.add(CSV_Silver_String);//Add the updated array list into the new array list
		}
		//System.out.println(newSilverCustomerDetails);
		for(String silverCst: newSilverCustomerDetails) {
			this.dataHandler.writeData(silverCst);
		}
		
		
		ArrayList<String> newGoldCustomerDetails = new ArrayList<String>();
		String CSV_Gold_String;
		for(GoldCustomer customer: goldCustomerDetails1) {				
			String membershipClass = customer.getMembershipClass();
			String firstName = customer.getFirstName();
			String lastName = customer.getlastName();
			int age = customer.getAge();
			String gender = customer.getGender();
			int phoneNumber = customer.getPhoneNumber();
			String emailAddress = customer.getEmailAddress();
			
			CSV_Gold_String = membershipClass +","+firstName+","+lastName+","+age+","+gender+","+phoneNumber+","+emailAddress;
			newGoldCustomerDetails.add(CSV_Gold_String);//Add the updated array list into the new array list
		}
		//System.out.println(newGoldCustomerDetails);
		for(String goldCst: newGoldCustomerDetails) {
			this.dataHandler.writeData(goldCst);
		}
		
		
	}
}




	





