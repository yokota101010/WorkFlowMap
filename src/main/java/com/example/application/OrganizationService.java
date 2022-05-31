package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.organization.Organization;
import com.example.domain.model.organization.OrganizationFactory;
import com.example.domain.model.organization.OrganizationId;
import com.example.domain.model.organization.OrganizationRepository;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository repository;

	@Autowired
	private OrganizationFactory factory;

	@Autowired
	private PasswordEncoder encoder;

	/*組織登録（１件）*/
	@Transactional
	public void registerOrganization(Organization organization) {
		organization.validate();

		//パスワードを暗号化
		String rawPassword = organization.getPassword();
		organization.setPassword(encoder.encode(rawPassword));

		//利用者権限を設定
		organization.setRole("ROLE_ADMIN");

		repository.insertOne(organization);
	}

	/*組織取得（１件）*/
	@Transactional
	public Organization getOrganization(OrganizationId organizationId) {
		Organization organization = repository.findOne(organizationId);

		//パスワードをマスク化
		organization.setPassword("password");
		return organization;
	}

//	/*組織取得（条件：userId）ログイン専用*/
//	@Transactional
//	public Organization getOrganizationByUserId(UserId userId) {
//		return repository.findOneByUserId(userId);
//	}

	/*新規組織インスタンス生成*/
	@Transactional
	public Organization newOrganization() {
		return factory.getOrganizationInstance();
	}
}
