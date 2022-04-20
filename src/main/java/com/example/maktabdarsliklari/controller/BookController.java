package com.example.maktabdarsliklari.controller;

import com.example.maktabdarsliklari.dto.ApiResponse;
import com.example.maktabdarsliklari.dto.BookDTO;
import com.example.maktabdarsliklari.entity.Book;
import com.example.maktabdarsliklari.repository.BookRepository;
import com.example.maktabdarsliklari.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {


   private final BookRepository bookRepository;
   private final BookService bookService;


    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(bookRepository.findAll());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
//        Optional<Book> bookOptional = bookRepository.findByIdAndActiveTrue(id);
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) return ResponseEntity.notFound().build();
        bookRepository.delete(bookOptional.get());

        return ResponseEntity.ok().body("Deleted");
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    private ResponseEntity<?> getOne(@PathVariable Integer id){
        System.out.println(id);
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(bookOptional.get());

//        return ResponseEntity.ok().body(bookRepository.getById(id));


    }


    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> add(@ModelAttribute BookDTO book){
        ApiResponse apiResponse = bookService.save(book);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id,@RequestBody BookDTO book){
        ApiResponse apiResponse = bookService.edit(id, book);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

}
