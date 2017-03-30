package com.amarj.musiciansfriend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amarj.musiciansfriend.dao.CategoryDAO;
import com.amarj.musiciansfriend.model.Category;

@Controller
public class CategoryController {
	public static Logger log = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@PostMapping("/manage_category_create")
	public ModelAndView createCategory(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("description")String description)
	{
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		
		ModelAndView mv = new ModelAndView("Redirect:/manage_categories");
		
		if (categoryDAO.save(category)) {
			log.debug(" All category created successfully ");
			mv.addObject("msg", "Successfully Created All Category");
		} else {
			log.debug("Not able to create category");
			mv.addObject("msg", "Not able to create, please contact Administrator");
		}
		return mv;
	}

}
