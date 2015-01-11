package pl.dmcs.nsai.struts2.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

import pl.dmcs.nsai.struts2.dao.AppointmentException;
import pl.dmcs.nsai.struts2.domain.AppointmentData;
import pl.dmcs.nsai.struts2.domain.DoctorData;
import pl.dmcs.nsai.struts2.domain.UserData;
import pl.dmcs.nsai.struts2.service.AppointmentService;
import pl.dmcs.nsai.struts2.service.DoctorService;
import pl.dmcs.nsai.struts2.service.UserService;
import pl.dmcs.nsai.struts2.util.JSONUtil;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-2-nsai")
@Namespace("/")
@Results({ 
	@Result(name = "input", type = "tiles", location = "AppointmentDef")
})
@Action("*Appointment")
public class AppointmentAction extends ActionSupport {

	private static final long serialVersionUID = -5857737360465159998L;
	@Autowired
	private AppointmentService  appService;
	@Autowired
	private DoctorService  doctorService;
	@Autowired
	private UserService  userService;
	
	private List<DoctorData> doctors = new ArrayList<>();
	private List<UserData> users = new ArrayList<>();
	private String start;
	private String end;
	private Long doctorId;
	private Long appointmentId;
	private Long userId;
	
	
	@Action("initAppointment")
	public String execute() {
		doctors = doctorService.findAll();
		users = userService.findAll();
		return INPUT;
	}
	
	@Action("loadAppointment")
	public String load() throws Exception{
		if (doctorId!=null){
			String json=JSONUtil.appointmentsListToJSON(appService.getWeeklyForDoctor(start, end, doctorId));
			JSONUtil.setJsonResponse(ServletActionContext.getResponse(), json);
		}
		return null;
	}
	
	
	@Action("createAppointment")
	public String create() throws Exception{
		if (doctorId!=null){
			Long appUserId;
			if ( ServletActionContext.getRequest().isUserInRole("ROLE_ADMIN") ){
				appUserId = userId;
			}
			else{
				UserData user = (UserData)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				appUserId=user.getId();
			}
			
			
			List<AppointmentData> futureAppointments= appService.getForUserAfterDate( appUserId, new Date());
			if( !futureAppointments.isEmpty()){
				ServletActionContext.getResponse().sendError(HttpServletResponse.SC_PRECONDITION_FAILED );
				return null;
			}
			try{
				AppointmentData app=appService.create(doctorId, appUserId, start);
				String json=JSONUtil.appointmentToJSON(app).toString();
				JSONUtil.setJsonResponse(ServletActionContext.getResponse(), json);
			}
			catch(AppointmentException ex){
				ServletActionContext.getResponse().sendError(HttpServletResponse.SC_EXPECTATION_FAILED);
				return null;
			}
		}
		return null;	
	}
	

	@Action("deleteAppointment")
	public String delete() throws Exception{
		appService.delete(appointmentId);
		return null;
	}
	
	//Getters & setters
	public List<DoctorData> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<DoctorData> doctors) {
		this.doctors = doctors;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public List<UserData> getUsers() {
		return users;
	}
	public void setUsers(List<UserData> users) {
		this.users = users;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	
	

}
