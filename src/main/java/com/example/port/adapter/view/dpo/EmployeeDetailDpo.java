package com.example.port.adapter.view.dpo;

import javax.validation.Valid;

import com.example.domain.model.employee.Employee;
import com.example.fw.annotation.DomainPayloadObject;

import lombok.Data;

@Data
@DomainPayloadObject
public class EmployeeDetailDpo {

	@Valid
	private Employee employee;
}
