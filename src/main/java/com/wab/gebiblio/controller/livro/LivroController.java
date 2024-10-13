package com.wab.gebiblio.controller.livro;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import com.wab.gebiblio.application.ApplicationUrlPattern;
import com.wab.gebiblio.dto.livro.LivroAtualizacaoDTO;
import com.wab.gebiblio.dto.livro.LivroCriacaoDTO;
import com.wab.gebiblio.dto.livro.LivroDTO;
import com.wab.gebiblio.entity.livro.Livro;
import com.wab.gebiblio.mapper.livro.LivroMapper;
import com.wab.gebiblio.service.livro.LivroService;
import com.wab.gebiblio.service.usuario.UsuarioService;

import java.util.List;
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
 * Controller onde são disponibilizados endpoints para operações com livros.
 */
@RestController
@RequestMapping(LivroController.ENDPOINT)
public class LivroController {

	public static final String ENDPOINT = ApplicationUrlPattern.API_V1 + "/livro";

	@Autowired
	private LivroService livroService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private LivroMapper livroMapper;

	@GetMapping("/{livroId}")
	@Operation(summary = "Consulta um livro")
	public ResponseEntity<LivroDTO> consultar(@PathVariable Long livroId) {

		Optional<Livro> livroOpt = livroService.consultar(livroId);

		if (livroOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		LivroDTO dto = livroMapper.convertToDTO(livroOpt.get());

		return ResponseEntity.ok(dto);
	}

	@PostMapping
	@Operation(summary = "Cria um livro")
	public ResponseEntity<LivroDTO> criar(@Valid @RequestBody LivroCriacaoDTO dto) {

		Livro entity = livroMapper.convertToEntityCriacao(dto);

		entity = livroService.salvar(entity);

		LivroDTO dtoCriado = livroMapper.convertToDTO(entity);

		return ResponseEntity.ok(dtoCriado);
	}

	@PutMapping("/{livroId}")
	@Operation(summary = "Atualiza um livro")
	public ResponseEntity<LivroDTO> atualizar(@PathVariable Long livroId, @Valid @RequestBody LivroAtualizacaoDTO dto) {

		Optional<Livro> optEntity = livroService.consultar(livroId);

		if (optEntity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Livro entity = optEntity.get();

		livroMapper.convertToEntityAtualizacao(entity, dto);

		entity = livroService.salvar(entity);

		LivroDTO dtoAtualizado = livroMapper.convertToDTO(entity);

		return ResponseEntity.ok(dtoAtualizado);
	}

	@DeleteMapping("/{livroId}")
	@Operation(summary = "Deleta um livro")
	public ResponseEntity<?> deletar(@PathVariable Long livroId) {
		livroService.deletar(livroId);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/sugerir/{usuarioId}")
	@Operation(summary = "Sugere livros para o usuário",
			description = "Sugere livros conforme a categoria de livros já emprestados, sem apresentar os livros já emprestados.")
	public ResponseEntity<List<LivroDTO>> sugerirLivros(@PathVariable Long usuarioId) {

		if (!usuarioService.existe(usuarioId)) {
			return ResponseEntity.notFound().build();
		}

		List<Livro> entitys = livroService.sugerirLivros(usuarioId);

		List<LivroDTO> dtos = entitys.stream().map(livroMapper::convertToDTO).toList();

		return ResponseEntity.ok(dtos);
	}

}
