package pl.dmcs.nsai.struts2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.dmcs.nsai.struts2.dao.UserDAO;
import pl.dmcs.nsai.struts2.domain.UserData;

public class UserService implements UserDetailsService{

	@Autowired
	private UserDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		System.out.println("USER SECURITY SERVICE");
		System.out.println("Username "+username);
		UserData user = dao.findByLogin(username);
		if (user == null){
			throw new UsernameNotFoundException("User for username " + username + "was not found.");
		}
		return user;
	}

	public UserData findById(Long id){
		return dao.findById(id);
	}
	public List<UserData> findAll(){
		return dao.findAll();
	}

	public UserData create(UserData user){
		
		return dao.create(user);
	}
	
	public void delete(UserData user){
		dao.delete(user);
	}

	public void delete(Long id){
		dao.delete(id);
	}
	public UserData modify(UserData user){
		return dao.modify(user);
	}
}
