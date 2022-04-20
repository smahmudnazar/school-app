package com.example.maktabdarsliklari.service;

import com.example.maktabdarsliklari.dto.ApiResponse;
import com.example.maktabdarsliklari.dto.BookDTO;
import com.example.maktabdarsliklari.entity.Attachment;
import com.example.maktabdarsliklari.entity.Book;
import com.example.maktabdarsliklari.entity.Group;
import com.example.maktabdarsliklari.entity.Language;
import com.example.maktabdarsliklari.repository.BookRepository;
import com.example.maktabdarsliklari.repository.GroupRepository;
import com.example.maktabdarsliklari.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    final BookRepository bookRepository;
    final LanguageRepository languageRepository;
    final GroupRepository groupRepository;

    @SneakyThrows
    public ApiResponse save(BookDTO bookDTO) {
        Book book=new Book();
        book.setName(bookDTO.getName());
        book.setDescription(bookDTO.getDescription());
        book.setAuthors(bookDTO.getAuthors());

        Optional<Group> byGroup = groupRepository.findById(bookDTO.getClass_id());
        if (byGroup.isEmpty()) {
            return new ApiResponse("Group not found",false);
        }

        Optional<Language> byLanguageEnum = languageRepository.findById(bookDTO.getLanguage_id());
        if (byLanguageEnum.isEmpty()) {
            return new ApiResponse("Language not found",false);
        }

        Attachment img=new Attachment();
        img.setName(bookDTO.getImg().getOriginalFilename());
        img.setContentType(bookDTO.getImg().getContentType());
        img.setSize(bookDTO.getImg().getSize());
        img.setBytes(bookDTO.getImg().getBytes());

        book.setImg(img);

        Attachment file=new Attachment();
        file.setName(bookDTO.getFile().getOriginalFilename());
        file.setContentType(bookDTO.getFile().getContentType());
        file.setSize(bookDTO.getFile().getSize());
        file.setBytes(bookDTO.getFile().getBytes());

        book.setFile(file);

        book.setLanguage(byLanguageEnum.get());
        book.setGroup(byGroup.get());

        bookRepository.save(book);

        return new ApiResponse("Added!",true);
    }


    @SneakyThrows
    public ApiResponse edit(Integer id, BookDTO bookDTO) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) return new ApiResponse("Not found",false);

        Book book = bookOptional.get();
        book.setAuthors(bookDTO.getAuthors());
        book.setDescription(bookDTO.getDescription());
        book.setName(bookDTO.getName());

        Optional<Group> byGroup = groupRepository.findById(bookDTO.getClass_id());
        if (byGroup.isEmpty()) {
            return new ApiResponse("Group not found",false);
        }

        Optional<Language> byLanguageEnum = languageRepository.findById(bookDTO.getLanguage_id());
        if (byLanguageEnum.isEmpty()) {
            return new ApiResponse("Language not found",false);
        }

        Attachment img=new Attachment();
        img.setName(bookDTO.getImg().getOriginalFilename());
        img.setContentType(bookDTO.getImg().getContentType());
        img.setSize(bookDTO.getImg().getSize());
        img.setBytes(bookDTO.getImg().getBytes());

        book.setImg(img);

        Attachment file=new Attachment();
        file.setName(bookDTO.getFile().getOriginalFilename());
        file.setContentType(bookDTO.getFile().getContentType());
        file.setSize(bookDTO.getFile().getSize());
        file.setBytes(bookDTO.getFile().getBytes());

        book.setFile(file);

        book.setLanguage(byLanguageEnum.get());
        book.setGroup(byGroup.get());

        bookRepository.save(book);

        return new ApiResponse("Edited",true);
    }
}
