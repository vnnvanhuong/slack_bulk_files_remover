package vn.nvanhuong.petproject.slackbulkfilesremover;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseParser {
	private static final String FILES_NODE = "files";
	private static final String OK_NODE = "ok";
	
	private ResponseParser() {}

	public static List<File> parseList(Response response) throws ResponseParserException  {
		try {
			String json = response.readEntity(String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);			
			return mapper.readValue(root.get(FILES_NODE).toString(), new TypeReference<List<File>>(){});
		} catch (IOException e) {
			throw new ResponseParserException(e);
		}
		
	}
	
	public static Boolean parseDelete(Response response) throws ResponseParserException  {
		try {
			String json = response.readEntity(String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);			
			
			return mapper.readValue(root.get(OK_NODE).toString(), Boolean.class);
		} catch (IOException e) {
			throw new ResponseParserException(e);
		}
		
	}
}
