package com.mmenezes.springbootrelacional.api.services;

import java.util.Optional;

import com.mmenezes.springbootrelacional.entity.Categoria;

public interface CategoriaService {
	
	public Optional<Categoria> buscar(Integer id);

}
