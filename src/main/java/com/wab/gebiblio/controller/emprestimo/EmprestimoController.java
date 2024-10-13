package com.wab.gebiblio.controller.emprestimo;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import com.wab.gebiblio.application.ApplicationUrlPattern;
import com.wab.gebiblio.application.exception.GeBiblioException;
import com.wab.gebiblio.dto.emprestimo.EmprestimoAtualizacaoDTO;
import com.wab.gebiblio.dto.emprestimo.EmprestimoCriacaoDTO;
import com.wab.gebiblio.dto.emprestimo.EmprestimoDTO;
import com.wab.gebiblio.entity.emprestimo.Emprestimo;
import com.wab.gebiblio.mapper.emprestimo.EmprestimoMapper;
import com.wab.gebiblio.service.emprestimo.EmprestimoService;

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
 * Controller onde são disponibilizados endpoints para operações com empréstimos de livros.
 */
@RestController
@RequestMapping(EmprestimoController.ENDPOINT)
public class EmprestimoController {

	public static final String ENDPOINT = ApplicationUrlPattern.API_V1 + "/emprestimo";

	@Autowired
	private EmprestimoService emprestimoService;

	@Autowired
	private EmprestimoMapper emprestimoMapper;

	@GetMapping("/{emprestimoId}")
	@Operation(summary = "Consulta um empréstimo")
	public ResponseEntity<EmprestimoDTO> consultar(@PathVariable Long emprestimoId) {

		Optional<Emprestimo> emprestimoOpt = emprestimoService.consultar(emprestimoId);

		if (emprestimoOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		EmprestimoDTO dto = emprestimoMapper.convertToDTO(emprestimoOpt.get());

		return ResponseEntity.ok(dto);
	}

	@PostMapping
	@Operation(summary = "Cria um empréstimo")
	public ResponseEntity<EmprestimoDTO> criar(@Valid @RequestBody EmprestimoCriacaoDTO dto) throws GeBiblioException {

		Emprestimo entity = emprestimoMapper.convertToEntityCriacao(dto);

		entity = emprestimoService.salvar(entity);

		EmprestimoDTO dtoCriado = emprestimoMapper.convertToDTO(entity);

		return ResponseEntity.ok(dtoCriado);
	}

	@PutMapping("/{emprestimoId}")
	@Operation(summary = "Atualiza um empréstimo")
	public ResponseEntity<EmprestimoDTO> atualizar(@PathVariable Long emprestimoId, @RequestBody EmprestimoAtualizacaoDTO dto) throws GeBiblioException {

		Optional<Emprestimo> entityOpt = emprestimoService.consultar(emprestimoId);

		if (entityOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Emprestimo entity = entityOpt.get();

		emprestimoMapper.convertToEntityAtualizacao(entity, dto);

		entity = emprestimoService.salvar(entity);

		EmprestimoDTO dtoAtualizado = emprestimoMapper.convertToDTO(entity);

		return ResponseEntity.ok(dtoAtualizado);
	}

	@DeleteMapping("/{emprestimoId}")
	@Operation(summary = "Deleta um empréstimo")
	public ResponseEntity<?> deletar(@PathVariable Long emprestimoId) {
		emprestimoService.deletar(emprestimoId);
		return ResponseEntity.ok().build();
	}

}
