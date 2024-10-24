package com.sample.specification;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.sample.entity.Project;

public class ProjectSpecification {

	public static Specification<Project> projectIdEquals(final String projectId) {
		return (root, query, builder) ->
			builder.equal(root.get("projectId"), projectId);
	}

	public static Specification<Project> projectIdIn(final List<String> projectIds) {
		return (root, query, builder) ->
			root.get("projectId").in(projectIds);
	}

	public static Specification<Project> projectNameLike(final String projectName) {
		return (root, query, builder)->
			builder.like(root.get("projectName"), "%" + projectName + "%");
	}

	public static Specification<Project> startDateBetween(final LocalDate from, final LocalDate to) {
		return (root, query, builder) ->
			builder.between(root.get("startDate"), from, to);
	}

	public static Specification<Project> endDateIsNull() {
		return (root, query, builder) ->
			builder.isNull(root.get("endDate"));
	}

	public static Specification<Project> endDateLessThan(final LocalDate date) {
		return (root, query, builder) ->
			builder.lessThan(root.get("endDate"), date);
	}
}
