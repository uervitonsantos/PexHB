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
@Table(name = "USUARIO")
@NamedQueries({ @NamedQuery(name = "Usuario.consultarTodos", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "Usuario.consultarCodigo", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
		@NamedQuery(name = "Usuario.consultarEmail", query = "SELECT u FROM Usuario u where u.email=:email"),
		@NamedQuery(name = "Usuario.autenticarLogin", query = "SELECT u from Usuario u where u.email = :email and u.senha = :senha")

})

public class Usuario implements Serializable, EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1088513495068713690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;

	@Column(name = "EMAIL", unique =true, nullable=true, length = 50)
	private String email;

	@NotNull
	@Column(name = "PRIVILEGIO", nullable = false, length = 13)
	private String privilegio;

	@Column(name = "DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@NotNull
	@Column(name = "SENHA", nullable = false, length = 25)
	private String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer id, String nome, String email, String privilegio, Date data, String senha ) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.privilegio = privilegio;
		this.data = data;
		this.senha = senha;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((privilegio == null) ? 0 : privilegio.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
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
		if (privilegio == null) {
			if (other.privilegio != null)
				return false;
		} else if (!privilegio.equals(other.privilegio))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", privilegio=" + privilegio + ", data="
				+ data + ", senha=" + senha + ", getId()=" + getId() + ", getNome()=" + getNome() + ", getEmail()="
				+ getEmail() + ", getPrivilegio()=" + getPrivilegio() + ", getData()=" + getData() + ", getSenha()="
				+ getSenha() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

}
