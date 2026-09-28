package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dao.CustomerDao;
import com.project.hotelmgmt.dto.CustomerDTO;
import com.project.hotelmgmt.dto.HotelDTO;
import com.project.hotelmgmt.entity.BookingEntity;
import com.project.hotelmgmt.entity.CustomerEntity;
import com.project.hotelmgmt.exceptions.BookingsExistInHotelException;
import com.project.hotelmgmt.exceptions.CustomerNotFoundException;
import com.project.hotelmgmt.service.CustomerService;
import com.project.hotelmgmt.util.EntityDTOConvert;
import com.project.hotelmgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        System.out.println("from customer service addCustomer method");
        customerDTO.setCustomerId(UtilData.generateCustomerId());
        customerDao.save(entityDTOConvert.convertCustomerDTOToCustomerEntity(customerDTO));
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        System.out.println("from customer service updateCustomer method");
        CustomerEntity customerEntity = customerDao.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));

        customerEntity.setCustomerName(customerDTO.getCustomerName());
        customerEntity.setNIC(customerDTO.getNIC());
        customerEntity.setAge(customerDTO.getAge());

        customerDao.save(customerEntity);
    }

    @Override
    public void deleteCustomer(String customerId) {
        System.out.println("from customer service deleteCustomer method");
        CustomerEntity customerEntity = customerDao.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
        List<BookingEntity> bookings=customerEntity.getBookings();
        if (!bookings.isEmpty()){
            throw new BookingsExistInHotelException("Customer cannot be deleted,Bookings Exists");
        }
        customerDao.delete(customerEntity);
    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        System.out.println("from customer service getSelectedCustomer method");
        CustomerEntity customerEntity = customerDao.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
        CustomerDTO customerDTO=entityDTOConvert.convertCustomerEntityToCustomerDTO(customerEntity);
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        System.out.println("from customer service getAllCustomers method");
        List<CustomerEntity> customerEntityList = customerDao.findAll();
        List<CustomerDTO> customerDTOS=entityDTOConvert.convertCustomerEntityListToCustomerDTOList(customerEntityList);
        return customerDTOS;
    }
}