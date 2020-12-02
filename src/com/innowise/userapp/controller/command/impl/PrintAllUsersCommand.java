package com.innowise.userapp.controller.command.impl;

import java.util.List;
import java.util.Map;

import com.innowise.userapp.bean.User;
import com.innowise.userapp.controller.command.Command;
import com.innowise.userapp.dao.DAOException;
import com.innowise.userapp.dao.UserDAO;
import com.innowise.userapp.dao.impl.UserFileDAO;

public class PrintAllUsersCommand implements Command{
	
	
	private UserDAO userDao;
	@Override
	public String execute(Map<String, Object> parameters) throws DAOException {
		userDao = new UserFileDAO();
		StringBuilder allUsersStringBuilder = new StringBuilder();
		List<User> allUsers = userDao.getAllUsers();
		for(User u: allUsers) {
			allUsersStringBuilder.append(u).append("\n");
		}
		return allUsersStringBuilder.toString();
	}

}
