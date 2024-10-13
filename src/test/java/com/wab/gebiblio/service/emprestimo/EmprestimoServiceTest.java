package com.wab.gebiblio.service.emprestimo;

import com.wab.gebiblio.application.exception.GeBiblioException;
import com.wab.gebiblio.entity.emprestimo.Emprestimo;
import com.wab.gebiblio.entity.emprestimo.EmprestimoStatus;
import com.wab.gebiblio.entity.livro.Livro;
import com.wab.gebiblio.entity.usuario.Usuario;
import com.wab.gebiblio.repository.emprestimo.EmprestimoRepository;
import com.wab.gebiblio.validator.emprestimo.EmprestimoValidator;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Classe de testes unitário do serviço de empréstimo.
 */
public class EmprestimoServiceTest {

	@Mock
	private EmprestimoRepository emprestimoRepository;

	@Mock
	private EmprestimoValidator emprestimoValidator;

	@InjectMocks
	private EmprestimoService emprestimoService;

	@BeforeEach
	public void setupTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testConsultar() {

		Long emprestimoId = 1L;
		LocalDate dataEmprestimo = LocalDate.of(2024, 10, 12);
		LocalDate dataDevolucao = LocalDate.of(2024, 10, 30);
		EmprestimoStatus status = EmprestimoStatus.EMPRESTADO;
		Long livroId = 10L;
		Long usuarioId = 20L;

		Emprestimo emprestimoMock = new Emprestimo();
		emprestimoMock.setId(emprestimoId);
		emprestimoMock.setDataEmprestimo(dataEmprestimo);
		emprestimoMock.setDataDevolucao(dataDevolucao);
		emprestimoMock.setStatus(status);

		Livro livroMock = new Livro();
		livroMock.setId(livroId);
		emprestimoMock.setLivro(livroMock);

		Usuario usuarioMock = new Usuario();
		usuarioMock.setId(usuarioId);
		emprestimoMock.setUsuario(usuarioMock);

		when(emprestimoRepository.findById(emprestimoId)).thenReturn(Optional.of(emprestimoMock));

		Emprestimo emprestimo = emprestimoService.consultar(emprestimoId).orElse(null);

		assertNotNull(emprestimo);
		assertEquals(dataEmprestimo, emprestimo.getDataEmprestimo());
		assertEquals(dataDevolucao, emprestimo.getDataDevolucao());
		assertEquals(status, emprestimo.getStatus());
		assertNotNull(emprestimo.getLivro());
		assertEquals(livroId, emprestimo.getLivro().getId());
		assertNotNull(emprestimo.getUsuario());
		assertEquals(usuarioId, emprestimo.getUsuario().getId());

		// Verificar se é chamado somente uma vez
		verify(emprestimoRepository).findById(1L);
	}

	@Test
	public void testSalvar() throws GeBiblioException {

		Long emprestimoId = 1L;
		LocalDate dataEmprestimo = LocalDate.of(2024, 10, 12);
		LocalDate dataDevolucao = LocalDate.of(2024, 10, 30);
		EmprestimoStatus status = EmprestimoStatus.EMPRESTADO;
		Long livroId = 10L;
		Long usuarioId = 20L;

		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setId(emprestimoId);
		emprestimo.setDataEmprestimo(dataEmprestimo);
		emprestimo.setDataDevolucao(dataDevolucao);
		emprestimo.setStatus(status);

		Livro livroMock = new Livro();
		livroMock.setId(livroId);
		emprestimo.setLivro(livroMock);

		Usuario usuarioMock = new Usuario();
		usuarioMock.setId(usuarioId);
		emprestimo.setUsuario(usuarioMock);

		when(emprestimoRepository.save(emprestimo)).thenReturn(emprestimo);
		doNothing().when(emprestimoValidator).validate(emprestimo);

		Emprestimo emprestimoSalvo = emprestimoService.salvar(emprestimo);

		assertNotNull(emprestimoSalvo);
		assertEquals(dataEmprestimo, emprestimo.getDataEmprestimo());
		assertEquals(dataDevolucao, emprestimoSalvo.getDataDevolucao());
		assertEquals(status, emprestimoSalvo.getStatus());
		assertNotNull(emprestimoSalvo.getLivro());
		assertEquals(livroId, emprestimoSalvo.getLivro().getId());
		assertNotNull(emprestimoSalvo.getUsuario());
		assertEquals(usuarioId, emprestimoSalvo.getUsuario().getId());

		// Verificar se é chamado somente uma vez
		verify(emprestimoRepository).save(emprestimo);
		verify(emprestimoValidator).validate(emprestimo);
	}

	@Test
	public void testDeletar() {

		doNothing().when(emprestimoRepository).deleteById(1L);

		emprestimoService.deletar(1L);

		verify(emprestimoRepository).deleteById(1L);
	}

}
