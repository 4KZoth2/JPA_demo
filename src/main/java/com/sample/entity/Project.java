package com.sample.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "project_id", length = 20)
    private String projectId;

    @Column(name = "project_name", nullable = false, length = 100)
    private String projectName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;


}
