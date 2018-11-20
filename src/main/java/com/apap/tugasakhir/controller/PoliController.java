package com.apap.tugasakhir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugasakhir.model.JadwalPoliModel;
import com.apap.tugasakhir.service.JadwalService;
import com.apap.tugasakhir.service.PoliService;

@Controller
public class PoliController {
	
	@Autowired
	private PoliService poliService;
	
	@Autowired
	private JadwalService jadwalService;
	
	@RequestMapping(value = "/rawat-jalan/poli/jadwal", method = RequestMethod.GET)
    private String view(Model model) {
		List<JadwalPoliModel> listJadwal = jadwalService.findAll();
        model.addAttribute("listJadwal", listJadwal);
        return "view-jadwal";
    }

}
