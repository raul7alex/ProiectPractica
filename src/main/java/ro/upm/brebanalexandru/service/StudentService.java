package ro.upm.brebanalexandru.service;

import java.util.List;
import ro.upm.brebanalexandru.pojo.StudentPojo;;

public interface StudentService {
	
	public List<StudentPojo> getStudentByName();

	public static List<StudentPojo> findByName() {
		// TODO Auto-generated method stub
		return null;
	}
}