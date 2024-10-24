package com.sample.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Employee;
import com.sample.entity.EmployeeDetail;
import com.sample.entity.Project;
import com.sample.entity.ProjectDetail;
import com.sample.repository.DepartmentRepository;
import com.sample.repository.EmployeeDetailRepository;
import com.sample.repository.EmployeeRepository;
import com.sample.repository.ProjectDetailRepository;
import com.sample.repository.ProjectRepository;
import com.sample.repository.TaskRepository;
import com.sample.specification.EmployeeDetailSpecification;
import com.sample.specification.EmployeeSpecification;
import com.sample.specification.ProjectDetailSpecification;
import com.sample.specification.ProjectSpecification;
import com.sample.specification.TaskSpecification;


@Service
public class DemoService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectDetailRepository projectDetailRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeDetailRepository employeeDetailRepository;

	@Autowired
	private TaskRepository taskRepository;

	public List<Project> getProject(final String projectId) {
		return projectRepository.findAll(
			ProjectSpecification.projectIdEquals(projectId)
		);
	}

	public List<Project> getProjectByTerm(final LocalDate from, final LocalDate to) {
		return projectRepository.findAll(
			ProjectSpecification.startDateBetween(from, to)
			.and(ProjectSpecification.endDateIsNull())
		);
	}

	public List<Project> getProjectByKeyword(final String keyword) {
		return projectRepository.findAll(
			ProjectSpecification.projectNameLike(keyword)
		);
	}

	public List<ProjectDetail> getProjectByEmployeeId(final String employeeId) {
		return projectDetailRepository.findAll(
			ProjectDetailSpecification.joinEmployee()
			.and(ProjectDetailSpecification.employeeIdEquals(employeeId))
		);
	}

	public List<Employee> getEmployee(final String name) {
		return employeeRepository.findAll(
			EmployeeSpecification.joinEmployeeDetail()
			.and(EmployeeSpecification.nameEquals(name))
		);
	}

	public List<EmployeeDetail> getEmployeeDetailsBySomeParams(
		final List<String> employeeIds, final String departmentId, final LocalDate hireDate
	) {
		return employeeDetailRepository.findAll(
			EmployeeDetailSpecification.employeeIdIn(employeeIds)
			.and(EmployeeDetailSpecification.departmentIdNotEquals(departmentId))
			.and(EmployeeDetailSpecification.hireDateMoreThan(hireDate))
		);
	}

	public long getTotalTaskNumber(final String employeeId) {
		return taskRepository.count(TaskSpecification.employeeIdEquals(employeeId));
	}

	public String addEmployee(final String employeeId, final String departmentId) {
		// saveメソッドでINSERT出来ることを確認するサンプル。
		// 本来はemployee_detailテーブルにもレコードを追加するべきだがここでは割愛。
		final var department = departmentRepository.findById(departmentId);
		if (!department.isPresent()) {
			return "No such departmentId: " + departmentId;
		}
		if (employeeRepository.existsById(employeeId)) {
			return "EmployeeId \"" + employeeId + "\" already exists.";
		}
		final var employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setDepartment(department.get());
		employeeRepository.save(employee);
		return "New employee \"" + employeeId + "\" has been registered.";
	}

	public String updateEmployeeAddress(final String employeeId, final String address) {
		// saveメソッドでUPDATE出来ることを確認するサンプル。
		final var employeeDetail = employeeDetailRepository.findById(employeeId);
		if (!employeeDetail.isPresent()) {
			return "No such employeeId: " + employeeId;
		}
		final var entity = employeeDetail.get();
		entity.setAddress(address);
		employeeDetailRepository.save(entity);
		return "The employee " + employeeId + "'s address has been updated.";
	}
}
