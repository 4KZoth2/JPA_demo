package com.sample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name", nullable = false, length = 100)
    private String taskName;

	@Column(name = "project_id", insertable = false, updatable = false)
	private String projectId;

	@Column(name = "employee_id", insertable = false, updatable = false)
    private String employeeId;

    @Column(name = "progress_status", length = 50)
    private String progressStatus;

}
