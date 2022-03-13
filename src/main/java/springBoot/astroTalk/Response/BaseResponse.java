package springBoot.astroTalk.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int status;
	
	private List<ErrorResponse> errors;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<ErrorResponse> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorResponse> errors) {
		this.errors = errors;
	}
	
	public void setErrors(ErrorResponse errors) {
		if(errors != null) {
			if(this.errors == null) {
				this.errors = new ArrayList<ErrorResponse>();
			}
			this.errors.add(errors);
		}
	}
	
}

