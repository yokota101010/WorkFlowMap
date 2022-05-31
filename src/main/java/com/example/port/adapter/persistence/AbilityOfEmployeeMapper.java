package com.example.port.adapter.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.model.ability.AbilityId;
import com.example.domain.model.employee.Employee;
import com.example.domain.model.employee.EmployeeId;
import com.example.domain.model.organization.OrganizationId;

@Mapper
public interface AbilityOfEmployeeMapper {

	/*従業員の職能作成（１件）*/
	public void insertOne(
			@Param("_OrganizationId") OrganizationId organizationId,
			@Param("_EmployeeId") EmployeeId employeeId,
			@Param("_AbilityId") AbilityId abilityId);

	/*従業員の職能削除（全件）*/
	public int deleteMany(@Param("_Employee") Employee employee);
}
