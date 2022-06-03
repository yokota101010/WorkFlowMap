package com.example.domain.model.organization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.model.EntityNotExistsException;
import com.example.domain.model.loginuser.UserId;

@SpringBootTest
public class OrganizationRepositoryTest {

	Organization org1;
	Organization org2;

	@Autowired
	OrganizationRepository repository;

	@BeforeEach
	void setUp() throws Exception {

		// given
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

		System.out.println("通過！！！");
	}

	@AfterEach
	void tearDown() throws Exception {
		try {
			repository.deleteOne(org1);
		} catch(Exception e){
			// 何もしない
		}

		try {
			repository.deleteOne(org2);
		} catch(Exception e){
			// 何もしない
		}
	}

	@Nested
	class InsertOneとFindOneのテスト {

		@Test
		void 組織を登録後にorganizationIdをキーに取り出すことができる() {

			// additional condition is not given

			// when
			Organization actualOrg = repository.findOne(org1.getOrganizationId());

			// then
			assertEquals(org1, actualOrg);
		}

		@Test
		void 存在しないorganizationIdの組織を取得するとEntityNotExistsExceptionを発行する() {

			// given
			OrganizationId orgId = new OrganizationId("not exist");

			// when
			Executable executable = () -> repository.findOne(orgId);

			// then
			assertThrows(EntityNotExistsException.class, executable);
		}

	}

	@Nested
	class InsertOneとFindOneByUserIdのテスト {

		@Test
		void 組織を登録後にuserIdをキーに取り出すことができる() {

			// additional condition is not given

			// when
			Organization actualOrg = repository.findOneByUserId(org2.getUserId());

			// then
			assertEquals(org2, actualOrg);
		}

		@Test
		void 存在しないuserIdの組織を取得するとEntityNotExistsExceptionを発行する() {

			System.out.println("通過！！！");
			// given
			UserId userId = new UserId("not exist");

			// when
			Executable executable = () -> repository.findOneByUserId(userId);

			// then
			assertThrows(EntityNotExistsException.class, executable);
		}

	}

	@Nested
	class DeleteOneのテスト {

		@Test
		void 組織を削除後に取り出すとEntityNotExistsExceptionを発行する() {

			// additional condition is not given

			// when
			repository.deleteOne(org1);
			Executable executable = () -> repository.findOneByUserId(org1.getUserId());

			// then
			assertThrows(EntityNotExistsException.class, executable);
		}

	}
}
