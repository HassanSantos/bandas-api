package com.cadastro.banda.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cadastro.banda.demo.document.Pessoa;
import com.cadastro.banda.demo.dto.PessoaDto;
import com.cadastro.banda.demo.repository.PessoaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class PessoaServiceTest {

    @Spy
    ModelMapper modelMapper;

    @InjectMocks
    PessoaService pessoaService;

    @Mock
    PessoaRepository pessoaRepository; 

    @Test
    public void passarPessoa_retornarTrue(){
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setId(1);
        pessoaDto.setNome("nome");
        pessoaDto.setIdade(26);
        pessoaDto.setIdInstrumento(1);
        assertEquals(pessoaDto ,pessoaService.salvarCadastro(pessoaDto));

    }

    public  void passarPessoa_retornarExcetion(){
    }

}
