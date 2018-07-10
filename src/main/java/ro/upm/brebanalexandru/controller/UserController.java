package ro.upm.brebanalexandru.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.upm.brebanalexandru.bl.UserBl;
import ro.upm.brebanalexandru.pojo.UserPojo;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserBl userBl;

	@GetMapping("/users")
	public List<UserPojo> getAllUsers(){
		return userBl.getAllUsers();
	}
	
	@PostMapping("/users")
	public UserPojo createUser(@Valid @RequestBody UserPojo user) {
	    return userBl.save(user);
	}
	
	
	@GetMapping("/users/{id}")
	public UserPojo findUserById(@PathVariable(value = "id") Integer userId) {
		return userBl.findUserById(userId);
	}
	
	//update
	@PutMapping("/users/{id}")
	public UserPojo updateUser(@PathVariable(value = "id") Integer userId,
	                                        @Valid @RequestBody UserPojo userDetails) {

		try {
	    	userBl.updateUser(userId, userDetails);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	    return null;
	}
	
	@DeleteMapping("/users/{id}")
	public UserPojo deleteUserById(@PathVariable(value = "id") Integer userId) {
		try {
			userBl.deleteById(userId);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
