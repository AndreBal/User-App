package com.innowise.userapp.dao;

public class DAOException extends Exception{
	
	private static final long serialVersionUID = -2053338600349652490L;

	public DAOException(String message, Exception e) {
		super(message , e);
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Exception e) {
		super(e);
	}
	
	public DAOException() {
		super();
	}

}
