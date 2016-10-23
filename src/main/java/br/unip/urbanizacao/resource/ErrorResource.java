package br.unip.urbanizacao.resource;

public class ErrorResource {

	private int code;
	private String message;
	private StackTraceElement stack;

	public ErrorResource(final int code, final String message) {
		this.code = code;
		this.message = message;
	}

	public ErrorResource(final int code, final String message, final StackTraceElement stack) {
		this.stack = stack;
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(final int code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public StackTraceElement getStack() {
		return this.stack;
	}

	public void setStack(final StackTraceElement stack) {
		this.stack = stack;
	}

}
