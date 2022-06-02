package com.example.domain.model.organization;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.model.loginuser.UserId;

@SpringBootTest
public class OrganizationTest extends Organization {

	@Test
	public void 全てのフィールドが等しいならばOrganization自体も等しいと判断する() {
		Organization org1 = new Organization();
		org1.setOrganizationId(new OrganizationId("orgId"));
		org1.setName("name");
		org1.setDescription("description");
		org1.setUserId(new UserId("userid"));
		org1.setPassword("password");
		org1.setRole("ROLE");

		Organization org2 = new Organization();
		org2.setOrganizationId(new OrganizationId("orgId"));
		org2.setName("name");
		org2.setDescription("description");
		org2.setUserId(new UserId("userid"));
		org2.setPassword("password");
		org2.setRole("ROLE");

		assertTrue(org1.equals(org2));
	}

	@Test
	public void organizationIdが異なるならばOrganization自体も異なると判断する() {
		Organization org1 = new Organization();
		org1.setOrganizationId(new OrganizationId("orgId"));
		org1.setName("name");
		org1.setDescription("description");
		org1.setUserId(new UserId("userid"));
		org1.setPassword("password");
		org1.setRole("ROLE");

		Organization org2 = new Organization();
		org2.setOrganizationId(new OrganizationId("orgId2"));
		org2.setName("name");
		org2.setDescription("description");
		org2.setUserId(new UserId("userid"));
		org2.setPassword("password");
		org2.setRole("ROLE");

		assertFalse(org1.equals(org2));
	}

	@Test
	public void nameが異なるならばOrganization自体も異なると判断する() {
		Organization org1 = new Organization();
		org1.setOrganizationId(new OrganizationId("orgId"));
		org1.setName("name");
		org1.setDescription("description");
		org1.setUserId(new UserId("userid"));
		org1.setPassword("password");
		org1.setRole("ROLE");

		Organization org2 = new Organization();
		org2.setOrganizationId(new OrganizationId("orgId"));
		org2.setName("name2");
		org2.setDescription("description");
		org2.setUserId(new UserId("userid"));
		org2.setPassword("password");
		org2.setRole("ROLE");

		assertFalse(org1.equals(org2));
	}

	@Test
	public void descriptionが異なるならばOrganization自体も異なると判断する() {
		Organization org1 = new Organization();
		org1.setOrganizationId(new OrganizationId("orgId"));
		org1.setName("name");
		org1.setDescription("description");
		org1.setUserId(new UserId("userid"));
		org1.setPassword("password");
		org1.setRole("ROLE");

		Organization org2 = new Organization();
		org2.setOrganizationId(new OrganizationId("orgId"));
		org2.setName("name");
		org2.setDescription("description2");
		org2.setUserId(new UserId("userid"));
		org2.setPassword("password");
		org2.setRole("ROLE");

		assertFalse(org1.equals(org2));
	}

	@Test
	public void userIdが異なるならばOrganization自体も異なると判断する() {
		Organization org1 = new Organization();
		org1.setOrganizationId(new OrganizationId("orgId"));
		org1.setName("name");
		org1.setDescription("description");
		org1.setUserId(new UserId("userid"));
		org1.setPassword("password");
		org1.setRole("ROLE");

		Organization org2 = new Organization();
		org2.setOrganizationId(new OrganizationId("orgId"));
		org2.setName("name");
		org2.setDescription("description");
		org2.setUserId(new UserId("userid2"));
		org2.setPassword("password");
		org2.setRole("ROLE");

		assertFalse(org1.equals(org2));
	}

	@Test
	public void passwordが異なるならばOrganization自体も異なると判断する() {
		Organization org1 = new Organization();
		org1.setOrganizationId(new OrganizationId("orgId"));
		org1.setName("name");
		org1.setDescription("description");
		org1.setUserId(new UserId("userid"));
		org1.setPassword("password");
		org1.setRole("ROLE");

		Organization org2 = new Organization();
		org2.setOrganizationId(new OrganizationId("orgId"));
		org2.setName("name");
		org2.setDescription("description");
		org2.setUserId(new UserId("userid"));
		org2.setPassword("password2");
		org2.setRole("ROLE");

		assertFalse(org1.equals(org2));
	}

	@Test
	public void roleが異なるならばOrganization自体も異なると判断する() {
		Organization org1 = new Organization();
		org1.setOrganizationId(new OrganizationId("orgId"));
		org1.setName("name");
		org1.setDescription("description");
		org1.setUserId(new UserId("userid"));
		org1.setPassword("password");
		org1.setRole("ROLE");

		Organization org2 = new Organization();
		org2.setOrganizationId(new OrganizationId("orgId"));
		org2.setName("name");
		org2.setDescription("description");
		org2.setUserId(new UserId("userid"));
		org2.setPassword("password");
		org2.setRole("ROLE2");

		assertFalse(org1.equals(org2));
	}
}
