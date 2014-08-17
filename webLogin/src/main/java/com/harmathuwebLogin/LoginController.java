package com.harmathuwebLogin;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller("/app")
public class LoginController implements LoginService {
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	UsersRepository userRepository;

	@Override
	@RequestMapping(value = "/app/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@ResponseBody
	public String login(@RequestBody Users user) {
		Users user_res = userRepository.findByUserNameAndPassWord(
				user.getUserName(), user.getPassWord());
		if (user_res != null) {
			Sessions new_session = new Sessions(user_res,
					GregorianCalendar.getInstance(),
					GregorianCalendar.getInstance());
			sessionRepository.save(new_session);
			String body = "{\"sessionId\" : \"" + new_session.getSessionId()
					+ "\",\"firstName\" : \"" + user_res.getFirstName()
					+ "\",\"lastName\" : \"" + user_res.getLastName() + "\"}";
			return body;
		} else {
			throw new HttpUnauthorizedException();
		}
	}
}
