package pl.dmcs.nsai.struts2.actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import pl.dmcs.nsai.struts2.domain.DoctorData;
import pl.dmcs.nsai.struts2.service.DoctorService;
import pl.dmcs.nsai.struts2.util.JSONUtil;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-2-nsai")
@Namespace("/")
@Results({ 
	@Result(name = "input", type = "tiles", location = "DoctorListDef")
})
@Action("*Doctor")
public class DoctorAction extends ActionSupport{
	private static final long serialVersionUID = -8182772525485270092L;
	@Autowired
	private DoctorService doctorService;
	private DoctorData doctor;
	private Long id;


	@Override
	public String execute() throws Exception {
		super.execute();
		return INPUT;
	}

	@Action("getAllDoctor")
	public String getAll() throws Exception{
		List<DoctorData> doctors = doctorService.findAll();
		String json=JSONUtil.doctorsListToJSON(doctors);
		JSONUtil.setJsonResponse(ServletActionContext.getResponse(), json);
		return null ;
	}

	@Action("createDoctor")
	public String create() throws Exception{
		doctorService.create(doctor);
		JSONUtil.setJsonResponse(ServletActionContext.getResponse(), "{}");
		return null;
	}

	@Action("modifyDoctor")
	public String modify() throws Exception{
		doctor.setId(id);
		doctorService.modify(doctor);
		JSONUtil.setJsonResponse(ServletActionContext.getResponse(), "{}");
		return null;
	}

	@Action("deleteDoctor")
	public String delete() throws Exception{
		doctorService.delete(id);
		JSONUtil.setJsonResponse(ServletActionContext.getResponse(), "{}");
		return null;
	}
	
	//Getters & setters
	public DoctorData getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorData doctor) {
		this.doctor = doctor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


}
