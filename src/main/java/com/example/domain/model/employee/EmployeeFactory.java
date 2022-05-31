package com.example.domain.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.organization.OrganizationId;
import com.example.utilities.SessionInfo;

@Service
public class EmployeeFactory {

	@Autowired
	private SessionInfo sessionInfo;

	public Employee getEmployeeInstance() {
		Employee employee = new Employee();
		employee.setOrganizationId(new OrganizationId(sessionInfo.getOrganizationId()));
		return employee;
	}
}
