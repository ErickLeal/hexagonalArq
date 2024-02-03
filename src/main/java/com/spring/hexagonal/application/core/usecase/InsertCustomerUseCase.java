package com.spring.hexagonal.application.core.usecase;

import com.spring.hexagonal.application.core.domain.Customer;
import com.spring.hexagonal.application.ports.in.InsertCustomerInPort;
import com.spring.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import com.spring.hexagonal.application.ports.out.InsertCustomerOutPort;
import com.spring.hexagonal.application.ports.out.SendCpfForValidationOutPort;

public class InsertCustomerUseCase implements InsertCustomerInPort {

    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;
    private final InsertCustomerOutPort insertCustomerOutPort;

    private final SendCpfForValidationOutPort sendCpfForValidationOutPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutPort findAddressByZipCodeOutPort,
             InsertCustomerOutPort insertCustomerOutPort,
            SendCpfForValidationOutPort sendCpfForValidationOutPort
    ){
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.insertCustomerOutPort = insertCustomerOutPort;
        this.sendCpfForValidationOutPort = sendCpfForValidationOutPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = this.findAddressByZipCodeOutPort.find(zipCode);
        customer.setAddress(address);
        this.insertCustomerOutPort.insert(customer);
        sendCpfForValidationOutPort.send(customer.getCpf());
    }
}
