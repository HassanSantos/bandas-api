package com.cadastro.banda.demo.repository;

import com.cadastro.banda.demo.document.Pessoa;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PessoaRepository extends MongoRepository<Pessoa, Integer> {
    Pessoa findByNome(String nome);
}
