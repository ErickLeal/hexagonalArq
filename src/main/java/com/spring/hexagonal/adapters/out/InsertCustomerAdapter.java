package com.spring.hexagonal.adapters.out;

import com.spring.hexagonal.adapters.out.repository.CustomerRepository;
import com.spring.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.spring.hexagonal.application.core.domain.Customer;
import com.spring.hexagonal.application.ports.out.InsertCustomerOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Override
    public void insert(Customer customer) {
        var customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
        this.customerRepository.save(customerEntity);
    }
}
