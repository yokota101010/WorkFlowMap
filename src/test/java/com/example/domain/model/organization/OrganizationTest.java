package com.example.domain.model.organization;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.model.loginuser.UserId;

@SpringBootTest
public class OrganizationTest {

	@Nested
	class equalsのテスト {

		@Test
		void 全てのフィールドが等しいならばOrganization自体も等しいと判断する() {

			// given
			OrganizationId Id = new OrganizationId("orgId");
			String name = "name";
			String description = "description";
			UserId userId = new UserId("userid");
			String password = "password";
			String role = "ROLE";

			// when
			Organization org1 = new Organization();
			org1.setOrganizationId(Id);
			org1.setName(name);
			org1.setDescription(description);
			org1.setUserId(userId);
			org1.setPassword(password);
			org1.setRole(role);

			Organization org2 = new Organization();
			org2.setOrganizationId(Id);
			org2.setName(name);
			org2.setDescription(description);
			org2.setUserId(userId);
			org2.setPassword(password);
			org2.setRole(role);

			// then
			assertTrue(org1.equals(org2));
		}

		@Test
		void organizationIdが異なるならばOrganization自体も異なると判断する() {

			// given
			OrganizationId Id1 = new OrganizationId("orgId1");
			OrganizationId Id2 = new OrganizationId("orgId2");

			String name = "name";
			String description = "description";
			UserId userId = new UserId("userid");
			String password = "password";
			String role = "ROLE";

			// when
			Organization org1 = new Organization();
			org1.setOrganizationId(Id1);
			org1.setName(name);
			org1.setDescription(description);
			org1.setUserId(userId);
			org1.setPassword(password);
			org1.setRole(role);

			Organization org2 = new Organization();
			org2.setOrganizationId(Id2);
			org2.setName(name);
			org2.setDescription(description);
			org2.setUserId(userId);
			org2.setPassword(password);
			org2.setRole(role);

			// then
			assertFalse(org1.equals(org2));
		}

		@Test
		void nameが異なるならばOrganization自体も異なると判断する() {

			// given
			OrganizationId Id = new OrganizationId("orgId");

			String name1 = "name1";
			String name2 = "name2";

			String description = "description";
			UserId userId = new UserId("userid");
			String password = "password";
			String role = "ROLE";

			// when
			Organization org1 = new Organization();
			org1.setOrganizationId(Id);
			org1.setName(name1);
			org1.setDescription(description);
			org1.setUserId(userId);
			org1.setPassword(password);
			org1.setRole(role);

			Organization org2 = new Organization();
			org2.setOrganizationId(Id);
			org2.setName(name2);
			org2.setDescription(description);
			org2.setUserId(userId);
			org2.setPassword(password);
			org2.setRole(role);

			// then
			assertFalse(org1.equals(org2));
		}

		@Test
		void descriptionが異なるならばOrganization自体も異なると判断する() {

			// given
			OrganizationId Id = new OrganizationId("orgId");
			String name = "name";

			String description1 = "description1";
			String description2 = "description2";

			UserId userId = new UserId("userid");
			String password = "password";
			String role = "ROLE";

			// when
			Organization org1 = new Organization();
			org1.setOrganizationId(Id);
			org1.setName(name);
			org1.setDescription(description1);
			org1.setUserId(userId);
			org1.setPassword(password);
			org1.setRole(role);

			Organization org2 = new Organization();
			org2.setOrganizationId(Id);
			org2.setName(name);
			org2.setDescription(description2);
			org2.setUserId(userId);
			org2.setPassword(password);
			org2.setRole(role);

			// then
			assertFalse(org1.equals(org2));
		}

		@Test
		void userIdが異なるならばOrganization自体も異なると判断する() {

			// given
			OrganizationId Id = new OrganizationId("orgId");
			String name = "name";
			String description = "description";

			UserId userId1 = new UserId("userid1");
			UserId userId2 = new UserId("userid2");

			String password = "password";
			String role = "ROLE";

			// when
			Organization org1 = new Organization();
			org1.setOrganizationId(Id);
			org1.setName(name);
			org1.setDescription(description);
			org1.setUserId(userId1);
			org1.setPassword(password);
			org1.setRole(role);

			Organization org2 = new Organization();
			org2.setOrganizationId(Id);
			org2.setName(name);
			org2.setDescription(description);
			org2.setUserId(userId2);
			org2.setPassword(password);
			org2.setRole(role);

			// then
			assertFalse(org1.equals(org2));
		}

		@Test
		void passwordが異なるならばOrganization自体も異なると判断する() {

			// given
			OrganizationId Id = new OrganizationId("orgId");
			String name = "name";
			String description = "description";
			UserId userId = new UserId("userid");

			String password1 = "password1";
			String password2 = "password2";

			String role = "ROLE";

			// when
			Organization org1 = new Organization();
			org1.setOrganizationId(Id);
			org1.setName(name);
			org1.setDescription(description);
			org1.setUserId(userId);
			org1.setPassword(password1);
			org1.setRole(role);

			Organization org2 = new Organization();
			org2.setOrganizationId(Id);
			org2.setName(name);
			org2.setDescription(description);
			org2.setUserId(userId);
			org2.setPassword(password2);
			org2.setRole(role);

			// then
			assertFalse(org1.equals(org2));
		}

		@Test
		void roleが異なるならばOrganization自体も異なると判断する() {

			// given
			OrganizationId Id = new OrganizationId("orgId");
			String name = "name";
			String description = "description";
			UserId userId = new UserId("userid");
			String password = "password";

			String role1 = "ROLE1";
			String role2 = "ROLE2";

			// when
			Organization org1 = new Organization();
			org1.setOrganizationId(Id);
			org1.setName(name);
			org1.setDescription(description);
			org1.setUserId(userId);
			org1.setPassword(password);
			org1.setRole(role1);

			Organization org2 = new Organization();
			org2.setOrganizationId(Id);
			org2.setName(name);
			org2.setDescription(description);
			org2.setUserId(userId);
			org2.setPassword(password);
			org2.setRole(role2);

			// then
			assertFalse(org1.equals(org2));
		}

	}
}
