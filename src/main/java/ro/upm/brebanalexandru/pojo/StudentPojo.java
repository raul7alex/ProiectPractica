package ro.upm.brebanalexandru.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class StudentPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotBlank
	@Column(name = "firstname")
	private String firstname;
	
	@NotBlank
	@Column(name = "lastname")
	private String lastname;

	@NotBlank
	@Column(name = "profile")
	private String profile;
	
	@Column(name = "year")
	private Integer year;
	
	@Column(nullable = false, updatable = false,name = "registrationdate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date registrationdate;
	
	@Column(nullable = false,name = "lastmodificaton")///test
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
	private Date lastmod;
	
	@Column(name = "status")
	private Integer status;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}



	public Date getRegistrationdate() {
		return registrationdate;
	}



	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}



	public Date getLastmod() {
		return lastmod;
	}



	public void setLastmod(Date lastmod) {
		this.lastmod = lastmod;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "StudentPOJO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", year=" + year
				+ ", profile=" + profile + ", status=" + status + ", registrationdate=" + registrationdate
				+ ", lastmodificaton=" + lastmod + "]";
	}
	
	
	
	
}
