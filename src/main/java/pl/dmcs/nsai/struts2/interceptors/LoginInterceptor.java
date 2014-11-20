package pl.dmcs.nsai.struts2.interceptors;

import java.util.Map;

import pl.dmcs.nsai.struts2.actions.LoginAction;
import pl.dmcs.nsai.struts2.actions.RegisterAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Interceptor checks whether the current session has expired and redirects user to the login page.
 * @author KCH, JB
 *
 */
public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 3202644269719474460L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> sessionAttributes = invocation.getInvocationContext().getSession();
		ActionSupport action = (ActionSupport) invocation.getAction();
		
		//validates all actions except LoginAction and RegisterAction
		boolean validateAction = !(action instanceof LoginAction || action instanceof RegisterAction); 
		
		//check if session has expired
		if (validateAction && (sessionAttributes == null || sessionAttributes.get(LoginAction.USER_CONTEXT_PARAM_NAME) == null)) {
			action.addActionError(action.getText("errors.sessionExpired"));

			//if session expired then move user to the login page
			//@see global-results in the struts.xml file
			return "sessionExpired";
		}

		//if session is still active then continue action invocation
		return invocation.invoke();
	}
}
