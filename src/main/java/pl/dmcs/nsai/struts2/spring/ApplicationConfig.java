package pl.dmcs.nsai.struts2.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.dmcs.nsai.struts2.dao.AppointmentDAO;
import pl.dmcs.nsai.struts2.dao.DoctorDAO;
import pl.dmcs.nsai.struts2.dao.UserDAO;
import pl.dmcs.nsai.struts2.service.AppointmentService;
import pl.dmcs.nsai.struts2.service.DoctorService;
import pl.dmcs.nsai.struts2.service.UserService;

@Configuration
@EnableTransactionManagement
public class ApplicationConfig {

	
	@Bean
	public UserDAO getUserDAO(){
		return new UserDAO();
	}
	@Bean
	public UserService getUserService(){
		return new UserService();
	}
	
	@Bean
	public AppointmentDAO getAppointmentDAO(){
		return new AppointmentDAO();
	}
	
	@Bean
	public AppointmentService getAppointmentService(){
		return new AppointmentService();
	}
	
	@Bean
	public DoctorDAO getDoctorDAO(){
		return new DoctorDAO();
	}
	
	@Bean
	public DoctorService getDoctorService(){
		return new DoctorService();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
		LocalContainerEntityManagerFactoryBean b = new LocalContainerEntityManagerFactoryBean();
		b.setPersistenceXmlLocation("/WEB-INF/classes/META-INF/persistence.xml");
		return b;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				getEntityManagerFactory().getObject() );
		return transactionManager;
	}
}
