package ro.sapientia.cshunor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.sapientia.cshunor.pojo.StudentPojo;
import ro.sapientia.cshunor.service.StudentService;
import ro.sapientia.cshunor.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentsDao;
	
	@Override
	public List<StudentPojo> getStudentByName() {
		List<StudentPojo> studentList = StudentService.findByName();
		return studentList;
	}
}
