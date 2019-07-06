package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import data.GoldCustomer;
import data.NormalCustomer;
import data.RegularCustomer;
import data.SilverCustomer;
import dataController.DataController;
import ui.RegisterMember;
import ui.ViewAndChangeCustomerDetails;
import ui.ViewAndChangeGoldDetails;
import ui.ViewAndChangeSilverDetails;

public class ChangeMemberDetailsActionListener implements ActionListener {
	
	private RegisterMember ui;
	private DataController dataHandler;
	
	//ArrayList<RegularCustomer> customerDetails = DataController.readFile("data/customerDetails.csv");
	ArrayList<NormalCustomer> normalCustomerDetails = DataController.readFile3("data/normalCustomerDetails.csv");
	ArrayList<SilverCustomer> silverCustomerDetails = DataController.readFile1("data/silverCustomerDetails.csv");
	ArrayList<GoldCustomer> goldCustomerDetails = DataController.readFile2("data/goldCustomerDetails.csv");
//	RegularCustomer cst;

	public ChangeMemberDetailsActionListener(RegisterMember ui, DataController dataHandler )
	{
	
		this.ui = ui;
		this.dataHandler = dataHandler;
		
	}

	DefaultListModel regularCustomerName = new DefaultListModel();
	DefaultListModel silverCustomerName = new DefaultListModel();
	DefaultListModel goldCustomerName = new DefaultListModel();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		
		//ArrayList<RegularCustomer> customerDetails = DataController.readFile("data/customerDetails.csv");
		ArrayList<NormalCustomer> normalCustomerDetails = DataController.readFile3("data/normalCustomerDetails.csv");
		ArrayList<SilverCustomer> silverCustomerDetails = DataController.readFile1("data/silverCustomerDetails.csv");
		ArrayList<GoldCustomer> goldCustomerDetails = DataController.readFile2("data/goldCustomerDetails.csv");
		String comboBoxMembership = (String) ui.getComboBoxModifyMember().getSelectedItem();
		
		if(event.getSource() == ui.getBtnSearch()) {
			//Use to reset the name in the list
			regularCustomerName.clear();
			silverCustomerName.clear();
			goldCustomerName.clear();
			
			if (comboBoxMembership.equals("Regular")) {
				//Enable and disable button after the Search button has been pressed
				ui.getBtnEdit().setVisible(true);
				ui.getBtnEditThisGold().setVisible(false);
				ui.getBtnEditThisSilver().setVisible(false);
				ui.getBtnUpdate().setVisible(true);
				ui.getBtnUpdateSilver().setVisible(false);
				ui.getBtnUpdateGold().setVisible(false);
				
				//Set the customer to the list
				try {
					for (NormalCustomer membershipClass: normalCustomerDetails) {
							String regularName = membershipClass.getFirstName() + " " + membershipClass.getlastName();
							regularCustomerName.addElement(regularName);
					}
					ui.getListModifyMember().setModel(regularCustomerName);
				}catch(NullPointerException e) {
					System.out.println("Error");
				}
				ui.getListModifyMember().setEnabled(true); //Enable the list to be clicked
			}
			else if (comboBoxMembership.equals("Silver")) {
				//Enable and disable button after the Search button has been pressed
				ui.getBtnEditThisSilver().setVisible(true);
				ui.getBtnEditThisGold().setVisible(false);
				ui.getBtnEdit().setVisible(false);
				ui.getBtnUpdate().setVisible(false);
				ui.getBtnUpdateSilver().setVisible(true);
				ui.getBtnUpdateGold().setVisible(false);
				
				//Set the customer to the list
				try {
					for (SilverCustomer membershipClass: silverCustomerDetails) {
							String silverName = membershipClass.getFirstName() + " " + membershipClass.getlastName();
							silverCustomerName.addElement(silverName);
					}
					ui.getListModifyMember().setModel(silverCustomerName);
				
				}catch(NullPointerException e) {
					e.printStackTrace();
					System.out.println("Error");
				}
				ui.getListModifyMember().setEnabled(true);
			}
			else if(comboBoxMembership.equals("Gold")) {
				//Enable and disable button after the Search button has been pressed
				ui.getBtnEditThisGold().setVisible(true);
				ui.getBtnEdit().setVisible(false);
				ui.getBtnEditThisSilver().setVisible(false);
				ui.getBtnUpdate().setVisible(false);
				ui.getBtnUpdateSilver().setVisible(false);
				ui.getBtnUpdateGold().setVisible(true);
				//Set the customer to the list
				try {

					for (GoldCustomer membershipClass: goldCustomerDetails) {
							String goldName = membershipClass.getFirstName() + " " + membershipClass.getlastName();
							goldCustomerName.addElement(goldName);
					}
					ui.getListModifyMember().setModel(goldCustomerName);
				}catch(NullPointerException e) {
					e.printStackTrace();
					System.out.println("Error");
				}
				ui.getListModifyMember().setEnabled(true); //Enable the list to be clicked
			}
		}

		//Disable the text fields after the user clicks on Change Member Details Button
		if (event.getSource() == ui.getBtnModifyMemberDetail()) {
			ui.getModifyMemberClassTxt().setEnabled(false);
			ui.getModifyFirstNameTxt().setEnabled(false);
			ui.getModifyLastNameTxt().setEnabled(false);
			ui.getModifyAgeTxt().setEnabled(false);
			ui.getModifyGenderTxt().setEnabled(false);
			ui.getModifyPhoneTxt().setEnabled(false);
			ui.getModifyEmailTxt().setEnabled(false);
		}
		//Enable the text fields after the user clicks on Edit Button
		else if (event.getSource() == ui.getBtnEditThisSilver()) {
			ui.getModifyMemberClassTxt().setEnabled(true);
			ui.getModifyFirstNameTxt().setEnabled(true);
			ui.getModifyLastNameTxt().setEnabled(true);
			ui.getModifyAgeTxt().setEnabled(true);
			ui.getModifyGenderTxt().setEnabled(true);
			ui.getModifyPhoneTxt().setEnabled(true);
			ui.getModifyEmailTxt().setEnabled(true);
			
			
			try {
				int index = ui.getListModifyMember().getSelectedIndex();
				//Get all of the customer details at the selected index
				String membershipClass = silverCustomerDetails.get(index).getMembershipClass();
				String firstName = silverCustomerDetails.get(index).getFirstName();
				String lastName = silverCustomerDetails.get(index).getlastName();
				int age = silverCustomerDetails.get(index).getAge();
				String gender = silverCustomerDetails.get(index).getGender();
				int phoneNumber = silverCustomerDetails.get(index).getPhoneNumber();
				String email = silverCustomerDetails.get(index).getEmailAddress();
				int point = silverCustomerDetails.get(index).getSilverLoyaltyPoints();
				
				//Set the selected customers to the text fields
				ui.getModifyMemberClassTxt().setText(membershipClass);
				ui.getModifyFirstNameTxt().setText(firstName);
				ui.getModifyLastNameTxt().setText(lastName);
				ui.getModifyAgeTxt().setText(age+"");
				ui.getModifyGenderTxt().setText(gender);
				ui.getModifyPhoneTxt().setText(phoneNumber+"");
				ui.getModifyEmailTxt().setText(email);
				ui.getModifyLoyaltyPoint().setText(point+"");
				
			}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		//Enable the text fields after the user clicks on Edit Button
		else if (event.getSource() == ui.getBtnEditThisGold()) {
			ui.getModifyMemberClassTxt().setEnabled(true);
			ui.getModifyFirstNameTxt().setEnabled(true);
			ui.getModifyLastNameTxt().setEnabled(true);
			ui.getModifyAgeTxt().setEnabled(true);
			ui.getModifyGenderTxt().setEnabled(true);
			ui.getModifyPhoneTxt().setEnabled(true);
			ui.getModifyEmailTxt().setEnabled(true);
			
			
			try {
				int index = ui.getListModifyMember().getSelectedIndex();
				//Get all of the customer details at the selected index
				String membershipClass = goldCustomerDetails.get(index).getMembershipClass();
				String firstName = goldCustomerDetails.get(index).getFirstName();
				String lastName = goldCustomerDetails.get(index).getlastName();
				int age = goldCustomerDetails.get(index).getAge();
				String gender = goldCustomerDetails.get(index).getGender();
				int phoneNumber = goldCustomerDetails.get(index).getPhoneNumber();
				String email = goldCustomerDetails.get(index).getEmailAddress();
				int point = goldCustomerDetails.get(index).getGoldLoyaltyPoints();
				
				//Set the selected customers to the text fields
				ui.getModifyMemberClassTxt().setText(membershipClass);
				ui.getModifyFirstNameTxt().setText(firstName);
				ui.getModifyLastNameTxt().setText(lastName);
				ui.getModifyAgeTxt().setText(age+"");
				ui.getModifyGenderTxt().setText(gender);
				ui.getModifyPhoneTxt().setText(phoneNumber+"");
				ui.getModifyEmailTxt().setText(email);
				ui.getModifyLoyaltyPoint().setText(point+"");
				
			}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		//Enable the text fields after the user clicks on Edit Button
		else if (event.getSource() == ui.getBtnEdit()) {
			ui.getModifyMemberClassTxt().setEnabled(true);
			ui.getModifyFirstNameTxt().setEnabled(true);
			ui.getModifyLastNameTxt().setEnabled(true);
			ui.getModifyAgeTxt().setEnabled(true);
			ui.getModifyGenderTxt().setEnabled(true);
			ui.getModifyPhoneTxt().setEnabled(true);
			ui.getModifyEmailTxt().setEnabled(true);
			
			try {
				int index = ui.getListModifyMember().getSelectedIndex();
				//Get all of the customer details at the selected index
				String membershipClass = normalCustomerDetails.get(index).getMembershipClass();
				String firstName = normalCustomerDetails.get(index).getFirstName();
				String lastName = normalCustomerDetails.get(index).getlastName();
				int age = normalCustomerDetails.get(index).getAge();
				String gender = normalCustomerDetails.get(index).getGender();
				int phoneNumber = normalCustomerDetails.get(index).getPhoneNumber();
				String email = normalCustomerDetails.get(index).getEmailAddress();
				
				//Set the selected customers to the text fields
				ui.getModifyMemberClassTxt().setText(membershipClass);
				ui.getModifyFirstNameTxt().setText(firstName);
				ui.getModifyLastNameTxt().setText(lastName);
				ui.getModifyAgeTxt().setText(age+"");
				ui.getModifyGenderTxt().setText(gender);
				ui.getModifyPhoneTxt().setText(phoneNumber+"");
				ui.getModifyEmailTxt().setText(email);
				ui.getModifyLoyaltyPoint().setText("Not available");
				
			}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			
		}
		//Update the Regular Customer Details to the normalCustomer Details file
		else if (event.getSource() == ui.getBtnUpdate()) {
			
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			if(confirmation == JOptionPane.YES_OPTION )
			{
				//Get all the customer details from the text fields
				String membershipClass = ui.getModifyMemberClassTxt().getText();
				String firstName = ui.getModifyFirstNameTxt().getText();
				String lastName = ui.getModifyLastNameTxt().getText();
				String age = ui.getModifyAgeTxt().getText();
				int age1 = 0;
				String gender = ui.getModifyGenderTxt().getText();
				String phoneNumber = ui.getModifyPhoneTxt().getText();
				int phoneNumber1 = 0;
				String email = ui.getModifyEmailTxt().getText();
			    Boolean all_data_valid = true;
			    String Error_Message = "";
				
				//Data validation
				if( (firstName.length() <3) || (lastName.length() <3) )
				{
					
					Error_Message  += "+ Customer First Name and Last Name must contain more than 2 characters.\n";
					all_data_valid = false;
					
					
				}
			
				if(age.length()>0) {
					try {
					  age1 = Integer.parseInt(age);
					}catch(NumberFormatException ex) {
						Error_Message += "+ You must enter number for age.\n";
						all_data_valid = false;
					}						
				
					if (age1 < 0 || age1 > 120) {
						Error_Message += "+ Invalid age. Age must be between 0-120.\n";
						all_data_valid = false;
					}
				}else if(age == "" || age.length() <= 0) {
					Error_Message += "+ Age must be filled.\n";
					all_data_valid = false;
				}else {
					Error_Message += "+ You must enter age  between 0-120.\n";
					all_data_valid = false;
				}
				
				if(gender.equalsIgnoreCase("Male") == false && gender.equalsIgnoreCase("Female") == false && gender.equalsIgnoreCase("None") == false) {
						Error_Message += "+ Gender must be \"Male\", \"Female\", or \"None\".\n";
						all_data_valid = false;
				}
				else if (gender.length()<=0 || gender.equalsIgnoreCase("")) {
					Error_Message += "+ Gender must be filled.\n";
					all_data_valid = false;
				}
				
				
				if(phoneNumber.length()>0) {
					try {
					  phoneNumber1 = Integer.parseInt(phoneNumber);
					}catch(NumberFormatException ex) {
						Error_Message += "+ Phone number must be numbers.\n";
						all_data_valid = false;
					}if (phoneNumber1 <= 2) {
						Error_Message += "+ Invalid phone number. Phone number must have more than 2 digits.\n";
						all_data_valid = false;
					}			
				}else if(phoneNumber == "" || phoneNumber.length() <= 0) {
					Error_Message += "+ Phone number must be filled.\n";
					all_data_valid = false;
				}else {
					Error_Message += "+ Phone number must be filled.\n";
					all_data_valid = false;
				}
				
				if (email.length() <= 4 || email.contains("@") == false || email.contains(".") == false) {
					Error_Message += "+ Email Address must be valid.\n";
					all_data_valid = false;
				}
					
				//check whether there is any error or not	
				if(all_data_valid == true)	
				{	
					
					try {
						int index = ui.getListModifyMember().getSelectedIndex();
						//Array List used to store the updated array list after the modification
						ArrayList<String> newNormalCustomerDetails = new ArrayList<String>();
						String CSV_Regular_String = membershipClass +","+firstName+","+lastName+","+age+","+gender+","+phoneNumber+","+email;
						normalCustomerDetails.remove(index); // Remove the customer records at the selected index from the arraylist
						newNormalCustomerDetails.add(CSV_Regular_String); // Add the modified customer into the new array list
						
						
						String CSV_newRegular_String;
						for(NormalCustomer customer: normalCustomerDetails) {				
							String newMembershipClass = customer.getMembershipClass();
							String newFirstName = customer.getFirstName();
							String newLastName = customer.getlastName();
							int newAge = customer.getAge();
							String newGender = customer.getGender();
							int newPhoneNumber = customer.getPhoneNumber();
							String newEmailAddress = customer.getEmailAddress();
							
							CSV_newRegular_String = newMembershipClass +","+newFirstName+","+newLastName+","+newAge+","+newGender+","+newPhoneNumber+","+newEmailAddress;
							newNormalCustomerDetails.add(CSV_newRegular_String); // Add the updated array list into the new ArrayList
						}
						
						this.dataHandler.overwriteNormalData(); // Overwrite the data with blank
						for(String cst: newNormalCustomerDetails) { // Add the new array list to the normalCustomer Details file
							this.dataHandler.writeNormalData(cst);
						}
					}catch(ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
					}
					
					//After modifying, disable the text fields
					ui.getModifyMemberClassTxt().setEnabled(false);
					ui.getModifyFirstNameTxt().setEnabled(false);
					ui.getModifyLastNameTxt().setEnabled(false);
					ui.getModifyAgeTxt().setEnabled(false);
					ui.getModifyGenderTxt().setEnabled(false);
					ui.getModifyPhoneTxt().setEnabled(false);
					ui.getModifyEmailTxt().setEnabled(false);
					ui.getListModifyMember().setEnabled(false);
				}
				else {
					//if there are errors, show the message
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//Update the Silver Customer Details to the silverCustomer Details file
		else if (event.getSource() == ui.getBtnUpdateSilver()) {
			
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{
				String membershipClass = ui.getModifyMemberClassTxt().getText();
				String firstName = ui.getModifyFirstNameTxt().getText();
				String lastName = ui.getModifyLastNameTxt().getText();
				String age = ui.getModifyAgeTxt().getText();
				int age1 = 0;
				String gender = ui.getModifyGenderTxt().getText();
				String phoneNumber = ui.getModifyPhoneTxt().getText();
				int phoneNumber1 = 0;
				String email = ui.getModifyEmailTxt().getText();
				String silverLoyaltyPoints = ui.getModifyLoyaltyPoint().getText();
			    Boolean all_data_valid = true;
			    String Error_Message = "";
				
				//Data validation
				if( (firstName.length() <3) || (lastName.length() <3) )
				{
					Error_Message  += "+ Customer First Name and Last Name must contain more than 2 characters.\n";
					all_data_valid = false;
				}
			
				if(age.length()>0) {
					try {
					  age1 = Integer.parseInt(age);
					}catch(NumberFormatException ex) {
						Error_Message += "+ You must enter number for age.\n";
						all_data_valid = false;
					}						
				
					if (age1 < 0 || age1 > 120) {
						Error_Message += "+ Invalid age. Age must be between 0-120.\n";
						all_data_valid = false;
					}
				}else if(age == "" || age.length() <= 0) {
					Error_Message += "+ Age must be filled.\n";
					all_data_valid = false;
				}else {
					Error_Message += "+ You must enter age  between 0-120.\n";
					all_data_valid = false;
				}
				
				
				if(gender.equalsIgnoreCase("Male") == false && gender.equalsIgnoreCase("Female") == false && gender.equalsIgnoreCase("None") == false) {
						Error_Message += "+ Gender must be \"Male\", \"Female\", or \"None\".\n";
						all_data_valid = false;
				}
				else if (gender.length()<=0 || gender.equalsIgnoreCase("")) {
					Error_Message += "+ Gender must be filled.\n";
					all_data_valid = false;
				}
				
				
				if(phoneNumber.length()>0) {
					try {
					  phoneNumber1 = Integer.parseInt(phoneNumber);
					}catch(NumberFormatException ex) {
						Error_Message += "+ Phone number must be numbers.\n";
						all_data_valid = false;
					}if (phoneNumber1 <= 2) {
						Error_Message += "+ Invalid phone number. Phone number must have more than 2 digits.\n";
						all_data_valid = false;
					}			
				}else if(phoneNumber == "" || phoneNumber.length() <= 0) {
					Error_Message += "+ Phone number must be filled.\n";
					all_data_valid = false;
				}else {
					Error_Message += "+ Phone number must be filled.\n";
					all_data_valid = false;
				}
				
				if (email.length() <= 4 || email.contains("@") == false || email.contains(".") == false) {
					Error_Message += "+ Email Address must be valid.\n";
					all_data_valid = false;
				}
					
				//check whether there is any error or not	
				if(all_data_valid == true)	
				{	
					try {
						int index = ui.getListModifyMember().getSelectedIndex();
						//Array List used to store the updated array list after the modification
						ArrayList<String> newSilverCustomerDetails = new ArrayList<String>();
						String CSV_Silver_String = membershipClass +","+firstName+","+lastName+","+age+","+gender+","+phoneNumber+","+email+","+silverLoyaltyPoints;
						silverCustomerDetails.remove(index); // Remove the customer records at the selected index from the array list
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
							int newSilverLoyaltyPoints = customer.getSilverLoyaltyPoints();
							
							CSV_newSilver_String = newMembershipClass +","+newFirstName+","+newLastName+","+newAge+","+newGender+","+newPhoneNumber+","+newEmailAddress+","+newSilverLoyaltyPoints;
							newSilverCustomerDetails.add(CSV_newSilver_String); // Add the updated array list into the new ArrayList
						}
						
				
						this.dataHandler.overwriteSilverData(); // Overwrite the data with blank
						for(String cst: newSilverCustomerDetails) { // Add the new array list to the silverCustomer Details file
							this.dataHandler.writeSilverData(cst);
						}
					}catch(ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
					}
					
					//After modifying, disable the text fields
					ui.getModifyMemberClassTxt().setEnabled(false);
					ui.getModifyFirstNameTxt().setEnabled(false);
					ui.getModifyLastNameTxt().setEnabled(false);
					ui.getModifyAgeTxt().setEnabled(false);
					ui.getModifyGenderTxt().setEnabled(false);
					ui.getModifyPhoneTxt().setEnabled(false);
					ui.getModifyEmailTxt().setEnabled(false);
					ui.getListModifyMember().setEnabled(false);
				}
				else {
					//if there are errors, show the message
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			/////
			
		}
		//Update the Gold Customer Details to the silverCustomer Details file
		else if (event.getSource() == ui.getBtnUpdateGold()) {
			
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{
				String membershipClass = ui.getModifyMemberClassTxt().getText();
				String firstName = ui.getModifyFirstNameTxt().getText();
				String lastName = ui.getModifyLastNameTxt().getText();
				String age = ui.getModifyAgeTxt().getText();
				int age1 = 0;
				String gender = ui.getModifyGenderTxt().getText();
				String phoneNumber = ui.getModifyPhoneTxt().getText();
				int phoneNumber1 = 0;
				String email = ui.getModifyEmailTxt().getText();
				String goldLoyaltyPoints = ui.getModifyLoyaltyPoint().getText();
			    Boolean all_data_valid = true;
			    String Error_Message = "";
				
				//Data validation
				if( (firstName.length() <3) || (lastName.length() <3) )
				{
					
					Error_Message  += "+ Customer First Name and Last Name must contain more than 2 characters.\n";
					all_data_valid = false;
					
					
				}
			
				if(age.length()>0) {
					try {
					  age1 = Integer.parseInt(age);
					}catch(NumberFormatException ex) {
						Error_Message += "+ You must enter number for age.\n";
						all_data_valid = false;
					}						
				
					if (age1 < 0 || age1 > 120) {
						Error_Message += "+ Invalid age. Age must be between 0-120.\n";
						all_data_valid = false;
					}
				}else if(age == "" || age.length() <= 0) {
					Error_Message += "+ Age must be filled.\n";
					all_data_valid = false;
				}else {
					Error_Message += "+ You must enter age  between 0-120.\n";
					all_data_valid = false;
				}
				
				if(gender.equalsIgnoreCase("Male") == false && gender.equalsIgnoreCase("Female") == false && gender.equalsIgnoreCase("None") == false) {
						Error_Message += "+ Gender must be \"Male\", \"Female\", or \"None\".\n";
						all_data_valid = false;
				}
				else if (gender.length()<=0 || gender.equalsIgnoreCase("")) {
					Error_Message += "+ Gender must be filled.\n";
					all_data_valid = false;
				}
				
				
				if(phoneNumber.length()>0) {
					try {
					  phoneNumber1 = Integer.parseInt(phoneNumber);
					}catch(NumberFormatException ex) {
						Error_Message += "+ Phone number must be numbers.\n";
						all_data_valid = false;
					}if (phoneNumber1 <= 2) {
						Error_Message += "+ Invalid phone number. Phone number must have more than 2 digits.\n";
						all_data_valid = false;
					}			
				}else if(phoneNumber == "" || phoneNumber.length() <= 0) {
					Error_Message += "+ Phone number must be filled.\n";
					all_data_valid = false;
				}else {
					Error_Message += "+ Phone number must be filled.\n";
					all_data_valid = false;
				}
				
				if (email.length() <= 4 || email.contains("@") == false || email.contains(".") == false) {
					Error_Message += "+ Email Address must be valid.\n";
					all_data_valid = false;
				}
					
				//check whether there is any error or not	
				if(all_data_valid == true)	
				{	
					try {
						int index = ui.getListModifyMember().getSelectedIndex();
						//Array List used to store the updated array list after the modification
						ArrayList<String> newGoldCustomerDetails = new ArrayList<String>();
						String CSV_Gold_String = membershipClass +","+firstName+","+lastName+","+age+","+gender+","+phoneNumber+","+email+","+goldLoyaltyPoints;
						goldCustomerDetails.remove(index); // Remove the customer records at the selected index from the array list
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
							int newGoldLoyaltyPoints = customer.getGoldLoyaltyPoints();
							
							CSV_newGold_String = newMembershipClass +","+newFirstName+","+newLastName+","+newAge+","+newGender+","+newPhoneNumber+","+newEmailAddress+","+newGoldLoyaltyPoints;
							newGoldCustomerDetails.add(CSV_newGold_String); // Add the updated array list into the new ArrayList
						}
						
						this.dataHandler.overwriteGoldData(); // Overwrite the data with blank
						for(String cst: newGoldCustomerDetails) { // Add the new array list to the goldCustomer Details file
							this.dataHandler.writeGoldData(cst);
						}
					}catch(ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
					}
					
					//After modifying, disable the text fields
					ui.getModifyMemberClassTxt().setEnabled(false);
					ui.getModifyFirstNameTxt().setEnabled(false);
					ui.getModifyLastNameTxt().setEnabled(false);
					ui.getModifyAgeTxt().setEnabled(false);
					ui.getModifyGenderTxt().setEnabled(false);
					ui.getModifyPhoneTxt().setEnabled(false);
					ui.getModifyEmailTxt().setEnabled(false);
					ui.getListModifyMember().setEnabled(false);
				}
				else {
					//if there are errors, show the message
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			
			//////

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


