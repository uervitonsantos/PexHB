package br.com.kambo.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DaoGenerico<TIPO extends EntidadeBase> {

	@PersistenceContext(unitName = "KamboPU")
	public EntityManager em;
	private List<TIPO> listaObjetos;
	protected Class <TIPO> classePersistente;

	public DaoGenerico() {

	}

	public void salvar(TIPO obj) throws Exception {
		em.persist(obj);
	}

	public void atualizar(TIPO obj) throws Exception {
		em.merge(obj);
	}

	public void excluir(TIPO obj) throws Exception {
		obj = em.merge(obj);
		em.remove(obj);
	}

	public TIPO buscarPorId(int id) throws Exception {
		return (TIPO) em.find(classePersistente, id);

	}

	@SuppressWarnings("unchecked")
	public List<TIPO> listarTodos() throws Exception {
		List<TIPO> t;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("from ").append(classePersistente.getSimpleName());
			Query q = em.createQuery(sql.toString());
			t = q.getResultList();
		} catch (Exception e) {
			t = new ArrayList<>();
		}
		return t;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<TIPO> getListaObjetos() {
		return listaObjetos;
	}

	public void setListaObjetos(List<TIPO> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}

	@SuppressWarnings("rawtypes")
	public Class getClassePersistente() {
		return classePersistente;
	}

	public void setClassePersistente(Class<TIPO> classePersistente) {
		this.classePersistente = classePersistente;
	}

}
