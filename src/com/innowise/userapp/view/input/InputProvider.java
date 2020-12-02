package com.innowise.userapp.view.input;

import java.util.HashMap;
import java.util.Map;

import com.innowise.userapp.controller.command.CommandName;
import com.innowise.userapp.view.input.impl.AddUserInput;
import com.innowise.userapp.view.input.impl.DeleteUserInput;
import com.innowise.userapp.view.input.impl.EditUserInput;
import com.innowise.userapp.view.input.impl.PrintUserInput;

public class InputProvider {
	
private Map<CommandName, Input> inputs = new HashMap<>();
	
	public InputProvider(){
	inputs.put(CommandName.ADD_USER, new AddUserInput());
	inputs.put(CommandName.DELETE_USER, new DeleteUserInput());
	inputs.put(CommandName.PRINT_USER, new PrintUserInput());
	inputs.put(CommandName.EDIT_USER, new EditUserInput());
	}
	
	
	public Input getInput(String name) {
		CommandName commandName;
		commandName = CommandName.valueOf(name.toUpperCase());
		return inputs.get(commandName);
	}

}
