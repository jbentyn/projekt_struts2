package pl.dmcs.nsai.struts2.spring;

import org.eclipse.persistence.internal.jpa.EntityManagerFactoryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import pl.dmcs.nsai.struts2.dao.UserDAO;

@Configuration
public class ApplicationConfig {

	@Bean
	public TestBean getTest(){
		TestBean test = new TestBean();
		test.setName("HHHHHHHHHHHHEEEEELLLLLOOOOO");
		return  test;
	}
	
	@Bean
	public UserDAO getUserDAO(){
		return new UserDAO();
	}
	

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
		LocalContainerEntityManagerFactoryBean b = new LocalContainerEntityManagerFactoryBean();
		b.setPersistenceXmlLocation("/WEB-INF/classes/META-INF/persistence.xml");
		// LOAD TIME WEAVER??
		return b;
	}
}
