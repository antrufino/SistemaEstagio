package br.edu.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifce.entity.Habilidade;
import br.edu.ifce.entity.TipoHabilidade;
import br.edu.ifce.exception.DAOException;
import br.edu.ifce.util.GenericDAO;


public class HabilidadeDAO extends GenericDAO<Habilidade>{

	private static final long serialVersionUID = 1L;
	
	public Habilidade getHabilidadeByName(String name){
		EntityManager entityManager = getEMFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select t from Habilidade t where t.dsHabilidade=?1");
		query.setParameter(1,name);
		Habilidade hab = (Habilidade) query.getSingleResult();
		entityManager.getTransaction().commit();
		return hab;
	}
	
	@SuppressWarnings("unchecked")
	public List<Habilidade> consultaHabilidade(TipoHabilidade tipoHabilidade){
		EntityManager entityManager = getEMFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select h from Habilidade h inner join h.tipoHabilidade on h.tipoHabilidade.id=?1");
		query.setParameter(1,tipoHabilidade.getId());
		List<Habilidade> hab = query.getResultList();
		entityManager.getTransaction().commit();
		return hab;
		
	}
	
	public List<Habilidade> consultaHabilidadeByTipo(TipoHabilidade tipoHabilidade) throws DAOException {
		return listByQuery("select h from Habilidade h inner join h.tipoHabilidade on h.tipoHabilidade.id=?1", tipoHabilidade.getId());
	}
	

}
