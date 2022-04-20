package com.example.maktabdarsliklari.controller;

import com.example.maktabdarsliklari.dto.ApiResponse;
import com.example.maktabdarsliklari.entity.Book;
import com.example.maktabdarsliklari.repository.BookRepository;
import com.example.maktabdarsliklari.repository.GroupRepository;
import com.example.maktabdarsliklari.repository.LanguageRepository;
import com.example.maktabdarsliklari.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatisticController {
    final BookRepository bookRepository;
    final GroupRepository groupRepository;
    final LanguageRepository languageRepository;
    final StatisticService statisticService;

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/groups/{id}")
    public ResponseEntity<?> getGroupsByLanguage(@PathVariable Integer id){
        ApiResponse groupsByLanguage = statisticService.getGroupsByLanguage(id);
        return ResponseEntity.ok().body(groupsByLanguage);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/{gr_id}/{lang_id}")
//    @GetMapping("/?group_id={gr_id}&language_id={lang_id}")
    public ResponseEntity<?> findByGroupIdAndLanguageId(@PathVariable Integer gr_id,@PathVariable Integer lang_id){
        List<Book> byGroupIdAndLanguageId = bookRepository.findByGroupIdAndLanguageId(gr_id, lang_id);
        return ResponseEntity.ok().body(byGroupIdAndLanguageId);
    }



}
