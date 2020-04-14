package com.rental.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rental.handler.CustomException;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/addUser")
	@ResponseBody
	public ResponseEntity<Boolean> signUp(@RequestBody User user) throws CustomException{
		if(userServ.addUser(user)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	public ResponseEntity<ArrayList<User>> getUserlist(){
		ArrayList<User> list = new ArrayList<User>();
		list = userServ.getUserList();
		return new ResponseEntity<ArrayList<User>>(list, HttpStatus.OK);
	}
}









//@RequestMapping(method = RequestMethod.GET, value = "/signUp1")
//public String display1() {
//	System.out.println("Rushil Shah");
//	return "signUp";
//}
//
//@RequestMapping(method = RequestMethod.GET, value = "/signUp2")
//public String display2() {
//	System.out.println("Rushil Shah");
//	return "loginSignUp";
//}