package com.example.exception;

public class UserNotFound extends RuntimeException{/**
	 * 
	 */
	private static final long serialVersionUID = 2547581308277802157L;

	public UserNotFound(String message) {
		super(message);
	}
	public UserNotFound(String message, Throwable throwable) {
		super(message,throwable );
	}

}
