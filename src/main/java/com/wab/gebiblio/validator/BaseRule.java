package com.wab.gebiblio.validator;

import com.wab.gebiblio.application.exception.GeBiblioValidationError;
import com.wab.gebiblio.entity.BaseEntity;

import java.util.List;

/**
 * Interface que define uma regra de negócio do sistema.
 */
public interface BaseRule<E extends BaseEntity> {

	/**
	 * Executa a validação da regra de negócio.
	 */
	void validate(List<GeBiblioValidationError> erros, E entity);

}
