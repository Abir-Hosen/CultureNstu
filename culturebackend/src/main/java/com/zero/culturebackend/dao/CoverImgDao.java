package com.zero.culturebackend.dao;

import com.zero.culturebackend.dto.Registered_cover_img;

public interface CoverImgDao {

	boolean addCoverImg(Registered_cover_img registered_cover_img);
	Registered_cover_img getByRegId(int regId);
	boolean updateCoverImg(Registered_cover_img registered_cover_img);
	boolean deleteCoverImg(Registered_cover_img registered_cover_img);
}
