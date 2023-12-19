package com.hightech.assign.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hightech.assign.entity.*;
import com.hightech.assign.repo.AssignRepo;
import com.hightech.assign.services.AssignServ;

@RestController
public class AssignController {
	
	@Autowired
	private AssignRepo repo;
	
	@Autowired
	private AssignServ assignServ;
	

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
//		List<PersonalInfo> p2=new ArrayList<>();
//		
//		p2.addAll(assignServ.getAllPersonalInfo());
	    assignServ.deleteById(id);
	    return new ResponseEntity<>("deleted id "+id,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllData(){
		List<PersonalInfo> p=new ArrayList<>();
		
		p.addAll(assignServ.getAllPersonalInfo());
		return new ResponseEntity<>( p,HttpStatus.OK);
	}
	@GetMapping("/personal/{id}")
	public ResponseEntity<?> DataByPersonalId(@PathVariable Long id){
	    Optional<PersonalInfo> optionalPersonalInfo = assignServ.getPersonalInfoById(id);
	    if (optionalPersonalInfo.isPresent()) {
	        List<PersonalInfo> p1 = new ArrayList<>();
	        p1.add(optionalPersonalInfo.get());
	        return new ResponseEntity<>(p1, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	

	@GetMapping("/byname/{name}")
	public ResponseEntity<?> DataByPersonalId(@PathVariable String name){
		Optional<PersonalInfo> optionalPersonalInfo = assignServ.getDataByname(name);
		if (optionalPersonalInfo.isPresent()) {
			List<PersonalInfo> p3 = new ArrayList<>();
			p3.add(optionalPersonalInfo.get());
			return new ResponseEntity<>(p3, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/byexp/{exp}")
	public ResponseEntity<?> DataByExp(@PathVariable int exp){
	    List<Integer> ids = assignServ.dataByExp(exp);
	    List<PersonalInfo> p3 = new ArrayList<>();
	    if(!ids.isEmpty()) {
		    for(Integer id : ids){
		        Optional<PersonalInfo>info=assignServ.getPersonalInfoById(Long.valueOf(id));
		        info.ifPresent(p3::add);
		    }
		    return new ResponseEntity<>(p3, HttpStatus.OK);
	    }
	    
	    return new ResponseEntity<>("No PersonalInfo found for the given exp", HttpStatus.NOT_FOUND);
	    
	}
	
	
	@PostMapping("/reg")
	public ResponseEntity<?>SetAllInfo(@RequestBody String t){
		
		
		
		PersonalInfo personalInfo=new PersonalInfo();
		personalInfo.setId((long) 3);
		personalInfo.setFirstName("Aashu");
		personalInfo.setLastName("Sondhiya");
		personalInfo.setPhoneNumber("9876543210");
		personalInfo.setEmail("aashu@gmail.com");
		personalInfo.setPassword("54321");

		ArrayList<AddressInfo> addressInfoArrayList=new ArrayList<>();
		
		AddressInfo addressInfo=new AddressInfo();
		//addressInfo.setId((long) 11);
		addressInfo.setBuildingNumber("196");
		addressInfo.setCity("Sihora");
		addressInfo.setCountry("India");
		addressInfo.setLandmark("abc");;
		addressInfo.setPostalCode("483225");
		addressInfo.setState("M.P.");
		addressInfo.setStreetAddress("khitola");
		addressInfo.setPersonalInfo(personalInfo);
		
		AddressInfo addressInfo1=new AddressInfo();
		//addressInfo.setId((long) 11);
		addressInfo1.setBuildingNumber("19");
		addressInfo1.setCity("jbp");
		addressInfo1.setCountry("India");
		addressInfo1.setLandmark("abcd");;
		addressInfo1.setPostalCode("482001");
		addressInfo1.setState("M.P.");
		addressInfo1.setStreetAddress("khola");
		addressInfo1.setPersonalInfo(personalInfo);
		
		addressInfoArrayList.add(addressInfo);
		addressInfoArrayList.add(addressInfo1);
		
		ProjectInfo projectInfo=new ProjectInfo();
		//projectInfo.setProjectId(11);
		projectInfo.setProjectDescription(null);
		projectInfo.setProjectManager(null);
		projectInfo.setProjectName(null);
		projectInfo.setPersonalInfo(personalInfo);
		
		
		SkillInfo skillInfo=new SkillInfo();
		//skillInfo.setId(11);
		skillInfo.setCategory(null);
		skillInfo.setDescription(null);
		skillInfo.setExperience(0);
		skillInfo.setName("Aashu Sondhiya");
		skillInfo.setPersonalInfo(personalInfo);
		
		
		personalInfo.setAddressInfo(addressInfoArrayList);
		personalInfo.setProjectInfo(projectInfo);
		personalInfo.setSkillInfo(skillInfo);
		
		try {
			repo.save(personalInfo);
			
		}catch(Exception e) {
			
			return new ResponseEntity<>("failed to save", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	
}
