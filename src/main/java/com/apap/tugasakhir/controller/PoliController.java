package com.apap.tugasakhir.controller;

import java.util.Date;
/*Pada skema diatas, terdapat 7 macam tabel. Tabel POLI merepresentasikan poli yang
 terdapat pada Rumah Sakit. Tabel HARI_POLI merepresentasikan hari dimana poli terkait
 beroperasi. Tabel JADWAL_POLI merepresentasikan jadwal dokter jaga pada poli terkait


[3] Membuat poli
Initial Page: /rawat-jalan/poli/tambah
Form Request: POST, /rawat-jalan/poli/tambah
Response Page: /rawat-jalan/poli/tambah
Role: Admin Poli
Poin: 6

Pada fitur ini Anda diminta untuk membuat poli yang ada pada RSCS.. Data yang perlu di-input
dalam fitur ini adalah sebagai berikut
● nama
● deskripsi dari poli tersebut
Setelah proses ini selesai maka halaman akan menampilkan “Poli Berhasil Dibuat”.

[4] Melihat poli
Initial Page: -
Form Request: GET, /rawat-jalan/poli
Response Page: /rawat-jalan/poli
Role: Admin Poli, Staff Rawat Jalan
Poin: 5

Pada fitur ini Anda diminta untuk menampilkan informasi semua poli yang tersedia pada RSCS
termasuk hari dari poli tersebut.

[5] Mengubah poli
Initial Page: /rawat-jalan/poli/ubah
Form Request: POST, /rawat-jalan/poli/ubah
Response Page: /rawat-jalan/poli/ubah
Role: Admin Poli
Poin: 6

Pada fitur ini Anda diminta untuk dapat melakukan update suatu data pada poli termasuk nama
poli tersebut
*/ 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.JadwalService;
import com.apap.tugasakhir.service.PoliService;

@Controller
public class PoliController {

	@Autowired
	private PoliService poliService;

	@Autowired
	webService web;

	@Autowired
	private JadwalService jadwalService;

	@RequestMapping(value = "/rawat-jalan/poli/jadwal", method = RequestMethod.GET)
	private String viewJadwal(Model model, Authentication authentication) {
		List<JadwalPoliModel> listJadwal = jadwalService.findAll();
		String[] days;
		days = new String[] { "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" };
		List<DokterModel> listDokter = web.getAllDokter();
		String role = authentication.getAuthorities().toString();

		model.addAttribute("listJadwal", listJadwal);
		model.addAttribute("days", days);
		model.addAttribute("listDokter", listDokter);
		model.addAttribute("role", role);
		return "view-jadwal";
	}

	@RequestMapping(value = "/rawat-jalan/poli/jadwal/ubah/{id}", method = RequestMethod.GET)
	private String updateJadwal(@PathVariable(value = "id") String id, Model model) {
		JadwalPoliModel jadwal = jadwalService.getJadwalById(Long.parseLong(id));
		
        Date date1 = jadwal.getTanggal();
        Date date2 = new Date();
        
        // tanggal sudah lewat
        if (date1.compareTo(date2) < 0) return "update-jadwal-fail";
		
		model.addAttribute("jadwal", jadwal);
		model.addAttribute("newJadwal", new JadwalPoliModel());

		List<PoliModel> listPoli = poliService.findAll();
		List<DokterModel> listDokter = web.getAllDokter();

		model.addAttribute("listPoli", listPoli);
		model.addAttribute("listDokter", listDokter);
		return "update-jadwal";
	}

	@RequestMapping(value = "/rawat-jalan/poli/jadwal/ubah/{id}", method = RequestMethod.POST)
	private String updateJadwalSubmit(@ModelAttribute JadwalPoliModel newJadwal, @PathVariable(value = "id") String id,
			Model model) {
		jadwalService.update(Long.parseLong(id), newJadwal);
		model.addAttribute("id", id);
		return "update-jadwal-success";
	}

	@RequestMapping(value = "/rawat-jalan/poli/jadwal/tambah", method = RequestMethod.GET)
	private String addJadwal(Model model) {
		List<DokterModel> listDokter = web.getAllDokter();
		List<PoliModel> listPoli = poliService.findAll();
		model.addAttribute("listPoli", listPoli);
		model.addAttribute("listDokter", listDokter);
		model.addAttribute("jadwal", new JadwalPoliModel());
		return "tambah-jadwal";
	}

	@RequestMapping(value = "/rawat-jalan/poli/jadwal/tambah", method = RequestMethod.POST)
	private String addJadwalSubmit(@ModelAttribute JadwalPoliModel jadwal, Model model) {
		jadwalService.add(jadwal);

		return "tambah-jadwal-success";
		
	}
	
	//Fitur 3. Membuat Poli
	
		@RequestMapping(value = "/rawat-jalan/poli/tambah", method = RequestMethod.GET)
		private String add(Model model) {
			model.addAttribute("poli", new PoliModel());
			return "add-poli";
		}

		@RequestMapping(value = "/rawat-jalan/poli/tambah", method = RequestMethod.POST)
		private String addPoliSubmit(@ModelAttribute PoliModel poli) {
			poliService.add(poli);
			return "added";
		}
		
		//Fitur 4. Melihat Poli 
		@RequestMapping(value = "/rawat-jalan/poli", method = RequestMethod.GET)
		private String viewPoli(Model model) {
			List<PoliModel> listPoli = poliService.getAllPoli();

			model.addAttribute("listPoli", listPoli);
			model.addAttribute("title", "Lihat Semua Jabatan");
			return "viewall-poli";	
		}
		
		//Fitur 5. Mengubah Poli 
		@RequestMapping(value="/rawat-jalan/poli/ubah", method=RequestMethod.GET)
		private String updatePoli(@RequestParam("id") long id, Model model) {
			PoliModel poli = poliService.getDetailById(id);
			model.addAttribute("poli", poli);
			model.addAttribute("title", "Ubah Poli");
			return "update-poli";
		}
		
		@RequestMapping(value="/rawat-jalan/poli/ubah", method=RequestMethod.POST)
		private String updatePoliSubmit(@ModelAttribute PoliModel poli) {
			poli.setId(poli.getId());
			poliService.update(poli);
			return "update-poli-success";
		}

}
