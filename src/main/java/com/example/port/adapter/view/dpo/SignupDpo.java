package com.example.port.adapter.view.dpo;

import javax.validation.Valid;

import com.example.domain.model.organization.Organization;
import com.example.fw.annotation.DomainPayloadObject;

import lombok.Data;

@Data
@DomainPayloadObject
public class SignupDpo {

	@Valid
	private Organization organization;
}
