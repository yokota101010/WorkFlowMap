package com.example.port.adapter.view.dpo;

import javax.validation.Valid;

import com.example.domain.model.ability.Ability;
import com.example.fw.annotation.DomainPayloadObject;

import lombok.Data;

@Data
@DomainPayloadObject
public class AbilityDetailDpo {

	@Valid
	Ability ability;
}
