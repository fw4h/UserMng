package com.user.mng.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.mng.pojo.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	String tableClass = "User";

	public User getUserByUsernameAndPassword(String username, String password) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session
					.createQuery("from " + tableClass + " where username = :param1 and password = :param2");
			query.setParameter("param1", username);
			query.setParameter("param2", password);

			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public User getUserById(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			User user = session.get(User.class, id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public void deleteUserById(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			User user = session.get(User.class, id);
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateUser(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void createUser(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<User> selectAll() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from " + tableClass);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
}
