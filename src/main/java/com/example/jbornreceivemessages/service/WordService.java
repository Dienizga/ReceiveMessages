package com.example.jbornreceivemessages.service;

import com.example.jbornreceivemessages.entity.Word;
import com.example.jbornreceivemessages.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository repository;

    public Word SaveWordInDataBase(String str) {
        Word word = new Word();
        word.setValue(str);
        if (word.getValue() != null) {
            repository.save(word);
        }
        return word;
    }
}
