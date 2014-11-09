package br.edu.ifce.dao;

import java.util.List;

import br.edu.ifce.entity.TipoRedeSocial;
import br.edu.ifce.exception.DAOException;
import br.edu.ifce.util.GenericDAO;

public class TipoRedeSocialDAO extends GenericDAO<TipoRedeSocial>{

private static final long serialVersionUID = 1L;
	
		
	public List<TipoRedeSocial> ListByDsTipoRedeSocial(String dsTipoRedeSocial) throws DAOException {
		return listByQuery("select u from TipoRedeSocial u where u.dsTipoRedeSocial = ?1", dsTipoRedeSocial);
	}
	
}
