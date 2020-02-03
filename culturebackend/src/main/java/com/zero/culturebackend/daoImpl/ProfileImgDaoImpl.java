package com.zero.culturebackend.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zero.culturebackend.dao.ProfileImgDao;
import com.zero.culturebackend.dto.Registered_profile_img;

@Repository("profileImgDao")
@Transactional
public class ProfileImgDaoImpl implements ProfileImgDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addProfileImg(Registered_profile_img registered_profile_img) {
		try {
			sessionFactory.getCurrentSession().persist(registered_profile_img);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Creation error of registered");
			return false;
		}
	}

	public boolean updateProfileImg(Registered_profile_img registered_profile_img) {
		try {
			sessionFactory.getCurrentSession().update(registered_profile_img);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Updating error of registered");
			return false;
		}
	}

	public Registered_profile_img getByRegId(int regId) {
		String selectQuery = "FROM Registered_profile_img WHERE reg_id = :regId";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Registered_profile_img.class)
					.setParameter("regId", regId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteProfileImg(Registered_profile_img registered_profile_img) {
		try {
			sessionFactory.getCurrentSession().delete(registered_profile_img);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error of registered details");
			return false;
		}
	}

}
