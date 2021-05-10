package com.cadastro.banda.demo.service;

import com.cadastro.banda.demo.document.Instrumento;
import com.cadastro.banda.demo.dto.InstrumentoDto;
import com.cadastro.banda.demo.exceptions.BandaException;
import com.cadastro.banda.demo.repository.InstrumentoRepository;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentoService {
    @Autowired
    InstrumentoRepository instrumentoRepository;

    @Autowired
    ModelMapper modelMapper;

    public InstrumentoDto cadastrarInstrumento(InstrumentoDto instrumentoDto) throws BandaException{
        try{
            Instrumento instrumento = new Instrumento();
            instrumento = modelMapper.map(instrumentoDto , Instrumento.class);
            instrumentoRepository.save(instrumento);
            return instrumentoDto;
        }catch (MappingException | org.modelmapper.ConfigurationException | IllegalArgumentException e) {
            throw new BandaException(ExceptionUtils.getMessage(e));
        }
    }
    
}
