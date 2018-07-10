package ro.upm.brebanalexandru.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import ro.upm.brebanalexandru.dao.UserDao;
import ro.upm.brebanalexandru.pojo.UserPojo;
import ro.upm.brebanalexandru.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	
	private UserDao userDao;
	
	@Override
	public List<UserPojo> getUserByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPojo> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public UserPojo save( UserPojo user) {
		return userDao.save(user);
	}

	@Override
	public UserPojo findUserById(Integer userId) throws ResourceNotFoundException {
		return userDao.findById(userId)
	    		.orElseThrow(() -> new ResourceNotFoundException("User"));
	}

	@Override
	public void updateUser(Integer userId, UserPojo userDetails) {
		UserPojo user = userDao.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("user"));
		user.setId(userId);
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		userDao.save(user);
	}

	@Override
	public List<UserPojo> findByName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteById(Integer userId) {
		userDao.deleteById(userId);
	}
}
