package com.example.domain.model.ability;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AbilityTest extends Ability {

	@Test
	public void 全てのフィールドが等しいならばAbility自体も等しいと判断する() {
		Ability ability1 = new Ability();
		ability1.setAbilityId(new AbilityId("abilityId"));
		ability1.setName("name");
		ability1.setDescription("description");
		ability1.setNumOfHolders(100);

		Ability ability2 = new Ability();
		ability2.setAbilityId(new AbilityId("abilityId"));
		ability2.setName("name");
		ability2.setDescription("description");
		ability2.setNumOfHolders(100);

		assertTrue(ability1.equals(ability2));
	}

	@Test
	public void abilityIdが異なるならばAbility自体も異なると判断する() {
		Ability ability1 = new Ability();
		ability1.setAbilityId(new AbilityId("abilityId"));
		ability1.setName("name");
		ability1.setDescription("description");
		ability1.setNumOfHolders(100);

		Ability ability2 = new Ability();
		ability2.setAbilityId(new AbilityId("abilityId2"));
		ability2.setName("name");
		ability2.setDescription("description");
		ability2.setNumOfHolders(100);

		assertFalse(ability1.equals(ability2));
	}

	@Test
	public void nameが異なるならばAbility自体も異なると判断する() {
		Ability ability1 = new Ability();
		ability1.setAbilityId(new AbilityId("abilityId"));
		ability1.setName("name");
		ability1.setDescription("description");
		ability1.setNumOfHolders(100);

		Ability ability2 = new Ability();
		ability2.setAbilityId(new AbilityId("abilityId"));
		ability2.setName("name2");
		ability2.setDescription("description");
		ability2.setNumOfHolders(100);

		assertFalse(ability1.equals(ability2));
	}

	@Test
	public void descriptionが異なるならばAbility自体も異なると判断する() {
		Ability ability1 = new Ability();
		ability1.setAbilityId(new AbilityId("abilityId"));
		ability1.setName("name");
		ability1.setDescription("description");
		ability1.setNumOfHolders(100);

		Ability ability2 = new Ability();
		ability2.setAbilityId(new AbilityId("abilityId"));
		ability2.setName("name");
		ability2.setDescription("description2");
		ability2.setNumOfHolders(100);

		assertFalse(ability1.equals(ability2));
	}

	@Test
	public void numOfHoldersが異なるならばAbility自体も異なると判断する() {
		Ability ability1 = new Ability();
		ability1.setAbilityId(new AbilityId("abilityId"));
		ability1.setName("name");
		ability1.setDescription("description");
		ability1.setNumOfHolders(100);

		Ability ability2 = new Ability();
		ability2.setAbilityId(new AbilityId("abilityId"));
		ability2.setName("name");
		ability2.setDescription("description");
		ability2.setNumOfHolders(200);

		assertFalse(ability1.equals(ability2));
	}

}
