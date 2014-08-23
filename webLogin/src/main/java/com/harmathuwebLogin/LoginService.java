package com.harmathuwebLogin;

import org.springframework.http.HttpEntity;

public interface LoginService {
	public HttpEntity<String> login(Users user);
	public String validateSession (String sessionId);
}
