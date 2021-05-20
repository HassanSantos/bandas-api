package com.cadastro.banda.demo.service;

import com.cadastro.banda.demo.document.Pessoa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.cadastro.banda.demo.dto.PessoaDto;
import com.cadastro.banda.demo.exceptions.BandaException;
import com.cadastro.banda.demo.repository.PessoaRepository;
import java.lang.StackWalker.Option;
import org.modelmapper.MappingException;
import java.util.ArrayList;
import java.util.Optional;

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
    public void passarPessoa_retornarTrue() {
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setId(1);
        pessoaDto.setNome("nome");
        pessoaDto.setIdade(26);
        pessoaDto.setIdInstrumento(1);
        assertEquals(pessoaDto, pessoaService.salvarCadastro(pessoaDto));

    }

    @Test
    public  void passarPessoa_retornarExcetion(){
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setId(1);
        pessoaDto.setNome("nome");
        pessoaDto.setIdade(26);
        pessoaDto.setIdInstrumento(1);
        MappingException mappingException = new MappingException(new ArrayList<>());
        Mockito.when(modelMapper.map(pessoaDto, Pessoa.class)).thenThrow(mappingException);
        assertThrows(BandaException.class, () ->  pessoaService.salvarCadastro(pessoaDto));
    }

    @Test
    public void aoPassarId_retornarPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        pessoa.setIdade(25);
        pessoa.setNome("Ozzy");
        pessoa.setIdInstrumento(1);

        Optional <Pessoa> pessoaOpt = Optional.of(pessoa);

        when(pessoaRepository.findById(any())).thenReturn(pessoaOpt);
        assertNotNull(pessoaService.buscarPessoa(1));
    }

    @Test
    public void aoPassarId_retornarException(){
        
    }

}
