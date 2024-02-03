package com.spring.hexagonal.adapters.out.client.mapper;

import com.spring.hexagonal.adapters.out.client.response.AddressResponse;
import com.spring.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
