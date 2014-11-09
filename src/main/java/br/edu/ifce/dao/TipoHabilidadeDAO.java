package br.edu.ifce.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifce.entity.TipoHabilidade;
import br.edu.ifce.util.GenericDAO;

public class TipoHabilidadeDAO extends GenericDAO<TipoHabilidade>{

	private static final long serialVersionUID = 1L;
	
	public TipoHabilidade getTipoHabilidadeByName(String name){
		EntityManager entityManager = getEMFactory().createEntityManager();
		entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("select t from TipoHabilidade t where t.dsTipoHabilidade=?1");
			query.setParameter(1,name);
			TipoHabilidade tipo = (TipoHabilidade) query.getSingleResult();
			entityManager.getTransaction().commit();
			return tipo;
	
	}
	
	@SuppressWarnings("null")
	public TipoHabilidade TipoHabilidadeByName(String name){
		Query query = null;
		return  (TipoHabilidade) query.setParameter("select t from TipoHabilidade t where t.dsTipoHabilidade=?1", name);
	}
	

}