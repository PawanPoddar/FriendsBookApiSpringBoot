package springBoot.astroTalk.Response;

import java.io.Serializable;

public class ErrorResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int errorCode;
	
	private String errorDesc;

	public int getErrorCode() {
		return errorCode;
	}

	public ErrorResponse setErrorCode(int errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public ErrorResponse setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
		return this;
	}
}
