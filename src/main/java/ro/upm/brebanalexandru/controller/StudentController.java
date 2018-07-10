package ro.upm.brebanalexandru.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.upm.brebanalexandru.pojo.StudentPojo;
import ro.upm.brebanalexandru.bl.StudentBl;

@RestController
@RequestMapping("/api")
public class StudentController{

	@Autowired
	StudentBl studentBl;
	

	@GetMapping("/student")
	public List<StudentPojo> getAllStudents(){
		return studentBl.getAllStudents();
	}
	

	@PostMapping("/student")
	public StudentPojo createStudent(@Valid @RequestBody StudentPojo student) {
	    return studentBl.save(student);
	}
	
	
	@GetMapping("/student/{id}")
	public StudentPojo findStudentById(@PathVariable(value = "id") Integer studentId) {	
		return studentBl.findStudentById(studentId);
	}
	
	//to do
	@PutMapping("/student/{id}")
	public StudentPojo updateStudent(@PathVariable(value = "id") Integer studentId,
	                                        @Valid @RequestBody StudentPojo studentDetails) {
	    try {
	    	studentBl.updateStudent(studentId, studentDetails);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	    return null;
	}
	
	@DeleteMapping("/student/{id}")
	public StudentPojo deleteStudentById(@PathVariable(value = "id") Integer studentId) {
		try {
			studentBl.deleteByID(studentId);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}