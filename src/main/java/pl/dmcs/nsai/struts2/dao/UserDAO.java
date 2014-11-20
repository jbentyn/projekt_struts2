package pl.dmcs.nsai.struts2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pl.dmcs.nsai.struts2.domain.UserData;


public class UserDAO {

	@PersistenceContext(unitName="StrutsPersistence")
	protected EntityManager em;

	
	public List<UserData> findAll(){
		Query q = em.createQuery("select m from UserData m");
		List<UserData> users = q.getResultList();
		return users;
	}
	
	
	//Getters & setters
	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
}
