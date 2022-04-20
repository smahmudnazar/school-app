package com.example.maktabdarsliklari.entity;

import com.example.maktabdarsliklari.entity.enums.ClassEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "classes")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ClassEnum groups;

    public Group(ClassEnum group) {
        this.groups = group;
    }
}
