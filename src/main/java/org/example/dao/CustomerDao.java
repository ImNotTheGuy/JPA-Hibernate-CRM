package org.example.dao;

import org.example.entity.Customer;
import org.example.hibernate.EntityManagerSingleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CustomerDao {

    public static void create(Customer customerToCreate){

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(customerToCreate);
        entityTransaction.commit();
    }

    public static Customer findById(Long id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityTransaction.commit();
        return customer;
    }
}
