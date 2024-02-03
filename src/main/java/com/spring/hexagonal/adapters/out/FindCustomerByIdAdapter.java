package com.spring.hexagonal.adapters.out;

import com.spring.hexagonal.adapters.out.repository.CustomerRepository;
import com.spring.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.spring.hexagonal.application.core.domain.Customer;
import com.spring.hexagonal.application.ports.out.FindCustomerByIdOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
       var customerEntity = this.customerRepository.findById(id);
       return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
