package com.cadastro.banda.demo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import com.cadastro.banda.demo.document.Banda;
import com.cadastro.banda.demo.document.Pessoa;
import com.cadastro.banda.demo.dto.BandaDto;
import com.cadastro.banda.demo.repository.BandaRepository;
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
public class BandaServiceTest {
    @Mock
    BandaRepository bandaRepository;

    @InjectMocks
    BandaService bandaService;

    @Spy
    ModelMapper modelMapper;
    
    @Mock
    PessoaRepository pessoaRepository;

    BandaDto bandaDto = new BandaDto();
    Banda banda = new Banda();


    Pessoa vocalista = new Pessoa();
    Pessoa baterista = new Pessoa();
    Pessoa guitarrista = new Pessoa();
    Pessoa baixista = new Pessoa();
    

    @Test
    public void aoCadastrarBanda_RetornarTrue(){
    BandaDto bandaDto = new BandaDto();
    vocalista.setNome("teste");
    vocalista.setId(1);
    vocalista.setIdInstrumento(1);
    vocalista.setIdade(27);
    
    baterista.setId(2);
    baterista.setNome("teste2");
    baterista.setIdade(22);
    baterista.setIdInstrumento(0);

    baixista.setId(3);
    baixista.setIdInstrumento(2);
    baixista.setIdade(23);
    baixista.setNome("nome");

    baixista.setId(0);
    baixista.setIdade(55);
    baixista.setIdInstrumento(3);
    baixista.setNome("joaquim");

    Optional<Pessoa> vocalistaOpt = Optional.of(vocalista);
    Optional<Pessoa> guitarristaOpt = Optional.of(guitarrista);
    Optional<Pessoa> baixistaOpt = Optional.of(baixista);
    Optional<Pessoa> bateristaOpt = Optional.of(baterista);

    Mockito.when(pessoaRepository.findById(any())).thenReturn(vocalistaOpt);
    Mockito.when(pessoaRepository.findById(any())).thenReturn(guitarristaOpt);
    Mockito.when(pessoaRepository.findById(any())).thenReturn(baixistaOpt);
    Mockito.when(pessoaRepository.findById(any())).thenReturn(bateristaOpt);

    bandaDto.setAno(2222);
    bandaDto.setIdBaixista(2);
    bandaDto.setIdBaterista(3);
    bandaDto.setId(1);
    bandaDto.setGenero("Rock");
    bandaDto.setBaixista(baixista);
    bandaDto.setGuitarrista(guitarrista);
    bandaDto.setNome("nome");
    assertTrue(bandaService.cadastrarBanda(bandaDto));
    }
}
