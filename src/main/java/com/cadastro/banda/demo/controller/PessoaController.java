package com.cadastro.banda.demo.controller;

import java.util.Optional;

import com.cadastro.banda.demo.document.Pessoa;
import com.cadastro.banda.demo.dto.PessoaDto;
import com.cadastro.banda.demo.repository.PessoaRepository;
import com.cadastro.banda.demo.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping
    public PessoaDto cadastrarPessoa(@RequestBody PessoaDto pessoaDto){
        pessoaService.salvarCadastro(pessoaDto);
        return pessoaDto;
    }

    @GetMapping(path = "/{id}")
    public Optional<Pessoa> buscarPessoa(@PathVariable int id){
        return pessoaRepository.findById(id);
    }

}
