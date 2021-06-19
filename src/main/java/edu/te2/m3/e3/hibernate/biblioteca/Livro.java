package edu.te2.m3.e3.hibernate.biblioteca;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "livro")
@NamedQuery(name = "Livro.findAll", query = "FROM Livro l")
@NamedQuery(name = "Livro.findByCodigo", query = "SELECT l FROM Livro l WHERE l.id = ?1")
@NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = ?1")
public class Livro {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Basic(optional = false)
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "preco")
	private BigDecimal preco;

	@Column(name = "lancamento")
	@Temporal(TemporalType.DATE)
	private LocalDate lancamento;

	@Basic(optional = false)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "editora_id", nullable = false)
	private Editora editora;

	public Livro() {
		super();
	}
	
	public Livro(String titulo, BigDecimal preco, LocalDate lancamento, Editora editora) {
		super();
		this.setTitulo(titulo);
		this.setPreco(preco);
		this.setLancamento(lancamento);
		this.setEditora(editora);
	}
	
	public Livro(Long codigo, String titulo, BigDecimal preco, LocalDate lancamento, Editora editora) {
		super();
		this.setCodigo(codigo);
		this.setTitulo(titulo);
		this.setPreco(preco);
		this.setLancamento(lancamento);
		this.setEditora(editora);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getLancamento() {
		return lancamento;
	}

	public void setLancamento(LocalDate lancamento) {
		this.lancamento = lancamento;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((editora == null) ? 0 : editora.hashCode());
		result = prime * result + ((lancamento == null) ? 0 : lancamento.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (editora == null) {
			if (other.editora != null)
				return false;
		} else if (!editora.equals(other.editora))
			return false;
		if (lancamento == null) {
			if (other.lancamento != null)
				return false;
		} else if (!lancamento.equals(other.lancamento))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [codigo=" + codigo + ", titulo=" + titulo + ", preco=" + preco + ", lancamento=" + lancamento
				+ ", editora=" + editora + "]";
	}
	
}
