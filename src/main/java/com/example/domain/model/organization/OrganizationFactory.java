package com.example.domain.model.organization;

import org.springframework.stereotype.Service;

@Service
public class OrganizationFactory {

	public Organization getOrganizationInstance() {
		return new Organization();
	}
}
