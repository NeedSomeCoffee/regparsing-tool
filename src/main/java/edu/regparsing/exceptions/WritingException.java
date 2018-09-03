package edu.regparsing.exceptions;

import java.io.IOException;

public class WritingException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2983876175723862770L;
	private String message;
	private Throwable cause;
	
	
	public WritingException(String message) {
		this.message = message;
	}


	public WritingException(String message, Throwable cause) {
		this.message = message;
		this.cause = cause;
	}


	public String getMessage() {
		return message;
	}


	public Throwable getCause() {
		return cause;
	}
}
