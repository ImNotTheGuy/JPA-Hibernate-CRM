package org.example;

import org.example.dao.CustomerDao;
import org.example.entity.Customer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AppTest 
{
    @Test
    public void createCustomer()
    {
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDao.create(customer);

        assertTrue( true );
    }

    @Test
    public void findById(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDao.create(customer);

        Customer customer1 = CustomerDao.findById(customer.getId());
        assertEquals("Alain", customer1.getFirstName());
    }

    @Test
    public void dontFindById() {
        Customer customer = CustomerDao.findById(5);
        assertNull(customer);
    }

    @Test
    public void findAll() {

        CustomerDao.create(new Customer("Marie"));
        CustomerDao.create(new Customer("Michel"));
        CustomerDao.create(new Customer("Alex"));

        List<Customer> customers = CustomerDao.findAll();
        assertEquals(3, customers.size());
    }

    @Test
    public void deleteCustomer(){
        Customer marie = new Customer("Marie");
        CustomerDao.create(marie);

        List<Customer> customers = CustomerDao.findAll();
        assertEquals(1, customers.size());

        CustomerDao.delete(marie);

        customers = CustomerDao.findAll();
        assertEquals(0, customers.size());
    }

    @Test
    public void deleteCustomerById(){
        Customer customer = new Customer();
        customer = CustomerDao.findById(13L);

        CustomerDao.deleteCustomerById(13L);
        assertNull(CustomerDao.findById(13L));

    }
}
