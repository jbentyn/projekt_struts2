package pl.dmcs.nsai.struts2.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import pl.dmcs.nsai.struts2.domain.AppointmentData;

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
	
	public static void setJsonResponse(HttpServletResponse response, String json) throws IOException{
		response.setContentType("application/json");
		PrintWriter out = response.getWriter(); 
		out.write(json);
	}
}
