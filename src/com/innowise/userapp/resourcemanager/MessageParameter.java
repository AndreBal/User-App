package com.innowise.userapp.resourcemanager;

public class MessageParameter {
	public static final String START = "start";
	public static final String FINISH = "finish";
	public static final String NEXT_COMMAND = "next";
	public static final String HELP = "help";
	public static final String WRONG_COMMAND = "wrongCommand";
	
	public static final String USER_ENTER_NAME = "user.enterName";
	public static final String USER_ENTER_SURNAME = "user.enterSurname";
	public static final String USER_ENTER_EMAIL = "user.enterEmail";
	public static final String USER_REENTER_EMAIL = "user.reenterEmail";
	public static final String USER_ENTER_ROLES = "user.enterRoles";
	public static final String USER_ROLES_WRONG_AMMOUNT = "user.rolesWrongAmount";
	public static final String USER_ENTER_PHONES = "user.enterPhones";
	public static final String USER_PHONES_WRONG_AMMOUNT = "user.phonesWrongAmount";
	public static final String USER_WRONG_PHONE_FORMAT = "user.phonesWrongFormat";
	
	public static final String EDIT_USER_START = "editUser.start";
	public static final String EDIT_USER_CHOOSE_PARAMETER = "editUser.chooseParameter";
	public static final String EDIT_USER_WRONG_PARAMETER = "editUser.wrongParameter";
	public static final String EDIT_USER_EDITED_SUCCESSFULLY = "editUser.editedSuccessfully";
	
	public static final String USER_NOT_FOUND = "user.notFound";
	
	public static final String ADD_USER_ADDED_SUCCESSFULLY = "addUser.addedSuccessfully";
	
	public static final String DELETE_USER_DELETED_SUCCESSFULLY = "deleteUser.deletedSuccessfully";
	public static final String DELETE_USER_USER_DOESNT_EXIST = "deleteUser.userDoesntExist";
	
	private MessageParameter() {}

}
