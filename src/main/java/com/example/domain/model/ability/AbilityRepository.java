package com.example.domain.model.ability;

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
import com.example.port.adapter.persistence.AbilityMapper;

@Repository
public class AbilityRepository {

	@Autowired
	AbilityMapper mapper;

	/*職能登録（１件）*/
	public void insertOne(Ability ability) {
		try {
			mapper.insertOne(ability);

		} catch(DuplicateKeyException e) {

			//一意制約違反の場合はException発行
			throw new EntityNotUniqueException();
		} catch(DataIntegrityViolationException e) {

			//参照先のエンティティが存在しない場合はException発行
			throw new ReferencingEntityNotExistsException();
		}
	}

	/*職能更新（１件）*/
	public void updateOne(Ability ability) {

		Ability abilityBeforeChange = mapper.findOne(ability.getOrganizationId(), ability.getAbilityId());

		if(abilityBeforeChange == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		} else if(ability.equals(abilityBeforeChange)) {

			//属性に変化が無ければException発行
			throw new EntityNotChangedException();
		}

		mapper.updateOne(ability);
	}

	/*職能削除（１件）*/
	public void deleteOne(Ability ability) {
		int number;

		try {
			number = mapper.deleteOne(ability);
		} catch(DataIntegrityViolationException e) {

			//削除対象が使用中の場合はException発行
			throw new ReferencedEntityCannotDeleteException();
		}

		if(number == 0) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}
	}

	/*職能取得（１件）*/
	public Ability findOne(OrganizationId organizationId, AbilityId abilityId) {

		Ability ability = mapper.findOne(organizationId, abilityId);
		if(ability == null) {

			//該当するエンティティが存在しない場合はException発行
			throw new EntityNotExistsException();
		}

		return ability;
	}

	/*職能取得（全件）*/
	public List<Ability> findMany(OrganizationId organizationId) {
		return mapper.findMany(organizationId);
	}
}
