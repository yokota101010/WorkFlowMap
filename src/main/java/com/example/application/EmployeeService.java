package com.example.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.employee.Employee;
import com.example.domain.model.employee.EmployeeFactory;
import com.example.domain.model.employee.EmployeeId;
import com.example.domain.model.employee.EmployeeRepository;
import com.example.domain.model.organization.OrganizationId;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private EmployeeFactory factory;

	/*従業員登録（１件）*/
	@Transactional
	public void registerEmployee(Employee employee) {
		employee.validate();

		//パスワードを暗号化
		String rawPassword = employee.getPassword();
		employee.setPassword(encoder.encode(rawPassword));

		//利用者権限を設定
		employee.setRole("ROLE_GENERAL");

		repository.insertOne(employee);
	}

	/*従業員更新（１件）*/
	@Transactional
	public void updateEmployee(Employee employee) {
		employee.validate();

		repository.updateOne(employee);
	}

	/*従業員削除（１件）*/
	@Transactional
	public void deleteEmployee(Employee employee) {
		repository.deleteOne(employee);
	}

	/*従業員取得（１件）*/
	@Transactional
	public Employee getEmployee(OrganizationId organizationId, EmployeeId employeeId) {
		Employee employee = repository.findOne(organizationId, employeeId);

		//パスワードをマスク化
		employee.setPassword("password");
		return employee;
	}

	/*従業員取得（全件）*/
	@Transactional
	public List<Employee> getEmployees(OrganizationId organizationId) {
		List<Employee> employees = repository.findMany(organizationId);

		//パスワードをマスク化
		for(Employee employee : employees) {
			employee.setPassword("password");
		}
		return employees;
	}

//	/*従業員取得（条件：userId）*/
//	@Transactional
//	public Employee getEmployeeByUserId(UserId userId) {
//		return repository.findOneByUserId(userId);
//	}

	/*新規従業員インスタンス生成*/
	@Transactional
	public Employee newEmployee() {
		return factory.getEmployeeInstance();
	}
}
