package co.com.japl.facturacionelectronica.request;

import java.io.File;

public class FileRequest extends ARequest{
	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}