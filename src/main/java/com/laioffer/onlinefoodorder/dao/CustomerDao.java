package com.laioffer.onlinefoodorder.dao;

import com.laioffer.onlinefoodorder.entity.Customer;
import org.springframework.stereotype.Repository;

import com.laioffer.onlinefoodorder.entity.Authorities;
import org.hibernate.Criteria;
import org.hibernate.Session;
// this is the central API class abstracting the notion of
//a persistence service, the main function of the Session is to offer create,
//read and delete operations for instances of mapped entity classes.
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(customer.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();
            //Transaction is used to make operations of multiple tables as one atomic process
            //if one fails, will delete the others succeeded

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
            //some failed, delete others
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Customer getCustomer(String email) {
        Customer customer = null;
        try (Session session = sessionFactory.openSession()) {
            //put these in () to auto close
            customer = session.get(Customer.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }
}

