package com.wab.gebiblio.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Representação DTO de uma criação de usuário.
 */
public class UsuarioCriacaoDTO {

	@NotBlank(message = "Nome é obrigatório.")
	private String nome;

	@Email(message = "E-mail inválido.")
	@NotBlank(message = "E-mail é obrigatório.")
	private String email;

	@NotNull(message = "Data de cadastro é obrigatória.")
	private LocalDate dataCadastro;

	@NotNull(message = "Telefone é obrigatório.")
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
