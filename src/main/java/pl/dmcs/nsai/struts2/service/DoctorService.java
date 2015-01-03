package pl.dmcs.nsai.struts2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.dmcs.nsai.struts2.dao.DoctorDAO;
import pl.dmcs.nsai.struts2.domain.DoctorData;

public class DoctorService {
	@Autowired
	private DoctorDAO dao;
	
	public List<DoctorData> findAll(){
		return dao.findAll();
	}
	
	public DoctorData findById(Long id){
		return dao.findById(id);
	}
}
