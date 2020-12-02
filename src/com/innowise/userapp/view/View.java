package com.innowise.userapp.view;

import java.util.Map;
import java.util.Scanner;

import com.innowise.userapp.controller.Controller;
import com.innowise.userapp.controller.command.CommandName;
import com.innowise.userapp.resourcemanager.MessageParameter;
import com.innowise.userapp.resourcemanager.ResourceManager;
import com.innowise.userapp.view.input.ParameterInput;

public class View {
	private ResourceManager resManager;
	private Scanner scanner;
	private final static String EXIT_COMMAND = CommandName.EXIT.toString();
	private Controller controller;
	private ParameterInput paramIn;

	public View() {
		resManager = ResourceManager.getInstance();
		controller = new Controller();
		paramIn = new ParameterInput();
	}

	public void start() {

		System.out.println(resManager.getValue(MessageParameter.START));
		scanner = new Scanner(System.in);
		String command = scanner.nextLine();

		while (!command.toUpperCase().equals(EXIT_COMMAND)) {
			try {
				CommandName.valueOf(command.toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println(resManager.getValue(MessageParameter.WRONG_COMMAND));
				command = scanner.nextLine();
				continue;
			}
			Map<String, Object> parameters = paramIn.inputParameters(scanner, command);
			
			System.out.println(controller.doCommand(command, parameters));

			System.out.println(resManager.getValue(MessageParameter.NEXT_COMMAND));
			command = scanner.nextLine();
		}

		scanner.close();
		System.out.println(resManager.getValue(MessageParameter.FINISH));
	}
}
