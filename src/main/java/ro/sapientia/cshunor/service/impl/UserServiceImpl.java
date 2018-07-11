package ro.sapientia.cshunor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.sapientia.cshunor.pojo.UserPojo;
import ro.sapientia.cshunor.service.UserService;
import ro.sapientia.cshunor.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao UsersDao;
	
	@Override
	public List<UserPojo> getUserByName() {
		List<UserPojo> studentList = UserService.findByName();
		return UserList;
	}

	@Override
	public List<UserPojo> getUsertByName() {
		// TODO Auto-generated method stub
		return null;
	}
}
