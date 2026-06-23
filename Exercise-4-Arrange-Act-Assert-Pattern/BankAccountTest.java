import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount("Navin", 1000.0);
        System.out.println("setUp: Account created with balance 1000");
    }

    @After
    public void tearDown() {
        account = null;
        System.out.println("tearDown: Account destroyed\n");
    }

    @Test
    public void testDeposit() {
        double depositAmount = 500.0;

        account.deposit(depositAmount);

        assertEquals(1500.0, account.getBalance(), 0.001);
        System.out.println("testDeposit passed!");
    }

    @Test
    public void testWithdraw() {

        double withdrawAmount = 200.0;

        account.withdraw(withdrawAmount);

        assertEquals(800.0, account.getBalance(), 0.001);
        System.out.println("testWithdraw passed!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientBalance() {
        double bigAmount = 9999.0;

        account.withdraw(bigAmount);

        System.out.println("testWithdrawInsufficientBalance passed!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDeposit() {
        double invalidAmount = -100.0;

        account.deposit(invalidAmount);
    }

    @Test
    public void testOwnerName() {

        String owner = account.getOwner();

        assertEquals("Navin", owner);
        assertNotNull(owner);
        System.out.println("testOwnerName passed!");
    }
}