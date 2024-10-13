package com.wab.gebiblio.service.livro;

import com.wab.gebiblio.application.exception.GeBiblioException;
import com.wab.gebiblio.entity.livro.Livro;
import com.wab.gebiblio.repository.livro.LivroRepository;

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
 * Classe de testes unitário do serviço de livro.
 */
public class LivroServiceTest {

	@Mock
	private LivroRepository livroRepository;

	@InjectMocks
	private LivroService livroService;

	@BeforeEach
	public void setupTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testConsultar() {

		Long livroId = 1L;
		String titulo = "Livro Teste";
		String autor = "Beltrano";
		String isbn = "123456";
		LocalDate dataPublicacao = LocalDate.of(2000, 12, 30);
		String categoria = "Programação";

		Livro livroMock = new Livro();
		livroMock.setId(livroId);
		livroMock.setTitulo(titulo);
		livroMock.setAutor(autor);
		livroMock.setIsbn(isbn);
		livroMock.setDataPublicacao(dataPublicacao);
		livroMock.setCategoria(categoria);

		when(livroRepository.findById(livroId)).thenReturn(Optional.of(livroMock));

		Livro livro = livroService.consultar(livroId).orElse(null);

		assertNotNull(livro);
		assertEquals(titulo, livro.getTitulo());
		assertEquals(autor, livro.getAutor());
		assertEquals(isbn, livro.getIsbn());
		assertEquals(dataPublicacao, livro.getDataPublicacao());
		assertEquals(categoria, livro.getCategoria());

		// Verificar se é chamado somente uma vez
		verify(livroRepository).findById(1L);
	}

	@Test
	public void testSalvar() throws GeBiblioException {

		String titulo = "Livro Teste";
		String autor = "Beltrano";
		String isbn = "123456";
		LocalDate dataPublicacao = LocalDate.of(2000, 12, 30);
		String categoria = "Programação";

		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setIsbn(isbn);
		livro.setDataPublicacao(dataPublicacao);
		livro.setCategoria(categoria);

		when(livroRepository.save(livro)).thenReturn(livro);

		Livro livroSalvo = livroService.salvar(livro);
		assertNotNull(livroSalvo);
		assertEquals(titulo, livroSalvo.getTitulo());
		assertEquals(autor, livroSalvo.getAutor());
		assertEquals(isbn, livroSalvo.getIsbn());
		assertEquals(dataPublicacao, livroSalvo.getDataPublicacao());
		assertEquals(categoria, livroSalvo.getCategoria());

		// Verificar se é chamado somente uma vez
		verify(livroRepository).save(livro);
	}

	@Test
	public void testDeletar() {

		doNothing().when(livroRepository).deleteById(1L);

		livroService.deletar(1L);

		verify(livroRepository).deleteById(1L);
	}

}
