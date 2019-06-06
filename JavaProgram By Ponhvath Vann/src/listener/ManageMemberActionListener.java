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


public class ManageMemberActionListener implements ActionListener {
	
	private RegisterMember ui;
	private DataController dataHandler;
	
	
	ArrayList<NormalCustomer> normalCustomerDetails = DataController.readFile3("data/normalCustomerDetails.csv");
	ArrayList<SilverCustomer> silverCustomerDetails = DataController.readFile1("data/silverCustomerDetails.csv");
	ArrayList<GoldCustomer> goldCustomerDetails = DataController.readFile2("data/goldCustomerDetails.csv");

	
	public ManageMemberActionListener(RegisterMember ui, DataController dataHandler )
	{
	
		this.ui = ui;
		this.dataHandler = dataHandler;
		
	}

	
	DefaultListModel regularCustomerName = new DefaultListModel();
	DefaultListModel silverCustomerName = new DefaultListModel();
	DefaultListModel goldCustomerName = new DefaultListModel();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		ArrayList<NormalCustomer> normalCustomerDetails = DataController.readFile3("data/normalCustomerDetails.csv");
		ArrayList<SilverCustomer> silverCustomerDetails = DataController.readFile1("data/silverCustomerDetails.csv");
		ArrayList<GoldCustomer> goldCustomerDetails = DataController.readFile2("data/goldCustomerDetails.csv");
		
		
		if (event.getSource() == ui.getBtnManageMember()) {
			
			//Use to reset the name in the list
			regularCustomerName.clear();
			silverCustomerName.clear();
			goldCustomerName.clear();
			
			//Setting the Regular Customer into the list
			try {
				for (NormalCustomer membershipClass: normalCustomerDetails) {
					
						String regularName = membershipClass.getFirstName() + " " + membershipClass.getlastName();
						regularCustomerName.addElement(regularName);
					
				}
				ui.getRegularCustomerJList().setModel(regularCustomerName);
			}catch(NullPointerException e) {
				System.out.println("Error! Cannot find the customer.");
			}
			
			//Setting the Silver Customer into the list
			try {
				for (SilverCustomer membershipClass: silverCustomerDetails) {
					
						String silverName = membershipClass.getFirstName() + " " + membershipClass.getlastName();
						silverCustomerName.addElement(silverName);
						
				}
				ui.getSilverCustomerJList().setModel(silverCustomerName);
			}catch(NullPointerException e) {
				//e.printStackTrace();
				System.out.println("Error! Cannot find the customer.");
			}
			
			//Setting the Gold Customer into the list
			try {
				for (GoldCustomer membershipClass: goldCustomerDetails) {
					
						String goldName = membershipClass.getFirstName() + " " + membershipClass.getlastName();
						goldCustomerName.addElement(goldName);
						
				}
				ui.getGoldCustomerJList().setModel(goldCustomerName);
			}catch(NullPointerException e) {
				//e.printStackTrace();
				System.out.println("Error! Cannot find the customer.");
			}
		}

		else if (event.getSource() == ui.getBtnRemoveRegular()) {
			//Use to store the updated customers list after removal
			ArrayList<String> newNormalCustomerDetails = new ArrayList<String>(); 
			try {
				int index = ui.getRegularCustomerJList().getSelectedIndex();
				regularCustomerName.removeElementAt(index);
				normalCustomerDetails.remove(index);
				
				
				String CSV_Regular_String;
				for(NormalCustomer customer: normalCustomerDetails) {				
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
				
				// Overwrite the file with blank data
				this.dataHandler.overwriteNormalData(); 
				// Add the new array list into the file
				for(String cst: newNormalCustomerDetails) {
					this.dataHandler.writeNormalData(cst);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		else if (event.getSource() == ui.getBtnRemoveSilver()) {
			//Use to store the updated customers list after removal
			ArrayList<String> newSilverCustomerDetails = new ArrayList<String>();
			try {
				int index = ui.getSilverCustomerJList().getSelectedIndex();
				
				silverCustomerName.removeElementAt(index);
				silverCustomerDetails.remove(index);
				
				
				String CSV_Silver_String;
				for(SilverCustomer customer: silverCustomerDetails) {				
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
				// Overwrite the file with blank data
				this.dataHandler.overwriteSilverData();
				// Add the new array list into the file
				for(String cst: newSilverCustomerDetails) {
					this.dataHandler.writeSilverData(cst);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		else if (event.getSource() == ui.getBtnRemoveGold()) {
			//Use to store the updated customers list after removal
			ArrayList<String> newGoldCustomerDetails = new ArrayList<String>();
			
			try {
				int index = ui.getGoldCustomerJList().getSelectedIndex();
				//System.out.println(index);
				goldCustomerName.removeElementAt(index);
				goldCustomerDetails.remove(index);
				
				
				String CSV_Gold_String;
				for(GoldCustomer customer: goldCustomerDetails) {				
					
					
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
				// Overwrite the file with blank data
				this.dataHandler.overwriteGoldData();
				// Add the new array list into the file
				for(String cst: newGoldCustomerDetails) {
					this.dataHandler.writeGoldData(cst);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (event.getSource() == ui.getBtnNormalViewchangeDetails()) {
			try {
				int index = ui.getRegularCustomerJList().getSelectedIndex();
				DataController dc = new DataController();
				ViewAndChangeCustomerDetails ui1 = new ViewAndChangeCustomerDetails();
				ui1.setVisible(true); // Open the View customer details window
			
				//Get the customer details at the selected index
				String membershipClass = normalCustomerDetails.get(index).getMembershipClass();
				String firstName = normalCustomerDetails.get(index).getFirstName();
				String lastName = normalCustomerDetails.get(index).getlastName();
				int age = normalCustomerDetails.get(index).getAge();
				String gender = normalCustomerDetails.get(index).getGender();
				int phoneNumber = normalCustomerDetails.get(index).getPhoneNumber();
				String email = normalCustomerDetails.get(index).getEmailAddress();
				
				//Set the selected index customer to the text fields
				ui1.getMemberTxtField().setText(membershipClass);
				ui1.getFirstNameTxtField().setText(firstName);
				ui1.getLastNameTxtField().setText(lastName);
				ui1.getAgeTxtField().setText(age+"");
				ui1.getGenderTxtField().setText(gender);
				ui1.getPhoneNumberTxtField().setText(phoneNumber+"");
				ui1.getEmailTxtField().setText(email);
				
				
			}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
			}
			
		}

		else if (event.getSource() == ui.getBtnSilverViewchangeDetails()) {
			try {
				int index = ui.getSilverCustomerJList().getSelectedIndex();
				ViewAndChangeSilverDetails ui1 = new ViewAndChangeSilverDetails();
				ui1.setVisible(true); // Open the View customer details window
				
				//Get the customer details at the selected index
				String membershipClass = silverCustomerDetails.get(index).getMembershipClass();
				String firstName = silverCustomerDetails.get(index).getFirstName();
				String lastName = silverCustomerDetails.get(index).getlastName();
				int age = silverCustomerDetails.get(index).getAge();
				String gender = silverCustomerDetails.get(index).getGender();
				int phoneNumber = silverCustomerDetails.get(index).getPhoneNumber();
				String email = silverCustomerDetails.get(index).getEmailAddress();
				
				
				//Set the selected index customer to the text fields
				ui1.getMemberTxtField().setText(membershipClass);
				ui1.getFirstNameTxtField().setText(firstName);
				ui1.getLastNameTxtField().setText(lastName);
				ui1.getAgeTxtField().setText(age+"");
				ui1.getGenderTxtField().setText(gender);
				ui1.getPhoneNumberTxtField().setText(phoneNumber+"");
				ui1.getEmailTxtField().setText(email);
				
			}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
		}
		else if (event.getSource() == ui.getBtnGoldViewchangeDetails()) {
			try {
				int index = ui.getGoldCustomerJList().getSelectedIndex();
				ViewAndChangeGoldDetails ui1 = new ViewAndChangeGoldDetails();
				ui1.setVisible(true);// Open the View customer details window
				
				//Get the customer details at the selected index
				String membershipClass = goldCustomerDetails.get(index).getMembershipClass();
				String firstName = goldCustomerDetails.get(index).getFirstName();
				String lastName = goldCustomerDetails.get(index).getlastName();
				int age = goldCustomerDetails.get(index).getAge();
				String gender = goldCustomerDetails.get(index).getGender();
				int phoneNumber = goldCustomerDetails.get(index).getPhoneNumber();
				String email = goldCustomerDetails.get(index).getEmailAddress();
				
				
				//Set the selected index customer to the text fields
				ui1.getMemberTxtField().setText(membershipClass);
				ui1.getFirstNameTxtField().setText(firstName);
				ui1.getLastNameTxtField().setText(lastName);
				ui1.getAgeTxtField().setText(age+"");
				ui1.getGenderTxtField().setText(gender);
				ui1.getPhoneNumberTxtField().setText(phoneNumber+"");
				ui1.getEmailTxtField().setText(email);
				
			}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(ui, "+ Please select a customer to proceed." , "Info Message", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
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


