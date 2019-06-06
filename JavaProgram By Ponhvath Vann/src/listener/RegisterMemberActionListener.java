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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import dataController.DataController;
import ui.RegisterMember;


public class RegisterMemberActionListener implements ActionListener {
	
	private RegisterMember ui;
	private DataController dataHandler;

	public RegisterMemberActionListener(RegisterMember ui, DataController dataHandler )
	{
		
		this.ui = ui;
		this.dataHandler = dataHandler;
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == ui.getBtnRegister())
		{	
			//Display the dialog box when register button is clicked
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{	
				
				//if yes, we get data from inputs and validate it
				String comboBoxMembership = (String) ui.getComboBoxMembership().getSelectedItem();
				String firstName = ui.getRegisterTxtFieldFirstName().getText();
				String lastName = ui.getRegisterTextFieldLastName().getText();
				String age = ui.getRegisterTextFieldAge().getText();
				int age1 = 0;
				String comboBoxGender = (String) ui.getComboBoxGender().getSelectedItem();
				String phoneNumber = ui.getRegisterTextFieldPhoneNumber().getText();
				int phoneNumber1 = 0;
				String emailAddress = ui.getRegisterTextFieldEmailAddress().getText();
			    Boolean all_data_valid = true;
			    String Error_Message = "";
				
				//Data validation
			    if (comboBoxMembership==null || comboBoxGender==null) {
			    	Error_Message  += "+ Membership Class and Gender must be filled.\n";
			    	all_data_valid = false;
			    }
			    
			    
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
				
				if (emailAddress.length() <= 4 || emailAddress.contains("@") == false || emailAddress.contains(".") == false) {
					Error_Message += "+ Email Address must be valid.\n";
					all_data_valid = false;
				}
					
				//check whether there is any error or not	
				if(all_data_valid == true)	
				{	
					
					//Get the value in the Combo Box
					String comboBoxSelectedMember = (String) comboBoxMembership;
					String comboBoxSelectedGender = (String) comboBoxGender;
					//Concat string
					String CSV_String = comboBoxSelectedMember +","+firstName+","+lastName+","+age+","+comboBoxSelectedGender+","+phoneNumber+","+emailAddress;
					
					//Write data to the customerDetails text file that contains all type of customers
					this.dataHandler.writeData(CSV_String);

					if (comboBoxMembership.equalsIgnoreCase("Regular")) {
						String comboBoxSelectedSilverMember = (String) comboBoxMembership;
						String comboBoxSelectedSilverGender = (String) comboBoxGender;
						int silverLoyaltyPoints = 0;
						String CSV_Regular_String = comboBoxSelectedSilverMember +","+firstName+","+lastName+","+age+","+comboBoxSelectedSilverGender+","+phoneNumber+","+emailAddress+","+silverLoyaltyPoints;
						
						//Write data to the normalCustomerDetails text file that contains Regular Customer only
						this.dataHandler.writeNormalData(CSV_Regular_String);

						
						
					}
					
					if (comboBoxMembership.equalsIgnoreCase("Silver")) {
						String comboBoxSelectedSilverMember = (String) comboBoxMembership;
						String comboBoxSelectedSilverGender = (String) comboBoxGender;
						int silverLoyaltyPoints = 0;
						String CSV_Silver_String = comboBoxSelectedSilverMember +","+firstName+","+lastName+","+age+","+comboBoxSelectedSilverGender+","+phoneNumber+","+emailAddress+","+silverLoyaltyPoints;
						
						//Write data to the silverCustomerDetails text file that contains Silver Customer only
						this.dataHandler.writeSilverData(CSV_Silver_String);

						
						
					}
					
					if (comboBoxMembership.equalsIgnoreCase("Gold")) {
						String comboBoxSelectedGoldMember = (String) comboBoxMembership;
						String comboBoxSelectedGoldGender = (String) comboBoxGender;
						int goldLoyaltyPoints = 0;
						String CSV_Gold_String = comboBoxSelectedGoldMember +","+firstName+","+lastName+","+age+","+comboBoxSelectedGoldGender+","+phoneNumber+","+emailAddress+","+goldLoyaltyPoints;
						
						//Write data to the goldCustomerDetails text file that contains Gold Customer only
						this.dataHandler.writeGoldData(CSV_Gold_String);

						
						
					}
					
					JOptionPane.showMessageDialog(ui, "Your details have been saved", "Info Message", JOptionPane.INFORMATION_MESSAGE);
					//reset form
					ui.getComboBoxMembership().setSelectedItem(null);
					ui.getRegisterTxtFieldFirstName().setText(null);
					ui.getRegisterTextFieldLastName().setText(null);
					ui.getRegisterTextFieldAge().setText(null);
					ui.getComboBoxGender().setSelectedItem(null);
					ui.getRegisterTextFieldPhoneNumber().setText(null);
					ui.getRegisterTextFieldEmailAddress().setText(null);
					
					
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

