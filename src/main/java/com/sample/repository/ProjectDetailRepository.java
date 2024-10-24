package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sample.entity.ProjectDetail;

public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, Long>, JpaSpecificationExecutor<ProjectDetail> {
	
}
