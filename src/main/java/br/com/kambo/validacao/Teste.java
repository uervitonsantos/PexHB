package br.com.kambo.validacao;

import br.com.kambo.DAO.UsuarioDao;
import br.com.kambo.modal.Usuario;


public class Teste {

	public static void main(String[] args) throws Exception {
		
		UsuarioDao dao = new UsuarioDao();
		
		Usuario u = new Usuario();
		u.setNome("João santos");
		u.setEmail("joao.santos@gmail.com");
		u.setPrivilegio("suporte");
		u.setSenha("kln1503");
		
		dao.salvar(u);
	}
}