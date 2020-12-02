package com.innowise.userapp.view.input.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.innowise.userapp.controller.command.Parameter;
import com.innowise.userapp.resourcemanager.MessageParameter;
import com.innowise.userapp.resourcemanager.ResourceManager;
import com.innowise.userapp.view.validator.Validator;

public class InputMethods {
	private static ResourceManager resManager = ResourceManager.getInstance();

	public static String inputName(Scanner scanner) {
		System.out.println(resManager.getValue(MessageParameter.USER_ENTER_NAME));
		String name = scanner.nextLine();
		return name;
	}

	public static String inputSurname(Scanner scanner) {
		System.out.println(resManager.getValue(MessageParameter.USER_ENTER_SURNAME));
		String surname = scanner.nextLine();
		return surname;
	}

	public static String inputEmail(Scanner scanner) {
		System.out.println(resManager.getValue(MessageParameter.USER_ENTER_EMAIL));
		String email = scanner.nextLine();
		while (!Validator.validateValue(Parameter.EMAIL, email)) {
			System.out.println(resManager.getValue(MessageParameter.USER_REENTER_EMAIL));
			email = scanner.nextLine();
		}
		return email;
	}

	public static List<String> inputRoles(Scanner scanner) {
		System.out.println(resManager.getValue(MessageParameter.USER_ENTER_ROLES));
		String rolesString = scanner.nextLine();
		while (!Validator.validateAmmount(Parameter.ROLES, rolesString)) {
			System.out.println(resManager.getValue(MessageParameter.USER_ROLES_WRONG_AMMOUNT));
			rolesString = scanner.nextLine();
		}
		String[] rolesArray = rolesString.split(",");
		List<String> rolesList = Arrays.asList(rolesArray);
		return rolesList;
	}

	public static List<String> inputPhones(Scanner scanner) {
		System.out.println(resManager.getValue(MessageParameter.USER_ENTER_PHONES));
		String phonesString = scanner.nextLine();
		while (!Validator.validateAmmount(Parameter.PHONES, phonesString)) {
			System.out.println(resManager.getValue(MessageParameter.USER_PHONES_WRONG_AMMOUNT));
			phonesString = scanner.nextLine();
		}
		String[] phonesArray = phonesString.split(",");
		boolean allPhonesAreValid = true;
		do {
			if (!allPhonesAreValid) {
				System.out.println(resManager.getValue(MessageParameter.USER_WRONG_PHONE_FORMAT));
				phonesArray = scanner.nextLine().split(",");
			}
			for (String phoneString : phonesArray) {
				if (!Validator.validateValue(Parameter.PHONES, phoneString)) {
					allPhonesAreValid = false;
					break;
				}
				allPhonesAreValid = true;
			}
		} while (!allPhonesAreValid);
		List<String> phonesList = Arrays.asList(phonesArray);
		return phonesList;
	}
}
