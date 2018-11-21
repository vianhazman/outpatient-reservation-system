package com.apap.tugasakhir.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tugasakhir.model.UserRoleModel;
import com.apap.tugasakhir.repository.UserRoleDB;
import com.apap.tugasakhir.service.UserRoleService;


@Controller
@RequestMapping("/user")
public class UserRoleController {
	@Autowired	private UserRoleService userService;


	@RequestMapping( value = "/addUser", method = RequestMethod.POST)
	private String addUserSubmit(@ModelAttribute UserRoleModel user, Model model) {
			System.out.println(user.getUsername());
			userService.addUser(user);
			model.addAttribute("msg", user);
		return "login";
	}
	
	public boolean validatePassword(String password) {
		if (password.length()>=8 && Pattern.compile("[0-9]").matcher(password).find() &&  Pattern.compile("[a-zA-Z]").matcher(password).find())  {
			return true;
		}
		else {
			return false;
		}
	}
	

	
}
