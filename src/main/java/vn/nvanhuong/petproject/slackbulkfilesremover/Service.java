package vn.nvanhuong.petproject.slackbulkfilesremover;

import java.util.List;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

public class Service {

	public List<File> findFilesBy(String token) throws ResponseParserException {
		Form param = RequestParamBuilder.getInstance().withToken(token).build();
		Response response = ResponseProcessor.getInstance().process(param, SlackApiUrl.FILES_LIST);
		return ResponseParser.parseList(response);
	}
	
	public boolean deleteFileBy(String fileId, String token) throws ResponseParserException {
		Form param = RequestParamBuilder.getInstance().withToken(token).withFileId(fileId).build();
		Response response =  ResponseProcessor.getInstance().process(param, SlackApiUrl.FILES_DELETE);
		return ResponseParser.parseDelete(response);
	}
}
