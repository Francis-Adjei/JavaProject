package Interface;
import Class.Customer;

import java.util.ArrayList;


public interface IBranch {
    public String getName();
    public ArrayList<Customer> getCustomers();
    public boolean newCustomer(String customerName, double initialTransaction);
    public boolean addCustomerTransaction(String customerName, double transaction);
}
