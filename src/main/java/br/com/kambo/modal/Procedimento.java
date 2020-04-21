package br.com.kambo.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.kambo.DAO.EntidadeBase;

@Entity
@Table(name = "PROCEDIMENTO")
public class Procedimento implements Serializable, EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2198194455144798744L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "TITULO", unique =true, nullable=true)
	private String titulo;

	@Column(name = "CATEGORIA", nullable = false)
	private String categoria;

	@Column(name = "SUBCATEGORIA", nullable = false)
	private String subcategoria;

	@Column(name = "RESUMO", nullable = false)
	private String resumo;
	
	@Column(name = "VERSAO", nullable = false)
	private float versao;

	@NotNull
	@Column(name = "DATA_INCLUSAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_inclusao = new java.sql.Date(System.currentTimeMillis());
	
	@NotNull
	@Column(name = "DATA_ATUALIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_atualizacao = new java.sql.Date(System.currentTimeMillis());

	// Gets e Sets
	@Override
	public Integer getId() {
		return id;
	}

	public Date getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(Date data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public Date getData_atualizacao() {
		return data_atualizacao;
	}

	public void setData_atualizacao(Date data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	public float getVersao() {
		return versao;
	}

	public void setVersao(float versao) {
		this.versao = versao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((data_atualizacao == null) ? 0 : data_atualizacao.hashCode());
		result = prime * result + ((data_inclusao == null) ? 0 : data_inclusao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
		result = prime * result + ((subcategoria == null) ? 0 : subcategoria.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + Float.floatToIntBits(versao);
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
		Procedimento other = (Procedimento) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (data_atualizacao == null) {
			if (other.data_atualizacao != null)
				return false;
		} else if (!data_atualizacao.equals(other.data_atualizacao))
			return false;
		if (data_inclusao == null) {
			if (other.data_inclusao != null)
				return false;
		} else if (!data_inclusao.equals(other.data_inclusao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (resumo == null) {
			if (other.resumo != null)
				return false;
		} else if (!resumo.equals(other.resumo))
			return false;
		if (subcategoria == null) {
			if (other.subcategoria != null)
				return false;
		} else if (!subcategoria.equals(other.subcategoria))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (Float.floatToIntBits(versao) != Float.floatToIntBits(other.versao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Procedimento [id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + ", subcategoria="
				+ subcategoria + ", resumo=" + resumo + ", versao=" + versao + ", data_inclusao=" + data_inclusao
				+ ", data_atualizacao=" + data_atualizacao + "]";
	}

}
