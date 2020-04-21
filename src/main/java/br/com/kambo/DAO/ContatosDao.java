package br.com.kambo.DAO;

import javax.ejb.Stateless;

import br.com.kambo.modal.Contatos;

@Stateless
public class ContatosDao extends DaoGenerico<Contatos> {

	public ContatosDao() {
		super();
		classePersistente = Contatos.class;
	}

}
