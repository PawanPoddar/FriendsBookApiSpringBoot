package springBoot.astroTalk.Response;

import java.util.Map;

public class MapResponse extends BaseResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> data;

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
