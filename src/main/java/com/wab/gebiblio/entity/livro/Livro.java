package com.wab.gebiblio.entity.livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.wab.gebiblio.entity.BaseEntity;

import java.time.LocalDate;

/**
 * Representa um livro.
 */
@Entity
@Table(name = "livro")
public class Livro extends BaseEntity {

	@Column(name = "ds_titulo", nullable = false)
	private String titulo;

	@Column(name = "ds_autor", nullable = false)
	private String autor;

	@Column(name = "ds_isbn", nullable = false)
	private String isbn;

	@Column(name = "dt_publicacao", nullable = false)
	private LocalDate dataPublicacao;

	@Column(name = "ds_categoria", nullable = false)
	private String categoria;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
