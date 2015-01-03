package pl.dmcs.nsai.struts2.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.dmcs.nsai.struts2.dao.UserDAO;
import pl.dmcs.nsai.struts2.domain.UserData;

public class SecurityUserService  implements  UserDetailsService{

	@Autowired
	UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		System.out.println("USER SECURITY SERVICE");
		UserData user = userDao.findByLogin(username);
		if (user == null){
			throw new UsernameNotFoundException("User for username " + username + "was not found.");
		}
		return user;
	}

}
