package com.example.domain.model.loginuser;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.example.domain.model.RootEntity;

import lombok.Data;

@Data
public class Loginuser implements RootEntity {

	@Valid
	@NotNull
	protected UserId userId = new UserId("");

	@NotBlank
	@Length(min=4, max=100)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	protected String password = "";

	protected String role = "";	//システム内で設定する項目なので単項目チェック無し

	@Override
	public void validate() {}

	@Override
	public boolean equals(Object anObject) {
		boolean equalObjects = false;

		if(anObject != null && this.getClass() == anObject.getClass()) {
			Loginuser typeObject = (Loginuser)anObject;
			equalObjects =
				this.userId.equals(typeObject.getUserId()) &&
				this.password.equals(typeObject.getPassword()) &&
				this.role.equals(typeObject.getRole());
		}
		return equalObjects;
	}

	@Override
	public int hashCode() {
		int hashCodeValue = (45217 * 269)
				+ this.userId.hashCode()
				+ this.password.hashCode()
				+ this.role.hashCode();

		return hashCodeValue;
	}
}
