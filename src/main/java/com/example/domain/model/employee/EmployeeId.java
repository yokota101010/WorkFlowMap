package com.example.domain.model.employee;

import com.example.fw.IdObject;
import com.example.fw.annotation.Identifier;

@Identifier
public class EmployeeId extends IdObject {

	public EmployeeId() {
		super();
	}

	public EmployeeId(String id) {
		super(id);
	}
}
