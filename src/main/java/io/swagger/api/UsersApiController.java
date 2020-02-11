package io.swagger.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import io.swagger.model.User;
import io.swagger.service.UserService;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-21T11:51:13.410Z[GMT]")
@Controller
public class UsersApiController implements UsersApi {

    @Autowired
    private UserService userService;

    
    @PostMapping("/newUser")
    public ResponseEntity<User> usersPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User body) throws NotFoundException {
    	return userService.usersPost(body);
    }

    public ResponseEntity<User> usersUserNameGet(@ApiParam(value = "",required=true) @PathVariable("UserName") String userName) throws NotFoundException {
    	return userService.usersUserNameGet(userName);
	}

}
