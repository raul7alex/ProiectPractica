package ro.upm.brebanalexandru.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ro.upm.brebanalexandru.dao.StudentDao;
import ro.upm.brebanalexandru.service.StudentService;
import ro.upm.brebanalexandru.pojo.StudentPojo;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	//private StudentDao studentsDao;
	
	@Override
	public List<StudentPojo> getStudentByName() {
		List<StudentPojo> studentList = StudentService.findByName();
		return studentList;
	}
}
