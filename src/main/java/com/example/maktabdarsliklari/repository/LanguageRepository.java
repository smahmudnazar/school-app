package com.example.maktabdarsliklari.repository;

import com.example.maktabdarsliklari.entity.Language;
import com.example.maktabdarsliklari.entity.enums.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language,Integer> {

    Optional<Language>findByLanguageEnum(LanguageEnum name);
}
