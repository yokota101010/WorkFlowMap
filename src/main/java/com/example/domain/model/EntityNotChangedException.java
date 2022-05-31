package com.example.domain.model;

public class EntityNotChangedException extends EntityIntegrityViolationException {

	public EntityNotChangedException() {
		super("エンティティに変更がありません。");
	}
}
