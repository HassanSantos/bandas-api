package com.cadastro.banda.demo.document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
public class Instrumento {
    @Id
    @Getter @Setter private int id;
    @Getter @Setter private String nome;
}
