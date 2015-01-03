package pl.dmcs.nsai.struts2.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-2-nsai")
@Namespace("/")
@Results({ 
	@Result(name = "input", type = "tiles", location = "WelcomeDef")
})
@Action("*Welcome")
public class WelcomeAction extends ActionSupport {
	private static final long serialVersionUID = 3589172527820520033L;

	@Override
	@SkipValidation
	public String execute() throws Exception {
		super.execute();
		return INPUT;
	}
	
}
