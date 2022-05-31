package com.example.domain.model.ability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.organization.OrganizationId;
import com.example.utilities.SessionInfo;

@Service
public class AbilityFactory {

	@Autowired
	private SessionInfo sessionInfo;

	public Ability getAbilityInstance() {
		Ability ability = new Ability();
		ability.setOrganizationId(new OrganizationId(sessionInfo.getOrganizationId()));
		return ability;
	}
}
