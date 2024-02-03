package com.spring.hexagonal.adapters.out;

import com.spring.hexagonal.adapters.out.repository.CustomerRepository;
import com.spring.hexagonal.application.ports.out.DeleteCustomerByIdOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
