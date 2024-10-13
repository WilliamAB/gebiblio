package com.wab.gebiblio.service.usuario;

import com.wab.gebiblio.application.exception.GeBiblioException;
import com.wab.gebiblio.entity.usuario.Usuario;
import com.wab.gebiblio.repository.usuario.UsuarioRepository;
import com.wab.gebiblio.validator.usuario.UsuarioValidator;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Classe de testes unitário do serviço de usuário.
 */
public class UsuarioServiceTest {

	@Mock
	private UsuarioRepository usuarioRepository;

	@Mock
	private UsuarioValidator usuarioValidator;

	@InjectMocks
	private UsuarioService usuarioService;

	@BeforeEach
	public void setupTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testConsultar() {

		Long usuarioId = 1L;
		String nome = "Fulano";
		String email = "fulano@email.com";
		LocalDate dataCadastro = LocalDate.of(2024, 10, 11);
		String telefone = "47 9999-8888";

		Usuario usuarioMock = new Usuario();
		usuarioMock.setId(usuarioId);
		usuarioMock.setNome(nome);
		usuarioMock.setEmail(email);
		usuarioMock.setDataCadastro(dataCadastro);
		usuarioMock.setTelefone(telefone);

		when(usuarioRepository.findById(usuarioId)).thenReturn(Optional.of(usuarioMock));
		when(usuarioRepository.existsById(usuarioId)).thenReturn(true);

		assertTrue(usuarioService.existe(usuarioId));

		Usuario usuario = usuarioService.consultar(usuarioId).orElse(null);

		assertNotNull(usuario);
		assertEquals(nome, usuario.getNome());
		assertEquals(email, usuario.getEmail());
		assertEquals(dataCadastro, usuario.getDataCadastro());
		assertEquals(telefone, usuario.getTelefone());

		// Verificar se é chamado somente uma vez
		verify(usuarioRepository).findById(usuarioId);
		verify(usuarioRepository).existsById(usuarioId);
	}

	@Test
	public void testSalvar() throws GeBiblioException {

		String nome = "Fulano";
		String email = "fulano@email.com";
		LocalDate dataCadastro = LocalDate.of(2024, 10, 11);
		String telefone = "47 9999-8888";

		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setDataCadastro(dataCadastro);
		usuario.setTelefone(telefone);

		when(usuarioRepository.save(usuario)).thenReturn(usuario);
		doNothing().when(usuarioValidator).validate(usuario);

		Usuario usuarioSalvo = usuarioService.salvar(usuario);
		assertNotNull(usuarioSalvo);
		assertEquals(nome, usuarioSalvo.getNome());
		assertEquals(email, usuarioSalvo.getEmail());
		assertEquals(dataCadastro, usuarioSalvo.getDataCadastro());
		assertEquals(telefone, usuarioSalvo.getTelefone());

		// Verificar se é chamado somente uma vez
		verify(usuarioRepository).save(usuario);
		verify(usuarioValidator).validate(usuario);
	}

	@Test
	public void testDeletar() {

		doNothing().when(usuarioRepository).deleteById(1L);

		usuarioService.deletar(1L);

		verify(usuarioRepository).deleteById(1L);
	}

}
