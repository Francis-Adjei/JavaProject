package Class;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Francis", 50.00);
        customer.addTransaction(60);
        customer.addTransaction(80.06);
    }

    @Test
    public void testTestGetName() {
        // All fields are valid
        assertEquals("Francis", customer.getName());
    }

    @Test
    public void testTestGetTransactions() {
        //  Object customer has 3 transactions: (50.0,60.0,80.06); returns True
        assertEquals(Arrays.asList(50.0,60.0,80.06), customer.getTransactions());

        // Object has only one transaction in the list of transactions: expected:[500.0], actual: [500.0]
        assertEquals(Arrays.asList(500.0), (new Customer("Kofi", 500)).getTransactions());


        // Object has only one transaction in the list of transactions: expected:[0.0], actual: [0.0]
        assertEquals(Arrays.asList(0.0), (new Customer("Andrew", 0)).getTransactions());

        // Checks the length of the transactions list; expected: 3, actual: 3
        assertEquals(3, customer.getTransactions().size());
    }

    @Test
    public void testTestAddTransaction() {
        // Add transaction = 2000 to customer transactions
        customer.addTransaction(2000);

        // Get size of list of transactions
        int size = customer.getTransactions().size();

        // Checks the last element in the list; expected: 2000, actual: 2000
        assertEquals(2000, customer.getTransactions().get(size-1), 0.01);
    }
}