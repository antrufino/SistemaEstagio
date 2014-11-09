package br.edu.ifce.web;

import java.util.List;

import br.edu.ifce.dao.UsuarioDAO;
import br.edu.ifce.entity.Usuario;
import br.edu.ifce.exception.DAOException;

public class EstagiariosBean {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private List<Usuario> usuarios;
	
	
//	public List<Usuario> getUsuarios() {
//		if (usuarios == null){
//			try {
//				usuarios = usuarioDAO.listByTipoUsuario(3);
//			} catch (DAOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return usuarios;
//	}
}
