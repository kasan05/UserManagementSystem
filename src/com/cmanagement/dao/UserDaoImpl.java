package com.cmanagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmanagement.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getUser(int id) {
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

		Session session = null;
		Transaction transaction = null;
		User user = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User where name = :name");
			query.setParameter("name", name);
			List<User> list = query.list();
			session.close();
			if (list != null) {
				System.out.println("==========" + list.get(0).getName().toString() + "========");
				user = (User) list.get(0);
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Session session = null;
		Transaction transaction = null;
		List<User> list = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User u");
			list = query.list();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return list;
	}

}
