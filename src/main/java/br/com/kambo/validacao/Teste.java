package br.com.kambo.validacao;

import java.util.List;

import br.com.kambo.DAO.UsuarioDao;
import br.com.kambo.modal.Usuario;

public class Teste {

	public static void main(String[] args) throws Exception {
		UsuarioDao dao = new UsuarioDao();
		try {
			List<Usuario> usuarios = dao.consultarProId(1);
			for (Usuario u : usuarios) {
				System.out.println("Usuario: " + u.getId());
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}

	}
}