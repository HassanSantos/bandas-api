package com.cadastro.banda.demo.repository;

import com.cadastro.banda.demo.document.Instrumento;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstrumentoRepository extends MongoRepository<Instrumento, Integer>{
    
}
