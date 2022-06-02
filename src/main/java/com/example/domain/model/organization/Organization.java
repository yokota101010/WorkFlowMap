package com.example.domain.model.organization;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.domain.model.RootEntity;
import com.example.domain.model.loginuser.Loginuser;

import lombok.Data;

@Data
public class Organization extends Loginuser implements RootEntity {

	@Valid
	@NotNull
	private OrganizationId organizationId = new OrganizationId();

	@NotBlank
	private String name = "";

	@NotNull
	private String description = "";

	@Override
	public void validate() {
		super.validate();
	}

	@Override
	public boolean equals(Object anObject) {
		boolean equalObjects = false;

		if(anObject != null && this.getClass() == anObject.getClass()) {
			Organization typeObject = (Organization)anObject;
			equalObjects =
				this.organizationId.equals(typeObject.getOrganizationId()) &&
				this.name.equals(typeObject.getName()) &&
				this.description.equals(typeObject.getDescription()) &&
				this.userId.equals(typeObject.getUserId()) &&
				this.password.equals(typeObject.getPassword()) &&
				this.role.equals(typeObject.getRole());
		}
		return equalObjects;
	}

	@Override
	public int hashCode() {
		int hashCodeValue = (45217 * 269)
				+ this.organizationId.hashCode()
				+ this.name.hashCode()
				+ this.description.hashCode()
				+ this.userId.hashCode()
				+ this.password.hashCode()
				+ this.role.hashCode();

		return hashCodeValue;
	}
}
