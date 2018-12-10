package com.apap.tugasakhir.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apap.tugasakhir.model.DokterModel;
import com.apap.tugasakhir.model.JadwalPoliModel;
import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.JadwalService;
import com.apap.tugasakhir.service.RujukanRawatJalanService;

@RestController
@RequestMapping("/rawat-jalan")
public class ApiController {
	
	@Autowired
	JadwalService jadwal;
	
	@Autowired
	RujukanRawatJalanService rujukan;
	
	@Autowired
	webService web;
		
	@GetMapping(value= "/poli/jadwal/dokter-available")
	public List<DokterModel> availableDoctor(@RequestParam("date") String date) {
	List<DokterModel> allDokter = web.getAllDokter();
	Date tanggal = java.sql.Date.valueOf(date);
	ArrayList<DokterModel> availableDokter = new ArrayList<DokterModel>();
		for (DokterModel a:allDokter) {
			if (jadwal.getByTanggalAndDokter(tanggal, a.getId())==null) {
				availableDokter.add(a);
			}
		}
		return availableDokter;
	}
	@GetMapping(value= "/poli/pasien/total-pasien")
	public Map<String,Integer> totalPasien() {
	Map<String,Integer> json = new HashMap<String,Integer>();
	json.put("total", web.getAllPasien().size());
	json.put("inRawatJalan", web.getAllPasienRawatJalan().size());
	return json;
	}
	
	@GetMapping(value= "/poli/jadwal/kapasitas-poli")
	public Map<String,Integer> poliCapacity() {
	Map<String,Integer> json = new HashMap<String,Integer>();
	for (JadwalPoliModel obj:jadwal.findAll()) {
		String nama = obj.getPoli().getNama();
		if (json.containsKey(nama)) {
			json.put(nama, json.get(nama)+1);
		}
		else {
			json.put(nama, 1);
		}
	}
	return json;
	}
	
	@GetMapping(value= "/poli/pasien/rujukan-by-status")
	public Map<String,Integer> rujukanStatus() {
		Map<String,Integer> json = new HashMap<String,Integer>();
		String[] statusStr = {"Mendaftar di Rawat Jalan","Berada di Rawat Jalan", "Selesai di Rawat Jalan"};
		for (RujukanRawatJalanModel obj : rujukan.getAllRujukan()) {
			String status = statusStr[obj.getStatus()];
			if (json.containsKey(status)) {
				json.put(status, json.get(status)+1);
			}
			else {
				json.put(status, 1);
			}
		}
		return json;
	}
	
	@GetMapping(value= "/poli/pasien/nama-pasien-rujukan")
	public List<Map<String,String>> getNamaPasien() {
		List<Map<String,String>> json = new ArrayList<Map<String,String>>();
		for (RujukanRawatJalanModel obj : rujukan.getAllRujukan()) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("nama", obj.getNama());
			map.put("id", obj.getId()+"");
			json.add(map);
		}
		return json;
	}
}
