
package com.amarj.musiciansfriend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amarj.musiciansfriend.dao.CategoryDAO;
import com.amarj.musiciansfriend.dao.ProductDAO;
import com.amarj.musiciansfriend.dao.SupplierDAO;
import com.amarj.musiciansfriend.model.Category;
import com.amarj.musiciansfriend.model.Product;
import com.amarj.musiciansfriend.model.Supplier;

/**
 * @author amarj
 *
 */
@Controller
public class AdminController {

	
	/*@RequestMapping("/manage_products")
	public ModelAndView manageProducts()
	{
		System.out.println("manageProducts");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedProducts", "true");
		
		//get the categories from db.
		
		return mv;
		
	}
	
	@RequestMapping("/manage_suppliers")
	public ModelAndView manageSupplier()
	{
		System.out.println("manageSupplier");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedSuppliers", "true");
		
		//get the categories from db.
		
		return mv;
		
	}*/
	
	public static Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private Category category;
	
	@Autowired
	private CategoryDAO categoryDAO; 
	
	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	
	@RequestMapping("/manage_categories")
	public ModelAndView manageCategories()
	{
		System.out.println("manageCategories");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedCategories", "true");
		
		//get the categories from db.
		
		List<Category> categoryList= categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		mv.addObject("category", category); 
		
		return mv;
		
	}
	
	@RequestMapping("/manage_products")
	public ModelAndView manageProducts()
	{
		System.out.println("manageProducts");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedProducts", "true");
		
		//get the products from db.
		
		List<Product> productList = productDAO.list();
		mv.addObject("productList", productList);
		mv.addObject("product", product);
		
		return mv;
		
	}
	
	@RequestMapping("/manage_suppliers")
	public ModelAndView manageSupplier()
	{
		System.out.println("manageSupplier");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedSuppliers", "true");
		
		//get the suppliers from db.
		
		List<Supplier> supplierList = supplierDAO.list();
		mv.addObject("supplierList", supplierList);
		mv.addObject("supplier", supplier);
		
		return mv;
		
	}
}
