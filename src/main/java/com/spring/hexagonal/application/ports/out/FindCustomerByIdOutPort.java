package com.spring.hexagonal.application.ports.out;

import com.spring.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutPort {

    Optional<Customer> find(String id);

}
