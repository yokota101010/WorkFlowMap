package com.example.domain.model.loginuser;

import com.example.fw.IdObject;
import com.example.fw.annotation.Identifier;

@Identifier
public class UserId extends IdObject {

	public UserId() {
		super();
	}

	public UserId(String id) {
		super(id);
	}
}
