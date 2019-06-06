package listener;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ProcessPaymentActionListenerTest.class, NormalPaymentActionListenerTest.class})
public class AllTests {

}
