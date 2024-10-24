package com.sample.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sample.entity.EmployeeDetail;
import com.sample.entity.ProjectDetail;

import jakarta.persistence.criteria.JoinType;

public class ProjectDetailSpecification {

	public static Specification<ProjectDetail> employeeIdEquals(final String employeeId) {
		return (root, query, builder) ->
			builder.equal(root.get("employeeDetail").<EmployeeDetail>get("employeeId"), employeeId);
	}

	public static Specification<ProjectDetail> joinEmployee() {
		return (root, query, builder) -> {
			root.fetch("employeeDetail", JoinType.INNER);
			return null;
		};
	}

}
