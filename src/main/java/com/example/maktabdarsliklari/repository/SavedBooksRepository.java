package com.example.maktabdarsliklari.repository;

import com.example.maktabdarsliklari.entity.SavedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedBooksRepository extends JpaRepository<SavedBooks,Integer> {
}
