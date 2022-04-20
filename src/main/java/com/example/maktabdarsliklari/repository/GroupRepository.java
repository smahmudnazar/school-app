package com.example.maktabdarsliklari.repository;

import com.example.maktabdarsliklari.entity.Group;
import com.example.maktabdarsliklari.entity.enums.ClassEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Integer> {
    Optional<Group> findByGroups(ClassEnum group);

    @Query(nativeQuery = true,value = "select c.id ,c.groups from language\n" +
            "    join books b on language.id = b.language_id\n" +
            "    join classes c on c.id = b.group_id where language.id =:id ;")
    List<Group> findAllByLanguage(Integer id);







}
