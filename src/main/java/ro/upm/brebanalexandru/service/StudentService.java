package ro.upm.brebanalexandru.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import ro.upm.brebanalexandru.pojo.StudentPojo;;

public interface StudentService {
	
	public List<StudentPojo> getStudentByName();

	public List<StudentPojo> findByName();

	public List<StudentPojo> getAllStudents();

	public StudentPojo save(StudentPojo student);

	public StudentPojo getStudentById(Integer studentId) throws ResourceNotFoundException	;

	public StudentPojo deleteStudent(Integer studentId);

	public StudentPojo updateStudent(Integer studentId, @Valid StudentPojo studentDetails);

}