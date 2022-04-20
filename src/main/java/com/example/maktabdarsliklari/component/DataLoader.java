package com.example.maktabdarsliklari.component;

import com.example.maktabdarsliklari.entity.Book;
import com.example.maktabdarsliklari.entity.Group;
import com.example.maktabdarsliklari.entity.Language;
import com.example.maktabdarsliklari.entity.User;
import com.example.maktabdarsliklari.entity.enums.ClassEnum;
import com.example.maktabdarsliklari.entity.enums.LanguageEnum;
import com.example.maktabdarsliklari.entity.enums.RoleEnum;
import com.example.maktabdarsliklari.repository.BookRepository;
import com.example.maktabdarsliklari.repository.GroupRepository;
import com.example.maktabdarsliklari.repository.LanguageRepository;
import com.example.maktabdarsliklari.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;
    final BookRepository bookRepository;
    final LanguageRepository languageRepository;
    final GroupRepository groupRepository;


    @Value("${spring.sql.init.mode}")
    String mode;


    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")) {


            User admin=new User("admin", passwordEncoder.encode("admin"), RoleEnum.ADMIN);
            User user=new User("user", passwordEncoder.encode("user"), RoleEnum.USER);

            userRepository.save(admin);
            userRepository.save(user);

            Group group1 = groupRepository.save(new Group(ClassEnum.FIRST));
            Group group2 = groupRepository.save(new Group(ClassEnum.SECOND));
            Group group3 = groupRepository.save(new Group(ClassEnum.THIRD));


            Language english = languageRepository.save(new Language(LanguageEnum.ENGLISH));
            Language russian = languageRepository.save(new Language(LanguageEnum.RUSSIAN));
            Language uzbek = languageRepository.save(new Language(LanguageEnum.UZBEK));

            bookRepository.save(new Book("Algebra",english,group1,"Zor kitob","Abdulla Oripov"));
            bookRepository.save(new Book("Matamatika",russian,group3,"Zor kitob","Abdulla Oripov"));
            bookRepository.save(new Book("Uzbek tili",uzbek,group2,"Zor kitob","Abdulla Oripov"));


        }
    }
}
