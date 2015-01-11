<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../Tags.jsp"%>
<%@ include file="../Messages.jsp"%>

<div class="form-container">
<s:form action="registerUser" cssClass="form-horizontal"  validate="true">
  <fieldset>
    <legend>Register</legend>
    <div class="form-group">
      <label for="inputName" class="col-lg-2 control-label">Name</label>
      <div class="col-lg-10">
        <input name="user.name" class="form-control" id="inputName" placeholder="Name" type="text"><s:fielderror fieldName="user.name" />
      </div>
    </div>
    <div class="form-group">
      <label for="inputLastName" class="col-lg-2 control-label">Last Name</label>
      <div class="col-lg-10">
        <input name="user.lastName" class="form-control" id="inputLastName" placeholder="LastName" type="text"><s:fielderror fieldName="user.lastName" />
      </div>
    </div>
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">Email</label>
      <div class="col-lg-10">
        <input name="user.email" class="form-control" id="inputEmail" placeholder="Email" type="text"><s:fielderror fieldName="user.email" />
      </div>
    </div>
    <div class="form-group">
      <label for="inputMobile" class="col-lg-2 control-label">Mobile</label>
      <div class="col-lg-10">
        <input name="user.mobile" class="form-control" id="inputMobile" placeholder="Mobile" type="text"><s:fielderror fieldName="user.mobile" />
      </div>
    </div>
    <div class="form-group">
      <label for="inputLogin" class="col-lg-2 control-label">Login</label>
      <div class="col-lg-10">
        <input name="user.login" class="form-control" id="inputLogin" placeholder="Login" type="text"><s:fielderror fieldName="user.login" />
      </div>
    </div>
    
    <div class="form-group">
      <label for="inputPassword" class="col-lg-2 control-label">Password</label> 
      <div class="col-lg-10">
        <input name ="password" class="form-control" id="inputPassword" placeholder="Password" type="password"><s:fielderror fieldName="password" />
      </div>
    </div>
      <div class="form-group">
      <label for="inputPasswordConfirm" class="col-lg-2 control-label">Confirm password</label>
      <div class="col-lg-10">
        <input name ="passwordConfirm" class="form-control" id="inputPasswordConfirm" placeholder="PasswordConfirm" type="password">
      </div>
    </div>

		<div class="form-group">
			<label for="inputPasswordConfirm" class="col-lg-2 control-label">Captcha</label>
			<div class="col-lg-10">
				<img id="captchaImg" src="<s:url action='captcha'/>" alt="Captcha Image" height="45">
				<div>
					<input name="captchaAnswer" size="30" />
				</div>
				<div>Cannot read? Refresh page for new CAPTCHA.</div>
			</div>

		</div>



		<div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <button  type="submit" class="btn btn-primary float-right">Submit</button>
      </div>
    </div>
  </fieldset>
</s:form>
</div>