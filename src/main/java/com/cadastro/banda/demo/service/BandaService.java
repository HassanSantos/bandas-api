package com.cadastro.banda.demo.service;


import com.cadastro.banda.demo.document.Banda;
import com.cadastro.banda.demo.dto.BandaDto;
import com.cadastro.banda.demo.exceptions.BandaException;
import com.cadastro.banda.demo.repository.BandaRepository;
import com.cadastro.banda.demo.repository.PessoaRepository;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
        try {
            Banda banda;
            generateBanda(bandaDto);
            banda = modelMapper.map(bandaDto, Banda.class);
            bandaRepository.save(banda);
            return true;

        } catch (IllegalArgumentException | ConfigurationException | MappingException e) {
            throw new BandaException(ExceptionUtils.getMessage(e));
        }
    }

    private void generateBanda(BandaDto bandaDto) {
        bandaDto.setBaixista(pessoaRepository.findById(bandaDto.getIdBaixista()).get());
        bandaDto.setVocalista(pessoaRepository.findById(bandaDto.getIdVocalista()).get());
        bandaDto.setGuitarrista(pessoaRepository.findById(bandaDto.getIdGuitarrista()).get());
        bandaDto.setBaterista(pessoaRepository.findById(bandaDto.getIdBaterista()).get());
    }

    public BandaDto buscarBandaPorId(int id) throws BandaException {
        try {
            Banda banda = bandaRepository.findById(id);
            BandaDto bandaDto = new BandaDto();
            bandaDto = modelMapper.map(banda, BandaDto.class);
            return bandaDto;
        } catch (IllegalArgumentException | ConfigurationException | MappingException e) {
            throw new BandaException(ExceptionUtils.getMessage(e));
        }

    }
}