package com.dualdb.dualdbdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dualdb.dualdbdemo.service.UserService;
import com.dualdb.dualdbdemo.usermodel.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getusers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userList= userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	// /user/getproductbyuser?userId=1
	@GetMapping("/getproductbyuser")
	public ResponseEntity<User> getProductsByUser(@RequestParam(value= "userId") int userId){
		
		User user=userService.getProductsByUser(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		User userResponse= userService.saveUser(user);
		return new ResponseEntity<User>(userResponse,HttpStatus.OK);
	}

}
