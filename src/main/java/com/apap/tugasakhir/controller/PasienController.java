package com.apap.tugasakhir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tugasakhir.model.PasienModel;
import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import com.apap.tugasakhir.repository.RujukanRawatJalanDb;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.JadwalService;
import com.apap.tugasakhir.service.RujukanRawatJalanService;


@Controller
public class PasienController {
	@Autowired
	webService web;
	
	@Autowired
	RujukanRawatJalanDb rujukanDb;
	
	@Autowired
	private RujukanRawatJalanService rujukanService;
	
	@Autowired
	private JadwalService jadwalService;
	
	@RequestMapping(value = "/rawat-jalan/pasien", method = RequestMethod.GET)
	private String viewPasienRawatJalan(Model model) {
		List<PasienModel> draftPasien = web.getAllPasienRawatJalan();
		for (PasienModel pasien : draftPasien) {
			if (rujukanDb.findByidPasienAndTanggalRujuk(pasien.getId(), pasien.getTanggalRujukan()) == null) {
				RujukanRawatJalanModel newRujukan = new RujukanRawatJalanModel();
				newRujukan.setPasien(pasien.getId());
				newRujukan.setNama(pasien.getNama());
				newRujukan.setTanggalRujuk(pasien.getTanggalRujukan());
				newRujukan.setStatus(1);
				System.out.println(pasien.getPoliRujukan().getId()+ " " + pasien.getPoliRujukan());
				newRujukan.setJadwalPoli(jadwalService.getJadwalById(pasien.getPoliRujukan().getId()));
				rujukanDb.save(newRujukan);
			}
		}
		model.addAttribute("listRujukan",rujukanService.listRujukan());
		return "view-pasien";
	}
	
	@RequestMapping(value = "/rawat-jalan/pasien/{idRujukan}", method=RequestMethod.GET)
	private String detailPasienRawatJalan(@PathVariable (value="idRujukan") long id, Model model) {
		String[]listStatus = new String[] {"Mendaftar di IGD","Berada di IGD", "Selesai di IGD","Mendaftar di Rawat Inap","Berada di Rawat Inap",
				"Selesai di Rawat Inap","Mendaftar di Rawat Jalan","Berada di Rawat Jalan","Selesai di Rawat Jalan"};
		model.addAttribute("rujukan",rujukanService.getRujukanById(id));
		model.addAttribute("status",listStatus);
		System.out.println(rujukanService.getRujukanById(id));
		return "view-detail-pasien";
	}
}