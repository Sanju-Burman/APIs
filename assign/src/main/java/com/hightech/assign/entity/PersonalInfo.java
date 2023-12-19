package com.hightech.assign.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parsonal_info")
public class PersonalInfo {

	@Id
	@Column(name = "profile_Id")
	private Long id;

	@Column(name = "first_Name")
	private String firstName;

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "phone_Number")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy="personalInfo",cascade=CascadeType.ALL)
	private List<AddressInfo> addressInfo;

	@OneToOne(mappedBy="personalInfo",cascade=CascadeType.ALL)
	private ProjectInfo projectInfo;
	
	@OneToOne(mappedBy="personalInfo",cascade=CascadeType.ALL)
	private SkillInfo skillInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AddressInfo> getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(List<AddressInfo> addressInfo) {
		this.addressInfo = addressInfo;
	}

	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	public SkillInfo getSkillInfo() {
		return skillInfo;
	}

	public void setSkillInfo(SkillInfo skillInfo) {
		this.skillInfo = skillInfo;
	}

	@Override
	public String toString() {
		return "PersonalInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", password=" + password + ", addressInfo=" + addressInfo
				+ ", projectInfo=" + projectInfo + ", skillInfo=" + skillInfo + "]";
	}
	
	
}
