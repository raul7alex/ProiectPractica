package ro.upm.brebanalexandru.bl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import ro.upm.brebanalexandru.pojo.StudentPojo;
import ro.upm.brebanalexandru.service.StudentService;

public class StudentBl {

	@Autowired
	StudentService studentService;
	
	public List<StudentPojo> getAllStudents() {
		return studentService.getAllStudents();
	}

	public StudentPojo save(StudentPojo student) {
		// TODO valideaza name etc
		return studentService.save(student);
	}

	public StudentPojo getStudentById(Integer studentId) {
		// TODO verifici paramtrii
		return studentService.getStudentById(studentId);
	}

	public StudentPojo updateStudent(Integer studentId, @Valid StudentPojo studentDetails) {
		return studentService.updateStudent(studentId,studentDetails);
	}

	public StudentPojo deleteStudent(Integer studentId) {
		return studentService.deleteStudent(studentId);
	}




}
