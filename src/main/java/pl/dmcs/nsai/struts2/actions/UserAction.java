package pl.dmcs.nsai.struts2.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import nl.captcha.Captcha;
import nl.captcha.gimpy.DropShadowGimpyRenderer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.DefaultTextProducer;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import pl.dmcs.nsai.struts2.domain.UserData;
import pl.dmcs.nsai.struts2.service.UserService;
import pl.dmcs.nsai.struts2.util.JSONUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-2-nsai")
@Namespace("/")
@Results({ 
	@Result(name = "list", type = "tiles", location = "UserListDef"),
	@Result(name = "input", type = "tiles", location = "UserRegistrationDef"),
	@Result(name = "initRegister", type = "tiles", location = "UserRegistrationDef"),
	@Result(name = "index", type = "tiles", location = "WelcomeDef")
})
@Action("*User")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 2276912746177447401L;

	@Autowired
	private UserService userService;
	private UserData user = new UserData();
	private Long id;
	private String password;
	private String passwordConfirm;
	private InputStream inputStream;
	private String captchaAnswer;

	@SkipValidation
	@Action("listUser")
	public String listUser() throws Exception {	
		return "list";
	}
	@SkipValidation
	@Action("getAllUser")
	public String getAll() throws Exception{
		List<UserData> users = userService.findAll();
		String json=JSONUtil.usersListToJSON(users);
		JSONUtil.setJsonResponse(ServletActionContext.getResponse(), json);
		return null ;
	}
	@Action("createUser")
	public String createUser() throws Exception{
		userService.create(user);
		JSONUtil.setJsonResponse(ServletActionContext.getResponse(), "{}");
		return null;
	}
	@Action("modifyUser")
	public String modifyUser() throws Exception{
		user.setId(id);
		userService.modify(user);
		JSONUtil.setJsonResponse(ServletActionContext.getResponse(), "{}");
		return null;
	}
	@SkipValidation
	@Action("deleteUser")
	public String deleteUser() throws Exception{
		userService.delete(id);
		JSONUtil.setJsonResponse(ServletActionContext.getResponse(), "{}");
		return null;
	}

	@SkipValidation
	@Action("initRegisterUser")
	public String initRegisterUser() throws Exception{
		clearErrorsAndMessages();
		return "initRegister";
	}

	@Action("registerUser")
	public String registerUser() throws Exception{
		clearErrorsAndMessages();
		String correctCaptcha =(String)ActionContext.getContext().getSession().get("CorrectAnswer");
		if ( !correctCaptcha.equalsIgnoreCase(captchaAnswer)){
			addActionError("Wrong captcha text");
		}
		if (password.equals(passwordConfirm)){
			user.setPassword(password);
			userService.create(user);

		}else{
			addActionError("Password and password confirmation are not the same!");
		}
		if (hasErrors()){
			return "initRegister";
		}
		else{
			addActionMessage("registerDone");
			return "index";
		}
	}

	@SkipValidation
	@Action(value = "captcha", results = {@Result(type="stream", params = {"contentType", "image/jpeg"})})
	public String captcha() throws Exception{
		Captcha captcha = new Captcha.Builder(200, 50).addText(new DefaultTextProducer()).gimp(new DropShadowGimpyRenderer()).build();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		CaptchaServletUtil.writeImage(outputStream, captcha.getImage());
		ActionContext.getContext().getSession().put("CorrectAnswer", captcha.getAnswer());
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		return SUCCESS;
	}

	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getCaptchaAnswer() {
		return captchaAnswer;
	}
	public void setCaptchaAnswer(String captchaAnswer) {
		this.captchaAnswer = captchaAnswer;
	}

}
