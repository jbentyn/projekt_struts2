package pl.dmcs.nsai.struts2.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@ParentPackage("struts-2-nsai")
@Namespace("/")
@Results({ 
	@Result(name = "input", type = "tiles", location = "RegisterDef"),
	@Result(name = "success", type = "tiles", location = "LoginDef")
})
@Action("*Register")
@Validations(
		expressions = {
			@ExpressionValidator(expression = "password eq passwordConfirm", message = "${getText('labels.register.invalidpasswordConfirm')}")
		}
)
public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = -87122263505775714L;

	private String username;
	private String password;
	private String passwordConfirm;
	
	@Override
	@SkipValidation
	public String execute() throws Exception {
		super.execute();
		return INPUT;
	}
	
	@Action("registerRegister")
	public String register() throws Exception {
		return SUCCESS;
	}

	@RequiredStringValidator(message = "${getText('errors.required', new java.lang.String[]{fieldName})}")
	public void setUsername(String username) {
		this.username = username;
	}

	@RequiredStringValidator(message = "${getText('errors.required', new java.lang.String[]{fieldName})}")
	public void setPassword(String password) {
		this.password = password;
	}

	@RequiredStringValidator(message = "${getText('errors.required', new java.lang.String[]{fieldName})}", shortCircuit = true)
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPassword() {
		return password;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	
	public String getUsername() {
		return username;
	}
}
