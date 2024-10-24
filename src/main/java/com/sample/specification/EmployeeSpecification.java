package com.sample.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sample.entity.Employee;
import com.sample.entity.EmployeeDetail;

import jakarta.persistence.criteria.JoinType;

public class EmployeeSpecification {

	public static Specification<Employee> joinEmployeeDetail() {
		return (root, query, builder) -> {
			root.fetch("employeeDetail", JoinType.INNER);
			return null;
		};
	}

	public static Specification<Employee> employeeIdEquals(final String employeeId) {
		return (root, query, builder) -> builder.equal(root.get("employeeId"), employeeId);
	}

	public static Specification<Employee> departmentIdEquals(final String departmentId) {
		return (root, query, builder) -> builder.equal(root.get("firstName"), departmentId);
	}

	public static Specification<Employee> nameEquals(final String name) {
		return (root, query, builder) ->
			builder.equal(root.get("employeeDetail").<EmployeeDetail>get("name"), name);
	}
}
