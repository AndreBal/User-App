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

public class EditUserCommand implements Command{
	
	private ResourceManager resManager;
	private UserDAO userDao;

	@Override
	public String execute(Map<String, Object> parameters) throws DAOException {
		resManager = ResourceManager.getInstance();
		userDao = new UserFileDAO();
		String email = (String) parameters.get(Parameter.EMAIL);
		User user = userDao.getUserByEmail(email);
		if(user == null) {
			return resManager.getValue(MessageParameter.USER_NOT_FOUND);
		}
		userDao.deleteUserByEmail(email);
		
		if(parameters.containsKey(Parameter.NEW_NAME)) {
			String newName = (String) parameters.get(Parameter.NEW_NAME);
			user.setName(newName);
		}
		if(parameters.containsKey(Parameter.NEW_SURNAME)) {
			String newSurname = (String) parameters.get(Parameter.NEW_SURNAME);
			user.setSurname(newSurname);
		}
		if(parameters.containsKey(Parameter.NEW_EMAIL)) {
			String newEmail = (String) parameters.get(Parameter.NEW_EMAIL);
			user.setEmail(newEmail);
		}
		
		if(parameters.containsKey(Parameter.NEW_ROLES)) {
			List<String> newRoles = (List<String>) parameters.get(Parameter.NEW_ROLES);
			user.setRoles(newRoles);
		}
		if(parameters.containsKey(Parameter.NEW_PHONES)) {
			List<String> newPhones = (List<String>) parameters.get(Parameter.NEW_PHONES);
			user.setPhones(newPhones);
		}
		userDao.saveUser(user);
		return resManager.getValue(MessageParameter.EDIT_USER_EDITED_SUCCESSFULLY);
	}

}
