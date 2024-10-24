package com.sample.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "department")
public class Department {

	@Id
	@Column(name = "department_id", length = 20)
	private String departmentId;

	@Column(name = "department_name", nullable = false, length = 100)
	private String departmentName;

	@Column(name = "establishment_date")
	private LocalDate establishmentDate;

	@Column(name = "dissolution_flag")
	private Boolean dissolutionFlag;
}
