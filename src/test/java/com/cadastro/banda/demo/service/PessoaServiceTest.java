package com.cadastro.banda.demo.service;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import com.cadastro.banda.demo.DemoApplication;
import com.cadastro.banda.demo.document.Pessoa;
import com.cadastro.banda.demo.dto.PessoaDto;
import com.cadastro.banda.demo.exceptions.BandaException;
import com.cadastro.banda.demo.repository.PessoaRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS) 
public class PessoaServiceTest {

    @Spy  
    ModelMapper modelMapper;

    @InjectMocks  
    PessoaService pessoaService;

    @Mock 
    PessoaRepository pessoaRepository;

    PessoaDto pessoaDto = new PessoaDto();
    Pessoa pessoa = new Pessoa();

    @BeforeAll
    public void setup(){
        pessoaDto.setId(1);
        pessoaDto.setNome("nome");
        pessoaDto.setIdade(26);
        pessoaDto.setIdInstrumento(1);

        pessoa.setId(1);
        pessoa.setNome("nome");
        pessoa.setIdade(26);
        pessoa.setIdInstrumento(1);
       
    }

    @Test
    public void passarPessoa_retornarTrue() {
        Mockito.doCallRealMethod().when(modelMapper).map(pessoaDto, Pessoa.class);
        assertNotNull(pessoaDto, pessoaService.salvarCadastro(pessoaDto));

    }

    @Test
    public void passarPessoa_retornarExcetion() {
        MappingException mappingException = new MappingException(new ArrayList<>());
        Mockito.when(modelMapper.map(pessoaDto, Pessoa.class)).thenThrow(mappingException);
        assertThrows(BandaException.class, () -> pessoaService.salvarCadastro(pessoaDto));
    }
    @Test
    public void aoChamarMetodoSalvarPessoa(){
        pessoaService.salvarCadastroPessoa(pessoa);
        verify(pessoaRepository, times(1)).save(pessoa);
    }
    @Test
    public void aoChamarMetodoSalvar_RetornarException(){
        Pessoa pessoa = new Pessoa();
        Optional<Pessoa> pessoaOpt = Optional.of(pessoa);
        Mockito.when(pessoaRepository.findByNome(any())).thenReturn(pessoaOpt);
        assertFalse(pessoaService.salvarCadastroPessoa(pessoa));
    }   

    @Test
    public void aoPassarId_retornarPessoa() {
        Optional<Pessoa> pessoaOpt = Optional.of(pessoa);
        when(pessoaRepository.findById(any())).thenReturn(pessoaOpt);
        Mockito.doCallRealMethod().when(modelMapper).map(pessoaOpt, Pessoa.class);
        assertNotNull(pessoaService.buscarPessoa(1));
    }

    @Test
    public void aoPassarId_retornarException() {
        Optional<Pessoa> pessoaOpt = Optional.of(pessoa);
        Mockito.when(pessoaRepository.findById(any())).thenReturn(pessoaOpt);
        MappingException mappingException = new MappingException(new ArrayList<>());
        Mockito.when(modelMapper.map(pessoaOpt, PessoaDto.class)).thenThrow(mappingException);
        assertThrows(BandaException.class, () -> pessoaService.buscarPessoa(1));
    }

}
