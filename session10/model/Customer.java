package com.ra.session10.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Customer", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone")
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Username không được để trống.")
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min = 6, message = "Mật khẩu từ 6 ký tự trở lên ")
    @NotBlank (message = "Mật khẩu không được để trống")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Column(name = "phone", nullable = false)
    @Pattern(
            regexp = "^(03|05|07|08|09)\\d{8}$",
            message = "Số điện thoại phải bắt đầu bằng 03|05|07|08|09 và có đủ 10 số"
    )
    private  String phone;

    @Column(name = "status", nullable = false)
    private Boolean status = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
}

