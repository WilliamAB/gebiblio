package com.wab.gebiblio.validator.emprestimo;

import com.wab.gebiblio.application.exception.GeBiblioValidationError;
import com.wab.gebiblio.entity.emprestimo.Emprestimo;
import com.wab.gebiblio.validator.BaseRule;
import com.wab.gebiblio.validator.CodeRule;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Regra que impede de fazer um empréstimo com data maior que a data corrente.
 */
@Service
public class EmprestimoDataEmprestimoRule implements BaseRule<Emprestimo> {

	@Override
	public void validate(List<GeBiblioValidationError> erros, Emprestimo entity) {

		if (entity.getDataEmprestimo() != null
				&& entity.getDataEmprestimo().isAfter(LocalDate.now())) {

			erros.add(new GeBiblioValidationError(CodeRule.getCodeEmprestimoDataEmprestimo(),
					"Data de empréstimo não pode ser maior que a data atual."));
		}
	}

}
