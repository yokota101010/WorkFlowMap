package com.example.port.adapter.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.model.loginuser.UserId;
import com.example.domain.model.organization.Organization;
import com.example.domain.model.organization.OrganizationId;

@Mapper
public interface OrganizationMapper {

	/*組織作成（１件）*/
	public void insertOne(@Param("_Organization") Organization organization);

	/*組織取得（１件）*/
	public Organization findOne(@Param("_OrganizationId") OrganizationId organizationId);

	/*組織取得（条件：userId）*/
	public Organization findOneByUserId(@Param("_UserId") UserId userId);
}
