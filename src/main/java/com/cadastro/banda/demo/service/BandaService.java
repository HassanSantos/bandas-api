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

            Pessoa pessoa = pessoaRepository.findById(bandaDto.getIdBaixista()).get();

            Banda banda;
            bandaDto.setBaterista(pessoa);
            banda = modelMapper.map(bandaDto, Banda.class);
            bandaRepository.save(banda);
            return true;
    }


    public Optional<Banda> buscarBanda(int id) {
        Optional<Banda> banda = bandaRepository.findById(id);
        return banda;
    }

    public List<Banda> findByNome(String nome){
        var banda = bandaRepository.findByNome(nome);
        return banda;
    }
}