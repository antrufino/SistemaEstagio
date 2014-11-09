/**
 * @author Katarina Hachém
 */

package br.edu.ifce.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifce.entity.Aluno;
import br.edu.ifce.util.GenericDAO;

public class AlunoDao extends GenericDAO<Aluno> {

	private static final long serialVersionUID = 1L;

	
	
	
	public Aluno getAlunoByIdPessoa(Integer idPessoa) {
		EntityManager entityManager = getEMFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select a from Aluno a where a.pessoa.id=?1");
		query.setParameter(1, idPessoa);
		Aluno alu = (Aluno) query.getSingleResult();
		entityManager.getTransaction().commit();
		return alu;
	}

}
