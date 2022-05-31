/*システム利用者*/
INSERT INTO m_loginuser(
	user_id,
	password,
	role
)VALUES
('org01@co.jp','$2a$10$Ky55Ci8WvjI.WedVFJvnpufPzHZRk8kXE.e1WoJ9Bi6cPRFarH.8W','ROLE_ADMIN'),
('org02@co.jp','$2a$10$Ky55Ci8WvjI.WedVFJvnpufPzHZRk8kXE.e1WoJ9Bi6cPRFarH.8W','ROLE_ADMIN'),
('emp01@co.jp','$2a$10$Ky55Ci8WvjI.WedVFJvnpufPzHZRk8kXE.e1WoJ9Bi6cPRFarH.8W','ROLE_GENERAL'),
('emp02@co.jp','$2a$10$Ky55Ci8WvjI.WedVFJvnpufPzHZRk8kXE.e1WoJ9Bi6cPRFarH.8W','ROLE_GENERAL');

/*組織*/
INSERT INTO m_organization(
	organization_id,
	name,
	description,
	user_id
)VALUES
('swing_auto','スイング自動車','自動車修理（ス）','org01@co.jp'),
('clean_auto','クリーン自動車','自動車修理（ク）','org02@co.jp');

/*部署*/
INSERT INTO m_division(
	organization_id,
	division_id,
	name,
	description,
	num_of_employees
)VALUES
('swing_auto','headoffice','本部（ス）','経営戦略や財務を担当（ス）', 10),
('swing_auto','eigyou01','営業１課（ス）','飛び込み営業専門部隊（ス）', 15),
('swing_auto','eigyou02','営業２課（ス）','既存顧客対応専門部隊（ス）', 20),
('swing_auto','system01','システム１課（ス）','社内システムの運用・保守（ス）', 25),
('clean_auto','headoffice','本部（ク）','経営戦略や財務を担当（ク）', 10),
('clean_auto','eigyou01','営業１課（ク）','飛び込み営業専門部隊（ク）', 15),
('clean_auto','eigyou02','営業２課（ク）','既存顧客対応専門部隊（ク）', 20),
('clean_auto','system01','システム１課（ク）','社内システムの運用・保守（ク）', 25);

/*従業員*/
INSERT INTO m_employee(
	organization_id,
	employee_id,
	division_id,
	name,
	description,
	user_id
)VALUES
('swing_auto','emp01','system01','パソコン太郎','システムとスイングが得意','emp01@co.jp'),
('clean_auto','emp02','system01','パソコン次郎','システムとクリーンが得意','emp02@co.jp');

/*職能*/
INSERT INTO m_ability(
	organization_id,
	ability_id,
	name,
	description,
	num_of_holders
)VALUES
('swing_auto','ability01','プレゼン（ス）','みんなの前で話すのがうまい', 1),
('swing_auto','ability02','プログラミング（ス）','設計に従ってプログラムを作れる', 2),
('swing_auto','ability03','設計（ス）','自動化の仕組みを作れる', 3),
('swing_auto','ability04','会計（ス）','お金の話に強い', 4),
('clean_auto','ability05','プレゼン（ク）','みんなの前で話すのがうまい', 11),
('clean_auto','ability06','プログラミング（ク）','設計に従ってプログラムを作れる', 12),
('clean_auto','ability07','設計（ク）','自動化の仕組みを作れる', 13),
('clean_auto','ability08','会計（ク）','お金の話に強い', 14);

/*従業員の職能*/
INSERT INTO m_ability_of_employee(
	organization_id,
	employee_id,
	ability_id
)VALUES
('swing_auto','emp01','ability01'),
('swing_auto','emp01','ability03'),
('clean_auto','emp02','ability05'),
('clean_auto','emp02','ability06');
