package Class;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    private Bank bank;


    @Before
    public void setUp() throws Exception {
        bank = new Bank("National Australia Bank");
        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 1745.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide","Tim",44.22);
        bank.addCustomerTransaction("Adelaide","Tim",12.44);
        bank.addCustomerTransaction("Adelaide","Tim",1.65);

        bank.addCustomerTransaction("Cape Coast","Francis",170);

    }

    @Test
    public void testTestAddBranch() {
        // All fields are valid; return True
        assertTrue(bank.addBranch("Accra"));

        // branchName:"Adelaide" (Branch already exist in the list of branches); return False
        assertFalse(bank.addBranch("Adelaide"));

    }

    @Test
    public void testTestAddCustomer() {
        bank.addBranch("Cape Coast");
        // All fields are valid; return True
        assertTrue(bank.addCustomer("Cape Coast","Kweku",20));

        // branchName: Bolgatanga (Name of branch not in the list of branches); return False
        assertFalse(bank.addCustomer("Bolgatanga", "Yaw", 30));

        // customerName: Time (Name of customer already in the list of customers); return False
        assertFalse(bank.addCustomer("Adelaide", "Tim", 30));

    }

    @Test
    public void testTestAddCustomerTransaction() {
        bank.addBranch("Kumasi");
        bank.addCustomer("Kumasi", "Kofi", 2500.05);

        // All fields are valid
        assertTrue(bank.addCustomerTransaction("Kumasi","Kofi",100));

        // branchName:"Tema" (Name of branch not in the list of branches); return False
        assertFalse(bank.addCustomerTransaction("Tema","Kofi",100));

        // customerName:"Dave" (classes.Customer not in the list of customers for Cape Coast branch); return False
        assertFalse(bank.addCustomerTransaction("Kumasi","Dave",100));

    }
   @Test
    public void testTestListCustomers() {
       // branchName:Adelaide (Branch exists in the list branches); return True
       assertTrue(bank.listCustomers("Adelaide",false));

       // branchName:Takwa (Branch does not exist in the list branches); return false
       assertFalse(bank.listCustomers("Takwa",false));

       // Prints customers with their transactions in the Adelaide branch
       bank.listCustomers("Adelaide",true);

       // Prints customers without their transactions in the Adelaide branch
       bank.listCustomers("Adelaide",false);


       bank = new Bank("GCB");
       bank.addBranch("Bongo");

       // Prints nothing since branch has no customers
       bank.listCustomers("Bongo",true);
    }
}