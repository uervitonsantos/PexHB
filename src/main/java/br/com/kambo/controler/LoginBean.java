package br.com.kambo.controler;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.kambo.DAO.UsuarioDao;
import br.com.kambo.modal.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5353062251309811191L;

	private Usuario usuariologado;

	public Usuario getUsuariologado() {
		if (usuariologado == null) {
			usuariologado = new Usuario();
		}
		return usuariologado;
	}

	public void setUsuariologado(Usuario usuariologado) {
		this.usuariologado = usuariologado;
	}

	public void autenticar() {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			usuariologado = usuarioDao.getAutenticar(usuariologado.getEmail(), usuariologado.getSenha());

			if (usuariologado == null) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "E-mail ou Senha incorretos!"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "OK!", "Usuario autenticado com sucesso!"));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Usuario não encontrado"));
		}
	}
}
