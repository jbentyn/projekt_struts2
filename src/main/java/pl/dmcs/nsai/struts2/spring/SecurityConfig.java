package pl.dmcs.nsai.struts2.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("user").roles("user");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		  .authorizeRequests()
		  .antMatchers("/").permitAll()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
			.and()
	    .formLogin()
	        .loginPage("/index")
	       // .usernameParameter("username")
	       // .passwordParameter("password")
	        .defaultSuccessUrl("/loginLogin.action") 
	        .failureUrl("/errorLogin.action");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		 web
	      .ignoring()
	         .antMatchers("/resources/**"); 
	}

}
