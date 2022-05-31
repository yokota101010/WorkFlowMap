package com.example.port.adapter.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.model.ability.Ability;
import com.example.domain.model.ability.AbilityId;
import com.example.domain.model.organization.OrganizationId;

@Mapper
public interface AbilityMapper {

	/*職能作成（１件）*/
	public void insertOne(@Param("_Ability") Ability ability);

	/*職能更新（１件）*/
	public int updateOne(@Param("_Ability") Ability ability);

	/*職能削除（１件）*/
	public int deleteOne(@Param("_Ability") Ability ability);

	/*職能取得（１件）*/
	public Ability findOne(@Param("_OrganizationId") OrganizationId organizationId, @Param("_AbilityId") AbilityId abilityId);

	/*職能取得（全件）*/
	public List<Ability> findMany(@Param("_OrganizationId") OrganizationId organizationId);
}
