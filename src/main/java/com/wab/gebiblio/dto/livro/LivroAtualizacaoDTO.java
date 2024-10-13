package com.wab.gebiblio.dto.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Representação DTO de uma atualização de livro.
 */
public class LivroAtualizacaoDTO {

	@NotBlank(message = "Título é obrigatório.")
	private String titulo;

	@NotBlank(message = "Autor é obrigatório.")
	private String autor;

	@NotBlank(message = "ISBN é obrigatório.")
	private String isbn;

	@NotNull(message = "Data de publicação é obrigatória.")
	private LocalDate dataPublicacao;

	@NotBlank(message = "Categoria é obrigatória.")
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
