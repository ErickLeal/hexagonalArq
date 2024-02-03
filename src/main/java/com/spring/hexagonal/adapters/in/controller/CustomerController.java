package com.spring.hexagonal.adapters.in.controller;

import com.spring.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.spring.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.spring.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.spring.hexagonal.application.core.domain.Customer;
import com.spring.hexagonal.application.ports.in.DeleteCustomerByIdInPort;
import com.spring.hexagonal.application.ports.in.FindCustomerByIdInPort;
import com.spring.hexagonal.application.ports.in.InsertCustomerInPort;
import com.spring.hexagonal.application.ports.in.UpdateCustomerInPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private InsertCustomerInPort insertCustomerInPort;

    @Autowired
    private FindCustomerByIdInPort findCustomerByIdInPort;

    @Autowired
    private UpdateCustomerInPort updateCustomerInPort;

    @Autowired
    private DeleteCustomerByIdInPort deleteCustomerByIdInPort;


    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = this.customerMapper.toCustomer(customerRequest);
        this.insertCustomerInPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = this.findCustomerByIdInPort.find(id);
        var customerResponse = this.customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok().body(customerResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable final String id,
            @Valid @RequestBody CustomerRequest customerRequest
    ){
        Customer customer = this.customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        this.updateCustomerInPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        this.deleteCustomerByIdInPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
