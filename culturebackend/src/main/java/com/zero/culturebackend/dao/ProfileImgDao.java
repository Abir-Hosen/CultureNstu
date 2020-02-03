package com.zero.culturebackend.dao;

import com.zero.culturebackend.dto.Registered_profile_img;

public interface ProfileImgDao {

	boolean addProfileImg(Registered_profile_img registered_profile_img);
	Registered_profile_img getByRegId(int regId);
	boolean updateProfileImg(Registered_profile_img registered_profile_img);
	boolean deleteProfileImg(Registered_profile_img registered_profile_img);
}
