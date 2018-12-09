package com.apap.tugasakhir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/rawat-jalan/poli/tambah")
	public String addPoli () {
		return "add-poli";
	}
}
