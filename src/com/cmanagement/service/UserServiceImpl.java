package com.cmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmanagement.dao.UserDao;
import com.cmanagement.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean removeUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User updateUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
