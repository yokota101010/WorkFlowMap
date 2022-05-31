package com.example.domain.model.ability;

import com.example.fw.IdObject;
import com.example.fw.annotation.Identifier;

@Identifier
public class AbilityId extends IdObject {


	public AbilityId() {
		super();
	}

	public AbilityId(String id) {
		super(id);
	}

}
