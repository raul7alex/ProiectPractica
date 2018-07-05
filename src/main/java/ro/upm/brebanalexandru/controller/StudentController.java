package ro.upm.brebanalexandru.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.upm.brebanalexandru.dao.StudentDao;
import ro.upm.brebanalexandru.pojo.StudentPojo;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@GetMapping("/student")
	public List<StudentPojo> getAllStudents(){
		return studentDao.findAll();
	}
	
	@PostMapping("/student")
	public StudentPojo createStudent(@Valid @RequestBody StudentPojo student) {
	    return studentDao.save(student);
	}
	
	@GetMapping("/student/{id}")
	public StudentPojo getStudentById(@PathVariable(value = "id") Integer studentId) {
	   System.out.println(" ------------------"+studentId);
		return studentDao.findById(studentId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Student"));
	}
	
	@PutMapping("/student/{id}")
	public StudentPojo updateStudent(@PathVariable(value = "id") Integer studentId,
	                                        @Valid @RequestBody StudentPojo studentDetails) {

		StudentPojo student = studentDao.findById(studentId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Student"));

	    student.setId(studentDetails.getId());
	    student.setLastname(studentDetails.getLastname());
	    student.setFirstname(studentDetails.getFirstname());
	    student.setProfile(studentDetails.getProfile());
	    student.setYear(studentDetails.getYear());
	    
	    Date date = new Date();
	    student.setRegistrationdate(new Timestamp(date.getTime()));

	    StudentPojo updatedStudent = studentDao.save(student);
	    return updatedStudent;
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Integer studentId) {
		StudentPojo student = studentDao.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student"));

		studentDao.delete(student);

	    return ResponseEntity.ok().build();
	}
}