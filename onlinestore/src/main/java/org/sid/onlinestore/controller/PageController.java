package org.sid.onlinestore.controller;

import org.sid.dao.CategoryDao;
import org.sid.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring mvc");
		mv.addObject("userClickHome", true);
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDao.list());
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAbout", true);
		mv.addObject("title", "About Us");
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickContact", true);
		mv.addObject("title", "Contact Us");
		return mv;
	}

	@RequestMapping(value = { "/test" })
	public ModelAndView test(@RequestParam("greeting") String greeting) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}

	@RequestMapping(value = { "/test/{greeting}" })
	public ModelAndView test2(@PathVariable("greeting") String ggreeting) {
		if (ggreeting == null) {
			ggreeting = "hello there";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", ggreeting);
		return mv;
	}

	// method to load all products based on a category

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDao.list());
		return mv;
	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		// cateogryDAO to fetch a single category
		Category category = categoryDao.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", category.getName());
		// passer la liste des categories
		mv.addObject("categories", categoryDao.list());
		// passer une seule categorie
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;
	}

}
