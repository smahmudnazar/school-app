package com.example.maktabdarsliklari.repository;

import com.example.maktabdarsliklari.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book,Integer> {
//
//    @Query(value = "select * from book",nativeQuery = true)
//    List<Book> getAllBooks();

    List<Book> findByGroupIdAndLanguageId(Integer groupId,Integer languageId);
    List<Book> findAllByActiveTrue();
    Optional<Book> findByIdAndActiveTrue(Integer id);

//    @Query(nativeQuery = true,value = "select * from books;")
//    List<BookProjection> findAllBooks();
//    Optional<Book> findById(Integer id);

}
