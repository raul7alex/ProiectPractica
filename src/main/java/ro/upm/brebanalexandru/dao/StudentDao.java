package ro.upm.brebanalexandru.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.upm.brebanalexandru.pojo.StudentPojo;
import java.util.List;


@Repository	
public interface StudentDao extends JpaRepository<StudentPojo, Integer>{




}