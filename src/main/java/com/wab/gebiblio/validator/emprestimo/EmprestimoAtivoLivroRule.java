package com.wab.gebiblio.validator.emprestimo;

import com.wab.gebiblio.application.exception.GeBiblioValidationError;
import com.wab.gebiblio.entity.emprestimo.Emprestimo;
import com.wab.gebiblio.service.emprestimo.EmprestimoService;
import com.wab.gebiblio.validator.BaseRule;
import com.wab.gebiblio.validator.CodeRule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Regra que impede de fazer um empréstimo se o livro já está emprestado.
 */
@Service
public class EmprestimoAtivoLivroRule implements BaseRule<Emprestimo> {

	@Autowired
	private EmprestimoService emprestimoService;

	@Override
	public void validate(List<GeBiblioValidationError> erros, Emprestimo entity) {

		if (entity.getLivro() == null
				|| entity.getUsuario() == null) {
			return;
		}

		if (emprestimoService.existeEmprestimoAtivo(entity.getLivro().getId())) {
			erros.add(new GeBiblioValidationError(CodeRule.getCodeEmprestimoAtivoLivro(),
					"Empréstimo não autorizado, pois o livro %s possui empréstimo ativo".formatted(entity.getLivro().getTitulo())));
		}
	}

}
