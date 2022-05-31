package com.example.domain.model;

public class ReferencingEntityNotExistsException extends EntityIntegrityViolationException {

	public ReferencingEntityNotExistsException() {
		super("参照先が存在しません。");
	}
}
