package com.innowise.userapp.dao;

import java.util.List;

import com.innowise.userapp.bean.User;

public interface UserDAO {
	
	void saveUser(User user) throws DAOException;
	
	User getUserByEmail(String email) throws DAOException;
	
	boolean deleteUserByEmail(String email) throws DAOException;
	
	List<User> getAllUsers() throws DAOException;

}
