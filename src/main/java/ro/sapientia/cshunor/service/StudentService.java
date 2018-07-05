package ro.sapientia.cshunor.service;

import ro.sapientia.cshunor.pojo.StudentPojo;

import java.util.List;

public interface StudentService {
	
	public List<StudentPojo> getStudentByName();

	public static List<StudentPojo> findByName() {
		// TODO Auto-generated method stub
		return null;
	}
}
