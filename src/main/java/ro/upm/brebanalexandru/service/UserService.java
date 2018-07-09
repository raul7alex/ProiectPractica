package ro.upm.brebanalexandru.service;

import java.util.List;

import javax.validation.Valid;

import ro.upm.brebanalexandru.pojo.UserPojo;

public interface UserService {
	public List<UserPojo> getUserByName();

	public List<UserPojo> findByName();

	public List<UserPojo> findAll();

	public UserPojo save(@Valid UserPojo user);

	public UserPojo getUserById(Integer userId);

	public UserPojo updateUser(Integer userId, @Valid UserPojo userDetails);

	public UserPojo deleteUser(Integer userId);

}
