package listener;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProcessPaymentActionListenerTest {

	

	@Test
	public void testSumSilverDiscountPrice() {
		double r = ProcessPaymentActionListener.sumSilverDiscountPrice(10, 60);
		assertEquals(r,54);
	}
	
	@Test
	public void testSumGoldDiscountPrice() {
		double r = ProcessPaymentActionListener.sumGoldDiscountPrice(15,47);
		assertEquals(r,39.95);
	}
	
	@Test
	public void testSumTotalPrice() {
		double r = ProcessPaymentActionListener.sumTotalPrice(10, 60);
		assertEquals(r,70);
	}
}