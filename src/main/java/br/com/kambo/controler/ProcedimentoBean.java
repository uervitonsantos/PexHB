package br.com.kambo.controler;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.kambo.DAO.ProcedimentoDao;
import br.com.kambo.modal.Procedimento;

@ManagedBean
@ViewScoped
public class ProcedimentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7369878729122471108L;

	// INICIALIZAÇÃO DOS OBJETOS

	@EJB
	private ProcedimentoDao dao;
	private Procedimento procedimento = new Procedimento();

	private Procedimento selectProcedimento;

	// METODO QUE LISTA TODOS OS USUARIOS CADASTRADOS
	public List<Procedimento> getprocedimentos() throws Exception {
		return dao.listarTodos();
	}

	public void novo() {
		procedimento = new Procedimento();
	}

	public synchronized void selecionarLinha(Procedimento procedimento) {
		this.setProcedimento(procedimento);
	}

	// METODO SALVAR
	public String salvar() {
		try {
			dao.salvar(this.procedimento);
			novo();
			@SuppressWarnings("unused")
			List<Procedimento> procedimentos = dao.listarTodos();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Procedimento cadastrado com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Erro ao cadastrar o procedmento"));
		}
		return null;

	}

	// METODO EXCLUIR
	public String excluir(int id) throws Exception {
		try {
			dao.excluir(procedimento);
			novo();
			@SuppressWarnings("unused")
			List<Procedimento> procedimentos = dao.listarTodos();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Procedimento excluido com sucesso!"));
		} catch (RuntimeException error) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
					"Ocorreu um erro ao tentar excluir o procedimento!"));
			error.printStackTrace();
		}
		return null;
	}

	public ProcedimentoDao getDao() {
		return dao;
	}

	public void setDao(ProcedimentoDao dao) {
		this.dao = dao;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Procedimento getSelectProcedimento() {
		return selectProcedimento;
	}

	public void setSelectProcedimento(Procedimento selectProcedimento) {
		this.selectProcedimento = selectProcedimento;
	}

}
