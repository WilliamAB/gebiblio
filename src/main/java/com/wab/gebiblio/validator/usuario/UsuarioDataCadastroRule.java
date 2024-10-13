package com.wab.gebiblio.validator.usuario;

import com.wab.gebiblio.application.exception.GeBiblioValidationError;
import com.wab.gebiblio.entity.usuario.Usuario;
import com.wab.gebiblio.validator.BaseRule;
import com.wab.gebiblio.validator.CodeRule;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Regra que impede cadastrar um usuário com data de cadastro maior que a data corrente.
 */
@Service
public class UsuarioDataCadastroRule implements BaseRule<Usuario> {

	@Override
	public void validate(List<GeBiblioValidationError> erros, Usuario entity) {

		if (entity.getDataCadastro() != null
				&& entity.getDataCadastro().isAfter(LocalDate.now())) {

			erros.add(new GeBiblioValidationError(CodeRule.getCodeUsuarioDataCadastro(),
					"Data de cadastro não pode ser maior que a data atual."));
		}
	}

}
