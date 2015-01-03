package pl.dmcs.nsai.struts2.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class DoctorData implements Serializable {

	private static final long serialVersionUID = 7349521060835355118L;

	@Id
	@SequenceGenerator(name="doctor_id_seq",sequenceName="doctor_id_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="doctor_id_seq")
	@Column(name="id",updatable=false)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;

	public DoctorData(){
	
	}
	
	public DoctorData( String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name).append(" ").append(lastName);
		return builder.toString();
	}
	
	
}
