package com.cmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmanagement.model.User;
import com.cmanagement.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String test() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap map) {
		return "login";
	}

	@RequestMapping("/failure")
	public String failure() {
		return "failure";
	}

	@RequestMapping("/home")
	public String hello(ModelMap map) {
		try {
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			if (user != null) {
				map.addAttribute("user", user.getUsername());
			}
		} catch (Exception e) {
			return "login";
		}
		return "home";
	}

	@RequestMapping("/list")
	public String listUsers(ModelMap map) {
		map.addAttribute("listusers", userService.getAllUsers());
		return "listusers";

	}

	@RequestMapping("/personaldetails")
	public String personalDetails(ModelMap map) {
		User dbUser = null;
		try {
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			if (user != null) {
				dbUser = userService.getUserByName(user.getUsername());
				map.addAttribute("dbUser", dbUser);
			}
		} catch (Exception e) {
			return "login";
		}

		return "personaldetails";

	}

	@RequestMapping("/appLogout")
	public String appLogout(HttpServletResponse response, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "login";
	}
}
