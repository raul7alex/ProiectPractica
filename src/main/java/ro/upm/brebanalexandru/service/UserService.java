package ro.upm.brebanalexandru.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import ro.upm.brebanalexandru.pojo.UserPojo;

public interface UserService {
	public List<UserPojo> getUserByName();

	public List<UserPojo> findByName();

	public List<UserPojo> getAllUsers();

	public UserPojo save(UserPojo user);

	public UserPojo findUserById(Integer userId) throws ResourceNotFoundException;

	public void updateUser(Integer userId, @Valid UserPojo userDetails);

	public void deleteById(Integer userId);

}
