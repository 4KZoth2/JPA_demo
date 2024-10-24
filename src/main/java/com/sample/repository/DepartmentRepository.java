package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sample.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>, JpaSpecificationExecutor<Department> {

}
