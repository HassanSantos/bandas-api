package com.cadastro.banda.demo.service;

import java.util.Optional;

import com.cadastro.banda.demo.document.Pessoa;
import com.cadastro.banda.demo.dto.PessoaDto;
import com.cadastro.banda.demo.exceptions.BandaException;
import com.cadastro.banda.demo.repository.PessoaRepository;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ModelMapper modelMapper;

    public String salvarCadastro(PessoaDto pessoaDto) throws BandaException {
        try {
            Pessoa pessoa;
            pessoa = modelMapper.map(pessoaDto, Pessoa.class);
            if (salvarCadastroPessoa(pessoa)) {
                return pessoaDto.getNome() + "foi cadastrado com sucesso";
            }
            return null;

        } catch (IllegalArgumentException | ConfigurationException | MappingException e) {
            throw new BandaException(ExceptionUtils.getMessage(e));
        }
    }

    public Boolean salvarCadastroPessoa(Pessoa pessoa) {
        if (pessoaRepository.findByNome(pessoa.getNome()).isEmpty()) {
            pessoaRepository.save(pessoa);
            return true;
        }
        return false;
    }

    public PessoaDto buscarPessoa(int id) {
        try {
            Optional<Pessoa> pessoa = pessoaRepository.findById(id);
            PessoaDto pessoaDto;
            pessoaDto = modelMapper.map(pessoa, PessoaDto.class);
            return pessoaDto;
        } catch (IllegalArgumentException | ConfigurationException | MappingException e) {
            throw new BandaException(ExceptionUtils.getMessage(e));
        }
    }
}
