package com.wab.gebiblio.dto.emprestimo;

import jakarta.validation.constraints.NotNull;

import com.wab.gebiblio.entity.emprestimo.EmprestimoStatus;

import java.time.LocalDate;

/**
 * Representação DTO de uma criação de empréstimo.
 */
public class EmprestimoCriacaoDTO {

	@NotNull(message = "Data de empréstimo é obrigatória.")
	private LocalDate dataEmprestimo;

	@NotNull(message = "Data de devolução é obrigatória.")
	private LocalDate dataDevolucao;

	@NotNull(message = "Status é obrigatório.")
	private EmprestimoStatus status;

	@NotNull(message = "Usuário é obrigatório.")
	private Long usuarioId;

	@NotNull(message = "Livro é obrigatório.")
	private Long livroId;

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public EmprestimoStatus getStatus() {
		return status;
	}

	public void setStatus(EmprestimoStatus status) {
		this.status = status;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getLivroId() {
		return livroId;
	}

	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}

}
