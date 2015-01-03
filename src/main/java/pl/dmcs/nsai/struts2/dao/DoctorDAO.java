package pl.dmcs.nsai.struts2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.nsai.struts2.domain.DoctorData;
import pl.dmcs.nsai.struts2.domain.UserData;

public class DoctorDAO {
	@PersistenceContext(unitName="StrutsPersistence")
	protected EntityManager em;
	
	public List<DoctorData> findAll(){
		Query q = em.createQuery("select m from DoctorData m");
		List<DoctorData> doctors = q.getResultList();
		return doctors;
	}
	
	@Transactional
	public DoctorData create(Long id, String name, String lastName){
		DoctorData doctor = new DoctorData( name, lastName);
		em.persist(doctor);
		return doctor;
	}
	@Transactional
	public void delete(DoctorData doctor){
		//TODO cascade appointments
		em.remove(doctor);
	
	}
	@Transactional
	public DoctorData modify(DoctorData doctor){
		  return em.merge(doctor);
	}
	
	public DoctorData findById(Long id){
		Query q = em.createQuery("select doctor from DoctorData doctor where doctor.id= :id");
		q.setParameter("id", id);
		DoctorData doctor = (DoctorData)q.getSingleResult();
		return doctor;
	}
}
