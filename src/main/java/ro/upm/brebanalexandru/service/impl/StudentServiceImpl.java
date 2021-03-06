package ro.upm.brebanalexandru.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


import ro.upm.brebanalexandru.service.StudentService;
import ro.upm.brebanalexandru.dao.StudentDao;
import ro.upm.brebanalexandru.pojo.StudentPojo;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentsDao;
	
	@Override
	public List<StudentPojo> getAllStudents() {
		return studentsDao.findAll();
	}
	
	@Override
	public StudentPojo save(StudentPojo student) {
		return studentsDao.save(student);
	}
	
	@Override
	public StudentPojo findStudentById(Integer studentId) throws ResourceNotFoundException	 {
		return studentsDao.findById(studentId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Student"));
	}

	@Override
	public List<StudentPojo> getStudentByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentPojo> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(Integer studentId, StudentPojo studentDetails) {
		StudentPojo student = studentsDao.findById(studentId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Student"));
	    student.setId(studentId);
	    student.setLastname(studentDetails.getLastname());
	    student.setFirstname(studentDetails.getFirstname());
	    student.setProfile(studentDetails.getProfile());
	    student.setYear(studentDetails.getYear());
	    Timestamp stamp=new Timestamp(System.currentTimeMillis());
	    Date date = new Date(stamp.getTime());
	    student.setLastmod(date);
	    studentsDao.save(student);

	}


	@Override
	public void deleteById(Integer studentId) {
		studentsDao.deleteById(studentId);
	}

	
}
