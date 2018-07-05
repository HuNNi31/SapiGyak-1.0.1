package ro.sapientia.cshunor.dao;

import org.springframework.stereotype.Repository;

import ro.sapientia.cshunor.pojo.UserPojo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDao extends JpaRepository<UserPojo,Integer> {
	
	
}

