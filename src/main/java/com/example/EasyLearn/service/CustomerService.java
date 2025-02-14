package com.example.EasyLearn.service;

import com.example.EasyLearn.exception.EntityNotFoundException;
import com.example.EasyLearn.model.Customer;
import com.example.EasyLearn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

      CustomerRepository customerRepository;

    @Autowired
    public CustomerService (CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        //return customerRepository.findAll();
        return customerRepository.findAllByOrderByFirstNameAsc();
    }
    public Customer findCustomer(long id){
        Optional<Customer> result = customerRepository.findById( id);
        Customer customer = null;
        if(result.isPresent()){
            customer = result.get();
        }
        else{
            throw new EntityNotFoundException("Customer with id=" + id + " not found.");
        }
        return customer;
    }
    public void saveCustomer (Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomer(long id){
        Optional<Customer> result = customerRepository.findById(id);
        if(result.isPresent()){
            customerRepository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Customer with id=" + id + " not found.");
           // throw new EntityNotFoundException("Customer with id=" + id + " not found.");
        }
    }

}
