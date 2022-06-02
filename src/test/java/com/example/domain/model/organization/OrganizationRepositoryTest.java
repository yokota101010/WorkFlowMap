package com.example.domain.model.organization;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.model.EntityNotExistsException;
import com.example.domain.model.loginuser.UserId;

@SpringBootTest
public class OrganizationRepositoryTest extends OrganizationRepository {

	Organization org1;
	Organization org2;

	@Autowired
	OrganizationRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		org1 = new Organization();
		org1.setOrganizationId(new OrganizationId("orgId1"));
		org1.setName("name1");
		org1.setDescription("description1");
		org1.setUserId(new UserId("userid1"));
		org1.setPassword("password1");
		org1.setRole("ROLE1");
		repository.insertOne(org1);

		org2 = new Organization();
		org2.setOrganizationId(new OrganizationId("orgId2"));
		org2.setName("name2");
		org2.setDescription("description2");
		org2.setUserId(new UserId("userid2"));
		org2.setPassword("password2");
		org2.setRole("ROLE2");
		repository.insertOne(org2);
	}

	@AfterEach
	void tearDown() throws Exception {
		try {
			repository.deleteOne(org1);
			repository.deleteOne(org2);
		} catch(Exception e){
			// 何もしない
		}
	}

	@Test
	public void 存在しないorganizationIdの組織を取得するとEntityNotExistsExceptionを発行する() {
		OrganizationId orgId = new OrganizationId("not exist");
		assertThrows(EntityNotExistsException.class, () -> repository.findOne(orgId));
	}

	@Test
	public void 存在しないuserIdの組織を取得するとEntityNotExistsExceptionを発行する() {
		UserId userId = new UserId("not exist");
		assertThrows(EntityNotExistsException.class, () -> repository.findOneByUserId(userId));
	}

	@Test
	public void 組織を登録後にorganizationIdをキーに取り出すことができる() {
		Organization actualOrg = repository.findOne(new OrganizationId("orgId1"));
		assertEquals(actualOrg, org1);
	}

	@Test
	public void 組織を登録後にuserIdをキーに取り出すことができる() {
		Organization actualOrg = repository.findOneByUserId(new UserId("userid2"));
		assertEquals(actualOrg, org2);
	}

	@Test
	public void 組織を削除後に取り出すとEntityNotExistsExceptionを発行する() {
		repository.deleteOne(org1);
		assertThrows(EntityNotExistsException.class, () -> repository.findOneByUserId(org1.getUserId()));
	}
}
