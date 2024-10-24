package com.sample.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_detail")
public class EmployeeDetail {

    @Id
    @Column(name = "employee_id", insertable = false, updatable = false)
    private String employeeId;

    @Column(name = "department_id", insertable = false, updatable = false)
    private String departmentId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    /* EmployeeからもEmployeeDetailを参照しているので
	 * 得られたEntityのListをそのままJSON化する時に循環参照が発生してしまう。
	 * その対策として親側にはJsonManagedReference、子側にはJsonBackReferenceアノテーションを付与する。
	 */
    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;
}
