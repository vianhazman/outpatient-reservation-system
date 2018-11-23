package com.apap.tugasakhir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tugasakhir.rest.webService;

@Controller
public class PasienController {
	@Autowired
	webService web;
	
	@RequestMapping(value = "/rawat-jalan/pasien", method = RequestMethod.GET)
	private String viewPasienRawatJalan(Model model) {
		model.addAttribute("listPasien",web.getAllPasienRawatJalan());
		return "view-pasien";
	}
}
