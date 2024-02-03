package com.spring.hexagonal.application.ports.in;

import com.spring.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInPort {

    void insert (Customer customer, String zipCode);
}
