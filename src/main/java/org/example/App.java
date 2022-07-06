package org.example;


import org.example.dao.CustomerDao;
import org.example.entity.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Customer customer = new Customer();

        customer.setFirstName("Test firstName");
        customer.setLastName("Test lastName");

        CustomerDao.create(customer);

    }
}
