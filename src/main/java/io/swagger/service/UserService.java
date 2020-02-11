package io.swagger.service;

import org.springframework.http.ResponseEntity;

import io.swagger.api.NotFoundException;
import io.swagger.model.User;

public interface UserService {

	ResponseEntity<User> usersPost(User body) throws NotFoundException;
	User getDetails(String userName) throws NotFoundException;


	ResponseEntity<User> usersUserNameGet(String userName) throws NotFoundException;

}
