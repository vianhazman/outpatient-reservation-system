package com.apap.tugasakhir.controller;

import com.apap.tugasakhir.model.ObatModel;
import com.apap.tugasakhir.model.PasienModel;
import com.apap.tugasakhir.model.PenangananModel;
import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.ObatService;
import com.apap.tugasakhir.model.DokterModel;
import com.apap.tugasakhir.model.PenangananModel;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.PenangananService;
import com.apap.tugasakhir.service.RujukanRawatJalanService;

import java.sql.Date;
import java.sql.Time;
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

@Controller
@RequestMapping("/rawat-jalan")
public class PenangananController {
	@Autowired
	webService web;
	
	@Autowired
	private PenangananService penangananService;
	
	@Autowired
	private ObatService obatService;
	
	@Autowired
	private RujukanRawatJalanService rujukanService;
	
	@RequestMapping(value = "/pasien/penanganan/", method = RequestMethod.GET)
	public String lihatPenanganan(Model model, @RequestParam Long idPasienRawatJalan) {
		System.out.println("test!");
		PasienModel pasienRawatJalan = web.getPasien(idPasienRawatJalan);
		
		
		List<PenangananModel> daftarPenanganan = penangananService.getAllPenanganan(idPasienRawatJalan);
		
		List<ObatModel> daftarObatAvailable = obatService.getAllObatAvailable();
		
		model.addAttribute("idPasien", idPasienRawatJalan);
		model.addAttribute("pasien", pasienRawatJalan);
		model.addAttribute("daftarPenanganan", daftarPenanganan);
		model.addAttribute("daftarObat", daftarObatAvailable);
		
		return "lihat-penanganan";
	}
	
	@RequestMapping(value = "/pasien/penanganan/tambah", method = RequestMethod.POST)
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