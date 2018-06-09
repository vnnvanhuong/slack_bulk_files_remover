package vn.nvanhuong.petproject.slackbulkfilesremover;

import javax.ws.rs.core.Form;

public class RequestParamBuilder {
	private static final String FILE = "file";
	private static final String TOKEN = "token";
	private static final RequestParamBuilder instance = new RequestParamBuilder();
	private String token;
	private String fileId;
	
	private RequestParamBuilder() {}

	public static RequestParamBuilder getInstance() {
		return instance;
	}
	
	public RequestParamBuilder withToken(String token) {
		this.token = token;
		return this;
	}
	
	public RequestParamBuilder withFileId(String fileId) {
		this.fileId = fileId;
		return this;
	}
	
	public Form build() {
		Form result = new Form();
		result.param(TOKEN, token);
		result.param(FILE, fileId);
		return result;
	}

}
