package pl.dmcs.nsai.struts2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users" )
//implementing userDetails for spring security
public class UserData implements Serializable , UserDetails{

	private static final long serialVersionUID = -7700909816583618817L;

	@Id
	@SequenceGenerator(name="users_id_seq",sequenceName="users_id_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="users_id_seq")
	@Column(name="id",updatable=false)
	private Long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="password")
	private String password;
	@ManyToMany(cascade=CascadeType.REMOVE)
	  @JoinTable(
	      name="user_role",
	      joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	      inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	private List<RoleData> roles = new ArrayList<>();
	
	public UserData(){
		
	}
	public UserData( String login, String name, String lastName,
			String email, String mobile, String password) {

		this.login = login;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name).append(" ").append(lastName);
		return builder.toString();
	}
	//Getters & setters
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}
	@Override
	public String getUsername() {
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<RoleData> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleData> roles) {
		this.roles = roles;
	}
	
	
}
