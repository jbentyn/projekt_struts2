package pl.dmcs.nsai.struts2.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.dmcs.nsai.struts2.dao.AppointmentDAO;
import pl.dmcs.nsai.struts2.dao.AppointmentException;
import pl.dmcs.nsai.struts2.domain.AppointmentData;
import pl.dmcs.nsai.struts2.domain.DoctorData;
import pl.dmcs.nsai.struts2.domain.UserData;
import pl.dmcs.nsai.struts2.util.DateUtil;

public class AppointmentService  {
	@Autowired
	private AppointmentDAO dao;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private UserService userService;
	
	
	
	public List<AppointmentData> getWeeklyForDoctor(String weekStartDate,String weekEndDate,Long doctorId) throws ParseException{
		Date start = DateUtil.FORMAT.parse(weekStartDate);
		Date end = DateUtil.FORMAT.parse(weekEndDate);
		return dao.getWeeklyForDoctor(start, end, doctorId);
	}
	public List<AppointmentData> getForUserAfterDate(Long userId, Date date) {
		return dao.getForUserAfterDate(userId, date);
	}
	public AppointmentData create ( Long doctorId, Long userId,String date) throws ParseException, AppointmentException{
		
		DoctorData doctor=doctorService.findById(doctorId);
		UserData user = userService.findById(userId);
		return dao.create(doctor, user,DateUtil.FORMAT_HOURS.parse(date));
	}
	
	public void delete (Long appId){
		dao.delete(appId);
	}
}
