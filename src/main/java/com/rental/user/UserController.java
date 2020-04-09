package com.rental.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rental.handler.CustomException;

@RestController
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/signUp")
	@ResponseBody
	public ResponseEntity<String> signUp(@RequestBody User user) throws CustomException{
		String str = null;
		if(userServ.addUser(user)) {
			str = "Sign Up Successfull";
			
		}
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
	}

}
