package com.spring.hexagonal.adapters.out;

import com.spring.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.spring.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.spring.hexagonal.application.core.domain.Address;
import com.spring.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
