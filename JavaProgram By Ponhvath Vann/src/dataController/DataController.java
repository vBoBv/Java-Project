package dataController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import data.Admin;
import data.GoldCustomer;
import data.NormalCustomer;
import data.RegularCustomer;
import data.SilverCustomer;

/*
 * 
 *   This class manages data access
 * 
 */


public class DataController {
	
	private final String USERNAME_PASSWORD_LOCATION = "data/usernamePassword.csv";
	private final String FILE_LOCATION = "data/customerDetails.csv";
	private final String FILE_LOCATION1 = "data/silverCustomerDetails.csv";
	private final String FILE_LOCATION2 = "data/goldCustomerDetails.csv";
	private final String FILE_LOCATION3 = "data/normalCustomerDetails.csv";
	
	
	//Write admin data to usernamPassword file
	public void writeUsernamePasswordData(String formData ){
		PrintWriter WriterUsernamePassword = null;
		try {
			File file = new File(USERNAME_PASSWORD_LOCATION);
			if(file.exists() != true)
			{
				//create folder
				file.getParentFile().mkdir();
			}
			
			WriterUsernamePassword = new PrintWriter(new FileWriter(USERNAME_PASSWORD_LOCATION, true));
			WriterUsernamePassword.println(formData);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			WriterUsernamePassword.close();
		}
	}
	
	
	//Write all of the customer details into customerDetails file
	public void writeData(String formData ){
		PrintWriter Writer = null;
		try {
			File file = new File(FILE_LOCATION);
			if(file.exists() != true)
			{
				//create folder
				file.getParentFile().mkdir();
			}
			
			Writer = new PrintWriter(new FileWriter(FILE_LOCATION, true));
			Writer.println(formData);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Writer.close();
		}
	}

	//Write Silver Customer into silverCustomerDetails file
	public void writeSilverData(String formData ){
		PrintWriter Writer1 = null;
		try {
			File file1 = new File(FILE_LOCATION1);
			if(file1.exists() != true)
			{
				//create folder
				file1.getParentFile().mkdir();
			}
			
			Writer1 = new PrintWriter(new FileWriter(FILE_LOCATION1, true));
			Writer1.println(formData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Writer1.close();
		}
	}
	
	//Write Gold Customer into goldCustomerDetails file
	public void writeGoldData(String formData) {
		PrintWriter Writer2 = null;
		try {
			File file2 = new File(FILE_LOCATION2);
			if(file2.exists() != true)
			{
				//create folder
				file2.getParentFile().mkdir();
			}
			
			Writer2 = new PrintWriter(new FileWriter(FILE_LOCATION2, true));
			Writer2.println(formData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Writer2.close();
		}
	}
	
	//Write Regular Customer into normalCustomerDetails file
	public void writeNormalData(String formData) {
		PrintWriter Writer3 = null;
		try {
			File file3 = new File(FILE_LOCATION3);
			if(file3.exists() != true)
			{
				//create folder
				file3.getParentFile().mkdir();
			}
			
			Writer3 = new PrintWriter(new FileWriter(FILE_LOCATION3, true));
			Writer3.println(formData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Writer3.close();
		}
	}
	
	//Use to overwrite silverCustomerDetails file with blank
	public void overwriteSilverData(){
		PrintWriter Overwriter1 = null;
		try {
			File file1 = new File(FILE_LOCATION1);
			if(file1.exists() != true)
			{
				//create folder
				file1.getParentFile().mkdir();
			}
			
			Overwriter1 = new PrintWriter(new FileWriter(FILE_LOCATION1, false));
			//Overwriter1.println(formData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Overwriter1.close();
		}
	}
	
	//Use to overwrite goldCustomerDetails file with blank
	public void overwriteGoldData() {
		PrintWriter Overwriter2 = null;
		try {
			File file2 = new File(FILE_LOCATION2);
			if(file2.exists() != true)
			{
				//create folder
				file2.getParentFile().mkdir();
			}
			
			Overwriter2 = new PrintWriter(new FileWriter(FILE_LOCATION2, false));
			//Overwriter2.println(formData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Overwriter2.close();
		}
	}
	
	//Use to overwrite normalCustomerDetails file with blank
	public void overwriteNormalData() {
		PrintWriter Overwriter3 = null;
		try {
			File file3 = new File(FILE_LOCATION3);
			if(file3.exists() != true)
			{
				//create folder
				file3.getParentFile().mkdir();
			}
			
			Overwriter3 = new PrintWriter(new FileWriter(FILE_LOCATION3, false));
			//Overwriter3.println(formData);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Overwriter3.close();
		}
	}
	
	//Use to overwrite customerDetails file with blank
	public void overwriteAllCustomerData() {
		PrintWriter Overwriter4 = null;
		try {
			File file4 = new File(FILE_LOCATION);
			if(file4.exists() != true)
			{
				//create folder
				file4.getParentFile().mkdir();
			}
			
			Overwriter4 = new PrintWriter(new FileWriter(FILE_LOCATION, false));
			//Overwriter4.println(formData);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Overwriter4.close();
		}
	}
	
	
	/*
	 * 
	 *  The method to read data in a text file and add each line to array 
	 * 
	 */
	
	//Use to read the usernamePassword file
	public static ArrayList<Admin> readFileAdmin(String USERNAME_PASSWORD_LOCATION) {
		ArrayList<Admin> adminDetailsArrayList = new ArrayList<Admin>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(USERNAME_PASSWORD_LOCATION));
			String line = reader.readLine();
			while( line!= null ){
				
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
			
			
				adminDetailsArrayList.add(new Admin(username,password)); 
				
				line = reader.readLine();
			}
			
			reader.close();
		
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read");
		}
			
		
		return adminDetailsArrayList;
		
	}
	
	//Use to read the customerDetails file
	public static ArrayList<RegularCustomer> readFile(String FILE_LOCATION) {
		ArrayList<RegularCustomer> customerDetailsArrayList = new ArrayList<RegularCustomer>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_LOCATION));
			String line = reader.readLine();
			while( line!= null ){
				
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				String membershipClass = tokenizer.nextToken();
				String firstName = tokenizer.nextToken();
				String lastName = tokenizer.nextToken();
				int age = Integer.parseInt(tokenizer.nextToken());
				String gender = tokenizer.nextToken();
				int phoneNumber = Integer.parseInt(tokenizer.nextToken());
				String emailAddress = tokenizer.nextToken();
			
				customerDetailsArrayList.add(new RegularCustomer(membershipClass,firstName,lastName,age,gender,phoneNumber,emailAddress)); 
				
				line = reader.readLine();
			}
			
			reader.close();
		
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read");
		}
			
		
		return customerDetailsArrayList;
		
	}
	
	//Use to read the silverCustomerDetails file
	public static ArrayList<SilverCustomer> readFile1(String FILE_LOCATION1) {
		ArrayList<SilverCustomer> silverCustomerDetailsArrayList = new ArrayList<SilverCustomer>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_LOCATION1));
			String line = reader.readLine();
			while( line!= null ){
				
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				String membershipClass = tokenizer.nextToken();
				String firstName = tokenizer.nextToken();
				String lastName = tokenizer.nextToken();
				int age = Integer.parseInt(tokenizer.nextToken());
				String gender = tokenizer.nextToken();
				int phoneNumber = Integer.parseInt(tokenizer.nextToken());
				String emailAddress = tokenizer.nextToken();
				
				silverCustomerDetailsArrayList.add(new SilverCustomer(membershipClass,firstName,lastName,age,gender,phoneNumber,emailAddress, 0)); 
				
				line = reader.readLine();
			}
			
			reader.close();
		
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read");
		}
			
		
		return silverCustomerDetailsArrayList;
		
	}
	
	//Use to read the goldCustomerDetails file
	public static ArrayList<GoldCustomer> readFile2(String FILE_LOCATION2) {
		ArrayList<GoldCustomer> goldCustomerDetailsArrayList = new ArrayList<GoldCustomer>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_LOCATION2));
			String line = reader.readLine();
			while( line!= null ){
				
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				String membershipClass = tokenizer.nextToken();
				String firstName = tokenizer.nextToken();
				String lastName = tokenizer.nextToken();
				int age = Integer.parseInt(tokenizer.nextToken());
				String gender = tokenizer.nextToken();
				int phoneNumber = Integer.parseInt(tokenizer.nextToken());
				String emailAddress = tokenizer.nextToken();
				
				goldCustomerDetailsArrayList.add(new GoldCustomer(membershipClass,firstName,lastName,age,gender,phoneNumber,emailAddress, 0)); 
				
				line = reader.readLine();
			}
			
			reader.close();
		
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read");
		}
			
		
		return goldCustomerDetailsArrayList;
		
	}
	
	//Use to read the normalCustomerDetails file
	public static ArrayList<NormalCustomer> readFile3(String FILE_LOCATION3) {
		ArrayList<NormalCustomer> normalCustomerDetailsArrayList = new ArrayList<NormalCustomer>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_LOCATION3));
			String line = reader.readLine();
			while( line!= null ){
				
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				String membershipClass = tokenizer.nextToken();
				String firstName = tokenizer.nextToken();
				String lastName = tokenizer.nextToken();
				int age = Integer.parseInt(tokenizer.nextToken());
				String gender = tokenizer.nextToken();
				int phoneNumber = Integer.parseInt(tokenizer.nextToken());
				String emailAddress = tokenizer.nextToken();
				
				normalCustomerDetailsArrayList.add(new NormalCustomer(membershipClass,firstName,lastName,age,gender,phoneNumber,emailAddress)); 
				
				line = reader.readLine();
			}
			
			reader.close();
		
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read");
		}
			
		
		return normalCustomerDetailsArrayList;
		
	}
	
}
