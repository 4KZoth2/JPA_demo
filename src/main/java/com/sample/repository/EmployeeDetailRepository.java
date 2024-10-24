package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sample.entity.EmployeeDetail;

public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail, String>, JpaSpecificationExecutor<EmployeeDetail> {

}
