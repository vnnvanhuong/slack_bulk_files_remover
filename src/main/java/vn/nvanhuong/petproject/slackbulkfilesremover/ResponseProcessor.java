package vn.nvanhuong.petproject.slackbulkfilesremover;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ResponseProcessor {
	private static final Client CLIENT = ClientBuilder.newClient();
	private static final ResponseProcessor INSTANCE = new ResponseProcessor();
	
	private ResponseProcessor() {}

	public static ResponseProcessor getInstance() {
		return INSTANCE;
	}
	
	public Response process(Form param, String url) {
		return CLIENT.target(url)
				.request(MediaType.APPLICATION_FORM_URLENCODED)
				.post(Entity.entity(param, MediaType.APPLICATION_FORM_URLENCODED));
	}
}
