package com.wab.gebiblio.application.exception;

/**
 * Representa um erro de validação de regra de negócio.
 */
public class GeBiblioValidationError {

	private final Integer codigo;
	private final String mensagem;

	public GeBiblioValidationError(Integer codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

}
