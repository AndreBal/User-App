package com.innowise.userapp.controller.command.impl;

import java.util.List;
import java.util.Map;

import com.innowise.userapp.bean.User;
import com.innowise.userapp.controller.command.Command;
import com.innowise.userapp.controller.command.Parameter;
import com.innowise.userapp.dao.DAOException;
import com.innowise.userapp.dao.UserDAO;
import com.innowise.userapp.dao.impl.UserFileDAO;
import com.innowise.userapp.resourcemanager.MessageParameter;
import com.innowise.userapp.resourcemanager.ResourceManager;

public class AddUserCommand implements Command {

	private ResourceManager resManager;
	private UserDAO userDao;

	@Override
	public String execute(Map<String, Object> parameters) throws DAOException {
		resManager = ResourceManager.getInstance();
		userDao = new UserFileDAO();
		User user = new User();
		String name = (String) parameters.get(Parameter.NAME);
		user.setName(name);
		String surname = (String) parameters.get(Parameter.SURNAME);
		user.setSurname(surname);
		String email = (String) parameters.get(Parameter.EMAIL);
		user.setEmail(email);
		List<String> roles = (List<String>) parameters.get(Parameter.ROLES);
		user.setRoles(roles);
		List<String> phones = (List<String>) parameters.get(Parameter.PHONES);
		user.setPhones(phones);

		userDao.saveUser(user);

		return resManager.getValue(MessageParameter.ADD_USER_ADDED_SUCCESSFULLY);
	}

}
