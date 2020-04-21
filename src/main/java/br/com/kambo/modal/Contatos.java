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

import br.com.kambo.DAO.EntidadeBase;

@Entity
@Table(name = "CONTATOS")
@NamedQueries({ @NamedQuery(name = "Contatos.consultarTodos", query = "SELECT c FROM Contatos c"),
		@NamedQuery(name = "Contatos.consultarCodigo", query = "SELECT c FROM Contatos c WHERE c.id = :id"),
		@NamedQuery(name = "Contatos.consultarNome", query = "SELECT c FROM Contatos c where c.nome= :nome"),
		@NamedQuery(name = "Contatos.consultarEmail", query = "SELECT c FROM Contatos c where c.email= :email")

})

public class Contatos implements Serializable, EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6522778456095302396L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "EMPRESA", nullable = false, length = 50)
	private String empresa;

	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;

	@Column(name = "CARGO", nullable = false, length = 20)
	private String cargo;

	@Column(name = "EMAIL", unique = true, nullable = true, length = 50)
	private String email;

	@Column(name = "TELEFONE_1", nullable = false, length = 15)
	private String telefone1;

	@Column(name = "TELEFONE_2", length = 15)
	private String telefone2;

	@Column(name = "DATA")
	@Temporal(TemporalType.DATE)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone1 == null) ? 0 : telefone1.hashCode());
		result = prime * result + ((telefone2 == null) ? 0 : telefone2.hashCode());
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
		Contatos other = (Contatos) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
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
		if (telefone1 == null) {
			if (other.telefone1 != null)
				return false;
		} else if (!telefone1.equals(other.telefone1))
			return false;
		if (telefone2 == null) {
			if (other.telefone2 != null)
				return false;
		} else if (!telefone2.equals(other.telefone2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contatos [id=" + id + ", empresa=" + empresa + ", nome=" + nome + ", cargo=" + cargo + ", email="
				+ email + ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", data=" + data + "]";
	}
}
