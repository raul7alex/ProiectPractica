package ro.upm.brebanalexandru.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.upm.brebanalexandru.pojo.StudentPojo;
import ro.upm.brebanalexandru.service.StudentService;


@Service
public class StudentBl {

	@Autowired
	StudentService studentService;
	
	public List<StudentPojo> getAllStudents() {
		return studentService.getAllStudents();
	}

	public StudentPojo save(StudentPojo student) {
		return studentService.save(student);
	}

	public StudentPojo findStudentById(Integer studentId) {
		return studentService.findStudentById(studentId);
	}

	public void updateStudent(Integer studentId, StudentPojo studentDetails) throws Exception {
		if(studentService.findStudentById(studentId) == null) throw new Exception("afads");
		if(studentDetails==null) throw new Exception("Empty student field!");
		if(studentDetails.getFirstname()==null||studentDetails.getFirstname().isEmpty()) throw new Exception("Empty student First Name field!");
		studentService.updateStudent(studentId, studentDetails);
	}

	public void deleteByID( Integer studentId ) throws Exception {
		if(studentService.findStudentById(studentId)==null)throw new Exception("No student with this ID!");
		studentService.deleteById(studentId);
	}




}
