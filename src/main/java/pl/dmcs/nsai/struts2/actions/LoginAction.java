package pl.dmcs.nsai.struts2.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import pl.dmcs.nsai.struts2.dao.UserDAO;
import pl.dmcs.nsai.struts2.domain.UserData;
import pl.dmcs.nsai.struts2.spring.TestBean;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The example login action using XML based configuration
 * @author KCH, JB
 *
 */
public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -367541240516039861L;

	/**
	 * The name of the session parameter storing the user context of the current user
	 */
	public static final String USER_CONTEXT_PARAM_NAME = "USER_CONTEXT";

	private String username;
	private String password;

	@Autowired
	private TestBean test;

	public TestBean getTest() {
		return test;
	}

	public void setTest(TestBean test) {
		this.test = test;
	}

	@Autowired
	private UserDAO userDAO;


	private Map<String, Object> session = new HashMap<>();
	@SkipValidation
	public String login() throws Exception {
//		//put the username to the session parameter
//		this.session.put(USER_CONTEXT_PARAM_NAME, this.username);

		
		return SUCCESS;
	}

	@SkipValidation
	public String jpaTest(){
		System.out.println(test.getName());	
		System.out.println("----------------------");
		System.out.println(ServletActionContext.getServletContext().getRealPath(""));
		System.out.println(userDAO.findAll());	
		return null;
	}
	
	@SkipValidation
	public String error(){
		return "error";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
