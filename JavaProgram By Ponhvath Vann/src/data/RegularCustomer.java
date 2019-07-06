package data;

import java.util.Scanner;

public class RegularCustomer {
	protected String membershipClass;
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String gender;
	protected int phoneNumber;
	protected String emailAddress;
	protected int LoyaltyPoint;
	
	
	public RegularCustomer(String memberShipClass, String firstName, String lastName, int age, String gender, int phoneNumber, String emailAddress) {
		this.membershipClass = memberShipClass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;

	
	}

	
	

	public String getMembershipClass() {
		return membershipClass;
	}

	public void setMembershipClass(String membershipClass) {
		if (membershipClass.equalsIgnoreCase("Regular") || membershipClass.equalsIgnoreCase("Silver") || membershipClass.equalsIgnoreCase("Gold")) {
			this.membershipClass = membershipClass;
		}
		else {
			System.out.println("Invalid class member. Class member must be \"regular\", \"silver\" or \"gold\".");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String setFirstName(String firstName) {
		if (firstName.length() >= 3) {
			this.firstName = firstName;
		}
		else {
			System.out.println("Invalid customer name. Customer name must contain more than 2 characters.");
		}
		return firstName;
		
	}
	
	public String getlastName() {
		return lastName;
	}

	public String setlastName(String lastName) {
		if (lastName.length() >= 3) {
			this.lastName = lastName;
		}
		else {
			System.out.println("Invalid customer name. Customer name must contain more than 2 characters.");
		}
		return lastName;
		
	}
	
	public String getName() {
		return getFirstName() + " " + getlastName();
		
	}

	public int getAge() {
		return age;
	}

	public int setAge(int age) {
		if (age >= 0 && age <= 120) {
			this.age = age;
		}
		else {
			System.out.println("Invalid age. Age must be between 0-120.");
		}
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String setGender(String gender) {
		if (gender.equalsIgnoreCase("none")  || gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
			this.gender = gender;
		}
		else {
			System.out.println("Invalid gender. Gender must be \"none\", \"male\" or \"female\".");
		}
		return gender;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public int setPhoneNumber(int phoneNumber) {
		if (phoneNumber >= 3) {
			this.phoneNumber = phoneNumber;
		}
		else {
			System.out.println("Invalid phone number. Phone number must be more than 3 numbers.");
		}
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String setEmailAddress(String emailAddress) {
		if (emailAddress.length() >= 4 && emailAddress.contains("@") && emailAddress.contains(".")) {
			this.emailAddress = emailAddress;
		}
		else {
			System.out.println("Invalid email address. Email Address must be valid and must be more than 3 characters.");
		}
		return emailAddress;
	}
	
	
	@Override
	public String toString() {
		return "RegularCustomer [membershipClass=" + membershipClass + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", emailAddress="
				+ emailAddress + "] + \n" ;
	}




	public void inputRegularCustomerDetails() {
		Scanner input = new Scanner(System.in);
		
		//Customer Class
		System.out.print("Membership class: ");
		membershipClass = input.nextLine();
		setMembershipClass(membershipClass);
		
		
		//Customer name
		do {
			System.out.print("Name: ");
			firstName = input.nextLine();
			setFirstName(firstName);
		   }while (firstName.length() < 3);
		
		//Customer age
		do {
			System.out.print("Age: ");
			age = input.nextInt();
			setAge(age);
			input.nextLine();
		   }while (age < 0 || age > 120);
		
		//Customer gender
		do {
			System.out.print("Gender: ");
			gender = input.nextLine();
			setGender(gender);
		   }while (gender.equalsIgnoreCase("none") == false && gender.equalsIgnoreCase("male") == false && gender.equalsIgnoreCase("female") == false);
		
		//Customer Mobile number
		do {
			System.out.print("Phone number: ");
			phoneNumber = input.nextInt();
			setPhoneNumber(phoneNumber);
			input.nextLine();
		}while (phoneNumber < 3);
		
		//Customer email address
		do {
			System.out.print("Email Address: ");
			emailAddress = input.nextLine();
			setEmailAddress(emailAddress);
		   }while (emailAddress.length() < 3 || emailAddress.contains("@") == false || emailAddress.contains(".") == false);
		
	}
	
}
