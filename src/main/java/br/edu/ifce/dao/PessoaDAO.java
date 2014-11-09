package br.edu.ifce.dao;

import java.util.List;

import br.edu.ifce.entity.Pessoa;
import br.edu.ifce.exception.DAOException;
import br.edu.ifce.util.GenericDAO;

public class PessoaDAO extends GenericDAO<Pessoa>{

	private static final long serialVersionUID = 1L;
	
	public List<Pessoa> ListByNome(String nome) throws DAOException {
		return listByQuery("select p from Pessoa p where p.nome = ?1", nome);
	}
}
