package ro.upm.brebanalexandru.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.upm.brebanalexandru.dao.UserDao;
import ro.upm.brebanalexandru.pojo.UserPojo;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserDao userDao;

	@GetMapping("/users")
	public List<UserPojo> getAllUsers(){
		return userDao.findAll();
	}
	
	//create a new one
	@PostMapping("/users")
	public UserPojo createUser(@Valid @RequestBody UserPojo user) {
	    return userDao.save(user);
	}
	
	
	@GetMapping("/users/{id}")
	public UserPojo getStudentById(@PathVariable(value = "id") Integer userId) {
	   System.out.println(" ------------------"+userId);
		return userDao.findById(userId)
	    		.orElseThrow(() -> new ResourceNotFoundException("user"));
	}
	
	//update
	@PutMapping("/users/{id}")
	public UserPojo updateUser(@PathVariable(value = "id") Integer userId,
	                                        @Valid @RequestBody UserPojo UserDetails) {

		UserPojo user = userDao.findById(userId)
	    		.orElseThrow(() -> new ResourceNotFoundException("user"));

	    user.setId(UserDetails.getId());
	    user.setUsername(UserDetails.getUsername());
	    user.setPassword(UserDetails.getPassword());
	    
	    UserPojo updatedUser = userDao.save(user);
	    return updatedUser;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer userId) {
		UserPojo user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user"));
		userDao.delete(user);

	    return ResponseEntity.ok().build();
	}
}
