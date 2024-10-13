package com.wab.gebiblio.dto.emprestimo;

import com.wab.gebiblio.dto.livro.LivroDTO;
import com.wab.gebiblio.dto.usuario.UsuarioDTO;
import com.wab.gebiblio.entity.emprestimo.EmprestimoStatus;

import java.time.LocalDate;

/**
 * Representação DTO de empréstimo.
 */
public class EmprestimoDTO {

	private Long id;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private EmprestimoStatus status;
	private UsuarioDTO usuario;
	private LivroDTO livro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public EmprestimoStatus getStatus() {
		return status;
	}

	public void setStatus(EmprestimoStatus status) {
		this.status = status;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public LivroDTO getLivro() {
		return livro;
	}

	public void setLivro(LivroDTO livro) {
		this.livro = livro;
	}

}
