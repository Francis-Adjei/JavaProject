package Class;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BranchTest {
    private Branch branch;
    private Branch branch1;
    private Branch branch2;

    @Before
    public void setUp() throws Exception {
        branch = new Branch("Adelaide");
        branch.newCustomer("Francis",20);
        branch.newCustomer("Bene",40);
    }

    @Test
    public void testTestGetName() {
        // All fields are valid
        assertEquals("Adelaide", branch.getName());
    }

    @Test
    public void testTestGetCustomers() {
        // (classes.Branch Adelaide has two customers: Francis and Bene); expected: 2, actual: 2
        assertEquals(2, branch.getCustomers().size());

        // (classes.Branch Accra has no customers); expected: 0, actual: 0
        assertEquals(0, (new Branch("Accra")).getCustomers().size());
    }

    @Test
    public void testTestNewCustomer() {
        // All fields are valid; return True
        assertTrue(branch.newCustomer("Tedd", 205));
    }

    @Test
    public void testTestAddCustomerTransaction() {
        // All fields are valid
        assertTrue(branch.addCustomerTransaction("Francis",10.4));

        // customerName="Amos" (Does not exist in the list of customers); return False
        assertFalse(branch.addCustomerTransaction("Amos",10.4));
    }
}