package com.ra.session12.model.dto;

import com.ra.session12.validator.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDTO {
    @NotBlank(message = "Customer name can not blank")
    private String customerName;

    @UniqueEmail
    @NotBlank(message = "Email can not blank")
    private String email;

    @NotBlank(message = "Password can not blank")
    private String password;

    @NotBlank(message = "Phone can not blank")
    @Pattern(regexp = "^(84|03|05|07|08|09)[0-9]{8}$" , message = "Phone invalid")
    private String phone;
}
