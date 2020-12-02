package com.innowise.userapp.view.input.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.innowise.userapp.controller.command.Parameter;
import com.innowise.userapp.view.input.Input;

public class DeleteUserInput implements Input {

	@Override
	public Map<String, Object> enter(Scanner scanner) {
		Map<String, Object> parameters = new HashMap<>();

		
		parameters.put(Parameter.EMAIL, InputMethods.inputEmail(scanner));
	

		return parameters;
	}

}
