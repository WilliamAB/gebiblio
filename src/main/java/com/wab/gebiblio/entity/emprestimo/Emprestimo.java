package com.wab.gebiblio.entity.emprestimo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.wab.gebiblio.entity.BaseEntity;
import com.wab.gebiblio.entity.livro.Livro;
import com.wab.gebiblio.entity.usuario.Usuario;

import java.time.LocalDate;

/**
 * Representa um empréstimo de livro.
 */
@Entity
@Table(name = "emprestimo")
public class Emprestimo extends BaseEntity {

	@Column(name = "dt_emprestimo", nullable = false)
	private LocalDate dataEmprestimo;

	@Column(name = "dt_devolucao", nullable = false)
	private LocalDate dataDevolucao;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tp_status", nullable = false)
	private EmprestimoStatus status;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "livro_id", nullable = false)
	private Livro livro;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
