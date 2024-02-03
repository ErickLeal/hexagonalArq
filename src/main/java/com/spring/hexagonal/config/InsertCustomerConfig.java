package com.spring.hexagonal.config;

import com.spring.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.spring.hexagonal.adapters.out.InsertCustomerAdapter;
import com.spring.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.spring.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
