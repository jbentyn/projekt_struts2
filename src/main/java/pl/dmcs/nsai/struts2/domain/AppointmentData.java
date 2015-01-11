package pl.dmcs.nsai.struts2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="appointment")
public class AppointmentData implements Serializable {
	
	private static final long serialVersionUID = 378800129835547506L;

	@Id
	@SequenceGenerator(name="appointment_id_seq",sequenceName="appointment_id_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="appointment_id_seq")
	@Column(name="id",updatable=false)
	private Long id;
	
	@Column(name="app_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="user_id")
	private UserData user;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="doctor_id")
	private DoctorData doctor;

	
	//Getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public DoctorData getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorData doctor) {
		this.doctor = doctor;
	}
	
	
	
	
}
