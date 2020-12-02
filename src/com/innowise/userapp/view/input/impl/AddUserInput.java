package com.innowise.userapp.view.input.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.innowise.userapp.controller.command.Parameter;
import com.innowise.userapp.view.input.Input;

public class AddUserInput implements Input {

	@Override
	public Map<String, Object> enter(Scanner scanner) {
		Map<String, Object> parameters = new HashMap<>();

		parameters.put(Parameter.NAME, InputMethods.inputName(scanner));
		parameters.put(Parameter.SURNAME, InputMethods.inputSurname(scanner));
		parameters.put(Parameter.EMAIL, InputMethods.inputEmail(scanner));
		parameters.put(Parameter.ROLES, InputMethods.inputRoles(scanner));
		parameters.put(Parameter.PHONES, InputMethods.inputPhones(scanner));

		return parameters;
	}

}
