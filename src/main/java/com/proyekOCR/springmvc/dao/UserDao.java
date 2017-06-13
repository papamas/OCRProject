package com.proyekOCR.springmvc.dao;

import java.util.List;

import com.proyekOCR.springmvc.model.User;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
        User findByEmail(String email);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();

}

