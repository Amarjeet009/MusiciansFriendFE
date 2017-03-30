/**
 * 
 */
package com.amarj.musiciansfriend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amarj.musiciansfriend.dao.SupplierDAO;
import com.amarj.musiciansfriend.model.Supplier;

/**
 * @author amarj
 *
 */
@Controller
public class SupplierController {

	// add category, delete category, update category, edit category, showCategoryList
	public static Logger log = LoggerFactory.getLogger(SupplierController.class);
			@Autowired
			private SupplierDAO supplierDAO;
			
			@Autowired
			private Supplier supplier;
			
			@PostMapping("/manage_supplier_create")
			public ModelAndView createCategory(@RequestParam("id")String id, 
					@RequestParam("name")String name, @RequestParam("address")String address)
			{
				supplier.setId(id);
				supplier.setName(name);
				supplier.setAddress(address);
				
				ModelAndView mv = new ModelAndView("Redirect:/manage_supplier");
				
				if (supplierDAO.saveOrUpdate(supplier)) {
					log.debug("Successfully Created All Supplier");
					mv.addObject("msg", "Successfully Created All Supplier");
				} else {
					log.debug("Not able to create");
					mv.addObject("msg", "Not able to create, please contact Administrator");
				}
				return mv;
			}
}
