package edu.regparsing.exceptions;

import java.io.IOException;

public class ParsingException extends IOException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2267161164088690186L;
	private String message;
	private Throwable cause;
	
	
	public ParsingException(String message) {
		this.message = message;
	}


	public ParsingException(String message, Throwable cause) {
		this.message = message;
		this.cause = cause;
	}


	public String getMessage() {
		return message;
	}


	public Throwable getCause() {
		return cause;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParsingException [message=");
		builder.append(message);
		builder.append(", cause=");
		builder.append(cause);
		builder.append("]");
		return builder.toString();
	}
	
	
}
