package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.loginCredentials.AdminLogin;
import com.example.demo.menu.MenuCatalog;

@Controller
public class HomeController 
{
	@Autowired
	private MenuCatalog menuCatalog;
	@GetMapping(value = {"/home", "/"})
	public String home()
	{
		return "Home";
	}

	@GetMapping("/products")
	public String products( Model model)
	{ 
		model.addAttribute("menuSections", menuCatalog.getSections());
		return "Products";
	}

	@GetMapping("/location")
	public String location()
	{
		return "redirect:/reviews";
	}

	@GetMapping("/about")
	public String about()
	{
		return "About";
	}

	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("adminLogin",new AdminLogin());
		return "Login";
	}
}
