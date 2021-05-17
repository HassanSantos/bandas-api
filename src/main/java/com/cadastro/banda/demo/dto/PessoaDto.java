package com.cadastro.banda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {
    private int id;
    private String nome;
    private int idade;
    private int idInstrumento;
}
