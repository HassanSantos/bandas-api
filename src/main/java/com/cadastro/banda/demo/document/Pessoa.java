package com.cadastro.banda.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
public class Pessoa {
    @Id
    @Getter @Setter private int id;
    @Getter @Setter private String nome;
    @Getter @Setter private int idade;
    @Getter @Setter private int idInstrumento;
}
