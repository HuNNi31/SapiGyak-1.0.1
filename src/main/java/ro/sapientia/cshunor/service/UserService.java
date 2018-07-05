package ro.sapientia.cshunor.service;

import ro.sapientia.cshunor.pojo.UserPojo;

import java.util.List;

public interface UserService {
	
	public List<UserPojo> getUsertByName();

	public static List<UserPojo> findByName() {
		// TODO Auto-generated method stub
		return null;
	}
}
