package com.sample.specification;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.sample.entity.EmployeeDetail;

public class EmployeeDetailSpecification {

	public static Specification<EmployeeDetail> employeeIdIn(final List<String> employeeIds) {
		return (root, query, builder) -> root.get("employeeId").in(employeeIds);
	}

	public static Specification<EmployeeDetail> hireDateMoreThan(final LocalDate hireDate) {
		return (root, query, builder) -> builder.greaterThan(root.get("hireDate"), hireDate);
	}

	public static Specification<EmployeeDetail> departmentIdNotEquals(final String departmentId) {
		return (root, query, builder) -> builder.notEqual(root.get("departmentId"), departmentId);
	}
}
