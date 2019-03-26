package com.felipeguimaraes.codechallenge.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PdvNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PdvNotFoundException(String message) {
		super(message, null, false, false);
	}

}
