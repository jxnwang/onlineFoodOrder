package com.laioffer.onlinefoodorder.dao;

import com.laioffer.onlinefoodorder.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
//this is a controller of data tier
public class CustomerDao {

    public void signUp(Customer customer) {
    }

    public Customer getCustomer(String email) {
        return new Customer();
    }


}
