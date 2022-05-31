package com.example.domain.model;

public class EntityIntegrityViolationException extends RuntimeException {

	public EntityIntegrityViolationException(String message) {
		super(message);
	}
}
