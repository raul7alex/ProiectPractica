package ro.upm.brebanalexandru.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import ro.upm.brebanalexandru.dao.UserDao;
import ro.upm.brebanalexandru.pojo.UserPojo;
import ro.upm.brebanalexandru.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	
	private UserDao userDao;
	
	@Override
	public List<UserPojo> getUserByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPojo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo save(@Valid UserPojo user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo updateUser(Integer userId, @Valid UserPojo userDetails) {
		UserPojo user = userDao.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("user"));
		
		user.setId(userDetails.getId());
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		UserPojo updatedUser = userDao.save(user);
		return updatedUser;
	}

	@Override
	public UserPojo deleteUser(Integer userId) {
		UserPojo user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user"));
		userDao.delete(user);
//return ResponseEntity.ok().build();
		return null;
	}

	@Override
	public List<UserPojo> findByName() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
