package com.example.domain.model.division;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.domain.model.RootEntity;
import com.example.domain.model.organization.OrganizationId;

import lombok.Data;

@Data
public class Division implements RootEntity {

	@Valid
	@NotNull
	private OrganizationId organizationId = new OrganizationId("");

	@Valid
	@NotNull
	private DivisionId divisionId = new DivisionId("");

	@NotBlank
	private String name = "";

	@NotNull
	private String description = "";

	private int numOfEmployees = 0;

	@Override
	public void validate() {}

	@Override
	public boolean equals(Object anObject) {
		boolean equalObjects = false;

		if(anObject != null && this.getClass() == anObject.getClass()) {
			Division typeObject = (Division)anObject;
			equalObjects =
				this.organizationId.equals(typeObject.getOrganizationId()) &&
				this.divisionId.equals(typeObject.getDivisionId()) &&
				this.name.equals(typeObject.getName()) &&
				this.description.equals(typeObject.getDescription()) &&
				this.numOfEmployees == typeObject.getNumOfEmployees();
		}
		return equalObjects;
	}

	@Override
	public int hashCode() {
		int hashCodeValue = (45217 * 269)
				+ this.organizationId.hashCode()
				+ this.divisionId.hashCode()
				+ this.name.hashCode()
				+ this.description.hashCode()
				+ this.numOfEmployees;

		return hashCodeValue;
	}
}
