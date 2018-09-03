package edu.regparsing.exceptions;

public class ResourceNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8871385734185908020L;
	private String message;
	private Throwable cause;
	
	
	public ResourceNotFoundException(String message) {
		this.message = message;
	}


	public ResourceNotFoundException(String message, Throwable cause) {
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
		builder.append("ResourceNotFoundException [message=");
		builder.append(message);
		builder.append(", cause=");
		builder.append(cause);
		builder.append("]");
		return builder.toString();
	}
}
