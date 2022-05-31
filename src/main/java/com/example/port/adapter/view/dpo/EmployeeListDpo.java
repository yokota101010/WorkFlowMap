package com.example.port.adapter.view.dpo;

import java.util.List;

import com.example.domain.model.employee.Employee;
import com.example.fw.annotation.DomainPayloadObject;

import lombok.Data;

@Data
@DomainPayloadObject
public class EmployeeListDpo {

	/*従業員情報一覧*/
	private List<Employee> employeeList;
}
