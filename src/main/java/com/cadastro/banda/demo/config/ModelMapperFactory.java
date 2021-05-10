package com.cadastro.banda.demo.config;
import org.modelmapper.ModelMapper;

public class ModelMapperFactory {
    public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
