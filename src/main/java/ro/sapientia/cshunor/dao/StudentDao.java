package ro.sapientia.cshunor.dao;

import org.springframework.stereotype.Repository;

import ro.sapientia.cshunor.pojo.StudentPojo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentDao extends JpaRepository<StudentPojo,Integer> {
	
	
}

