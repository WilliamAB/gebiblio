package com.wab.gebiblio.service.livro;

import com.wab.gebiblio.entity.livro.Livro;
import com.wab.gebiblio.entity.usuario.Usuario;
import com.wab.gebiblio.repository.livro.LivroRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviço para operações e consultas relacionadas a livros.
 */
@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	/**
	 * Consulta um livro a partir do id.
	 *
	 * @param idLivro o id de {@link Livro}
	 * @return um {@link Optional} como resultado da consulta
	 */
	@Transactional(readOnly = true)
	public Optional<Livro> consultar(Long idLivro) {
		return livroRepository.findById(idLivro);
	}

	/**
	 * Salva um livro, em inclusão ou atualização.
	 *
	 * @param livro o livro que será inserido/atualizado
	 * @return o livro salvo
	 */
	@Transactional
	public Livro salvar(Livro livro) {
		return livroRepository.save(livro);
	}

	/**
	 * Deleta um livro a partir do id.
	 *
	 * @param idLivro o id de {@link Livro}
	 */
	@Transactional
	public void deletar(Long idLivro) {
		livroRepository.deleteById(idLivro);
	}

	/**
	 * Sugere uma lista de livros para o usuário informado.
	 * São livros com a mesma categoria dos livros já emprestados e que já não tenham sido emprestados.
	 *
	 * @param idUsuario o id de {@link Usuario}
	 * @return uma lista de livros sugeridos
	 */
	@Transactional(readOnly = true)
	public List<Livro> sugerirLivros(Long idUsuario) {
		return livroRepository.findSugestaoUsuario(idUsuario);
	}

}
