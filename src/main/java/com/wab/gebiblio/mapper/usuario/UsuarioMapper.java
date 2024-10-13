package com.wab.gebiblio.mapper.usuario;

import com.wab.gebiblio.dto.usuario.UsuarioAtualizacaoDTO;
import com.wab.gebiblio.dto.usuario.UsuarioCriacaoDTO;
import com.wab.gebiblio.dto.usuario.UsuarioDTO;
import com.wab.gebiblio.entity.usuario.Usuario;

import org.springframework.stereotype.Service;

/**
 * Classe responsável por transformações entidade X DTO de usuário.
 */
@Service
public class UsuarioMapper {

	/**
	 * Converte uma entidade em DTO.
	 */
	public UsuarioDTO convertToDTO(Usuario entity) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setEmail(entity.getEmail());
		dto.setDataCadastro(entity.getDataCadastro());
		dto.setTelefone(entity.getTelefone());
		return dto;
	}

	/**
	 * Converte um DTO em entidade.
	 */
	public Usuario convertToEntityCriacao(UsuarioCriacaoDTO dto) {
		Usuario entity = new Usuario();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setDataCadastro(dto.getDataCadastro());
		entity.setTelefone(dto.getTelefone());
		return entity;
	}

	/**
	 * Converte um DTO em entidade, quando em atualização.
	 */
	public void convertToEntityAtualizacao(Usuario entity, UsuarioAtualizacaoDTO dto) {
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setDataCadastro(dto.getDataCadastro());
		entity.setTelefone(dto.getTelefone());
	}

}
