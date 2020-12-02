package com.innowise.userapp.controller.command.impl;

import java.util.Map;

import com.innowise.userapp.controller.command.Command;
import com.innowise.userapp.controller.command.CommandName;
import com.innowise.userapp.dao.DAOException;

public class HelpCommand implements Command{

	@Override
	public String execute(Map<String, Object> parameters) throws DAOException {
		StringBuilder commandNameStringBuilder = new StringBuilder();
		for(CommandName command: CommandName.values()) {
			commandNameStringBuilder.append(command.toString().toLowerCase()).append("\n");
		}
		return commandNameStringBuilder.toString();
	}

}
