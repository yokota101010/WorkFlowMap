package com.example.domain.model.ability;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AbilityTest {

	@Nested
	class equalsのテスト {

		@Test
		void 全てのフィールドが等しいならばAbility自体も等しいと判断する() {

			// given
			AbilityId Id = new AbilityId("abilityId");
			String name = "name";
			String description = "description";
			int numberOfHolders = 100;

			// when
			Ability ability1 = new Ability();
			ability1.setAbilityId(Id);
			ability1.setName(name);
			ability1.setDescription(description);
			ability1.setNumOfHolders(numberOfHolders);

			Ability ability2 = new Ability();
			ability2.setAbilityId(Id);
			ability2.setName(name);
			ability2.setDescription(description);
			ability2.setNumOfHolders(numberOfHolders);

			// then
			assertTrue(ability1.equals(ability2));
		}

		@Test
		void abilityIdが異なるならばAbility自体も異なると判断する() {

			// given
			AbilityId Id1 = new AbilityId("abilityId1");
			AbilityId Id2 = new AbilityId("abilityId2");

			String name = "name";
			String description = "description";
			int numberOfHolders = 100;

			// when
			Ability ability1 = new Ability();
			ability1.setAbilityId(Id1);
			ability1.setName(name);
			ability1.setDescription(description);
			ability1.setNumOfHolders(numberOfHolders);

			Ability ability2 = new Ability();
			ability2.setAbilityId(Id2);
			ability2.setName(name);
			ability2.setDescription(description);
			ability2.setNumOfHolders(numberOfHolders);

			// then
			assertFalse(ability1.equals(ability2));
		}

		@Test
		void nameが異なるならばAbility自体も異なると判断する() {

			// given
			AbilityId Id = new AbilityId("abilityId");

			String name1 = "name1";
			String name2 = "name2";

			String description = "description";
			int numberOfHolders = 100;

			// when
			Ability ability1 = new Ability();
			ability1.setAbilityId(Id);
			ability1.setName(name1);
			ability1.setDescription(description);
			ability1.setNumOfHolders(numberOfHolders);

			Ability ability2 = new Ability();
			ability2.setAbilityId(Id);
			ability2.setName(name2);
			ability2.setDescription(description);
			ability2.setNumOfHolders(numberOfHolders);

			// then
			assertFalse(ability1.equals(ability2));
		}

		@Test
		void descriptionが異なるならばAbility自体も異なると判断する() {

			// given
			AbilityId Id = new AbilityId("abilityId");
			String name = "name";

			String description1 = "description1";
			String description2 = "description2";

			int numberOfHolders = 100;

			// when
			Ability ability1 = new Ability();
			ability1.setAbilityId(Id);
			ability1.setName(name);
			ability1.setDescription(description1);
			ability1.setNumOfHolders(numberOfHolders);

			Ability ability2 = new Ability();
			ability2.setAbilityId(Id);
			ability2.setName(name);
			ability2.setDescription(description2);
			ability2.setNumOfHolders(numberOfHolders);

			// then
			assertFalse(ability1.equals(ability2));
		}

		@Test
		void numOfHoldersが異なるならばAbility自体も異なると判断する() {

			// given
			AbilityId Id = new AbilityId("abilityId");
			String name = "name";
			String description = "description";

			int numberOfHolders1 = 100;
			int numberOfHolders2 = 200;

			// when
			Ability ability1 = new Ability();
			ability1.setAbilityId(Id);
			ability1.setName(name);
			ability1.setDescription(description);
			ability1.setNumOfHolders(numberOfHolders1);

			Ability ability2 = new Ability();
			ability2.setAbilityId(Id);
			ability2.setName(name);
			ability2.setDescription(description);
			ability2.setNumOfHolders(numberOfHolders2);

			// then
			assertFalse(ability1.equals(ability2));
		}

	}

}
