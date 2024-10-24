package com.sample.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "employee_id", length = 20)
	private String employeeId;

	@Column(name = "department_id", insertable = false, updatable = false)
	private String departmentId;

	/* EmployeeDetailからもEmployeeを参照しているので
	 * 得られたEntityのListをそのままJSON化する時に循環参照が発生してしまう。
	 * その対策として親側にはJsonManagedReference、子側にはJsonBackReferenceアノテーションを付与する。
	 */
	@OneToOne
	@JoinColumn(name = "employee_id")
	@JsonManagedReference
	private EmployeeDetail employeeDetail;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
}
