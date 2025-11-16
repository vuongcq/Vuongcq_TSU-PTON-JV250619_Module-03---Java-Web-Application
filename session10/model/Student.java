package com.ra.session10.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name = "Student")
public class Student {
    @Id
    @Column(name = "student_id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "student_name", nullable = false)
    @NotBlank (message = "Tên không được để trống")
    private String studentName;

    @Column(name = "email", nullable = false)
    @Email
    @NotBlank(message = "Email không được để trống")
    private String email;

    @Positive(message = "Điểm số phải lớn hơn 0")
    @NotNull(message = "Điểm số không được để trống")
    @Column(name = "age_mark", nullable = false)
    private Float ageMark;

    private Boolean isStudying;

}
