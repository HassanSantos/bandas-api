package com.cadastro.banda.demo.service;

import java.lang.StackWalker.Option;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cadastro.banda.demo.document.Banda;
import com.cadastro.banda.demo.document.Pessoa;
import com.cadastro.banda.demo.dto.BandaDto;
import com.cadastro.banda.demo.dto.PessoaDto;
import com.cadastro.banda.demo.exceptions.BandaException;
import com.cadastro.banda.demo.repository.BandaRepository;
import com.cadastro.banda.demo.repository.InstrumentoRepository;
import com.cadastro.banda.demo.repository.PessoaRepository;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.var;

@Component
@Service
public class BandaService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    BandaRepository bandaRepository;

    public Boolean cadastrarBanda(BandaDto bandaDto) throws BandaException {

        Pessoa baixista = pessoaRepository.findById(bandaDto.getIdBaixista()).get();
        Pessoa vocalista = pessoaRepository.findById(bandaDto.getIdVocalista()).get();
        Pessoa guitarrista = pessoaRepository.findById(bandaDto.getIdGuitarrista()).get();
        Pessoa baterista = pessoaRepository.findById(bandaDto.getIdBaterista()).get();

        Banda banda;
        bandaDto.setBaixista(baixista);
        bandaDto.setVocalista(vocalista);
        bandaDto.setGuitarrista(guitarrista);
        bandaDto.setBaterista(baterista);
        banda = modelMapper.map(bandaDto, Banda.class);
        bandaRepository.save(banda);
        return true;
    }

    public BandaDto buscarBandaPorId(int id) {
        Banda banda = bandaRepository.findById(id);
        BandaDto bandaDto = new BandaDto();
        bandaDto = modelMapper.map(banda, BandaDto.class);
        return bandaDto;

    }

    public List<Banda> findByNome(String nome) {
        var banda = bandaRepository.findByNome(nome);
        return banda;
    }
}