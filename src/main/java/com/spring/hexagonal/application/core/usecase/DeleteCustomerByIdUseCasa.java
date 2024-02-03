package com.spring.hexagonal.application.core.usecase;

import com.spring.hexagonal.application.ports.in.DeleteCustomerByIdInPort;
import com.spring.hexagonal.application.ports.in.FindCustomerByIdInPort;
import com.spring.hexagonal.application.ports.out.DeleteCustomerByIdOutPort;

public class DeleteCustomerByIdUseCasa implements DeleteCustomerByIdInPort{

    private final FindCustomerByIdInPort findCustomerByIdInPort;

    private final DeleteCustomerByIdOutPort deleteCustomerByIdOutPort;

    public DeleteCustomerByIdUseCasa(
            FindCustomerByIdInPort findCustomerByIdInPort,
            DeleteCustomerByIdOutPort deleteCustomerByIdOutPort
    ){
        this.findCustomerByIdInPort = findCustomerByIdInPort;
        this.deleteCustomerByIdOutPort = deleteCustomerByIdOutPort;
    }

    @Override
    public void delete(String id){
        this.findCustomerByIdInPort.find(id);
        this.deleteCustomerByIdOutPort.delete(id);

    }
}
