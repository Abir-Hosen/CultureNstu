package com.zero.culturebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zero.culturebackend.dao.CategoryDao;
import com.zero.culturebackend.dto.Registered_category;

@Repository("categoryDao")
@Transactional
public  class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addCategory(Registered_category registered_category) {
		try {
			sessionFactory.getCurrentSession().persist(registered_category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Creation error of category");
			return false;
		}
	}

	public Registered_category getById(int catId) {
		try {
			return sessionFactory.getCurrentSession()
					.get(Registered_category.class, Integer.valueOf(catId));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Registered_category> categoryList() {
		return sessionFactory.getCurrentSession()
				.createQuery("From Registered_category", Registered_category.class).getResultList();
	}

	public boolean updateCategory(Registered_category registered_category) {
		try {
			sessionFactory.getCurrentSession().update(registered_category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Updating error of category");
			return false;
		}
	}

	public boolean deleteCategory(Registered_category registered_category) {
		try {
			sessionFactory.getCurrentSession().delete(registered_category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error of category");
			return false;
		}
	}
}
