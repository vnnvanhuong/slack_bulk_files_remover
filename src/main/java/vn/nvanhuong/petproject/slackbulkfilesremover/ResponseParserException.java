package vn.nvanhuong.petproject.slackbulkfilesremover;

import java.io.IOException;

public class ResponseParserException extends Exception {
	private static final long serialVersionUID = -3748077635007530956L;

	public ResponseParserException(IOException e) {
		super(e);
	}
}
