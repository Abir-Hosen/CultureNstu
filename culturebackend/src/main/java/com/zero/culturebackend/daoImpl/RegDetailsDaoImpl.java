package com.zero.culturebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zero.culturebackend.dao.RegDetailsDao;
import com.zero.culturebackend.dto.Registered_details;

@Repository("regDetailsDao")
@Transactional
public class RegDetailsDaoImpl implements RegDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addRegDetails(Registered_details registered_details) {
		try {
			sessionFactory.getCurrentSession().persist(registered_details);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Creation error of registered details");
			return false;
		}
	}

	public Registered_details getByRegId(int regId) {
		String selectQuery = "FROM Registered_details WHERE reg_id = :regId";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Registered_details.class)
					.setParameter("regId", regId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Registered_details> regDetailsList() {
		return sessionFactory.getCurrentSession().createQuery("From Registered_details", Registered_details.class)
				.getResultList();
	}

	public boolean updateRegDetails(Registered_details registered_details) {
		try {
			sessionFactory.getCurrentSession().update(registered_details);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Updating error of registered details");
			return false;
		}
	}

	public boolean deleteRegDetails(Registered_details registered_details) {
		try {
			sessionFactory.getCurrentSession().delete(registered_details);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error of registered details");
			return false;
		}
	}

}
