package com.spring.hexagonal.application.core.usecase;

import com.spring.hexagonal.application.core.domain.Customer;
import com.spring.hexagonal.application.ports.in.FindCustomerByIdInPort;
import com.spring.hexagonal.application.ports.in.UpdateCustomerInPort;
import com.spring.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import com.spring.hexagonal.application.ports.out.UpdateCustomerOutPort;

public class UpdateCustomerUseCase implements UpdateCustomerInPort {

    private final FindCustomerByIdInPort findCustomerByIdInPort;

    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;

    private final UpdateCustomerOutPort updateCustomerOutPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInPort findCustomerByIdInPort,
            FindAddressByZipCodeOutPort findAddressByZipCodeOutPort,
            UpdateCustomerOutPort updateCustomerOutPort
    ){
        this.findCustomerByIdInPort = findCustomerByIdInPort;
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.updateCustomerOutPort = updateCustomerOutPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        this.findCustomerByIdInPort.find(customer.getId());
        var address = this.findAddressByZipCodeOutPort.find(zipCode);
        customer.setAddress(address);
        this.updateCustomerOutPort.update(customer);
    }
}
