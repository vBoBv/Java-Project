package listener;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NormalPaymentActionListenerTest {

	@Test
	public void testCalculateBlueRayTotalPrice() {
		double r = NormalPaymentActionListener.calculateBlueRayTotalPrice(8,7);
		assertEquals(r,56);
	}
	
	@Test
	public void testCalculateDvdTotalPrice() {
		double r = NormalPaymentActionListener.calculateDvdTotalPrice(5,6);
		assertEquals(r,30);
	}

}
