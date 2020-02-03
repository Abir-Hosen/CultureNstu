package com.zero.culturenstu.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zero.culturebackend.dao.CategoryDao;
import com.zero.culturebackend.dao.CoverImgDao;
import com.zero.culturebackend.dao.ProfileImgDao;
import com.zero.culturebackend.dao.RegDetailsDao;
import com.zero.culturebackend.dao.RegPostDao;
import com.zero.culturebackend.dao.RegStatusDao;
import com.zero.culturebackend.dao.RegisteredDao;
import com.zero.culturebackend.dto.Registered;
import com.zero.culturebackend.dto.Registered_category;
import com.zero.culturebackend.dto.Registered_cover_img;
import com.zero.culturebackend.dto.Registered_details;
import com.zero.culturebackend.dto.Registered_post;
import com.zero.culturebackend.dto.Registered_profile_img;
import com.zero.culturebackend.dto.Registered_status;

@Controller
@RequestMapping("/admin")
public class ManagementController {

	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	RegisteredDao reggisteredDao;
	
	@Autowired
	CoverImgDao coverImgDao;
	
	@Autowired
	RegDetailsDao regDetailsDao;
	
	@Autowired
	RegPostDao regPostDao;
	
	@Autowired
	ProfileImgDao profileImgDao;
	
	@Autowired
	RegStatusDao regStatusDao;
	
	
	@RequestMapping("/panel")
	public ModelAndView panel() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminPanel", true);
		
		return mv;
	}
	@RequestMapping(value= {"/panel/category"}, method=RequestMethod.GET)
	public ModelAndView category(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminPanelCategory", true);
		mv.addObject("title", "Category");

		mv.addObject("categories", categoryDao.categoryList());
		
		Registered_category registered_category = new Registered_category();
		mv.addObject("category", registered_category);
		
		if(operation != null) {
			if(operation.equals("cat")) {
				mv.addObject("message", "Category added successfully!");
			}
		}
		
		return mv;
	}

	@RequestMapping(value= {"/panel/{id}/{name}/category"}, method=RequestMethod.GET)
	public ModelAndView editcategory(@PathVariable("id") int catId, @PathVariable("name") String catName) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminPanelCategory", true);
		mv.addObject("title", "Category");

		mv.addObject("categories", categoryDao.categoryList());
		mv.addObject("category", categoryDao.getById(catId));
		
		
		return mv;
	}
	
	@RequestMapping(value={"/panel/category"}, method=RequestMethod.POST)
	public String handleCategorySubmission(@Valid @ModelAttribute("category") Registered_category reg_category, BindingResult result, 
			Model model, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			model.addAttribute("userClickAdminPanelCategory", true);
			model.addAttribute("title", "Category");
			model.addAttribute("categories", categoryDao.categoryList());
			return "page";
		}
		
		if(reg_category.getId()==0) {
			categoryDao.addCategory(reg_category);
		}else {
			categoryDao.updateCategory(reg_category);
		}
		
		return "redirect:/admin/panel/category?operation=cat";
	}
	

	@RequestMapping(value= {"/panel/registered"},  method=RequestMethod.GET)
	public ModelAndView registered(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditRegistered", true);
		mv.addObject("title", "Registered");

		mv.addObject("registered", reggisteredDao.registeredList());
		/*
		Registered_category registered_category = new Registered_category();
		mv.addObject("category", registered_category);
		*/
		if(operation != null) {
			if(operation.equals("delete")) {
				mv.addObject("message", "Registered deleted successfully!");
			}
		}
		
		return mv;
	}
	

	@RequestMapping(value= {"/panel/{id}/{name}/registered"}, method=RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("id") int regId, @PathVariable("name") String regName) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditRegistered", true);
		mv.addObject("title", "Registered");

		mv.addObject("registered", reggisteredDao.registeredList());
		
		Registered registered = reggisteredDao.getById(regId);
		Registered_cover_img registered_cover_img = coverImgDao.getByRegId(regId);
		Registered_profile_img registered_profile_img = profileImgDao.getByRegId(regId);
		Registered_details registered_details = regDetailsDao.getByRegId(regId);
		List<Registered_post> registered_posts = regPostDao.regPostList(regId);
		Registered_status registered_status = regStatusDao.getById(regId);
		
		for(int i=0; i<registered_posts.size(); i++) {
			Registered_post regPost = registered_posts.get(i);
			regPostDao.deleteRegPost(regPost);
		}
		regStatusDao.deleteRegStatus(registered_status);
		regDetailsDao.deleteRegDetails(registered_details);
		coverImgDao.deleteCoverImg(registered_cover_img);
		profileImgDao.deleteProfileImg(registered_profile_img);
		reggisteredDao.deleteRegistered(registered);
		

		mv.addObject("registered", reggisteredDao.registeredList());
		
		return mv;
	}

	@RequestMapping(value= {"/panel/{id}/{name}/make/admin/registered"}, method=RequestMethod.GET)
	public ModelAndView makeAdmin(@PathVariable("id") int regId, @PathVariable("name") String regName) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditRegistered", true);
		mv.addObject("title", "Registered");

		mv.addObject("registered", reggisteredDao.registeredList());
		
		Registered registered = reggisteredDao.getById(regId);
		registered.setRole("Admin");
		reggisteredDao.updateRegistered(registered);
		

		mv.addObject("registered", reggisteredDao.registeredList());
		
		return mv;
	}
	

	@RequestMapping(value= {"/panel/{id}/{name}/make/member/registered"}, method=RequestMethod.GET)
	public ModelAndView makeMember(@PathVariable("id") int regId, @PathVariable("name") String regName) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditRegistered", true);
		mv.addObject("title", "Registered");

		mv.addObject("registered", reggisteredDao.registeredList());
		
		Registered registered = reggisteredDao.getById(regId);
		registered.setRole("Registered");
		reggisteredDao.updateRegistered(registered);
		

		mv.addObject("registered", reggisteredDao.registeredList());
		
		return mv;
	}

	@RequestMapping(value= {"/panel/{id}/{name}/make/active/registered"}, method=RequestMethod.GET)
	public ModelAndView activeMember(@PathVariable("id") int regId, @PathVariable("name") String regName) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditRegistered", true);
		mv.addObject("title", "Registered");

		mv.addObject("registered", reggisteredDao.registeredList());
		
		Registered registered = reggisteredDao.getById(regId);
		registered.setEnabled(true);
		reggisteredDao.updateRegistered(registered);
		

		mv.addObject("registered", reggisteredDao.registeredList());
		
		return mv;
	}

	@RequestMapping(value= {"/panel/{id}/{name}/make/deactive/registered"}, method=RequestMethod.GET)
	public ModelAndView deactiveMember(@PathVariable("id") int regId, @PathVariable("name") String regName) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditRegistered", true);
		mv.addObject("title", "Registered");

		mv.addObject("registered", reggisteredDao.registeredList());
		
		Registered registered = reggisteredDao.getById(regId);
		registered.setEnabled(false);
		reggisteredDao.updateRegistered(registered);
		

		mv.addObject("registered", reggisteredDao.registeredList());
		
		return mv;
	}
}
