package com.wab.gebiblio.repository.emprestimo;

import com.wab.gebiblio.entity.emprestimo.Emprestimo;
import com.wab.gebiblio.entity.emprestimo.EmprestimoStatus;
import com.wab.gebiblio.entity.livro.Livro;
import com.wab.gebiblio.repository.BaseRepository;

import org.springframework.stereotype.Repository;

/**
 * Repositório de dados de empréstimo.
 */
@Repository
public interface EmprestimoRepository extends BaseRepository<Emprestimo> {

	/**
	 * Consulta que verifica se existe um empréstimo para um livro com determinado status.
	 *
	 * @param livroId o id do {@link Livro}
	 * @param status o status do empréstimo
	 * @return se existe o empréstimo
	 */
	boolean existsByLivroIdAndStatus(Long livroId, EmprestimoStatus status);

}
