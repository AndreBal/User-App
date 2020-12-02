package com.innowise.userapp.controller.command.impl;

import java.util.Map;

import com.innowise.userapp.controller.command.Command;
import com.innowise.userapp.controller.command.Parameter;
import com.innowise.userapp.dao.DAOException;
import com.innowise.userapp.dao.UserDAO;
import com.innowise.userapp.dao.impl.UserFileDAO;
import com.innowise.userapp.resourcemanager.MessageParameter;
import com.innowise.userapp.resourcemanager.ResourceManager;

public class DeleteUserCommand implements Command {

	private ResourceManager resManager;
	private UserDAO userDao;

	@Override
	public String execute(Map<String, Object> parameters) throws DAOException {
		resManager = ResourceManager.getInstance();
		userDao = new UserFileDAO();
		String email = (String) parameters.get(Parameter.EMAIL);
		if (userDao.deleteUserByEmail(email)) {
			return resManager.getValue(MessageParameter.DELETE_USER_DELETED_SUCCESSFULLY);
		}
		return resManager.getValue(MessageParameter.DELETE_USER_USER_DOESNT_EXIST);
	}

}
