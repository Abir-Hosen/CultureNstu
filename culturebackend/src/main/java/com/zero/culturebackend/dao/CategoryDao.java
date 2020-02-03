package com.zero.culturebackend.dao;

import java.util.List;

import com.zero.culturebackend.dto.Registered_category;

public interface CategoryDao {
	
	boolean addCategory(Registered_category registered_category);
	Registered_category getById(int catId);
	List<Registered_category> categoryList();
	boolean updateCategory(Registered_category registered_category);
	boolean deleteCategory(Registered_category registered_category);

}
