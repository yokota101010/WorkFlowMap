package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.ability.AbilityRepository;
import com.example.domain.model.division.DivisionRepository;
import com.example.domain.model.employee.EmployeeRepository;
import com.example.domain.model.loginuser.LoginuserRepository;
import com.example.domain.model.organization.OrganizationRepository;

@Service
public class RepositoryService {

	@Autowired
	private AbilityRepository abilityRepository;

	@Autowired
	private DivisionRepository divisionRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private LoginuserRepository loginuserRepository;

	public AbilityRepository getAbilityRepository() {
		return abilityRepository;
	}

	public DivisionRepository getDivisionRepository() {
		return divisionRepository;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public OrganizationRepository getOrganizationRepository() {
		return organizationRepository;
	}

	public LoginuserRepository getLoginuserRepository() {
		return loginuserRepository;
	}
}
