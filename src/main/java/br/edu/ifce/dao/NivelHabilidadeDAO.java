package br.edu.ifce.dao;
import java.util.List;

import br.edu.ifce.entity.NivelHabilidade;
import br.edu.ifce.exception.DAOException;
import br.edu.ifce.util.GenericDAO;


public class NivelHabilidadeDAO extends GenericDAO<NivelHabilidade>{
	
	private static final long serialVersionUID = 1L;
	
	public List<NivelHabilidade> ListByDsNivelHabilidade(String dsNivelHabilidade) throws DAOException {
		return listByQuery("select u from NivelHabilidade u where u.dsNivelHabilidade = ?1", dsNivelHabilidade);
	}
}

