package ro.upm.brebanalexandru.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.upm.brebanalexandru.pojo.UserPojo;

public interface UserDao extends JpaRepository<UserPojo, Integer>{

}
