package com.cadastro.banda.demo.controller;

import java.lang.StackWalker.Option;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import com.cadastro.banda.demo.document.Banda;
import com.cadastro.banda.demo.dto.BandaDto;
import com.cadastro.banda.demo.service.BandaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/banda")
public class BandaController {
    @Autowired
    BandaService bandaService;

    @PostMapping
    public Boolean cadastrarBanda(@RequestBody BandaDto banda){
        return bandaService.cadastrarBanda(banda);
    }

    @GetMapping(path = "/{id}")
    public BandaDto buscarBanda(@PathVariable int id){
        return bandaService.buscarBandaPorId(id);
    }

    @GetMapping(path = "/nome/{nome}")
    public List<Banda> buscarBandaPeloNome(@PathVariable(value="nome") String nome){
        return bandaService.findByNome(nome);
    }
}
