package com.example.maktabdarsliklari.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookProjection {
   private Integer id;
   private String name,class_enum, language;
   private String description;
   private String authors;
}
