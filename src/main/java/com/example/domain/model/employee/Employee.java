package com.example.domain.model.employee;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.domain.model.RootEntity;
import com.example.domain.model.ability.AbilityId;
import com.example.domain.model.division.DivisionId;
import com.example.domain.model.loginuser.Loginuser;
import com.example.domain.model.organization.OrganizationId;

import lombok.Data;

@Data
public class Employee extends Loginuser implements RootEntity {

	@Valid
	@NotNull
	private OrganizationId organizationId = new OrganizationId("");

	@Valid
	@NotNull
	private EmployeeId employeeId = new EmployeeId("");

	@Valid
	@NotNull
	private DivisionId divisionId = new DivisionId("");

	@NotBlank
	private String name = "";

	@NotNull
	private String description = "";

	@Valid
	@NotNull
	private List<AbilityId> holdAbilityIds = new ArrayList<>();

	public int numberOfAbilities() {
		return holdAbilityIds.size();
	}

	@Override
	public void validate() {
		super.validate();
	}

	@Override
	public boolean equals(Object anObject) {
		boolean equalObjects = false;

		if(anObject != null && this.getClass() == anObject.getClass()) {
			Employee typeObject = (Employee)anObject;
			equalObjects =
				this.organizationId.equals(typeObject.getOrganizationId()) &&
				this.employeeId.equals(typeObject.getEmployeeId()) &&
				this.divisionId.equals(typeObject.getDivisionId()) &&
				this.name.equals(typeObject.getName()) &&
				this.description.equals(typeObject.getDescription()) &&
				this.userId.equals(typeObject.getUserId()) &&
				this.password.equals(typeObject.getPassword()) &&
				this.role.equals(typeObject.getRole()) &&
				areSameAbilities(typeObject.getHoldAbilityIds());
		}
		return equalObjects;
	}

	@Override
	public int hashCode() {
		int hashCodeValue = (45217 * 269)
				+ this.organizationId.hashCode()
				+ this.employeeId.hashCode()
				+ this.divisionId.hashCode()
				+ this.name.hashCode()
				+ this.description.hashCode()
				+ this.userId.hashCode()
				+ this.password.hashCode()
				+ this.role.hashCode()
				+ holdAbilityIds.hashCode();

		return hashCodeValue;
	}

	private boolean areSameAbilities(List<AbilityId> abilityIdList) {
		boolean equalIds = (holdAbilityIds.size() == abilityIdList.size());

		for(AbilityId abilityId : abilityIdList) {
			if(!holdAbilityIds.contains(abilityId)) {
				equalIds = false;
			}
		}
		return equalIds;
	}
}
