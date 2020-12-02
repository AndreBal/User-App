package com.innowise.userapp.controller;

import java.util.Map;

import com.innowise.userapp.controller.command.Command;
import com.innowise.userapp.controller.command.CommandProvider;
import com.innowise.userapp.dao.DAOException;

public class Controller {
	
	private final CommandProvider provider = new CommandProvider();
	
	public String doCommand(String commandName, Map<String,Object> parameters) {
		Command command = provider.getCommand(commandName);
		String result;
		try {
			result = command.execute(parameters);
		} catch (DAOException e) {
			return "Command execution failed. Contact your service provider";
		}
		return result;
	}

}
