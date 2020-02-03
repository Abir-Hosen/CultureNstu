package com.zero.culturebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zero.culturebackend.dao.RegPostDao;
import com.zero.culturebackend.dto.Registered;
import com.zero.culturebackend.dto.Registered_post;

@Repository("regPostDao")
@Transactional
public class RegPostDaoImpl implements RegPostDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addRegPost(Registered_post registered_post) {
		try {
			sessionFactory.getCurrentSession().persist(registered_post);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Creation error of registered");
			return false;
		}
	}

	public List<Registered_post> postList() {
		return sessionFactory.getCurrentSession()
				.createQuery("From Registered_post R ORDER By R.id DESC", Registered_post.class).getResultList();
	}

	public List<Registered_post> regPostList(int regId) {
		String selectQuery = "FROM Registered_post R WHERE regId = :regId ORDER By R.id DESC ";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Registered_post.class)
					.setParameter("regId", regId).getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateRegPost(Registered_post registered_post) {
		try {
			sessionFactory.getCurrentSession().update(registered_post);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Updating error of registered");
			return false;
		}
	}

	public boolean deleteRegPost(Registered_post registered_post) {
		try {
			sessionFactory.getCurrentSession().delete(registered_post);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error of registered");
			return false;
		}
	}

	public Registered_post getById(int id) {
		try {
			return sessionFactory.getCurrentSession()
					.get(Registered_post.class, Integer.valueOf(id));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
