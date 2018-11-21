package com.apap.tugasakhir.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugasakhir.model.DokterModel;
import com.apap.tugasakhir.model.JadwalPoliModel;
import com.apap.tugasakhir.model.PoliModel;
import com.apap.tugasakhir.service.DokterService;
import com.apap.tugasakhir.service.JadwalService;
import com.apap.tugasakhir.service.PoliService;

@Controller
public class PoliController {
	
	@Autowired
	private PoliService poliService;

	@Autowired
	private DokterService dokterService;
	
	@Autowired
	private JadwalService jadwalService;
	
	@RequestMapping(value = "/rawat-jalan/poli/jadwal", method = RequestMethod.GET)
    private String viewJadwal(Model model) {
		List<JadwalPoliModel> listJadwal = jadwalService.findAll();
        model.addAttribute("listJadwal", listJadwal);
        return "view-jadwal";
    }
	
	@RequestMapping(value = "/rawat-jalan/poli/jadwal/ubah/{id}", method = RequestMethod.GET)
	private String updateJadwal(@PathVariable(value = "id") String id, Model model) {
		JadwalPoliModel jadwal = jadwalService.getJadwalById(Long.parseLong(id));
		model.addAttribute("jadwal", jadwal);
		model.addAttribute("newJadwal", new JadwalPoliModel());
		
		List<PoliModel> listPoli = poliService.findAll();
		List<Long> poliIdList = new ArrayList<Long>();
		List<DokterModel> listDokter = dokterService.findAll();

		model.addAttribute("listPoli", listPoli);
		model.addAttribute("poliIdList", poliIdList);
		model.addAttribute("listDokter", listDokter);
		return "update-jadwal";
	}

	@RequestMapping(value = "/rawat-jalan/poli/jadwal/ubah/{id}", method = RequestMethod.POST)
	private String updateJadwalSubmit(@ModelAttribute JadwalPoliModel newJadwal, 
			@PathVariable(value = "id") String id, Model model) {
		jadwalService.update(Long.parseLong(id), newJadwal);
		model.addAttribute("id", id);
		return "update-jadwal-success";
	}

}
