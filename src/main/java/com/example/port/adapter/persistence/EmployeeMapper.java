package com.example.port.adapter.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.model.ability.Ability;
import com.example.domain.model.division.Division;
import com.example.domain.model.employee.Employee;
import com.example.domain.model.employee.EmployeeId;
import com.example.domain.model.loginuser.UserId;
import com.example.domain.model.organization.OrganizationId;

@Mapper
public interface EmployeeMapper {

	/*従業員作成（１件）*/
	public void insertOne(@Param("_Employee") Employee employee);

	/*従業員更新（１件）*/
	public int updateOne(@Param("_Employee") Employee employee);

	/*従業員削除（１件）*/
	public int deleteOne(@Param("_Employee") Employee employee);

	/*従業員取得（１件）*/
	public Employee findOne(
			@Param("_OrganizationId") OrganizationId organizationId,
			@Param("_EmployeeId") EmployeeId employeeId);

	/*従業員取得（全件）*/
	public List<Employee> findMany(@Param("_OrganizationId") OrganizationId organizationId);

	/*従業員取得（条件：userId）*/
	public Employee findOneByUserId(@Param("_UserId") UserId userId);

	/*従業員数取得（条件：division）*/
	public int countNumOfEmployeesIn(@Param("_Division") Division division);

	/*従業員数取得（条件：ability）*/
	public int countNumOfEmployeesHolding(@Param("_Ability") Ability ability);
}
