package com.zero.culturebackend.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zero.culturebackend.dao.CoverImgDao;
import com.zero.culturebackend.dto.Registered_cover_img;

@Repository("coverImgDao")
@Transactional
public class CoverImgDaoImpl implements CoverImgDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addCoverImg(Registered_cover_img registered_cover_img) {
		try {
			sessionFactory.getCurrentSession().persist(registered_cover_img);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Creation error of registered");
			return false;
		}
	}

	public boolean updateCoverImg(Registered_cover_img registered_cover_img) {
		try {
			sessionFactory.getCurrentSession().update(registered_cover_img);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Updating error of registered");
			return false;
		}
	}

	public Registered_cover_img getByRegId(int regId) {
		String selectQuery = "FROM Registered_cover_img WHERE reg_id = :regId";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Registered_cover_img.class)
					.setParameter("regId", regId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteCoverImg(Registered_cover_img registered_cover_img) {
		try {
			sessionFactory.getCurrentSession().delete(registered_cover_img);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error of registered details");
			return false;
		}
	}

}
