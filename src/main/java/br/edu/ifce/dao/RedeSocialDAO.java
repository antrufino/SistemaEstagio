package br.edu.ifce.dao;

import java.util.List;

import br.edu.ifce.entity.RedeSocial;
import br.edu.ifce.exception.DAOException;
import br.edu.ifce.util.GenericDAO;

public class RedeSocialDAO extends GenericDAO<RedeSocial>{

private static final long serialVersionUID = 1L;
	
		
	public List<RedeSocial> ListByDsRedeSocial(String dsRedeSocial) throws DAOException {
		return listByQuery("select u from RedeSocial u where u.dsRedeSocial = ?1", dsRedeSocial);		
	}
	
}
