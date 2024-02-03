package com.spring.hexagonal.application.core.usecase;

import com.spring.hexagonal.application.core.domain.Customer;
import com.spring.hexagonal.application.ports.in.FindCustomerByIdInPort;
import com.spring.hexagonal.application.ports.out.FindCustomerByIdOutPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInPort {

    private final FindCustomerByIdOutPort findCustomerByIdOutPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutPort findCustomerByIdOutPort){
        this.findCustomerByIdOutPort = findCustomerByIdOutPort;
    }

    @Override
    public Customer find(String id){
        return this.findCustomerByIdOutPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        
    }
}
