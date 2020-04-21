package br.com.kambo.controler;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.kambo.DAO.UsuarioDao;
import br.com.kambo.modal.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3423523115875179716L;

	// INICIALIZAÇÃO DOS OBJETOS

	@EJB
	private UsuarioDao dao;
	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	private Usuario selectedUsuario;
    private List<Usuario> selectedUsuarios;

	// METODO QUE LISTA TODOS OS USUARIOS CADASTRADOS
	public List<Usuario> getusuarios() throws Exception {
		return dao.listarTodos();

	}

	public void novo() {
		usuario = new Usuario();
	}

	// METODO SALVAR
	public String salvar() throws Exception {
		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!",
					"A senha não foi confirmada corretamente"));
			return null;
		}
		usuario.setData(Calendar.getInstance().getTime());
		dao.salvar(usuario);
		novo();
		@SuppressWarnings("unused")
		List<Usuario> usuarios = dao.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuário cadastrado com sucesso!"));
		return null;
	}

	// METODO EXCLUIR
	public String excluir() throws Exception {
		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!",
					"A senha não foi confirmada corretamente"));
			return null;
		}
		dao.excluir(usuario);
		novo();
		@SuppressWarnings("unused")
		List<Usuario> usuarios = dao.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuário excluido com sucesso!"));
		return null;

	}

	// METODO ATUALIZAR
	public String atualizar() throws Exception {
		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!",
					"A senha não foi confirmada corretamente"));
			return null;
		}
		dao.atualizar(usuario);
		novo();
		@SuppressWarnings("unused")
		List<Usuario> usuarios = dao.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Alterações do usuário salvas com sucesso!"));
		return null;
	}

	public String buscar(int id) throws Exception {
		usuario = dao.buscarPorId(id);
		return toString();

	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	public List<Usuario> getSelectedUsuarios() {
		return selectedUsuarios;
	}

	public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
		this.selectedUsuarios = selectedUsuarios;
	}

}
