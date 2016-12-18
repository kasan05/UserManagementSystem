package com.cmanagement.service;

import java.util.List;

import com.cmanagement.model.User;

public interface UserService {

	public User getUser(int id);

	public User getUserByName(String name);

	public List<User> getAllUsers();

	public void insertUser(User user);

	public boolean removeUser(int id);

	public User updateUser(int id);
}
