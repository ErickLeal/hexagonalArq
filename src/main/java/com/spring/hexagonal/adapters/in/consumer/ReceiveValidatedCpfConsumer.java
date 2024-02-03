package com.spring.hexagonal.adapters.in.consumer;

import com.spring.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.spring.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.spring.hexagonal.application.ports.in.UpdateCustomerInPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInPort updateCustomerInPort;
    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "hexagonal")
    public void receive(CustomerMessage customerMessage){

        var customer = this.customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInPort.update(customer,customerMessage.getZipCode());
    }

}
