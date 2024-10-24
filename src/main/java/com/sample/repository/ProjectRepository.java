package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sample.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String>, JpaSpecificationExecutor<Project> {

}
