package ro.upm.brebanalexandru.service;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import ro.upm.brebanalexandru.pojo.StudentPojo;;

public interface StudentService {
	
	public List<StudentPojo> getStudentByName();

	public List<StudentPojo> findByName();

	public List<StudentPojo> getAllStudents();

	public StudentPojo save(StudentPojo student);

	public void updateStudent(Integer studentId, StudentPojo studentDetails);

	public StudentPojo findStudentById(Integer studentId) throws ResourceNotFoundException	;

	public void deleteById(Integer studentId);



}