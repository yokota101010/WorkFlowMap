package com.example.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.ability.Ability;
import com.example.domain.model.ability.AbilityFactory;
import com.example.domain.model.ability.AbilityId;
import com.example.domain.model.ability.AbilityRepository;
import com.example.domain.model.organization.OrganizationId;

@Service
public class AbilityService {

	@Autowired
	private AbilityRepository repository;

	@Autowired
	private AbilityFactory factory;

	/*職能登録（１件）*/
	@Transactional
	public void registerAbility(Ability ability) {
		ability.validate();
		repository.insertOne(ability);
	}

	/*職能更新（１件）*/
	@Transactional
	public void updateAbility(Ability ability) {
		ability.validate();
		repository.updateOne(ability);
	}

	/*職能削除（１件）*/
	@Transactional
	public void deleteAbility(Ability ability) {
		repository.deleteOne(ability);
	}

	/*職能取得（１件）*/
	@Transactional
	public Ability getAbility(OrganizationId organizationId, AbilityId abilityId) {
		return repository.findOne(organizationId, abilityId);
	}

	/*職能取得（全件）*/
	@Transactional
	public List<Ability> getAbilities(OrganizationId organizationId) {
		return repository.findMany(organizationId);
	}

	/*新規職能インスタンス生成*/
	@Transactional
	public Ability newAbility() {
		return factory.getAbilityInstance();
	}
}
