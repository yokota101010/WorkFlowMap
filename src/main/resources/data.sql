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
('hakuba_auto','ハクバ自動車','自動車修理など','org01@co.jp'),
('kokuba_auto','コクバ自動車','自動車修理などしない','org02@co.jp');

/*部署*/
INSERT INTO m_division(
	organization_id,
	division_id,
	name,
	description,
	num_of_employees
)VALUES
('hakuba_auto','headoffice','本部','経営戦略や財務を担当', 10),
('hakuba_auto','eigyou01','営業１課','飛び込み営業専門部隊', 15),
('hakuba_auto','eigyou02','営業２課','既存顧客対応専門部隊', 20),
('hakuba_auto','system01','システム１課','社内システムの運用・保守', 25),
('kokuba_auto','headoffice','本部（黒）','経営戦略や財務を担当（黒）', 10),
('kokuba_auto','eigyou01','営業１課（黒）','飛び込み営業専門部隊（黒）', 15),
('kokuba_auto','eigyou02','営業２課（黒）','既存顧客対応専門部隊（黒）', 20),
('kokuba_auto','system01','システム１課（黒）','社内システムの運用・保守（黒）', 25);

/*従業員*/
INSERT INTO m_employee(
	organization_id,
	employee_id,
	division_id,
	name,
	description,
	user_id
)VALUES
('hakuba_auto','emp01','system01','パソコン次郎','システムが得意','emp01@co.jp'),
('kokuba_auto','emp02','system01','パソコン次郎（黒）','システムが得意（黒）','emp02@co.jp');

/*職能*/
INSERT INTO m_ability(
	organization_id,
	ability_id,
	name,
	description,
	num_of_holders
)VALUES
('hakuba_auto','ability01','プレゼン','みんなの前で話すのがうまい', 1),
('hakuba_auto','ability02','プログラミング','設計に従ってプログラムを作れる', 2),
('hakuba_auto','ability03','設計','自動化の仕組みを作れる', 3),
('hakuba_auto','ability04','会計','お金の話に強い', 4),
('kokuba_auto','ability05','プレゼン（黒）','みんなの前で話すのがうまい', 11),
('kokuba_auto','ability06','プログラミング（黒）','設計に従ってプログラムを作れる', 12),
('kokuba_auto','ability07','設計（黒）','自動化の仕組みを作れる', 13),
('kokuba_auto','ability08','会計（黒）','お金の話に強い', 14);

/*従業員の職能*/
INSERT INTO m_ability_of_employee(
	organization_id,
	employee_id,
	ability_id
)VALUES
('hakuba_auto','emp01','ability01'),
('hakuba_auto','emp01','ability03'),
('kokuba_auto','emp02','ability05'),
('kokuba_auto','emp02','ability06');
