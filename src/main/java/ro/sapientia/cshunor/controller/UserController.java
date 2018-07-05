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

import ro.sapientia.cshunor.dao.UserDao;
import ro.sapientia.cshunor.pojo.UserPojo;


@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserDao UserDao;

	@GetMapping("/Users")
	public List<UserPojo> getAllUsers(){
		return UserDao.findAll();
	}
	
	@PostMapping("/Users")
	public UserPojo createUser(@Valid @RequestBody UserPojo User) {
	    return UserDao.save(User);
	}
	
	@GetMapping("/Users/{id}")
	public UserPojo getUserById(@PathVariable(value = "id") Integer UserId) {
	   System.out.println(" ------------------"+UserId);
		return UserDao.findById(UserId)
	    		.orElseThrow(() -> new ResourceNotFoundException("User"));
	}
	
	@PutMapping("/Users/{id}")
	public UserPojo updateUser(@PathVariable(value = "id") Integer UserId,
	                                        @Valid @RequestBody UserPojo UserDetails) {

		UserPojo User = UserDao.findById(UserId)
	    		.orElseThrow(() -> new ResourceNotFoundException("User"));

	    User.setId(UserDetails.getId());
	    User.setLastName(UserDetails.getLastName());
	    User.setFirst_name(UserDetails.getFirst_name());



	    UserPojo updatedUser = UserDao.save(User);
	    return updatedUser;
	}
	
	@DeleteMapping("/Users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer UserId) {
		UserPojo User = UserDao.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User"));

		UserDao.delete(User);

	    return ResponseEntity.ok().build();
	}
}
