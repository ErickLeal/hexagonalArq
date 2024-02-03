package com.spring.hexagonal.application.ports.out;

import com.spring.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPort {

    Address find(String zipCode);

}
