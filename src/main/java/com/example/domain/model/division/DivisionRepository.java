package com.example.domain.model.division;

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
import com.example.domain.model.organization.OrganizationId;
import com.example.port.adapter.persistence.DivisionMapper;

@Repository
public class DivisionRepository {

	@Autowired
	DivisionMapper mapper;

	/*部署登録（１件）*/
	public void insertOne(Division division) {
		try {
			mapper.insertOne(division);

		} catch(DuplicateKeyException e) {

			//一意制約違反の場合はException発行
			throw new EntityNotUniqueException();
		} catch(DataIntegrityViolationException e) {

			//参照先のエンティティが存在しない場合はException発行
			throw new ReferencingEntityNotExistsException();
		}
	}

	/*部署更新（１件）*/
	public void updateOne(Division division) {

		Division divisonBeforeChange = mapper.findOne(division.getOrganizationId(), division.getDivisionId());

		if(divisonBeforeChange == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		} else 	if(division.equals(divisonBeforeChange)) {

			//属性に変化が無ければException発行
			throw new EntityNotChangedException();
		}

		mapper.updateOne(division);
	}

	/*部署削除（１件）*/
	public void deleteOne(Division division) {
		int number;

		try {
			number = mapper.deleteOne(division);
		} catch(DataIntegrityViolationException e) {

			//削除対象が使用中の場合はException発行
			throw new ReferencedEntityCannotDeleteException();
		}

		if(number == 0) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}
	}

	/*部署取得（１件）*/
	public Division findOne(OrganizationId organizationId, DivisionId divisionId) {
		Division division = mapper.findOne(organizationId, divisionId);

		if(division == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}

		return division;
	}

	/*部署取得（全件）*/
	public List<Division> findMany(OrganizationId organizationId) {
		return mapper.findMany(organizationId);
	}
}
