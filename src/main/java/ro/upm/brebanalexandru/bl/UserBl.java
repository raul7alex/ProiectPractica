package ro.upm.brebanalexandru.bl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import ro.upm.brebanalexandru.pojo.UserPojo;
import ro.upm.brebanalexandru.service.UserService;

public class UserBl {

	@Autowired
	UserService userService;
	
	public UserPojo deleteUser(Integer userId) {
		return userService.deleteUser(userId);
		
	}

	public List<UserPojo> findAll() {
		// TODO Auto-generated method stub
		return userService.findAll();
	}

	public UserPojo save(@Valid UserPojo user) {
		// TODO Auto-generated method stub
		return userService.save(user);
	}


	public UserPojo updateUser(Integer userId, @Valid UserPojo userDetails) {
		// TODO Auto-generated method stub
		return userService.updateUser(userId,userDetails);
	}

	public UserPojo getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userService.getUserById(userId);
	}
	
}
