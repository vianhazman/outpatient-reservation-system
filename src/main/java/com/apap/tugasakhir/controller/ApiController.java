package com.apap.tugasakhir.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tugasakhir.model.DokterModel;
import com.apap.tugasakhir.repository.JadwalPoliDB;
import com.apap.tugasakhir.rest.Setting;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.wrapper.GetDokterWrapper;

@RestController
@RequestMapping("/rawat-jalan")
public class ApiController {
	
	@Autowired
	JadwalPoliDB poliDb;
	
	@Autowired
	webService web;
	

		
	@GetMapping(value= "/poli/jadwal/dokter-available")
	public List<DokterModel> availableDoctor(@RequestParam("date") String date) {
	List<DokterModel> allDokter = web.getAllDokter();
	Date tanggal = java.sql.Date.valueOf(date);
	ArrayList<DokterModel> availableDokter = new ArrayList<DokterModel>();
		for (DokterModel a:allDokter) {
			if (poliDb.findByTanggalAndDokter(tanggal, a.getId())==null) {
				availableDokter.add(a);
			}
		}
		return availableDokter;
	}
	
	
}
