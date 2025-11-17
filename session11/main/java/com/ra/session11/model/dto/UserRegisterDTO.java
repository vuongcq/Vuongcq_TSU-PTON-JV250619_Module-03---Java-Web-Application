package com.ra.session11.model.dto;


import com.ra.session11.validator.UniquyeUsername;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisterDTO {
    @NotBlank
    @UniquyeUsername(message = "username existed")
    private String username;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;
    private MultipartFile avatar ;
}
