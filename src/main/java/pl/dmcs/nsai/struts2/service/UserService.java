package pl.dmcs.nsai.struts2.service;

import org.springframework.beans.factory.annotation.Autowired;

import pl.dmcs.nsai.struts2.dao.UserDAO;
import pl.dmcs.nsai.struts2.domain.UserData;

public class UserService {

	@Autowired
	private UserDAO dao;
	
	public UserData findById(Long id){
		return dao.findById(id);
	}
}
