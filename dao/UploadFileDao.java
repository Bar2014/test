package dao;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class UploadFileDao {
	private String username;
	private File uploadFile[ ];
	private String uploadFileFileName[ ];
	private String uploadFileContentType[ ];
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File[] getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File[] uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String[] getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String[] uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String[] getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String[] uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	
	public void  beginUpload() throws IOException{
		System.out.println("username:"+username);
		String targetDirectory = ServletActionContext.getServletContext().getRealPath("/upload");
		//System.out.println(targetDirectory);
				//ServletActionContext.getRequest().getRealPath("/upload");
		System.out.println("");
		for(int i=0;i<uploadFile.length;i++){
			File target =new File(targetDirectory, new SimpleDateFormat(
					"yyyy_MM_dd_HH_mm_ss").format(new Date()).toString()+
					System.nanoTime()+uploadFileFileName[i]);
			FileUtils.copyFile(uploadFile[i], target);
		}
		System.out.println("");
		//return "upload";
	}
	
}
