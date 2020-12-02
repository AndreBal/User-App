package com.innowise.userapp.view.input;

import java.util.Map;
import java.util.Scanner;

public class ParameterInput {

	private final InputProvider inputProvider = new InputProvider();

	public Map<String, Object> inputParameters(Scanner scanner, String command) {

		Input input = inputProvider.getInput(command);
		if (input != null) {
			Map<String, Object> parameters = input.enter(scanner);
			return parameters;
		}
		return null;
	}

}
