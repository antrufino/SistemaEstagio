package br.edu.ifce.dao;

import java.util.List;

import br.edu.ifce.entity.Pessoa;
import br.edu.ifce.entity.Usuario;
import br.edu.ifce.exception.DAOException;
import br.edu.ifce.util.GenericDAO;

public class UsuarioDAO extends GenericDAO<Usuario>{

	private static final long serialVersionUID = 1L;
	
	public List<Usuario> ListByCdEmail(String cdEmail) throws DAOException {
		return listByQuery("select u from Usuario u where u.cdEmail = ?1", cdEmail);
	}
	
	public List<Usuario> ListByCdEmailAndSenha(String cdEmail, String cdSenha) throws DAOException {
		return listByQuery("select u from Usuario u where u.cdEmail = ?1 and u.cdSenha = ?2", cdEmail, cdSenha);
	}

	public List<Usuario> listByTipoUsuario(Integer  id) throws DAOException{
		return listByQuery("Select u from Usuario u Inner Join u.tipoUsuario t where t.id = ?1", id);
	}
	
	public void addNovoEstagiario(Usuario usuario, Pessoa pessoa) throws DAOException{
		try {
			add(pessoa, usuario);
		} catch (DAOException e) {
			throw new DAOException("Erro ao salvar novo usuário", e);
		}
	}
	
}
