package com.cadastro.banda.demo.dto;

import java.util.Optional;

import com.cadastro.banda.demo.document.Pessoa;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BandaDto {
    private int id;
    private String nome;
    private String genero;
    private int ano;
    public int idVocalista;
    public int idBaterista;
    public int idGuitarrista;
    public int idBaixista;
    private Pessoa baterista;
    private Pessoa baixista;
    private Pessoa vocalista;
    private Pessoa guitarrista;
}
