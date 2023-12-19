package com.hightech.assign.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_info")
public class ProjectInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_Id")
	private long projectId;
	
	@Column(name = "project_Name")
	private String projectName;

	@Column(name = "project_Description")
	private String projectDescription;

	@Column(name = "project_Manager")
	private String projectManager;
	
	@OneToOne
	@JsonIgnore
	private PersonalInfo personalInfo;


	public long getProjectId() {
		return projectId;
	}


	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectDescription() {
		return projectDescription;
	}


	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


	public String getProjectManager() {
		return projectManager;
	}


	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}


	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}


	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}


	@Override
	public String toString() {
		return "ProjectInfo [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", projectManager=" + projectManager + ", personalInfo=" + personalInfo + "]";
	}
	
	
}
