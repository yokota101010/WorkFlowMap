package com.example.domain.model.ability;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.domain.model.RootEntity;
import com.example.domain.model.organization.OrganizationId;

import lombok.Data;

@Data
public class Ability implements RootEntity {

	@Valid
	@NotNull
	private OrganizationId organizationId = new OrganizationId("");

	@Valid
	@NotNull
	private AbilityId abilityId = new AbilityId("");

	@NotBlank
	private String name = "";

	@NotNull
	private String description = "";

	private int numOfHolders = 0;

	@Override
	public void validate() {}

	@Override
	public boolean equals(Object anObject) {
		boolean equalObjects = false;

		if(anObject != null && this.getClass() == anObject.getClass()) {
			Ability typeObject = (Ability)anObject;
			equalObjects =
				this.organizationId.equals(typeObject.getOrganizationId()) &&
				this.abilityId.equals(typeObject.getAbilityId()) &&
				this.name.equals(typeObject.getName()) &&
				this.description.equals(typeObject.getDescription()) &&
				this.numOfHolders == typeObject.getNumOfHolders();
		}
		return equalObjects;
	}

	@Override
	public int hashCode() {
		int hashCodeValue = (45217 * 269)
				+ this.organizationId.hashCode()
				+ this.abilityId.hashCode()
				+ this.name.hashCode()
				+ this.description.hashCode()
				+ this.numOfHolders;

		return hashCodeValue;
	}
}
