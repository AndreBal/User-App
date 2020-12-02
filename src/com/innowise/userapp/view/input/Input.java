package com.innowise.userapp.view.input;

import java.util.Map;
import java.util.Scanner;

import com.innowise.userapp.resourcemanager.ResourceManager;

public abstract interface Input {

	public abstract Map<String, Object> enter(Scanner scanner);

}
