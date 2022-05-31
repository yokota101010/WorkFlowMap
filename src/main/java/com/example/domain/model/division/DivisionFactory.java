package com.example.domain.model.division;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.organization.OrganizationId;
import com.example.utilities.SessionInfo;

@Service
public class DivisionFactory {

	@Autowired
	private SessionInfo sessionInfo;

	public Division getDivisionInstance() {
		Division division = new Division();
		division.setOrganizationId(new OrganizationId(sessionInfo.getOrganizationId()));
		return division;
	}
}
