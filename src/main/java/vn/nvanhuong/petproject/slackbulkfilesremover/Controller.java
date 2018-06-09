package vn.nvanhuong.petproject.slackbulkfilesremover;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "controller")
@ViewScoped
public class Controller {
	private List<File> files;
	private String token;

	public void onListFiles() {
		Service service = new Service();
		try {
			files = service.findFilesBy(token);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("All files listed successfully"));
		} catch (ResponseParserException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fail to obtain file list"));
			System.err.println(e);
		}
	}

	public void onDeleteAll() {
		Service service = new Service();
		boolean success = true;
		try {
			files = service.findFilesBy(token);
			for (File file : files) {
				try {
					 if(!service.deleteFileBy(file.getId(), token)) {
						 success = false;
					 }
				} catch (ResponseParserException e) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Could not delete file: " + file.getName()));
				}
			}

		} catch (ResponseParserException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fail to obtain file list"));
			System.err.println(e);
		}
		
		if(success) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("All files deleted successfully"));
		}
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
