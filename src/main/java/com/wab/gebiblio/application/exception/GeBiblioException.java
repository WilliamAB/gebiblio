package com.wab.gebiblio.application.exception;

import java.util.List;

/**
 * Classe que representa a exceção que pode ocorrer na aplicação, por validações de regras de negócio.
 */
public class GeBiblioException extends Exception {

	private final List<GeBiblioValidationError> erros;

	public GeBiblioException(List<GeBiblioValidationError> erros) {
		this.erros = erros;
	}

	public List<GeBiblioValidationError> getErros() {
		return erros;
	}

}
