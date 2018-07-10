package ro.upm.brebanalexandru.bl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.upm.brebanalexandru.pojo.UserPojo;
import ro.upm.brebanalexandru.service.UserService;

@Service
public class UserBl {

	@Autowired
	UserService userService;
	
	public void deleteById(Integer userId)throws Exception {
		if(userService.findUserById(userId)==null)throw new Exception("No user with this ID!");
		userService.deleteById(userId);
		
	}

	public List<UserPojo> getAllUsers() {
		return userService.getAllUsers();
	}

	public UserPojo save( UserPojo user) {
		return userService.save(user);
	}


	public void updateUser(Integer userId, @Valid UserPojo userDetails)throws Exception {
		if(userService.findUserById(userId) == null) throw new Exception("afads");
		if(userDetails==null) throw new Exception("Empty student field!");
		if(userDetails.getUsername()==null||userDetails.getUsername().isEmpty()) throw new Exception("Empty student First Name field!");
		userService.updateUser(userId, userDetails);
	}

	public UserPojo findUserById(Integer userId) {
		return userService.findUserById(userId);
	}
	
}
