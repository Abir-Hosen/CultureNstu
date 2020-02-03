package com.zero.culturebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zero.culturebackend.dao.RegStatusDao;
import com.zero.culturebackend.dto.Registered_details;
import com.zero.culturebackend.dto.Registered_status;

@Repository("regStatusDao")
@Transactional
public class RegStatusDaoImpl implements RegStatusDao {


	@Autowired
	private SessionFactory sessionFactory;

	public boolean addRegStatus(Registered_status registered_status) {
		try {
			sessionFactory.getCurrentSession().persist(registered_status);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Creation error of registered");
			return false;
		}
	}

	public Registered_status getById(int regId) {
		String selectQuery = "FROM Registered_status WHERE reg_id = :regId";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Registered_status.class)
					.setParameter("regId", regId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Registered_status> registeredList() {
		return sessionFactory.getCurrentSession()
				.createQuery("From Registered_status", Registered_status.class).getResultList();
	}

	public boolean updateRegStatus(Registered_status registered_status) {
		try {
			sessionFactory.getCurrentSession().update(registered_status);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Updating error of registered");
			return false;
		}
	}

	public boolean deleteRegStatus(Registered_status registered_status) {
		try {
			sessionFactory.getCurrentSession().delete(registered_status);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error of registered");
			return false;
		}
	}

}
