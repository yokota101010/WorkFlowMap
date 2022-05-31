package com.example.domain.model.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.example.domain.model.EntityNotChangedException;
import com.example.domain.model.EntityNotExistsException;
import com.example.domain.model.EntityNotUniqueException;
import com.example.domain.model.ReferencedEntityCannotDeleteException;
import com.example.domain.model.ReferencingEntityNotExistsException;
import com.example.domain.model.ability.Ability;
import com.example.domain.model.ability.AbilityId;
import com.example.domain.model.division.Division;
import com.example.domain.model.loginuser.Loginuser;
import com.example.domain.model.loginuser.UserId;
import com.example.domain.model.organization.OrganizationId;
import com.example.port.adapter.persistence.AbilityOfEmployeeMapper;
import com.example.port.adapter.persistence.EmployeeMapper;
import com.example.port.adapter.persistence.LoginuserMapper;

@Repository
public class EmployeeRepository {

	@Autowired
	EmployeeMapper empMapper;

	@Autowired
	AbilityOfEmployeeMapper aoeMapper;

	@Autowired
	LoginuserMapper usrMapper;

	/*従業員登録（１件）*/
	public void insertOne(Employee employee) {
		try {
			usrMapper.insertOne((Loginuser)employee);
			empMapper.insertOne(employee);
		} catch(DuplicateKeyException e) {

			//一意制約違反の場合はException発行
			throw new EntityNotUniqueException();
		} catch(DataIntegrityViolationException e) {

			//参照先のエンティティが存在しない場合はException発行
			throw new ReferencingEntityNotExistsException();
		}
	}

	/*従業員更新（１件）*/
	public void updateOne(Employee employee) {

		Employee employeeBeforeChange = empMapper.findOne(employee.getOrganizationId(), employee.getEmployeeId());

		if(employeeBeforeChange == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		} else if(employee.equals(employeeBeforeChange)) {

			//属性に変化が無ければException発行
			throw new EntityNotChangedException();
		}

		try {
			empMapper.updateOne(employee);	//EmployeeRepositoryからLoginuserの更新は行わない

		} catch(DataIntegrityViolationException e) {

			//参照先のエンティティが存在しない場合はException発行
			throw new ReferencingEntityNotExistsException();
		}

		//従業員の職能は総入れ替え
		aoeMapper.deleteMany(employee);
		List<AbilityId> aIds = employee.getHoldAbilityIds();
		for(AbilityId aid : aIds) {
			aoeMapper.insertOne(employee.getOrganizationId(), employee.getEmployeeId(), aid);
		}
	}

	/*従業員削除（１件）*/
	public void deleteOne(Employee employee) {
		int number;

		try {
			aoeMapper.deleteMany(employee);
			number = empMapper.deleteOne(employee);
			usrMapper.deleteOne((Loginuser)employee);
		} catch(DataIntegrityViolationException e) {

			//削除対象が使用中の場合はException発行
			throw new ReferencedEntityCannotDeleteException();
		}

		if(number == 0) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}
	}

	/*従業員取得（１件）*/
	public Employee findOne(OrganizationId organizationId, EmployeeId employeeId) {
		Employee employee = empMapper.findOne(organizationId, employeeId);

		if(employee == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}

		return employee;
	}

	/*従業員取得（全件）*/
	public List<Employee> findMany(OrganizationId organizationId){
		return empMapper.findMany(organizationId);
	}

	/*従業員取得（条件：userId）*/
	public Employee findOneByUserId(UserId userId) {
		Employee employee = empMapper.findOneByUserId(userId);

		if(employee == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}

		return employee;
	}

	/*従業員数取得（条件：division）*/
	public int numberOfEmployeesIn(Division division) {
		return empMapper.countNumOfEmployeesIn(division);
	}

	/*従業員数取得（条件：ability）*/
	public int numberOfEmployeesHolding(Ability ability) {
		return empMapper.countNumOfEmployeesHolding(ability);
	}
}
