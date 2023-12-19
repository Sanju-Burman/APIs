package com.hightech.assign.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hightech.assign.entity.PersonalInfo;


@Repository
public interface AssignRepo extends JpaRepository<PersonalInfo,Long > {
		
//	@Query(value = "SELECT * FROM icmrdata WHERE email = :email ", nativeQuery = true)
//	public List<PersonalInfo> getAllInfoByName(String name);
	
//	@Query(value = "SELECT profile_id FROM parsonal_info WHERE first_name= :name ", nativeQuery = true)
//	public Long idByname(String name);
	@Query(value = "SELECT personal_info_profile_id FROM skill_info WHERE name= :name ", nativeQuery = true)
	public Long idByname(String name);
	@Query(value = "SELECT personal_info_profile_id FROM skill_info WHERE experience= :exp ", nativeQuery = true)
	public List<Integer> expToId(int exp);
	//public List<List<PersonalInfo>> findAllById(Iterable<Integer> ids);
}
