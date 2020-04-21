package br.com.kambo.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.kambo.DAO.EntidadeBase;

@Entity
@Table(name = "ALARME")
@NamedQueries({ @NamedQuery(name = "Alarme.consultarTodos", query = "SELECT a FROM Alarme a"),
		@NamedQuery(name = "Alarme.consultarCodigo", query = "SELECT a FROM Alarme a WHERE a.id = :id"),
		@NamedQuery(name = "Alarme.consultarNome", query = "SELECT a FROM Alarme a where a.nome= :nome")
})

public class Alarme implements Serializable, EntidadeBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;

	@Column(name = "RESUMO", unique =true, nullable= false, length = 50)
	private String resumo;

	@NotNull
	@Column(name = "DATA_EXECUSAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataexecusao = new java.sql.Date(System.currentTimeMillis());

	@NotNull
	@Column(name = "DATA_FINALIZASAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datafinalizasao = new java.sql.Date(System.currentTimeMillis());

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Date getDataexecusao() {
		return dataexecusao;
	}

	public void setDataexecusao(Date dataexecusao) {
		this.dataexecusao = dataexecusao;
	}

	public Date getDatafinalizasao() {
		return datafinalizasao;
	}

	public void setDatafinalizasao(Date datafinalizasao) {
		this.datafinalizasao = datafinalizasao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataexecusao == null) ? 0 : dataexecusao.hashCode());
		result = prime * result + ((datafinalizasao == null) ? 0 : datafinalizasao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
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
		Alarme other = (Alarme) obj;
		if (dataexecusao == null) {
			if (other.dataexecusao != null)
				return false;
		} else if (!dataexecusao.equals(other.dataexecusao))
			return false;
		if (datafinalizasao == null) {
			if (other.datafinalizasao != null)
				return false;
		} else if (!datafinalizasao.equals(other.datafinalizasao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (resumo == null) {
			if (other.resumo != null)
				return false;
		} else if (!resumo.equals(other.resumo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alarme [id=" + id + ", nome=" + nome + ", resumo=" + resumo + ", dataexecusao=" + dataexecusao
				+ ", datafinalizasao=" + datafinalizasao + "]";
	}

	
}
