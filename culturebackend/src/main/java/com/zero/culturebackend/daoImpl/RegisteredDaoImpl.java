package com.zero.culturebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zero.culturebackend.dao.RegisteredDao;
import com.zero.culturebackend.dto.Registered;

@Repository("registeredDao")
@Transactional
public class RegisteredDaoImpl implements RegisteredDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addRegistered(Registered registered) {
		try {
			sessionFactory.getCurrentSession().persist(registered);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Creation error of registered");
			return false;
		}
	}

	public Registered getById(int regId) {
		try {
			return sessionFactory.getCurrentSession()
					.get(Registered.class, Integer.valueOf(regId));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Registered getByEmail(String regEmail) {
		String selectQuery = "FROM Registered WHERE email = :email";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Registered.class)
					.setParameter("email", regEmail).getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Registered> registeredList() {
		return sessionFactory.getCurrentSession()
				.createQuery("From Registered", Registered.class).getResultList();
	}

	public boolean updateRegistered(Registered registered) {
		try {
			sessionFactory.getCurrentSession().update(registered);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Updating error of registered");
			return false;
		}
	}

	public boolean deleteRegistered(Registered registered) {
		try {
			sessionFactory.getCurrentSession().delete(registered);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error of registered");
			return false;
		}
	}

}
