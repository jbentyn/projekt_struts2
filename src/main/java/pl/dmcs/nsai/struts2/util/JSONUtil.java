package pl.dmcs.nsai.struts2.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import pl.dmcs.nsai.struts2.domain.AppointmentData;
import pl.dmcs.nsai.struts2.domain.DoctorData;
import pl.dmcs.nsai.struts2.domain.UserData;

public class JSONUtil {
	
	
	public static JSONObject appointmentToJSON(AppointmentData app){
		JSONObject json = new JSONObject();
		json.put("id", app.getId() );
		json.put("start", DateUtil.FORMAT_HOURS.format(app.getDate()));
		return json;
	}
	
	public static String appointmentsListToJSON(List<AppointmentData> list){
		JSONArray  appointments = new JSONArray();
		for (int i = 0 ; i < list.size(); i++){
			appointments.put(appointmentToJSON(list.get(i)));
		}
		return appointments.toString();
	}
	

	public static JSONObject userToJSON(UserData user){
		JSONObject json = new JSONObject();
		json.put("id", user.getId());
		json.put("email", user.getEmail());
		json.put("lastName", user.getLastName());
		json.put("login", user.getLogin());
		json.put("mobile", user.getMobile());
		json.put("name", user.getName());
		return json;
	}
	
	public static String usersListToJSON(List<UserData> list){
		JSONArray  users = new JSONArray();
		for (int i = 0 ; i < list.size(); i++){
			users.put(userToJSON(list.get(i)));
		}
		return users.toString();
	}
	
	public static JSONObject doctorToJSON(DoctorData doctor){
		JSONObject json = new JSONObject();
		json.put("id", doctor.getId());
		json.put("lastName", doctor.getLastName());
		json.put("name", doctor.getName());
		return json;
	}
	
	public static String doctorsListToJSON(List<DoctorData> list){
		JSONArray  users = new JSONArray();
		for (int i = 0 ; i < list.size(); i++){
			users.put(doctorToJSON(list.get(i)));
		}
		return users.toString();
	}
	
	public static void setJsonResponse(HttpServletResponse response, String json) throws IOException{
		response.setContentType("application/json");
		PrintWriter out = response.getWriter(); 
		out.write(json);
	}
}
