package com.example.port.adapter.view.dpo;

import javax.validation.Valid;

import com.example.domain.model.division.Division;
import com.example.fw.annotation.DomainPayloadObject;

import lombok.Data;

@Data
@DomainPayloadObject
public class DivisionDetailDpo {

	@Valid
	private Division division;
}
