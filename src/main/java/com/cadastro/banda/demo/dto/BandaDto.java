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
    private int ano;
    private int idVocalista;
    private int idBaterista;
    private int idGuitarrista;
    private int idBaixista;
    private Pessoa baterista;
}
