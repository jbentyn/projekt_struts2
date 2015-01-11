package pl.dmcs.nsai.struts2.actions;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.security.access.prepost.PreAuthorize;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The example login action using XML based configuration
 * @author KCH, JB
 *
 */
public class LoginAction extends ActionSupport  {
	private static final long serialVersionUID = -367541240516039861L;

	@SkipValidation
	public String init() throws Exception {	
		return INPUT;
	}



}
