package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_categoria")
public class Categoria {
	
	@Id
	@Column(name="c_categoria")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer codigoCategoria;
	
	@NotEmpty(message="El campo nombre no puede estar vacio")
	@Size(message="El nombre de la categoria no debe tener mas de 50 caracteres", max=50)
	@Column(name="s_categoria")
	private String nombreCategoria;
	
	@OneToMany(mappedBy="categoria",fetch = FetchType.EAGER)
	private List<Libro> libros;

	public Categoria() {
	}

	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	

}
