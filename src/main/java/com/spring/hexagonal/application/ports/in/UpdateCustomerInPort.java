package com.spring.hexagonal.application.ports.in;

import com.spring.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInPort {

    void update(Customer customer, String zipCode);
}
