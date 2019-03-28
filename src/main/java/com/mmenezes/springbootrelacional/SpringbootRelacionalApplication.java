package com.mmenezes.springbootrelacional;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mmenezes.springbootrelacional.api.repository.CategoriaRepository;
import com.mmenezes.springbootrelacional.api.repository.ProdutoRepository;
import com.mmenezes.springbootrelacional.entity.Categoria;
import com.mmenezes.springbootrelacional.entity.Produto;

@SpringBootApplication
public class SpringbootRelacionalApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRelacionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 400.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);
		
		//categoria tem uma lista de produtos
		cat1.getListProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getListProdutos().addAll(Arrays.asList(prod2));
		
		//um produto tem uma lista de categorias
		prod1.getListCategorias().addAll(Arrays.asList(cat1));
		prod2.getListCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getListCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3)); 
		
	}
	
	
}
