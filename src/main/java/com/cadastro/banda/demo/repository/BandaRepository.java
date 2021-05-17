package com.cadastro.banda.demo.repository;

import java.util.List;

import com.cadastro.banda.demo.document.Banda;
import com.cadastro.banda.demo.document.Pessoa;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BandaRepository extends MongoRepository<Banda, Integer> {
    List<Banda> findByNome(String nome);
    Banda findById(int id);
}
