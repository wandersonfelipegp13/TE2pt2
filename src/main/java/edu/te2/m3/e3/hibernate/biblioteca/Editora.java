package edu.te2.m3.e3.hibernate.biblioteca;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "editora")
@NamedQuery(name = "Editora.findAll", query = "FROM Editora e")
@NamedQuery(name = "Editora.findByCodigo", query = "SELECT e FROM Editora e WHERE e.id = ?1")
@NamedQuery(name = "Editora.findByNome", query = "SELECT e FROM Editora e WHERE e.nome = ?1")
public class Editora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Basic(optional = false)
	@Column(name = "nome")
	private String nome;
	
	public Editora() {
		super();
	}
	
	public Editora(Long codigo) {
		super();
		this.setCodigo(codigo);
	}
	
	public Editora(String nome) {
		super();
		this.setNome(nome);
	}
	
	public Editora(Long codigo, String nome) {
		super();
		this.setCodigo(codigo);
		this.setNome(nome);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Editora other = (Editora) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Editora [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
