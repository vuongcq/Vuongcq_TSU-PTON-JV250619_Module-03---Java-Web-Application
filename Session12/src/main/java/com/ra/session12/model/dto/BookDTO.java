package com.ra.session12.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDTO {
    @NotBlank(message = "title can not blank")
    private String title;

    @NotBlank(message = "author can not blank")
    private String author;

    @NotNull(message = "price can not null")
    @Min(1)
    private Double price;

    @NotNull(message = "publishYear can not null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishYear;


    private MultipartFile image;
}
