package data;

public class GoldCustomer extends RegularCustomer {
	private int goldLoyaltyPoints;

	
	
	public GoldCustomer(String memberShipClass, String firstName, String lastName, int age, String gender,
			int phoneNumber, String emailAddress, int goldLoyaltyPoints) {
		super(memberShipClass, firstName, lastName, age, gender, phoneNumber, emailAddress);
		this.goldLoyaltyPoints = goldLoyaltyPoints;
	}
	
	public double getGoldLoyaltyPoints() {
		return goldLoyaltyPoints;
	}

	public void setGoldLoyaltyPoints(int goldLoyaltyPoints) {
		this.goldLoyaltyPoints = goldLoyaltyPoints;
	}

	public String getGoldName() {
		return getFirstName() + " " + getlastName();
		
	}
	
	
}
