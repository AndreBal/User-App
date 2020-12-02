package com.innowise.userapp.view.validator;

import java.util.regex.Pattern;

import com.innowise.userapp.controller.command.Parameter;

public class Validator {

	private final static String EMAIL_REGEX = "^(.+)@(.+)\\.(.+)$";
	private final static String PHONES_REGEX = "^(375)\\d{2}\\ \\d{7}$";
	private final static int ROLES_MIN = 1;
	private final static int ROLES_MAX = 3;
	private final static int PHONES_MIN = 1;
	private final static int PHONES_MAX = 3;

	public static boolean validateValue(String param, String value) {
		if (value == null || value.isEmpty()) {
			return false;
		}
		String regex;
		switch (param) {
		case (Parameter.EMAIL):
			regex = EMAIL_REGEX;
			break;
		case (Parameter.PHONES):
			regex = PHONES_REGEX;
			break;
		default:
			return false;
		}

		if (Pattern.matches(regex, value)) {
			return true;
		}
		return false;
	}

	public static boolean validateAmmount(String param, String value) {
		if (value == null || value.isEmpty()) {
			return false;
		}
		String[] valuesArray = value.split(",");
		int valuesAmmount = valuesArray.length;
		switch (param) {
		case (Parameter.ROLES):
			return (valuesAmmount >= ROLES_MIN && valuesAmmount <= ROLES_MAX);
		case (Parameter.PHONES):
			return (valuesAmmount >= PHONES_MIN && valuesAmmount <= PHONES_MAX);
		default:
			return false;
		}
	}

}
