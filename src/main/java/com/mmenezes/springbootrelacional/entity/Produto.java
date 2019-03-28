package com.mmenezes.springbootrelacional.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String nome;
	private Double preco;
	
	//Quando se tem uma lista em cada lado do objeto, Categoria e Produto, deve-se usar o manytomany
	//deve-se ter uma tabela no meio entre as tabelas originais (associativa), onde tem o relacionamento, para isso usa-se o 
	//@JoinTable, onde se diz: 
	// name => nome da tabela associativa
	// joinColums => nome da coluna que tera a chave primaria desta tabela (sempre sera da classe origiem )
	// inverseJoinColums => nome da coluna da outra tabela que será referenciada
	@ManyToMany
	@JoinTable(name= "PRODUTO_CATEGORIA",
			joinColumns = @JoinColumn(name= "produto_id"), 
			inverseJoinColumns = @JoinColumn(name= "categoria_id")
	)
	private List<Categoria> listCategorias = new ArrayList<>();
	
	public Produto() {}

	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Categoria> getListCategorias() {
		return listCategorias;
	}

	public void setListCategorias(List<Categoria> listCategorias) {
		this.listCategorias = listCategorias;
	}
	
	

}
