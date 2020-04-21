package br.com.kambo.controler;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.kambo.DAO.ContatosDao;
import br.com.kambo.modal.Contatos;

@ManagedBean
@ViewScoped
public class ContatosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3876201241795133011L;

	@EJB
	// INICIALIZAÇÃO DOS OBJETOS
	private ContatosDao dao;
	private Contatos contatos = new Contatos();

	// METODO QUE LISTA TODOS OS CONTATOS CADASTRADOS
	public List<Contatos> getcontatos() throws Exception {
		return dao.listarTodos();

	}

	// METODO SALVAR
	public String salvar() throws Exception {

		if (null != (contatos)) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!",
					"Preencha os dados necessarios para cadastrar o contato"));

			return null;
		}

		dao.salvar(this.contatos);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Contato cadastrado com sucesso!"));

		return null;
	}

	// METODO EXCLUIR
	public String excluir(int id) throws Exception {
		dao.excluir(contatos);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Contato excluido com sucesso!"));
		return null;

	}

	public ContatosDao getDao() {
		return dao;
	}

	public void setDao(ContatosDao dao) {
		this.dao = dao;
	}

	public Contatos getContatos() {
		return contatos;
	}

	public void setContatos(Contatos contatos) {
		this.contatos = contatos;
	}

}
