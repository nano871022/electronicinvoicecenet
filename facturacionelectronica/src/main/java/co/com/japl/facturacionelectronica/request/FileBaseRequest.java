package co.com.japl.facturacionelectronica.request;

import java.io.File;

public class FileBaseRequest extends BaseRequest{
	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}