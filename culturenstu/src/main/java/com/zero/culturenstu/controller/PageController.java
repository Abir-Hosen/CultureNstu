package com.zero.culturenstu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
import com.zero.culturenstu.util.FileUploadUtility;

@Controller
public class PageController {

	@Autowired
	RegisteredDao registeredDao;

	@Autowired
	RegDetailsDao regDetailsDao;

	@Autowired
	RegStatusDao regStatusDao;

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	RegPostDao regPostDao;
	
	@Autowired
	CoverImgDao coverImgDao;
	
	@Autowired
	ProfileImgDao profileImgDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@ModelAttribute("categories")
	public List<Registered_category> getCategories() {
		return categoryDao.categoryList();
	}

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		Registered_post registered_post = new Registered_post();
		mv.addObject("statusPost", registered_post);
		
		mv.addObject("userClickHome", true);
		return mv;
	}
	

	@RequestMapping(value = { "/viewpost/{id}/{title}" })
	public ModelAndView viewPost( @PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Post");

		Registered_post registered_post = regPostDao.getById(id);
		mv.addObject("post", registered_post);
		
		mv.addObject("userClickViewPost", true);
		return mv;
	}
	
	@RequestMapping(value = {"/delete/{id}/regId/{regId}"})
	public String deletePost(@PathVariable("id") int id, @PathVariable("regId") int regId) {
		
		
		Registered_post registered_post = regPostDao.getById(id);
		regPostDao.deleteRegPost(registered_post);

		return "redirect:/profile/id/"+regId+"?operation=delete";
	}

	@RequestMapping(value = { "/profile/id/{id}" },  method = RequestMethod.GET)
	public ModelAndView profile( @PathVariable("id") int regId, @RequestParam(name = "operation", required = false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickProfile", true);
		mv.addObject("title", "Profile");
		
		
		mv.addObject("regPosts", regPostDao.regPostList(regId));
		
		Registered_profile_img registered_profile_img = profileImgDao.getByRegId(regId);
		mv.addObject("profileimg", registered_profile_img);
		
		Registered_cover_img registered_cover_img = coverImgDao.getByRegId(regId);
		mv.addObject("coverimg", registered_cover_img);
		
		Registered_post registered_post = new Registered_post();
		mv.addObject("statusPost", registered_post);

		mv.addObject("regDet", regDetailsDao.getByRegId(regId));
		
		if (operation != null) {
			if (operation.equals("success")) {
				mv.addObject("message", "Post Uploaded!");
			}
			if (operation.equals("failed")) {
				mv.addObject("message", "Write your post!");
			}
			if (operation.equals("imagefailed")) {
				mv.addObject("message", "upload your image!");
			}
			if (operation.equals("delete")) {
				mv.addObject("message", "Post deleted!");
			}
		}

		return mv;
	}
	
	@RequestMapping(value= {"/profile/id/{id}"}, method=RequestMethod.POST)
	public String handlePostUpload(@Valid @ModelAttribute("statusPost") Registered_post regPost,  @PathVariable("id") int regId,
			BindingResult result, Model model, HttpServletRequest request) {

		
		if(!regPost.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, regPost.getFile(), regPost.getImgUrl());
		}else {
			
			return "redirect:/profile/id/"+regId+"?operation=imagefailed";
		}
		
		
		if(regPost.getId()==0) {
			if(regPost.getStatus().equals("") || regPost.getStatusTitle().equals("")) {
				return "redirect:/profile/id/"+regId+"?operation=failed";
			}else {
				regPostDao.addRegPost(regPost);
			}
		}else {
			regPostDao.updateRegPost(regPost);
		}
		
		
		return "redirect:/profile/id/"+regId+"?operation=success";
	}
	
	@RequestMapping(value= {"/change/cover/profile/id/{id}"}, method=RequestMethod.POST)
	public String handleCoverUpload(@Valid @ModelAttribute("coverimg") Registered_cover_img regCovImg,  @PathVariable("id") int regId,
			BindingResult result, Model model, HttpServletRequest request) {

		
		if(!regCovImg.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, regCovImg.getFile(), regCovImg.getImgCoverUrl());
		}else {
			return "redirect:/profile/id/"+regId+"?operation=imageCovfailed";
		}
		
		coverImgDao.updateCoverImg(regCovImg);
		
		return "redirect:/profile/id/"+regId+"?operation=Covsuccess";
	}
	

	
	@RequestMapping(value= {"/change/profpic/profile/id/{id}"}, method=RequestMethod.POST)
	public String handleProfPicUpload(@Valid @ModelAttribute("profileimg") Registered_profile_img regProfImg,  @PathVariable("id") int regId,
			BindingResult result, Model model, HttpServletRequest request) {

		
		if(!regProfImg.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, regProfImg.getFile(), regProfImg.getImgProfUrl());
		}else {
			return "redirect:/profile/id/"+regId+"?operation=imageProffailed";
		}
		
		profileImgDao.updateProfileImg(regProfImg);
		
		return "redirect:/profile/id/"+regId+"?operation=Profsuccess";
	}
	
	
	@RequestMapping(value = { "/profile/{id}/visit"})
	public ModelAndView profileVisit(@PathVariable("id") int regId) {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("registered", registeredDao.getById(regId));
		mv.addObject("regDetails", regDetailsDao.getByRegId(regId));
		mv.addObject("cover", coverImgDao.getByRegId(regId));
		mv.addObject("profileimg", profileImgDao.getByRegId(regId));
		mv.addObject("postreg", regPostDao.regPostList(regId));
		mv.addObject("category", categoryDao.getById(registeredDao.getById(regId).getCategory()).getName());
		
		mv.addObject("title", "Profile");
		mv.addObject("userClickVisitProfile", true);

		return mv;
	}

	// 333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333

	@RequestMapping(value = { "/{name}/edit/{id}/about" }, method = RequestMethod.GET)
	public ModelAndView editAboutProfile(@PathVariable("name") String name, @PathVariable("id") int regId,
			@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Edit About");
		mv.addObject("userClickEditAboutProfile", true);

		mv.addObject("about", regDetailsDao.getByRegId(regId));

		if (operation != null) {
			if (operation.equals("success")) {
				mv.addObject("message", "Register details successfully added!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = {"/edit/{id}/regId/{regId}"}, method = RequestMethod.GET)
	public ModelAndView editPost(@PathVariable("id") int id, @PathVariable("regId") int regId,
			@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickEditPost", true);
		mv.addObject("title", "Edit Post");
		
		mv.addObject("regPosts", regPostDao.regPostList(regId));
		
		Registered_profile_img registered_profile_img = profileImgDao.getByRegId(regId);
		mv.addObject("profileimg", registered_profile_img);
		
		Registered_cover_img registered_cover_img = coverImgDao.getByRegId(regId);
		mv.addObject("coverimg", registered_cover_img);
		
		
		mv.addObject("statusPost", regPostDao.getById(id));

		if (operation != null) {
			if (operation.equals("success")) {
				mv.addObject("message", "Post successfully edited!");
			}
		}
		return mv;
	}

	@RequestMapping(value = { "/edit/{id}/regId/{regId}" }, method = RequestMethod.POST)
	public String handleEditPost(@PathVariable("id") int id, @PathVariable("regId") int regId,
			@Valid @ModelAttribute("statusPost") Registered_post registered_post,
			BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAttribute("userClickEditPost", true);
			model.addAttribute("title", "Edit Post");
			return "page";
		}
		if (registered_post.getId()==0) {
			return "page";
		} else {
			regPostDao.updateRegPost(registered_post);
		}

		return "redirect:/edit/"+id+"/regId/"+regId+"?operation=success";
	}

	@RequestMapping(value = { "/{name}/edit/{id}/about" }, method = RequestMethod.POST)
	public String handleEditAbout(@PathVariable("name") String name, @PathVariable("id") int regId, 
			@Valid @ModelAttribute("about") Registered_details registered_details,
			BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAttribute("userClickEditAboutProfile", true);
			model.addAttribute("title", "Edit About");
/*			model.addAttribute("allAbout", regDetailsDao.regDetailsList());*/
			return "page";
		}
		if (registered_details.getReg_id() == 0) {
			return "page";
		} else {
			regDetailsDao.updateRegDetails(registered_details);
		}

		return "redirect:/"+name+"/edit/"+regId+"/about?operation=success";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public ModelAndView registration(@RequestParam(name = "success", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickregistration", true);

		Registered registered = new Registered();
		mv.addObject("register", registered);

		if (operation != null) {
			if (operation.equals("!not")) {
				mv.addObject("message", "Register successfully added for varification!");
			}

			if (operation.equals("mismatchedPassword")) {
				mv.addObject("message", "Password doesn't matched with confirm password!!");
			}
		}
		return mv;
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String habdleRegistrationSubmission(@Valid @ModelAttribute("register") Registered registered,
			BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAttribute("userClickregistration", true);
			model.addAttribute("title", "Registration");
			return "page";
		}
		if(registered.getPassword().equals(registered.getConfirmPassword())) {

			if (registered.getId() == 0) {
				// encode
				registered.setPassword(passwordEncoder.encode(registered.getPassword()));

				registeredDao.addRegistered(registered);
				
				Registered_details registered_details = new Registered_details();
				Registered_status registered_status = new Registered_status();
				Registered_post registered_post = new Registered_post();
				Registered_profile_img registered_profile_img = new Registered_profile_img();
				Registered_cover_img registered_cover_img = new Registered_cover_img();
				
				registered_details.setReg_id(registered.getId());
				registered_status.setReg_id(registered.getId());
				registered_post.setRegId(registered.getId());
				
				registered_post.setDate(new Date());
				registered_post.setStatusTitle("New Registration "+registered.getName()+"!");
				registered_post.setStatus("Welcome to <b>NSTU CULTURAL CLUB</b>.<br>"
						+ "<h3>Congratulations for being a part of our club. </h3>Our whole team welcomes a new member like you. "
						+ "We are looking forward for the club's success with you. Welcome aboard.");
				registered_post.setImgUrl("welcome");
				
				registered_profile_img.setReg_id(registered.getId());
				registered_cover_img.setReg_id(registered.getId());
				
				regDetailsDao.addRegDetails(registered_details);
				regStatusDao.addRegStatus(registered_status);
				regPostDao.addRegPost(registered_post);
				profileImgDao.addProfileImg(registered_profile_img);
				coverImgDao.addCoverImg(registered_cover_img);

			}
		}else {
			return "redirect:/registration?success=mismatchedPassword";
		}


		return "redirect:/registration?success=!not";
	}

	@RequestMapping(value= {"/login"})
	public ModelAndView login(@RequestParam(name="error", required=false)String error,
			@RequestParam(name="logout", required=false)String logout, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("login");

		if(error!=null) {
			mv.addObject("message", "Invalid Username & Password!");
		}
		if(logout!=null) {
			mv.addObject("logout", "User has successfully loggedout!");
		}
		mv.addObject("title", "Login");
		
		return mv;
	}
	
	
	@RequestMapping(value= {"/perform-logout"})
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	
}
