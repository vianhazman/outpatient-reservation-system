package com.apap.tugasakhir.controller;


import com.apap.tugasakhir.model.ObatModel;import com.apap.tugasakhir.model.PenangananModel;
import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import com.apap.tugasakhir.rest.Setting;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.ObatService;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


public class ObatController {
	
	@Autowired
	private ObatService obatService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	@GetMapping(value="/terima") 
	public String getObat(@PathVariable("id") Long id) throws Exception {
		String path = Setting.obatUrl;
		return restTemplate.getForEntity(path, String.class).getBody();
	}
	
	@GetMapping(value="/terima")
	public ObatDetail tambahObat(@PathVariable("id") String id) throws Exception {
		String path = Setting.obatUrl;
		ObatModel obat = obatService.getObat();
		ObatDetail detail = restTemplate.postForObject(path, obat, ObatDetail.class);
		return detail;
	}
	 
   
@Controller
public class ObatController {
	@Autowired
	webService web;
	
	@Autowired
	private ObatService obatService;
	
	@RequestMapping(value = "/rawat-jalan/obat/tambah", method = RequestMethod.POST)
	public String tambahObat(Model model, @ModelAttribute ObatModel obat) {
		ObatModel obatFarmasi = web.getObat();
		obatService.addObat(obat);
		return "";
	}

}
