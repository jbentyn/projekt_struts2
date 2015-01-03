package pl.dmcs.nsai.struts2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.nsai.struts2.domain.UserData;


public class UserDAO {

	@PersistenceContext(unitName="StrutsPersistence")
	protected EntityManager em;

	
	public List<UserData> findAll(){
		Query q = em.createQuery("select m from UserData m");
		List<UserData> users = q.getResultList();
		return users;
	}
	
	public UserData findByLogin(String login){
		Query q = em.createQuery("select user from UserData user where user.login= :login");
		q.setParameter("login", login);
		UserData user = (UserData)q.getSingleResult();
		return user;
	}
	
	public UserData findById(Long id){
		Query q = em.createQuery("select user from UserData user where user.id= :id");
		q.setParameter("id", id);
		UserData user = (UserData)q.getSingleResult();
		return user;
	}
	@Transactional
	public UserData create(String login, String name, String lastName,
			String email, String mobile, String password){
		UserData user = new UserData(login, name, lastName, email, mobile, password);
		em.persist(user);
		return user;
	}
	@Transactional
	public void delete(UserData user){
		//TODO cascade appointments
		em.remove(user);
	
	}
	@Transactional
	public UserData modify(UserData user){
		  return em.merge(user);
	}
	
	//Getters & setters
	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
}
