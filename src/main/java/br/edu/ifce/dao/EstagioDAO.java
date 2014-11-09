package br.edu.ifce.dao;

import java.util.Date;
import java.util.List;

import br.edu.ifce.entity.Empresa;
import br.edu.ifce.entity.Estagio;
import br.edu.ifce.exception.DAOException;
import br.edu.ifce.util.GenericDAO;

public class EstagioDAO extends GenericDAO<Estagio> {

	private static final long serialVersionUID = 1L;

	public List<Estagio> ListByDsEstagio(String dsEstagio) throws DAOException {
		return listByQuery("select u from Estagio u where u.dsEstagio = ?1",
				dsEstagio);
	}

	public List<Estagio> listByPesquisa(String dsEstagio) throws DAOException {

		if (dsEstagio == null) {
			return listByQuery("select u from Estagio u order by u.dsEstagio asc");
		} else
			return listByQuery("select u from Estagio u where lower(u.dsEstagio) like lower('%"
					+ dsEstagio + "%') order by u.dsEstagio asc");
	}

	// retorna uma lista filtrada pelas datas e/ou dsEstagio
	public List<Estagio> listByPesquisa2(String dsEstagio, Date inicio, Date fim)
			throws DAOException {

		if (dsEstagio == null) {
			return listByQuery(
					"select u from Estagio u where u.dtInicio >= ?1 and u.dtFim <= ?2 order by u.dsEstagio asc",
					inicio, fim);
		} else
			return listByQuery(
					"select u from Estagio u where lower(u.dsEstagio) like lower('%"
							+ dsEstagio
							+ "%') and u.dtInicio >= ?1 and u.dtFim <= ?2 order by u.dsEstagio asc",
					inicio, fim);
	}
}
