package pl.dmcs.nsai.struts2.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.nsai.struts2.domain.AppointmentData;
import pl.dmcs.nsai.struts2.domain.DoctorData;
import pl.dmcs.nsai.struts2.domain.UserData;

public class AppointmentDAO {
	@PersistenceContext(unitName="StrutsPersistence")
	protected EntityManager em;

	
	public List<AppointmentData> findAll(){
		Query q = em.createQuery("select m from AppointmentData m");
		List<AppointmentData> appointments = q.getResultList();
		return appointments;
	}
	
	public List<AppointmentData> getWeeklyForDoctor(Date weekStartDate,Date weekEndDate,Long doctorId) {
		StringBuilder builder = new StringBuilder();
		builder.append("Select app from AppointmentData app where app.doctor.id=:doctorId ");
		builder.append(" and app.date BETWEEN :startDate AND :endDate ");
		Query query = em.createQuery(builder.toString());
		query.setParameter("startDate",weekStartDate );
		query.setParameter("endDate", weekEndDate);
		query.setParameter("doctorId", doctorId);
		
		return query.getResultList();
	}
	
	public List<AppointmentData> getForUserAfterDate(Long userId, Date date) {
		StringBuilder builder = new StringBuilder();
		builder.append("Select app from AppointmentData app where app.user.id=:userId ");
		builder.append(" and app.date > :date");
		Query query = em.createQuery(builder.toString());
		query.setParameter("date",date );
		query.setParameter("userId", userId);
		
		return query.getResultList();
	}
	
	
	@Transactional
	public AppointmentData create(DoctorData doctor,UserData user, Date date){
		AppointmentData app = new AppointmentData();
		app.setDate(date);
		app.setDoctor(doctor);
		app.setUser(user);
		em.persist(app);
		return app;
	}

	@Transactional
	public void delete(AppointmentData app){
		em.remove(app);
	
	}
	@Transactional
	public AppointmentData modify(AppointmentData app){
		  return em.merge(app);
	}
}
