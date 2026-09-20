package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dto.CustomerDTO;
import com.project.hotelmgmt.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void addCustomer(CustomerDTO customerDTO){
        System.out.println("from Customer service addCustomer method");
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO){
        System.out.println("from Customer service updateCustomer method");
    }

    @Override
    public void deleteCustomer(String customerId){
        System.out.println("from Customer service deleteCustomer method");
    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId){
        System.out.println("from customer service getSelectedCustomer method");
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers(){
        System.out.println("from customer service getAllCustomer method");
        return List.of();
    }
}
