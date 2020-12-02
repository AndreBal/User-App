package com.innowise.userapp.controller.command;

import java.util.HashMap;
import java.util.Map;

import com.innowise.userapp.controller.command.impl.AddUserCommand;
import com.innowise.userapp.controller.command.impl.DeleteUserCommand;
import com.innowise.userapp.controller.command.impl.EditUserCommand;
import com.innowise.userapp.controller.command.impl.HelpCommand;
import com.innowise.userapp.controller.command.impl.PrintAllUsersCommand;
import com.innowise.userapp.controller.command.impl.PrintUserCommand;

public class CommandProvider {
	
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider(){
	commands.put(CommandName.ADD_USER, new AddUserCommand());
	commands.put(CommandName.DELETE_USER, new DeleteUserCommand());
	commands.put(CommandName.PRINT_USER, new PrintUserCommand());
	commands.put(CommandName.PRINT_ALL_USERS, new PrintAllUsersCommand());
	commands.put(CommandName.HELP, new HelpCommand());
	commands.put(CommandName.EDIT_USER, new EditUserCommand());
	}
	
	
	public Command getCommand(String name) {
		CommandName commandName;
		commandName = CommandName.valueOf(name.toUpperCase());
		return commands.get(commandName);
	}
}
