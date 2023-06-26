package com.example.jbornreceivemessages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

import static java.util.Collections.emptySet;

@Entity
@Table(name = "word")
@Data
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String value;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "data")
    @Column(name = "date_receive")
    private Set<String> date = emptySet();
}
