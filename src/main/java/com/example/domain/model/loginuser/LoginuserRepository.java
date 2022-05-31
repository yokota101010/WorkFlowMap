package com.example.domain.model.loginuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.model.EntityNotExistsException;
import com.example.port.adapter.persistence.LoginuserMapper;

@Repository
public class LoginuserRepository {

	@Autowired
	LoginuserMapper mapper;

	public Loginuser findLoginUser(UserId userId) {
		Loginuser loginuser = mapper.findOne(userId);

		if(loginuser == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}

		return loginuser;
	}
}
