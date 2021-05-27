package com.cadastro.banda.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @Getter @Setter private int id;
    @Getter @Setter private String nome;
    @Getter @Setter private int idade;
    @Getter @Setter private int idInstrumento;
}
