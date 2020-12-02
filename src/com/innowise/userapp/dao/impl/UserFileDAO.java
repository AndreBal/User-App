package com.innowise.userapp.dao.impl;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.innowise.userapp.bean.User;
import com.innowise.userapp.dao.DAOException;
import com.innowise.userapp.dao.UserDAO;

public class UserFileDAO implements UserDAO {

	private static final Logger log = LogManager.getLogger(UserFileDAO.class);

	private final static String PATH_TO_USERS_FILE = ".\\data\\users";

	@Override
	public void saveUser(User user) throws DAOException {
		List<User> users = getAllUsers();
		users.add(user);
		saveNewUserList(users);
	}

	@Override
	public User getUserByEmail(String email) throws DAOException {

		List<User> users = getAllUsers();

		for (User u : users) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public boolean deleteUserByEmail(String email) throws DAOException {
		List<User> users = getAllUsers();
		int index = -1;
		for (User u : users) {
			if (u.getEmail().equals(email)) {
				index = users.indexOf(u);
			}
		}
		if (index == -1) {
			return false;
		} else {
			users.remove(index);
			saveNewUserList(users);
			return true;
		}
	}

	private void saveNewUserList(List<User> users) throws DAOException {
		try (FileOutputStream streamOut = new FileOutputStream(PATH_TO_USERS_FILE);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(streamOut);) {
			objectOutputStream.writeObject(users);
			objectOutputStream.flush();
		} catch (FileNotFoundException e) {
			log.error("Users file not found");
			throw new DAOException(e);
		} catch (IOException e) {
			log.error("IOException");
			throw new DAOException(e);
		}
	}

	@Override
	public List<User> getAllUsers() throws DAOException {
		List<User> users = new ArrayList<>();
		try (FileInputStream streamIn = new FileInputStream(PATH_TO_USERS_FILE);
				ObjectInputStream objectInputStream = new ObjectInputStream(streamIn);) {
			users = (List<User>) objectInputStream.readObject();
		} catch (EOFException e) {
			System.out.println("File is empty");
			return new ArrayList<>();
		} catch (FileNotFoundException e) {
			log.error("Users file not found");
			throw new DAOException(e);
		} catch (IOException e) {
			log.error("IOException");
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			log.error("ClassNotFoundException during readObject()");
			throw new DAOException(e);
		}
		return users;
	}

}
