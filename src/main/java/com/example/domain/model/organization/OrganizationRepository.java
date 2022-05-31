package com.example.domain.model.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.example.domain.model.EntityNotExistsException;
import com.example.domain.model.EntityNotUniqueException;
import com.example.domain.model.loginuser.Loginuser;
import com.example.domain.model.loginuser.UserId;
import com.example.port.adapter.persistence.LoginuserMapper;
import com.example.port.adapter.persistence.OrganizationMapper;

@Repository
public class OrganizationRepository {

	@Autowired
	OrganizationMapper orgMapper;

	@Autowired
	LoginuserMapper usrMapper;

	/*組織登録（１件）*/
	public void insertOne(Organization organization) {
		try {
			usrMapper.insertOne((Loginuser)organization);
			orgMapper.insertOne(organization);
		} catch(DataIntegrityViolationException e) {

			//一意制約違反の場合はException発行
			throw new EntityNotUniqueException();
		}
	}

	/*組織取得（１件）*/
	public Organization findOne(OrganizationId organizationId) {
		Organization organization = orgMapper.findOne(organizationId);

		if(organization == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}

		return organization;
	}

	/*組織取得（条件：userId）*/
	public Organization findOneByUserId(UserId userId) {
		Organization organization = orgMapper.findOneByUserId(userId);

		if(organization == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}

		return organization;
	}
}
