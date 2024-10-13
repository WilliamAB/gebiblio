package com.wab.gebiblio.validator.usuario;

import com.wab.gebiblio.entity.usuario.Usuario;
import com.wab.gebiblio.validator.AbstractValidator;
import com.wab.gebiblio.validator.BaseRule;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Validador que define as regras de negócio que devem executar para o cadastro de usuário.
 */
@Service
public class UsuarioValidator extends AbstractValidator<Usuario> {

	@Override
	protected void addRules(List<Class<? extends BaseRule<Usuario>>> rules) {
		rules.add(UsuarioDataCadastroRule.class);
	}

}
