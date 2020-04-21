package br.com.kambo.DAO;

import javax.ejb.Stateless;

import br.com.kambo.modal.Procedimento;

@Stateless
public class ProcedimentoDao extends DaoGenerico<Procedimento> {

	public ProcedimentoDao() {
		super();
		classePersistente = Procedimento.class;
	}

}
