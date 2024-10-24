package com.sample.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sample.entity.Task;

public class TaskSpecification {

	public static Specification<Task> employeeIdEquals(final String employeeId) {
		return (root, query, builder) -> builder.equal(root.get("employeeId"), employeeId);
	}
}
