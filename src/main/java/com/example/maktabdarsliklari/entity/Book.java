package com.example.maktabdarsliklari.entity;

import com.example.maktabdarsliklari.entity.enums.ClassEnum;
import com.example.maktabdarsliklari.entity.enums.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    private Language language;

    @ManyToOne
    private Group group;


    private String description;

    private String authors;

    private boolean active=true;

    @ManyToOne(cascade = CascadeType.ALL)
    private Attachment img;

    @ManyToOne(cascade = CascadeType.ALL)
    private Attachment file;

    public Book(String name, Language language, Group group, String description, String authors) {
        this.name = name;
        this.language = language;
        this.group = group;
        this.description = description;
        this.authors = authors;
    }
}
