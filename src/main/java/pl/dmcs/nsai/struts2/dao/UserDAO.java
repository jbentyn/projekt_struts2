package pl.dmcs.nsai.struts2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.nsai.struts2.domain.RoleData;
import pl.dmcs.nsai.struts2.domain.UserData;


public class UserDAO {

	@PersistenceContext(unitName="StrutsPersistence")
	protected EntityManager em;

	@Autowired
	private PasswordEncoder encoder;

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
	private void persist(UserData user){
		user.setPassword(encoder.encode(user.getPassword()));

		Query query= em.createQuery("Select role FROM RoleData role WHERE role.name='ROLE_USER'");
		RoleData role= (RoleData)query.getSingleResult();
		user.getRoles().add(role);
		em.persist(user);
	}
	@Transactional
	public UserData create(String login, String name, String lastName,
			String email, String mobile, String password){
		UserData user = new UserData(login, name, lastName, email, mobile, password);
		persist(user);
		return user;
	}

	@Transactional
	public UserData create(UserData user){

		persist(user);
		return user;
	}
	private void beforeDelete(Long userId){
		Query query = em.createQuery("DELETE  FROM AppointmentData app WHERE app.user.id=:id");
		query.setParameter("id", userId);
		query.executeUpdate();
	}
	@Transactional
	public void delete(UserData user){
		beforeDelete(user.getId());
		em.remove(user);

	}
	@Transactional
	public void delete(Long id){
		beforeDelete(id);
		Query query = em.createQuery("DELETE  FROM UserData user WHERE user.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	@Transactional
	public UserData modify(UserData user){
		em.merge(user);
		em.flush();
		return user;
	}

	//Getters & setters
	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
}
