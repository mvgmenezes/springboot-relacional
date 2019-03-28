package com.mmenezes.springbootrelacional.api.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmenezes.springbootrelacional.api.services.CategoriaService;
import com.mmenezes.springbootrelacional.entity.Categoria;

@RestController
@RequestMapping(value="/api/categorias")
public class CategoriaResource {
 
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Categoria>> findById(@PathVariable Integer id) {
		return ResponseEntity.ok(categoriaService.buscar(id));
	}
	
}
