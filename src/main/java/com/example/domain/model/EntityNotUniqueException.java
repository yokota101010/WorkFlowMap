package com.example.domain.model;

public class EntityNotUniqueException extends EntityIntegrityViolationException {

	public EntityNotUniqueException() {
		super("指定のIDは既存です。");
	}
}
