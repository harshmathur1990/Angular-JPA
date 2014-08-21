package com.harmathuwebLogin;

import org.springframework.http.HttpEntity;

public interface LoginService {
	public String login(Users user);
	public String validateSession (String sessionId);
}
