package com.wab.gebiblio.validator.emprestimo;

import com.wab.gebiblio.entity.emprestimo.Emprestimo;
import com.wab.gebiblio.validator.AbstractValidator;
import com.wab.gebiblio.validator.BaseRule;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Validador que define as regras de negócio que devem executar para o empréstimo.
 */
@Service
public class EmprestimoValidator extends AbstractValidator<Emprestimo> {

	@Override
	protected void addRules(List<Class<? extends BaseRule<Emprestimo>>> rules) {
		rules.add(EmprestimoAtivoLivroRule.class);
		rules.add(EmprestimoDataEmprestimoRule.class);
	}

}
