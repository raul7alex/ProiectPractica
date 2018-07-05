package ro.upm.brebanalexandru.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.upm.brebanalexandru.pojo.UserPojo;
import java.util.List;

public interface UserDao extends JpaRepository<UserPojo, Integer>{

}
