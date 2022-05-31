/*システム利用者*/
CREATE TABLE IF NOT EXISTS m_loginuser(
	user_id VARCHAR(50),
	password VARCHAR(100),
	role VARCHAR(50),
	PRIMARY KEY (user_id)
);

/*組織*/
CREATE TABLE IF NOT EXISTS m_organization(
	organization_id VARCHAR(50),
	name VARCHAR(50),
	description VARCHAR(300),
	user_id VARCHAR(50),
	PRIMARY KEY (organization_id),
	UNIQUE(user_id)
);

/*部署*/
CREATE TABLE IF NOT EXISTS m_division(
	organization_id VARCHAR(50),
	division_id VARCHAR(50),
	name VARCHAR(50),
	description VARCHAR(300),
	num_of_employees INTEGER,
	PRIMARY KEY (organization_id, division_id)
);

/*従業員*/
CREATE TABLE IF NOT EXISTS m_employee(
	organization_id VARCHAR(50),
	employee_id VARCHAR(50),
	division_id VARCHAR(50),
	name VARCHAR(50),
	description VARCHAR(300),
	user_id VARCHAR(50),
	PRIMARY KEY (organization_id, employee_id),
	UNIQUE(user_id)
);

/*職能*/
CREATE TABLE IF NOT EXISTS m_ability(
	organization_id VARCHAR(50),
	ability_id VARCHAR(50),
	name VARCHAR(50),
	description VARCHAR(300),
	num_of_holders INTEGER,
	PRIMARY KEY (organization_id, ability_id)
);

/*従業員の職能*/
CREATE TABLE IF NOT EXISTS m_ability_of_employee(
	organization_id VARCHAR(50),
	employee_id VARCHAR(50),
	ability_id VARCHAR(50),
	PRIMARY KEY (organization_id, employee_id, ability_id)
);

ALTER TABLE m_organization ADD FOREIGN KEY(user_id)
	REFERENCES m_loginuser(user_id);

ALTER TABLE m_division ADD FOREIGN KEY(organization_id)
	REFERENCES m_organization(organization_id);

ALTER TABLE m_employee ADD FOREIGN KEY(user_id)
	REFERENCES m_loginuser(user_id);

ALTER TABLE m_employee ADD FOREIGN KEY(organization_id, division_id)
	REFERENCES m_division(organization_id, division_id);

ALTER TABLE m_ability ADD FOREIGN KEY(organization_id)
	REFERENCES m_organization(organization_id);

ALTER TABLE m_ability_of_employee ADD FOREIGN KEY(organization_id, ability_id)
	REFERENCES  m_ability(organization_id, ability_id);

ALTER TABLE m_ability_of_employee ADD FOREIGN KEY(organization_id, employee_id)
	REFERENCES m_employee(organization_id, employee_id);
