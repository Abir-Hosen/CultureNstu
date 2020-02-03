package com.zero.culturenstu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.zero.culturebackend.dao.CategoryDao;
import com.zero.culturebackend.dao.RegDetailsDao;
import com.zero.culturebackend.dao.RegPostDao;
import com.zero.culturebackend.dao.RegisteredDao;
import com.zero.culturebackend.dto.Registered;
import com.zero.culturebackend.dto.Registered_category;
import com.zero.culturebackend.dto.Registered_details;
import com.zero.culturebackend.dto.Registered_post;
import com.zero.culturenstu.model.RegisteredModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;

	@Autowired
	private RegisteredDao registeredDao;

	@Autowired
	private RegDetailsDao regDetailsDao;

	@Autowired
	private RegPostDao regPostDao;
	
	@Autowired
	private CategoryDao categoryDao;

	private RegisteredModel registeredModel = new RegisteredModel();

	@ModelAttribute("registeredModel")
	public RegisteredModel RegModel() {

		if (session.getAttribute("registeredModel") == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			Registered registered = registeredDao.getByEmail(authentication.getName());
			if (registered != null) {
				int regId = registered.getId();
				int catId= registered.getCategory();
				
				Registered_category category = categoryDao.getById(catId);
				Registered_details registered_details = regDetailsDao.getByRegId(regId);

				registeredModel.setId(registered.getId());
				registeredModel.setFullname(registered.getName());
				registeredModel.setEmail(registered.getEmail());
				registeredModel.setRoll(registered.getRole());
				registeredModel.setSlogan(registered_details.getSlogan());
				registeredModel.setAim(registered_details.getAim());
				registeredModel.setAbout(registered_details.getAbout());
				registeredModel.setAdress(registered_details.getAddress());
				registeredModel.setHall(registered_details.getHall_room());
				registeredModel.setSession(registered_details.getSession());
				registeredModel.setDepartment(registered.getDepartment());
				registeredModel.setRollId(registered_details.getRoll());
				registeredModel.setGraduate(registered_details.getGraduation_program());
				registeredModel.setCatName(category.getName());
				registeredModel.setDob(registered.getDob());
				registeredModel.setGender(registered.getGender());
				registeredModel.setBlood_group(registered.getBlood_group());

				session.setAttribute("registeredModel", registeredModel);
			}

		}

		return (RegisteredModel) session.getAttribute("registeredModel");
	}

	@ModelAttribute("registeredlist")
	public List<Registered> getRegistered() {
		return registeredDao.registeredList();
	}

	@ModelAttribute("allpost")
	public List<Registered_post> allPost() {
		return regPostDao.postList();
	}

}
