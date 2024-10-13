package com.wab.gebiblio.controller.usuario;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import com.wab.gebiblio.application.ApplicationUrlPattern;
import com.wab.gebiblio.application.exception.GeBiblioException;
import com.wab.gebiblio.dto.usuario.UsuarioAtualizacaoDTO;
import com.wab.gebiblio.dto.usuario.UsuarioCriacaoDTO;
import com.wab.gebiblio.dto.usuario.UsuarioDTO;
import com.wab.gebiblio.entity.usuario.Usuario;
import com.wab.gebiblio.mapper.usuario.UsuarioMapper;
import com.wab.gebiblio.service.usuario.UsuarioService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller onde são disponibilizados endpoints para operações com usuários.
 */
@RestController
@RequestMapping(UsuarioController.ENDPOINT)
public class UsuarioController {

	public static final String ENDPOINT = ApplicationUrlPattern.API_V1 + "/usuario";

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioMapper usuarioMapper;

	@GetMapping("/{usuarioId}")
	@Operation(summary = "Consulta um usuário")
	public ResponseEntity<UsuarioDTO> consultar(@PathVariable Long usuarioId) {

		Optional<Usuario> usuarioOpt = usuarioService.consultar(usuarioId);

		if (usuarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		UsuarioDTO dto = usuarioMapper.convertToDTO(usuarioOpt.get());

		return ResponseEntity.ok(dto);
	}

	@PostMapping
	@Operation(summary = "Cria um usuário")
	public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioCriacaoDTO dto) throws GeBiblioException {

		Usuario entity = usuarioMapper.convertToEntityCriacao(dto);

		entity = usuarioService.salvar(entity);

		UsuarioDTO dtoCriado = usuarioMapper.convertToDTO(entity);

		return ResponseEntity.ok(dtoCriado);
	}

	@PutMapping("/{usuarioId}")
	@Operation(summary = "Atualiza um usuário")
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long usuarioId, @Valid @RequestBody UsuarioAtualizacaoDTO dto) throws GeBiblioException {

		Optional<Usuario> optEntity = usuarioService.consultar(usuarioId);

		if (optEntity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Usuario entity = optEntity.get();

		usuarioMapper.convertToEntityAtualizacao(entity, dto);

		entity = usuarioService.salvar(entity);

		UsuarioDTO dtoAtualizado = usuarioMapper.convertToDTO(entity);

		return ResponseEntity.ok(dtoAtualizado);
	}

	@DeleteMapping("/{usuarioId}")
	@Operation(summary = "Deleta um usuário")
	public ResponseEntity<?> deletar(@PathVariable Long usuarioId) {
		usuarioService.deletar(usuarioId);
		return ResponseEntity.ok().build();
	}

}
