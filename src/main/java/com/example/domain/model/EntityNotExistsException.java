package com.example.domain.model;

public class EntityNotExistsException extends EntityIntegrityViolationException {

	public EntityNotExistsException() {
		super("指定のIDは削除済などの理由により存在しません。");
	}
}
