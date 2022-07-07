package org.example;

import org.example.dao.CustomerDao;
import org.example.entity.Customer;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Application CRM" );
        Customer customer = new Customer();
        customer.setFirstName("firstName");
        customer.setLastName("lastName");

        CustomerDao.create(customer);


    }
}
