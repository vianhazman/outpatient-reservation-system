package com.apap.tugasakhir.controller;

import com.apap.tugasakhir.model.PenangananModel;
import com.apap.tugasakhir.service.PenangananService;

import java.sql.Date;
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
	private PenangananService penangananService;
	
	@RequestMapping(value = "/admin/rawat-jalan/pasien/penanganan", method = RequestMethod.GET)
	public String lihatPenanganan(Model model, @RequestParam("id_pasien_rawat_jalan") Long idPasienRawatJalan) {
		List<PenangananModel> penanganan = penangananService.getAllPenanganan(idPasienRawatJalan);
		model.addAttribute("penanganan", penanganan);
		return "lihat-penanganan";
	}
	
	@RequestMapping(value="/admin/rawat-jalan/pasien/penanganan/tambah", method = RequestMethod.POST)
	private String tambahPenangananObat(@ModelAttribute PenangananModel penanganan, Model model) {
		
		
		return "lihat-penanganan";
	}
	
	@RequestMapping(value="/admin/rawat-jalan/pasien/penanganan/tambah", method = RequestMethod.POST)
	private String tambahPenangananLab(@ModelAttribute PenangananModel penanganan, Model model) {
		
		
		return "lihat-penanganan";
	}
	
	/**
	@RequestMapping(value="/pegawai/tambah", method = RequestMethod.POST)
	private String tambahPegawaiSubmit(@ModelAttribute PegawaiModel pegawai, @RequestParam("id_jabatan") Long id_jabatan, Model model) {
		String nipTahunMasuk = pegawaiService.getPegawaiTahunMasukSama(pegawai.getTahunMasuk());
		InstansiModel instansi = instansiService.getInstansiDetailById(pegawai.getInstansi().getId());
		
		String nipTanggalLahir = "";
		Date tanggalLahir = pegawai.getTanggalLahir();
		String[] tglLahir = (String.valueOf(tanggalLahir).split("-"));
		for(int i = 0; i < tglLahir.length; i++) {
			nipTanggalLahir = tglLahir[i].substring(tglLahir[i].length()-2, tglLahir[i].length()) + nipTanggalLahir;
		}
		
		pegawai.setNip("" + pegawai.getInstansi().getId() + nipTanggalLahir + pegawai.getTahunMasuk() + nipTahunMasuk); 
		pegawaiService.addPegawai(pegawai);
		
		JabatanPegawaiModel jabatanPegawai = new JabatanPegawaiModel();
		JabatanModel jabatan = jabatanService.getJabatanDetailById(id_jabatan);
		jabatanPegawai.setJabatan(jabatan);
		jabatanPegawai.setPegawai(pegawai);
		jabatanPegawaiService.addJabatanPegawai(jabatanPegawai);
		
		model.addAttribute("nip", pegawai.getNip());
		model.addAttribute("success", "ditambahkan");
		return "success";
	}
	 */
}
