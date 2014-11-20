package pl.dmcs.nsai.struts2.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport {

	private static final long serialVersionUID = -6491563250113483257L;
	
	// ADD NEW STRING - AJAX example
	private String someString;
	private List<String> strings = new ArrayList<>();

	/**
	 * Example AJAX action, which add new string to the list
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addString() throws Exception {
		this.strings.add(this.someString);
		this.someString = "";
		return SUCCESS;
	}

	/**
	 * The 3rd way to process validation
	 */
	public void validate() {
		// perform validation for the "addString" action
		if (ActionContext.getContext().getName().contains("addString")) {
			if (StringUtils.isEmpty(this.someString)) {
				this.addFieldError("someString", getText("errors.required", new String[] { "someString" }));
			}
		}
	}

	public String getSomeString() {
		return someString;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}

	public List<String> getStrings() {
		return strings;
	}

	public void setStrings(List<String> strings) {
		this.strings = strings;
	}
}
