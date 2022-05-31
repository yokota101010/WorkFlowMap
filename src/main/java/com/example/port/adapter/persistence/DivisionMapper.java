package com.example.port.adapter.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.model.division.Division;
import com.example.domain.model.division.DivisionId;
import com.example.domain.model.organization.OrganizationId;

@Mapper
public interface DivisionMapper {

	/*部署作成（１件）*/
	public void insertOne(@Param("_Division") Division division);

	/*部署更新（１件）*/
	public int updateOne(@Param("_Division") Division division);

	/*部署削除（１件）*/
	public int deleteOne(@Param("_Division") Division division);

	/*部署取得（１件）*/
	public Division findOne(@Param("_OrganizationId") OrganizationId organizationId, @Param("_DivisionId") DivisionId divisionId);

	/*部署取得（全件）*/
	public List<Division> findMany(@Param("_OrganizationId") OrganizationId organizationId);
}
