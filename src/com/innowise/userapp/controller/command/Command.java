package com.innowise.userapp.controller.command;

import java.util.Map;

import com.innowise.userapp.dao.DAOException;

public interface Command {
	String execute(Map<String,Object> parameters) throws DAOException;

}
