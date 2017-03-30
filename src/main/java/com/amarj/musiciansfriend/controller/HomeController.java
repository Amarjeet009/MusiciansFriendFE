
package com.amarj.musiciansfriend.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amarj.musiciansfriend.dao.UserDAO;
import com.amarj.musiciansfriend.model.User;

/**
 * @author amarj
 *
 */

@Controller
public class HomeController {
	public static Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/")
	 public ModelAndView showHomePage()
	 {
		System.out.println("Starting the method showHomePage");
		//Specifying which page you have navigation
		ModelAndView mv = new ModelAndView("/Home");
		
		//Specify what data you have to carry to home page
		
		mv.addObject("msg", "WELCOME TO SHOPPING CART");
		
		return mv;
	 }
	
	@RequestMapping("/login")
	public ModelAndView showLoginPage()
	{
		System.out.println("Clicked on Login link");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedLogin","true");
		
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegistrationPage()
	{
		System.out.println("Clicked on Registraion link");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedRegister","true");
		return mv;
	}
	
	
	@RequestMapping("/validate")
	public ModelAndView validateCredentials(@RequestParam("userID") String id, 
			@RequestParam("password") String pwd)
	{
		//Actually you have get the data from DB
		//Tempororily  -user->niit password =niit@123 // id and pwd is getting from db
		
		ModelAndView mv = new ModelAndView("/Menu/home");
		
		mv.addObject("isUserLoggedIn", "false");
		
		//if(id.equals("niit")  && pwd.equals("niit@123")){
		if( userDAO.validate(id, pwd)==true)
		
		{
		    user = userDAO.getUser(id);
			
			if(user.getRole().equals("ROLE_ADMIN"))
			{   log.debug("if User is Admin");
				mv.addObject("isAdmin", true);
                
			}
			else
			{   
				log.debug("if user is customer");
				mv.addObject("isAdmin", false);
				
			}  
			log.debug("Valid Credentials");
			mv.addObject("successMessage", "Valid Credentials");
			session.setAttribute("loginMessage", "Welcome :" +id);
		}
		else
		{   
			log.debug("InValid Credentials...please try again");
			mv.addObject("errorMessage", "InValid Credentials...please try again");
		}
		
		return mv;
		
	}
	
	@RequestMapping("/contact")
	public ModelAndView showContactPage()
	{
		System.out.println("Clicked on Contact link");
		ModelAndView mv = new ModelAndView("/Menu/home");
		mv.addObject("isUserClickedContact","true");
		
		log.debug("User clicked on link to contact");
		return mv;
	}
	
	@RequestMapping("/aboutUs")
	public ModelAndView showAboutUsPage()
	{
		System.out.println("Clicked on About Us link");
		ModelAndView mv = new ModelAndView("/Menu/home");
		mv.addObject("isUserClickedAboutUs","true");
		
		log.debug("User click on aboutUs");
		return mv;
	}
	
	@RequestMapping("/admin")
	public ModelAndView showAdminPage()
	{
		System.out.println("Clicked on Admin link");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isAdmin","true");
		
		log.debug("User click on admin links");
		return mv;
	}
	
   @RequestMapping("/logout")
	public ModelAndView logout()
	{
		ModelAndView mv =new ModelAndView("/Menu/home");
		//session.invalidate();
		session.removeAttribute("loginMessage");
		return mv;
		
	}
	
	
	
	
	
}
