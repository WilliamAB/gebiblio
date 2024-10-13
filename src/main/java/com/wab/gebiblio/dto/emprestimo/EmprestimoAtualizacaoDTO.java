package com.wab.gebiblio.dto.emprestimo;

import jakarta.validation.constraints.NotNull;

import com.wab.gebiblio.entity.emprestimo.EmprestimoStatus;

import java.time.LocalDate;

/**
 * Representação DTO de uma atualização de empréstimo.
 */
public class EmprestimoAtualizacaoDTO {

	@NotNull(message = "Data de devolução é obrigatória.")
	private LocalDate dataDevolucao;

	@NotNull(message = "Status é obrigatório.")
	private EmprestimoStatus status;

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

}
