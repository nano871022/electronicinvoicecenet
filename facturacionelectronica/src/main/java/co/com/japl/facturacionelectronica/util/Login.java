package co.com.japl.facturacionelectronica.util;
import java.util.Date;

import co.com.japl.facturacionelectronica.request.LoginRequest;

public class Login{
	private LoginRequest login;
	private Date create;
	private String token;
	public LoginRequest getLogin() {
		return login;
	}
	public void setLogin(LoginRequest login) {
		this.login = login;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}