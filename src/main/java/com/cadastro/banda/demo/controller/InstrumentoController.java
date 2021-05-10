package com.cadastro.banda.demo.controller;

import com.cadastro.banda.demo.dto.InstrumentoDto;
import com.cadastro.banda.demo.service.InstrumentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/instrumento"})
public class InstrumentoController {

    @Autowired
    InstrumentoService instrumentoService;
    @PostMapping
    public InstrumentoDto cadastrarInstrumento(@RequestBody InstrumentoDto instrumentoDto){
        return instrumentoService.cadastrarInstrumento(instrumentoDto);
    }
}
