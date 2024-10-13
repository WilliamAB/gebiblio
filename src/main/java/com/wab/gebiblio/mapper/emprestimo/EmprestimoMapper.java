package com.wab.gebiblio.mapper.emprestimo;

import com.wab.gebiblio.dto.emprestimo.EmprestimoAtualizacaoDTO;
import com.wab.gebiblio.dto.emprestimo.EmprestimoCriacaoDTO;
import com.wab.gebiblio.dto.emprestimo.EmprestimoDTO;
import com.wab.gebiblio.entity.emprestimo.Emprestimo;
import com.wab.gebiblio.mapper.livro.LivroMapper;
import com.wab.gebiblio.mapper.usuario.UsuarioMapper;
import com.wab.gebiblio.service.livro.LivroService;
import com.wab.gebiblio.service.usuario.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe responsável por transformações entidade X DTO de empréstimo.
 */
@Service
public class EmprestimoMapper {

	@Autowired
	private LivroMapper livroMapper;

	@Autowired
	private LivroService livroService;

	@Autowired
	private UsuarioMapper usuarioMapper;

	@Autowired
	private UsuarioService usuarioService;

	/**
	 * Converte uma entidade em DTO.
	 */
	public EmprestimoDTO convertToDTO(Emprestimo entity) {
		EmprestimoDTO dto = new EmprestimoDTO();
		dto.setId(entity.getId());
		dto.setDataEmprestimo(entity.getDataEmprestimo());
		dto.setDataDevolucao(entity.getDataDevolucao());
		dto.setLivro(livroMapper.convertToDTO(entity.getLivro()));
		dto.setUsuario(usuarioMapper.convertToDTO(entity.getUsuario()));
		dto.setStatus(entity.getStatus());
		return dto;
	}

	/**
	 * Converte um DTO de criação em entidade.
	 */
	public Emprestimo convertToEntityCriacao(EmprestimoCriacaoDTO dto) {
		Emprestimo entity = new Emprestimo();
		entity.setDataEmprestimo(dto.getDataEmprestimo());
		entity.setDataDevolucao(dto.getDataDevolucao());
		entity.setLivro(livroService.consultar(dto.getLivroId()).orElse(null));
		entity.setUsuario(usuarioService.consultar(dto.getUsuarioId()).orElse(null));
		entity.setStatus(dto.getStatus());
		return entity;
	}

	/**
	 * Converte um DTO de atualização em entidade.
	 */
	public void convertToEntityAtualizacao(Emprestimo entity, EmprestimoAtualizacaoDTO dto) {
		entity.setDataDevolucao(dto.getDataDevolucao());
		entity.setStatus(dto.getStatus());
	}

}
