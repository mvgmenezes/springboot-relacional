package com.mmenezes.springbootrelacional.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmenezes.springbootrelacional.api.repository.CategoriaRepository;
import com.mmenezes.springbootrelacional.api.services.CategoriaService;
import com.mmenezes.springbootrelacional.entity.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRespository;
	
	@Override
	public Optional<Categoria> buscar(Integer id) {
		return categoriaRespository.findById(id);
	}

}
