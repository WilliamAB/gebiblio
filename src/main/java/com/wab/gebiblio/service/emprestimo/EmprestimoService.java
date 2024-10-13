package com.wab.gebiblio.service.emprestimo;

import com.wab.gebiblio.entity.emprestimo.Emprestimo;
import com.wab.gebiblio.application.exception.GeBiblioException;
import com.wab.gebiblio.entity.emprestimo.EmprestimoStatus;
import com.wab.gebiblio.entity.livro.Livro;
import com.wab.gebiblio.repository.emprestimo.EmprestimoRepository;
import com.wab.gebiblio.validator.emprestimo.EmprestimoValidator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviço para operações e consultas relacionadas a empréstimos de livros.
 */
@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Autowired
	private EmprestimoValidator emprestimoValidator;

	/**
	 * Consulta um empréstimo a partir do id.
	 *
	 * @param idEmprestimo o id de {@link Emprestimo}
	 * @return um {@link Optional} como resultado da consulta
	 */
	@Transactional(readOnly = true)
	public Optional<Emprestimo> consultar(Long idEmprestimo) {
		return emprestimoRepository.findById(idEmprestimo);
	}

	/**
	 * Salva um empréstimo, em inclusão ou atualização.
	 *
	 * @param emprestimo o empréstimo que será inserido/atualizado
	 * @return o empréstimo salvo
	 * @throws GeBiblioException retorna a exceção caso ocorrem erros nas regras de negócio
	 */
	@Transactional
	public Emprestimo salvar(Emprestimo emprestimo) throws GeBiblioException {

		// Faz a validação do empréstimo antes de salvar
		emprestimoValidator.validate(emprestimo);

		return emprestimoRepository.save(emprestimo);
	}

	/**
	 * Deleta um empréstimo a partir do id.
	 *
	 * @param idEmprestimo o id de {@link Emprestimo}
	 */
	@Transactional
	public void deletar(Long idEmprestimo) {
		emprestimoRepository.deleteById(idEmprestimo);
	}

	/**
	 * Verifica se existe um empréstimo ativo para um determinado livro.
	 *
	 * @param idLivro o id do {@link Livro}
	 * @return se existe o empréstimo
	 */
	@Transactional(readOnly = true)
	public boolean existeEmprestimoAtivo(Long idLivro) {
		return emprestimoRepository.existsByLivroIdAndStatus(idLivro, EmprestimoStatus.EMPRESTADO);
	}

}
