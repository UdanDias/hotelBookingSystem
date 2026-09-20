package com.project.hotelmgmt.service;

import com.project.hotelmgmt.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    void updateCustomer(String customerId, CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerDTO getSelectedCustomer(String customerId);
    List<CustomerDTO> getAllCustomers();


}
