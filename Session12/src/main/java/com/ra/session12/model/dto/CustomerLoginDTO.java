package com.ra.session12.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerLoginDTO {
    @NotBlank(message = "email can not null")
    private String email;

    @NotBlank(message = "password can not null")
    private String password;
}
