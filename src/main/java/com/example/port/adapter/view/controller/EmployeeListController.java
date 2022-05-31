package com.example.port.adapter.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.EmployeeService;
import com.example.domain.model.employee.Employee;
import com.example.domain.model.organization.OrganizationId;
import com.example.port.adapter.view.dpo.EmployeeListDpo;
import com.example.utilities.SessionInfo;

@Controller
@RequestMapping("/employee")
public class EmployeeListController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private SessionInfo sessionInfo;

	/*従業員（一覧）画面を表示*/
	@GetMapping("/list")
	public String getEmployeeList(EmployeeListDpo dpo, Model model) {

		//従業員情報リストをdpoに設定
		List<Employee> employeeList = service.getEmployees(new OrganizationId(sessionInfo.getOrganizationId()));
		dpo.setEmployeeList(employeeList);

		//従業員（一覧）画面を表示
		return "employee/list";
	}
}
