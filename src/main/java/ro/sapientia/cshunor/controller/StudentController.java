package ro.sapientia.cshunor.controller;

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

import ro.sapientia.cshunor.dao.StudentDao;
import ro.sapientia.cshunor.pojo.StudentPojo;


@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@GetMapping("/students")
	public List<StudentPojo> getAllStudents(){
		return studentDao.findAll();
	}
	
	@PostMapping("/students")
	public StudentPojo createStudent(@Valid @RequestBody StudentPojo student) {
	    return studentDao.save(student);
	}
	
	@GetMapping("/students/{id}")
	public StudentPojo getStudentById(@PathVariable(value = "id") Integer studentId) {
	   System.out.println(" ------------------"+studentId);
		return studentDao.findById(studentId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Student"));
	}
	
	@PutMapping("/students/{id}")
	public StudentPojo updateStudent(@PathVariable(value = "id") Integer studentId,
	                                        @Valid @RequestBody StudentPojo studentDetails) {

		StudentPojo student = studentDao.findById(studentId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Student"));

	    student.setId(studentDetails.getId());
	    student.setLastName(studentDetails.getLastName());
	    student.setFirst_name(studentDetails.getFirst_name());
	    student.setDepartment(studentDetails.getDepartment());
	    student.setYear(studentDetails.getYear());
	    
	    Date date = new Date();
	    student.setUpdated(new Timestamp(date.getTime()));

	    StudentPojo updatedStudent = studentDao.save(student);
	    return updatedStudent;
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Integer studentId) {
		StudentPojo student = studentDao.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student"));

		studentDao.delete(student);

	    return ResponseEntity.ok().build();
	}
}
