package com.apap.tugasakhir.controller;

import com.apap.tugasakhir.model.DokterModel;
import com.apap.tugasakhir.model.PenangananModel;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.PenangananService;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;
import com.apap.tugasakhir.rest.Setting;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.wrapper.GetPasienWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apap.tugasakhir.model.PasienModel;

@RestController
@RequestMapping("/rawat-jalan")
public class PenangananController {
	@Autowired
	private PenangananService penangananService;
	
	@Autowired
	webService web;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	@GetMapping(value = "/pasien/penanganan")
	public String lihatPenanganan(Model model, @RequestParam("id_pasien_rawat_jalan") Long idPasienRawatJalan) throws Exception {
		PasienModel pasien = web.getPasien(idPasienRawatJalan);
		String path = "http://si-appointment.herokuapp.com/api/getPasien/" + idPasienRawatJalan;
		List<PenangananModel> penanganan = penangananService.getAllPenanganan(idPasienRawatJalan);
		model.addAttribute("penanganan", penanganan);
		model.addAttribute("pasien", pasien);
		return "lihat-penanganan";
	}
	
	@RequestMapping(value="/admin/rawat-jalan/pasien/penanganan/tambah/obat", method = RequestMethod.POST)
	private String tambahPenangananObat(@ModelAttribute PenangananModel penanganan, Model model) {
		
		
		return "lihat-penanganan";
	}
	
	@RequestMapping(value="/admin/rawat-jalan/pasien/penanganan/tambah/lab", method = RequestMethod.POST)
	private String tambahPenangananLab(@ModelAttribute PenangananModel penanganan, Model model) {
		
		
		return "lihat-penanganan";
	}
}