package com.spring.hexagonal.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    public String getZipCode() {
        return zipCode;
    }

    @NotBlank
    private String zipCode;
    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
}
