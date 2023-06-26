package com.example.jbornreceivemessages.service;

import com.example.jbornreceivemessages.entity.Word;
import com.example.jbornreceivemessages.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository repository;

    public void SaveWordInDataBase(String str) {
        Set<String> dateSet = new HashSet<>();
        String timeStamp = new SimpleDateFormat("dd MMMM yyyy, HH:mm:ss").format(Calendar.getInstance().getTime());
        dateSet.add(timeStamp);

        Word word = new Word();
        word.setValue(str);
        word.setDate(dateSet);
        if (word.getValue() != null) {
            repository.save(word);
        }
    }
}
