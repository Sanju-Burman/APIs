package com.hightech.assign.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hightech.assign.entity.PersonalInfo;
import com.hightech.assign.repo.AssignRepo;
@Service
public class AssignServ {

	@Autowired
	AssignRepo assignRepo;
	
	public List<PersonalInfo> getAllPersonalInfo(){
		return assignRepo.findAll();
		
	}
	public Optional<PersonalInfo> getPersonalInfoById(Long id){
		return assignRepo.findById(id);
		
	}
	public Optional<PersonalInfo> getDataByname(String name){
		Long id=assignRepo.idByname(name);
		return assignRepo.findById(id);
		
	}
	
	
	public void deleteById(Long id) {
		assignRepo.deleteById(id);
	}
	
	public List<Integer> dataByExp(int exp) {
		return assignRepo.expToId(exp);
	}
	
}
