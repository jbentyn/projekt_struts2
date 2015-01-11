package pl.dmcs.nsai.struts2.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pl.dmcs.nsai.struts2.service.CustomDeniedHandler;
import pl.dmcs.nsai.struts2.service.UserService;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userDetailsService;
	

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	
	@Autowired
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
			.antMatchers("/images/**").permitAll()
			.antMatchers("/views/js/**").permitAll()
			.antMatchers("/views/layout/**").permitAll()
			.antMatchers("/views/Login.jsp").permitAll()
			.antMatchers("/views/Welcome.jsp").permitAll()
			.antMatchers("/*Welcome.action").permitAll()
			.antMatchers("/initRegisterUser.action").permitAll()
			.antMatchers("/registerUser.action").permitAll()
			.antMatchers("/captcha.action").permitAll()
			.antMatchers("/denied.action").permitAll()
			
			.antMatchers("/*User.action").hasRole("ADMIN")
			.antMatchers("/*Doctor.action").hasRole("ADMIN")
			.antMatchers("/deleteAppointment.action").hasRole("ADMIN")
			.antMatchers("/*Appointment.action").hasAnyRole(new String []{"USER","ADMIN"})
		.and()
		.rememberMe()
		.and()
		.exceptionHandling()
		.accessDeniedHandler(new CustomDeniedHandler()) // doesn't work with annotation based restrictions
		.and()
		.formLogin()
			.loginPage("/initLogin.action")
			.defaultSuccessUrl("/initWelcome.action")
			.permitAll()
		.and()
		.logout()
			.logoutSuccessUrl("/initWelcome.action");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		 web
	      .ignoring()
	         .antMatchers("/resources/**"); 
	}

}
