package io.swagger.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.swagger.api.NotFoundException;
import io.swagger.dao.UserRepository;
import io.swagger.model.User;
@Service
public class UserServiceImpl implements UserService {
	
	/*
	 * private final HttpServletRequest request;
	 * 
	 * @org.springframework.beans.factory.annotation.Autowired public
	 * UserServiceImpl(HttpServletRequest request) { this.request = request; }
	 */
    
	 @Autowired
	    private UserRepository userRepository;

	@Override
	public ResponseEntity<User> usersPost(User body) throws NotFoundException {
		/*
		 * String accept = request.getHeader("Accept"); if (accept != null) {
		 */
			User user = userRepository.findOne(body.getUserName());
			if (user != null) {
				throw new NotFoundException(500, "User already exist with this username.");
			} else {
				user = userRepository.save(body);
				return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
			}
		/*} else

			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);*/
	}

	@Override
	public ResponseEntity<User> usersUserNameGet(String userName) throws NotFoundException {
		//String accept = request.getHeader("Accept");
		User user = userRepository.findOne(userName);
		
			if (user == null) {
				throw new NotFoundException(500, "No user found with this username.");
			} else {
				return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
			}
	}


	@Override
	public User getDetails(String userName) throws NotFoundException {
		
		User details=null;
		
			details=userRepository.findOne(userName);
		
		return details;
	}


}
