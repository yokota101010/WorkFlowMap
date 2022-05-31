package com.example.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.division.Division;
import com.example.domain.model.division.DivisionFactory;
import com.example.domain.model.division.DivisionId;
import com.example.domain.model.division.DivisionRepository;
import com.example.domain.model.organization.OrganizationId;

@Service
public class DivisionService {

	@Autowired
	private DivisionRepository repository;

	@Autowired
	private DivisionFactory factory;

	/*部署登録（１件）*/
	@Transactional
	public void registerDivision(Division division) {
		division.validate();
		repository.insertOne(division);
	}

	/*部署更新（１件）*/
	@Transactional
	public void updateDivision(Division division) {
		division.validate();
		repository.updateOne(division);
	}

	/*部署削除（１件）*/
	@Transactional
	public void deleteDivision(Division division) {
		repository.deleteOne(division);
	}

	/*部署取得（１件）*/
	@Transactional
	public Division getDivision(OrganizationId organizationId, DivisionId divisionId) {
		return repository.findOne(organizationId, divisionId);
	}

	/*部署取得（全件）*/
	@Transactional
	public List<Division> getDivisions(OrganizationId organizationId) {
		return repository.findMany(organizationId);
	}

	/*新規部署インスタンス生成*/
	@Transactional
	public Division newDivision() {
		return factory.getDivisionInstance();
	}
}
