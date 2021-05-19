package com.cadastro.banda.demo.service;

import java.util.Optional;


import com.cadastro.banda.demo.document.Pessoa;
import com.cadastro.banda.demo.dto.PessoaDto;
import com.cadastro.banda.demo.exceptions.BandaException;
import com.cadastro.banda.demo.repository.PessoaRepository;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.modelmapper.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ModelMapper modelMapper;

    public PessoaDto salvarCadastro(PessoaDto pessoaDto) throws BandaException {
        try {
            Pessoa pessoa;
            pessoa = modelMapper.map(pessoaDto, Pessoa.class);
            pessoaRepository.save(pessoa);
            return pessoaDto;
        } catch (IllegalArgumentException | ConfigurationException | MappingException e) {
            throw new BandaException(ExceptionUtils.getMessage(e));
        }

    }

    public Optional<Pessoa> buscarPessoa(int id) {
        return pessoaRepository.findById(id);
    }
}
