package com.example.port.adapter.view.dpo;

import java.util.List;

import com.example.domain.model.ability.Ability;
import com.example.fw.annotation.DomainPayloadObject;

import lombok.Data;

@Data
@DomainPayloadObject
public class AbilityListDpo {

	/*職能情報一覧*/
	private List<Ability> abilityList;
}
