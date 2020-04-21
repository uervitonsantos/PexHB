package br.com.kambo.DAO;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.kambo.modal.Usuario;

@Stateless
@ViewScoped
public class UsuarioDao extends DaoGenerico<Usuario> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioDao() {
		super();
		classePersistente = Usuario.class;

	}

	@PersistenceContext(unitName = "KamboPU")
	public EntityManager em;

	public Usuario getAutenticar(String email, String senha) {
		Usuario usuario = null;
		try {
			usuario = (Usuario) this.em.createNamedQuery("Usuario.autenticarLogin").setParameter("email", email)
					.setParameter("senha", senha).getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			System.out.println("Erro ao realizar busca " + e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> consultarProId(int id) throws Exception {
		List<Usuario> usuario;
		try {
			Query q = em.createNamedQuery("Usuario.consultarCodigo", Usuario.class);
			q.setParameter("id", id);
			usuario = q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return usuario;
	}
}
