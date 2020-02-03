package com.zero.culturebackend.dao;

import java.util.List;

import com.zero.culturebackend.dto.Registered_post;

public interface RegPostDao {
	
	boolean addRegPost(Registered_post registered_post);
	Registered_post getById(int id);
	List<Registered_post> postList();
	List<Registered_post> regPostList(int regId);
	boolean updateRegPost(Registered_post registered_post);
	boolean deleteRegPost(Registered_post registered_post);
}
