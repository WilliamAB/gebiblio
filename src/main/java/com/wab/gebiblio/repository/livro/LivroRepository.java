package com.wab.gebiblio.repository.livro;

import com.wab.gebiblio.entity.livro.Livro;
import com.wab.gebiblio.repository.BaseRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositório de dados de livro.
 */
@Repository
public interface LivroRepository extends BaseRepository<Livro> {

	@Query(value = """
			select l.* from livro l
				where exists (select 0 from emprestimo e inner join livro el on el.id = e.livro_id where e.usuario_id = :usuarioId and l.ds_categoria = el.ds_categoria)
				and not exists (select 0 from emprestimo e where e.livro_id = l.id and e.usuario_id = :usuarioId)
			""", nativeQuery = true)
	List<Livro> findSugestaoUsuario(Long usuarioId);

}
