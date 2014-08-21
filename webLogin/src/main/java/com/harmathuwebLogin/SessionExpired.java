package com.harmathuwebLogin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.REQUEST_TIMEOUT)
public class SessionExpired extends RuntimeException {

}
