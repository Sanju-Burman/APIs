package com.hightech.assign.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hightech.assign.entity.SkillInfo;

public interface SkillRepo extends JpaRepository<SkillInfo, Long> {

}
