package com.wab.gebiblio.validator;

import com.wab.gebiblio.application.exception.GeBiblioException;
import com.wab.gebiblio.application.exception.GeBiblioValidationError;
import com.wab.gebiblio.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Implementação comum para os validadores de regras de negócio das entidades da aplicação.
 *
 * @param <E> tipagem da entidade que será validada
 */
public abstract class AbstractValidator<E extends BaseEntity> {

	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * Executa as regras de negócio para a entidade.
	 */
	public void validate(E entity) throws GeBiblioException {

		List<Class<? extends BaseRule<E>>> rules = new ArrayList<>();

		addRules(rules);

		List<GeBiblioValidationError> erros = new ArrayList<>();

		for (Class<? extends BaseRule<E>> clazz : rules) {
			applicationContext.getBean(clazz).validate(erros, entity);
		}

		if (!erros.isEmpty()) {
			throw new GeBiblioException(erros);
		}
	}

	/**
	 * Adiciona as classes das regras de negócio que devem ser executadas para a entidade.
	 */
	protected abstract void addRules(List<Class<? extends BaseRule<E>>> rules);

}
