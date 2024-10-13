package com.wab.gebiblio.mapper.livro;

import com.wab.gebiblio.dto.livro.LivroAtualizacaoDTO;
import com.wab.gebiblio.dto.livro.LivroCriacaoDTO;
import com.wab.gebiblio.dto.livro.LivroDTO;
import com.wab.gebiblio.entity.livro.Livro;

import org.springframework.stereotype.Service;

/**
 * Classe responsável por transformações entidade X DTO de livro.
 */
@Service
public class LivroMapper {

	/**
	 * Converte uma entidade em DTO.
	 */
	public LivroDTO convertToDTO(Livro entity) {
		LivroDTO dto = new LivroDTO();
		dto.setId(entity.getId());
		dto.setAutor(entity.getAutor());
		dto.setCategoria(entity.getCategoria());
		dto.setIsbn(entity.getIsbn());
		dto.setTitulo(entity.getTitulo());
		dto.setDataPublicacao(entity.getDataPublicacao());
		return dto;
	}

	/**
	 * Converte um DTO em entidade, quando em criação.
	 */
	public Livro convertToEntityCriacao(LivroCriacaoDTO dto) {
		Livro entity = new Livro();
		entity.setAutor(dto.getAutor());
		entity.setCategoria(dto.getCategoria());
		entity.setIsbn(dto.getIsbn());
		entity.setTitulo(dto.getTitulo());
		entity.setDataPublicacao(dto.getDataPublicacao());
		return entity;
	}

	/**
	 * Converte um DTO em entidade, quando em atualização.
	 */
	public void convertToEntityAtualizacao(Livro entity, LivroAtualizacaoDTO dto) {
		entity.setAutor(dto.getAutor());
		entity.setCategoria(dto.getCategoria());
		entity.setIsbn(dto.getIsbn());
		entity.setTitulo(dto.getTitulo());
		entity.setDataPublicacao(dto.getDataPublicacao());
	}

}
