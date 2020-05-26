package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer codigoLibro;
	
	@NotEmpty(message="El titulo no puede estar vacio")
	@Size(message="El titulo del libro no debe tener mas de 500 caracteres", max=500)
	@Column(name="s_titulo")
	private String tituloLibro;
	
	@NotEmpty(message="El autor no puede estar vacio")
	@Size(message="El autor del libro no debe tener mas de 150 caracteres", max=150)
	@Column(name="s_autor")
	private String autorLibro;
	
	@NotEmpty(message="El isbn no puede estar vacio")
	@Size(message="El isbn del libro no debe tener mas de 10 caracteres", max=10)
	@Column(name="s_isbn")
	private String isbnLibro;


	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer categoriaLibro;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name="f_ingreso")
	private Date fechaIngreso;
	
	
	@Column(name="b_estado")
	private Boolean estadoLibro;	
	
	public Libro() {
		
	}
	
	public String getEstadoDelegate() {
		if(this.estadoLibro == null)return"";
		else {
			return estadoLibro == true?"Activo":"Inactivo";
		}
	}

	public Integer getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public String getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}

	public String getIsbnLibro() {
		return isbnLibro;
	}

	public void setIsbnLibro(String isbnLibro) {
		this.isbnLibro = isbnLibro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getCategoriaLibro() {
		return categoriaLibro;
	}

	public void setCategoriaLibro(Integer categoriaLibro) {
		this.categoriaLibro = categoriaLibro;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Boolean getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(Boolean estadoLibro) {
		this.estadoLibro = estadoLibro;
	}
	
	
	

}
