package com.example.jbornreceivemessages.repository;

import com.example.jbornreceivemessages.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
