package com.wab.gebiblio.entity.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.wab.gebiblio.entity.BaseEntity;

import java.time.LocalDate;

/**
 * Representa um usuário.
 */
@Entity
@Table(name = "usuario")
public class Usuario extends BaseEntity {

	@Column(name = "ds_nome", nullable = false)
	private String nome;

	@Column(name = "ds_email", nullable = false)
	private String email;

	@Column(name = "dt_cadastro", nullable = false)
	private LocalDate dataCadastro;

	@Column(name = "ds_telefone", nullable = false)
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
