package com.apap.tugasakhir.controller;

import com.apap.tugasakhir.model.ObatModel;
import com.apap.tugasakhir.model.PasienModel;
import com.apap.tugasakhir.model.PenangananModel;
import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.ObatService;
import com.apap.tugasakhir.service.PenangananService;
import com.apap.tugasakhir.service.RujukanRawatJalanService;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PenangananController {
	@Autowired
	webService web;
	
	@Autowired
	private PenangananService penangananService;
	
	@Autowired
	private ObatService obatService;
	
	@Autowired
	private RujukanRawatJalanService rujukanService;
	
	@RequestMapping(value = "/rawat-jalan/pasien/penanganan", method = RequestMethod.GET)
	public String lihatPenanganan(Model model, @RequestParam("id_pasien_rawat_jalan") Long idPasienRawatJalan) {
		
		List<PasienModel> daftarPasien = web.getAllPasienRawatJalan();
		PasienModel pasienRawatJalan = daftarPasien.get(0);
		for(PasienModel pasien: daftarPasien) {
			if(pasien.getId() == idPasienRawatJalan) {
				pasienRawatJalan = pasien;
			}
		}
		
		List<PenangananModel> daftarPenanganan = penangananService.getAllPenanganan(idPasienRawatJalan);
		
		List<ObatModel> daftarObatAvailable = obatService.getAllObatAvailable();
		
		model.addAttribute("idPasien", idPasienRawatJalan);
		model.addAttribute("pasien", pasienRawatJalan);
		model.addAttribute("daftarPenanganan", daftarPenanganan);
		model.addAttribute("daftarObat", daftarObatAvailable);
		
		return "lihat-penanganan";
	}
	
	@RequestMapping(value = "/rawat-jalan/pasien/penanganan/tambah", method = RequestMethod.POST)
	public String tambahPenanganan(Model model,@ModelAttribute PenangananModel penanganan, @RequestParam("jenis_penanganan") String jenisPenanganan, @RequestParam("id_pasien_rawat_jalan") Long idPasienRawatJalan) {
		
		if(jenisPenanganan.equals("obat")) {
			RujukanRawatJalanModel rujukan = rujukanService.getRujukanByIdPasien(idPasienRawatJalan);
			penanganan.setRujukanRawatJalan(rujukan);
			penangananService.addPenanganan(penanganan);
		} else if(jenisPenanganan.equals("lab")) {
			RujukanRawatJalanModel rujukan = rujukanService.getRujukanByIdPasien(idPasienRawatJalan);
			penanganan.setRujukanRawatJalan(rujukan);
			penangananService.addPenanganan(penanganan);
		}
		
		return "lihat-penanganan";
	}
}