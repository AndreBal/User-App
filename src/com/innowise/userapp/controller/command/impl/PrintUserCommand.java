package com.innowise.userapp.controller.command.impl;

import java.util.Map;

import com.innowise.userapp.bean.User;
import com.innowise.userapp.controller.command.Command;
import com.innowise.userapp.controller.command.Parameter;
import com.innowise.userapp.dao.DAOException;
import com.innowise.userapp.dao.UserDAO;
import com.innowise.userapp.dao.impl.UserFileDAO;
import com.innowise.userapp.resourcemanager.MessageParameter;
import com.innowise.userapp.resourcemanager.ResourceManager;

public class PrintUserCommand implements Command {

	private UserDAO userDao;
	private ResourceManager resManager = ResourceManager.getInstance();

	@Override
	public String execute(Map<String, Object> parameters) throws DAOException {
		userDao = new UserFileDAO();
		String email = (String) parameters.get(Parameter.EMAIL);
		User user = userDao.getUserByEmail(email);
		if(user == null) {
			return resManager.getValue(MessageParameter.USER_NOT_FOUND);
		}
		return user.toString();
	}

}
