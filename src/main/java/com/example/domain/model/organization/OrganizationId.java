package com.example.domain.model.organization;

import com.example.fw.IdObject;
import com.example.fw.annotation.Identifier;

@Identifier
public class OrganizationId extends IdObject {

	public OrganizationId() {
		super();
	}

	public OrganizationId(String id) {
		super(id);
	}
}
