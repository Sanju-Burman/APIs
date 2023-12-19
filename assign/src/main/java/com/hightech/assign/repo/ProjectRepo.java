package com.hightech.assign.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hightech.assign.entity.AddressInfo;

public interface ProjectRepo extends JpaRepository<AddressInfo,Long> {

}
