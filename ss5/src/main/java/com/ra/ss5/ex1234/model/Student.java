package com.ra.ss5.ex1234.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private Long id;
    private String studentName;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // Định dạng ngày
    private LocalDate birthday;
    private double avgMark;
}
