package com.spring.hexagonal.config;

import com.spring.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.spring.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.spring.hexagonal.application.core.usecase.DeleteCustomerByIdUseCasa;
import com.spring.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {
    @Bean
    public DeleteCustomerByIdUseCasa deleteCustomerByIdUseCasa(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ){
        return new DeleteCustomerByIdUseCasa(findCustomerByIdUseCase,deleteCustomerByIdAdapter);
    }
}
