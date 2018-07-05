package ro.upm.brebanalexandru.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ro.upm.brebanalexandru.dao.UserDao;
import ro.upm.brebanalexandru.pojo.UserPojo;
import ro.upm.brebanalexandru.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao UserDao;
	
	@Override
	public List<UserPojo> getUserByName() {
		List<UserPojo> userList = UserService.findByName();
		return userList;
	}
}
