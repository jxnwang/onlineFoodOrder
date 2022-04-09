package com.laioffer.onlinefoodorder.service;

import com.laioffer.onlinefoodorder.dao.CustomerDao;
import com.laioffer.onlinefoodorder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//this is a controller of logic tier
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void signUp(Customer customer) {
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}
