package com.example.jbornreceivemessages.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import static java.util.Collections.emptySet;

@Entity
@Table(name = "word")
@Data
public class Word {
    @Id
    private Long id;

    @Column
    private String value;

    @ElementCollection(targetClass = LocalDate.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "data")
    @Column(name = "role")
    private Set<LocalDate> date = emptySet();
}
