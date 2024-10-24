package com.sample.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.Employee;
import com.sample.entity.EmployeeDetail;
import com.sample.entity.Project;
import com.sample.entity.ProjectDetail;
import com.sample.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoContoller {

	@Autowired
	private DemoService demoService;

	// e.g. /demo/getEmployeeByName?name=山田 太郎
	@GetMapping(path = "/getEmployeeByName")
	public List<Employee> getEmployee(@RequestParam(required = true) final String name) {
		return demoService.getEmployee(name);
	}

	@GetMapping(path = "/getPjById")
	public List<Project> getProject(@RequestParam(required = true) final String projectId) {
		return demoService.getProject(projectId);
	}

	// e.g. /demo/getPjByTerm?from=2024-01-01&to=2024-12-31
	@GetMapping(path = "/getPjByTerm")
	public List<Project> getProject(
		@RequestParam(required = true) final LocalDate from,
		@RequestParam(required = true) final LocalDate to
	) {
		return demoService.getProjectByTerm(from, to);
	}

	@GetMapping(path = "/getPjByKeyword")
	public List<Project> getProjectByKeyword(@RequestParam(required = true) final String keyword) {
		return demoService.getProjectByKeyword(keyword);
	}

	@GetMapping(path = "/getPjDetailByEmployeeId")
	public List<ProjectDetail> getProjectDetailByEmployeeId(@RequestParam(required = true) final String employeeId) {
		return demoService.getProjectByEmployeeId(employeeId);
	}

	// e.g. /demo/getEmployeeDetails?id=E005&id=E006&id=E007&departmentId=D002&hireDate=2015-01-01
	@GetMapping(path = "/getEmployeeDetails")
	public List<EmployeeDetail> getEmployeeDetails(
		@RequestParam(required = true, value = "id") final List<String> ids,
		@RequestParam(required = true) final String departmentId,
		@RequestParam(required = true) final LocalDate hireDate
	) {
		return demoService.getEmployeeDetailsBySomeParams(ids, departmentId, hireDate);
	}

	@GetMapping(path = "/getTotalTaskNumber")
	public String getTotalTaskNumber(@RequestParam(required = true) final String employeeId) {
		return "Employee \"" + employeeId + "\" has "
			+ demoService.getTotalTaskNumber(employeeId) + " task(s).";
	}

	// 本来はPOSTが適当かも
	@GetMapping(path = "/registerEmployee")
	public String registerEmployee(
		@RequestParam(required = true) final String employeeId,
		@RequestParam(required = true) final String departmentId
	) {
		return demoService.addEmployee(employeeId, departmentId);
	}

	// 本来はPOSTが適当かも
	@GetMapping(path = "/updateEmployeeAddress")
	public String updateEmployeeAddress(
		@RequestParam(required = true) final String employeeId,
		@RequestParam(required = true) final String address
	) {
		return demoService.updateEmployeeAddress(employeeId, address);
	}
}
