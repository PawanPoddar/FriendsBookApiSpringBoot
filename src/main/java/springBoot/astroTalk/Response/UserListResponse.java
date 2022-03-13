package springBoot.astroTalk.Response;

import java.util.List;

import springBoot.astroTalk.Model.User;

public class UserListResponse extends BaseResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<User> data;

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}
}
