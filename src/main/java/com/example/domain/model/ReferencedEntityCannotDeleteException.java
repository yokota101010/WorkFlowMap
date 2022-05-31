package com.example.domain.model;

public class ReferencedEntityCannotDeleteException extends EntityIntegrityViolationException {

	public ReferencedEntityCannotDeleteException() {
		super("指定のIDは使用中です。");
	}
}
