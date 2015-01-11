package pl.dmcs.nsai.struts2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role" )
public class RoleData  implements GrantedAuthority{

	private static final long serialVersionUID = 1296673494306018668L;


	@Id
	@SequenceGenerator(name="role_id_seq",sequenceName="role_id_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="role_id_seq")
	@Column(name="id",updatable=false)
	private Long id;
	

	@Column(name="name",updatable=false, nullable=false)
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getAuthority() {
		
		return name;
	}


}
