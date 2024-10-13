package com.wab.gebiblio.service.usuario;

import com.wab.gebiblio.application.exception.GeBiblioException;
import com.wab.gebiblio.entity.usuario.Usuario;
import com.wab.gebiblio.repository.usuario.UsuarioRepository;
import com.wab.gebiblio.validator.usuario.UsuarioValidator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviço para operações e consultas relacionadas a usuários.
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioValidator usuarioValidator;

	/**
	 * Consulta um usuário a partir do id.
	 *
	 * @param idUsuario o id de {@link Usuario}
	 * @return um {@link Optional} como resultado da consulta
	 */
	@Transactional(readOnly = true)
	public Optional<Usuario> consultar(Long idUsuario) {
		return usuarioRepository.findById(idUsuario);
	}

	/**
	 * Salva um usuário, em inclusão ou atualização.
	 *
	 * @param usuario o usuário que será inserido/atualizado
	 * @return o usuário salvo
	 * @throws GeBiblioException retorna a exceção caso ocorrem erros nas regras de negócio
	 */
	@Transactional
	public Usuario salvar(Usuario usuario) throws GeBiblioException {

		// Faz a validação do usuário antes de salvar
		usuarioValidator.validate(usuario);

		return usuarioRepository.save(usuario);
	}

	/**
	 * Deleta um usuário a partir do id.
	 *
	 * @param idUsuario o id de {@link Usuario}
	 */
	@Transactional
	public void deletar(Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}

	/**
	 * Retorna se o id do usuário existe.
	 *
	 * @param idUsuario o id de {@link Usuario}
	 * @return se o usuário existe
	 */
	@Transactional(readOnly = true)
	public boolean existe(Long idUsuario) {
		return usuarioRepository.existsById(idUsuario);
	}

}
