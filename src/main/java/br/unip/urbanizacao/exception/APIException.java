package br.unip.urbanizacao.exception;

import br.unip.urbanizacao.resource.ErrorResource;

public class APIException extends Exception {

	private static final long serialVersionUID = 1L;

	private Integer errorCode = 500;

	public APIException() {
		super();
	}

	public APIException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public APIException(final String message, final Throwable cause,
			final Integer errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public APIException(final String message, final Integer errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public APIException(final String message) {
		super(message);
	}

	public APIException(final Throwable cause) {
		super(cause);
	}

	public APIException(final Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(final Integer errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorResource getResouce() {
		return new ErrorResource(this.errorCode, this.getMessage(), this.getStackTrace()[0]);
	}

}
