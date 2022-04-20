package com.example.maktabdarsliklari.service;

import com.example.maktabdarsliklari.dto.ApiResponse;
import com.example.maktabdarsliklari.entity.Group;
import com.example.maktabdarsliklari.entity.Language;
import com.example.maktabdarsliklari.repository.BookRepository;
import com.example.maktabdarsliklari.repository.GroupRepository;
import com.example.maktabdarsliklari.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatisticService {
    final BookRepository bookRepository;
    final GroupRepository groupRepository;
    final LanguageRepository languageRepository;


    public ApiResponse getGroupsByLanguage(Integer id) {
        List<Group> allByLanguage = groupRepository.findAllByLanguage(id);
        return new ApiResponse("Mana",true,allByLanguage);
    }
}
