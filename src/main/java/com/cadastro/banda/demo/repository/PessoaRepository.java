package com.cadastro.banda.demo.repository;

import java.util.Optional;

import com.cadastro.banda.demo.document.Pessoa;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PessoaRepository extends MongoRepository<Pessoa, Integer> {
    Optional<Pessoa> findByNome(String nome);
}
