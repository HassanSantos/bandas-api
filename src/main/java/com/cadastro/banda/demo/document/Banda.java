package com.cadastro.banda.demo.document;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
public class Banda {
    @Id 
    @Getter@Setter private int id;
    @Getter@Setter private String nome;
    @Getter@Setter private int ano;
    @Getter@Setter private String genero;
    @Getter@Setter private int idVocalista;
    @Getter@Setter private int idBaterista;
    @Getter@Setter private int idGuitarrista;
    @Getter@Setter private int idBaixista;
    @Getter@Setter private Pessoa baterista;
    @Getter@Setter private Pessoa guitarrista;
    @Getter@Setter private Pessoa vocalista;
    @Getter@Setter private Pessoa baixista;
}
