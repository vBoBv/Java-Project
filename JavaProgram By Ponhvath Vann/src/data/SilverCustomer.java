package data;

public class SilverCustomer extends RegularCustomer {
	private int silverLoyaltyPoints;
	
	
	public SilverCustomer(String memberShipClass, String firstName, String lastName, int age, String gender,
			int phoneNumber, String emailAddress, int silverLoyaltyPoints) {
		super(memberShipClass, firstName, lastName, age, gender, phoneNumber, emailAddress);
		this.silverLoyaltyPoints = silverLoyaltyPoints;
		
	}


	public int getSilverLoyaltyPoints() {
		return silverLoyaltyPoints;
	}


	public void setSilverLoyaltyPoints(int silverLoyaltyPoints) {
		this.silverLoyaltyPoints = silverLoyaltyPoints;
	}
	
	public String getSilverName() {
		return getFirstName() + " " + getlastName();
		
	}
	
	

	
	
	
}
