package ro.upm.brebanalexandru.service;

import java.util.List;

import ro.upm.brebanalexandru.pojo.UserPojo;

public interface UserService {
	public List<UserPojo> getUserByName();

	public static List<UserPojo> findByName() {
		// TODO Auto-generated method stub
		return null;
	}
}
