package com.apap.tugasakhir.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {
	
	@RequestMapping("/admin")
	public String admin () {
		return "admin";
	}
    
    @RequestMapping("/staff")
    public String user() {
    	return "staff";
    }
    
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/")
	public ModelAndView redirect(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return new ModelAndView("redirect:/admin");
		}
		return new ModelAndView("redirect:/staff");
	}
}
