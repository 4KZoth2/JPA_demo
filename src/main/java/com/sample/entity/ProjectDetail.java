package com.sample.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "project_detail")
public class ProjectDetail {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_detail_id")
    private Long projectDetailId;

	@Column(name = "project_id", insertable = false, updatable = false)
	private String projectId;

	@Column(name = "employee_id", insertable = false, updatable = false)
    private String employeeId;

    @Column(name = "role_name", length = 100)
    private String roleName;

    @Column(name = "assignment_date")
    private LocalDate assignmentDate;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private EmployeeDetail employeeDetail;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
