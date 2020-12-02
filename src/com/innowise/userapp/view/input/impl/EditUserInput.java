package com.innowise.userapp.view.input.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.innowise.userapp.controller.command.Parameter;
import com.innowise.userapp.resourcemanager.MessageParameter;
import com.innowise.userapp.resourcemanager.ResourceManager;
import com.innowise.userapp.view.input.Input;

public class EditUserInput implements Input {

	private ResourceManager resManager = ResourceManager.getInstance();
	private final static String CONFIRM = "confirm";

	@Override
	public Map<String, Object> enter(Scanner scanner) {
		Map<String, Object> parameters = new HashMap<>();
		System.out.println(resManager.getValue(MessageParameter.EDIT_USER_START));
		parameters.put(Parameter.EMAIL, InputMethods.inputEmail(scanner));
		String command;
		do {
			System.out.println(resManager.getValue(MessageParameter.EDIT_USER_CHOOSE_PARAMETER));
			command = scanner.nextLine().toLowerCase();
			switch (command) {
			case (CONFIRM):
				break;
			case (Parameter.NAME):
				parameters.put(Parameter.NEW_NAME, InputMethods.inputName(scanner));
				break;
			case (Parameter.SURNAME):
				parameters.put(Parameter.NEW_SURNAME, InputMethods.inputSurname(scanner));
				break;
			case (Parameter.EMAIL):
				parameters.put(Parameter.NEW_EMAIL, InputMethods.inputEmail(scanner));
				break;
			case (Parameter.ROLES):
				parameters.put(Parameter.NEW_ROLES, InputMethods.inputRoles(scanner));
				break;
			case (Parameter.PHONES):
				parameters.put(Parameter.NEW_PHONES, InputMethods.inputPhones(scanner));
				break;
			default:
				System.out.println(resManager.getValue(MessageParameter.EDIT_USER_WRONG_PARAMETER));
				break;
			}
		} while (!command.equals(CONFIRM));
		return parameters;
	}

}
