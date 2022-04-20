package com.example.maktabdarsliklari.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private String name;
    private Integer class_id,language_id;
    private String description;
    private String authors;
    private MultipartFile img,file;
}
