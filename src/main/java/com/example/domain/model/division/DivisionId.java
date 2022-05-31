package com.example.domain.model.division;

import com.example.fw.IdObject;
import com.example.fw.annotation.Identifier;

@Identifier
public class DivisionId extends IdObject {

	public DivisionId() {
		super();
	}

	public DivisionId(String id) {
		super(id);
	}
}
