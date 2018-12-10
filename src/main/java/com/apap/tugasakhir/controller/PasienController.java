package com.apap.tugasakhir.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.apap.tugasakhir.model.JadwalPoliModel;
import com.apap.tugasakhir.model.PasienModel;
import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.PoliService;
import com.apap.tugasakhir.service.RujukanRawatJalanService;

@Controller
public class PasienController {
	@Autowired
	webService web;
	
	@Autowired
	private RujukanRawatJalanService rujukanService;
	
	@Autowired
	private PoliService poliService;
	
	String[] listStatusPasien = new String[] {"Mendaftar Poli", "Berada di Poli", "Selesai"};
	
	@RequestMapping(value = "/rawat-jalan/pasien", method = RequestMethod.GET)
	private String viewPasienRawatJalan(Model model) {
		List<PasienModel> draftPasien = web.getAllPasienRawatJalan();
		for (PasienModel pasien : draftPasien) {
			if (rujukanService.getRujukanByIdPasienAndTanggalRujukan(pasien.getId(), pasien.getTanggalRujukan()) == null && pasien.getStatusPasien().getId() > 6) {
				RujukanRawatJalanModel newRujukan = new RujukanRawatJalanModel();
				System.out.println("ID: "+pasien.getStatusPasien().getId());
				newRujukan.setStatus((int)pasien.getStatusPasien().getId()-(int)7);
				System.out.println(newRujukan.getStatus()+pasien.getNama());
				newRujukan.setPasien(pasien.getId());
				newRujukan.setNama(pasien.getNama());
				long selisih = Integer.MAX_VALUE;
				JadwalPoliModel poli = new JadwalPoliModel();
				//for (JadwalPoliModel jadwal:polidb.findById(pasien.getPoliRujukan().getId()).getDaftarJadwalPoli()) {
				for (JadwalPoliModel jadwal : poliService.getPoliById(pasien.getPoliRujukan().getId()).getDaftarJadwalPoli()) {
					long sub = jadwal.getTanggal().getTime() - pasien.getTanggalRujukan().getTime();
					if (sub < selisih) {
						selisih = sub;
						poli = jadwal;
					}
				}
				newRujukan.setTanggalRujuk(pasien.getTanggalRujukan());
				newRujukan.setJadwalPoli(poli);
				rujukanService.saveRujukan(newRujukan);
			}
		}
		model.addAttribute("statusPasien",listStatusPasien);
		model.addAttribute("listRujukan",rujukanService.listRujukan());
		return "view-pasien";
	}	
	
	@RequestMapping (value = "/rawat-jalan/pasien/ubah", method = RequestMethod.GET)
	private String updateStatusPasien(Model model, @RequestParam String idPasien,@RequestParam String idRujukan) {
		long id = Integer.parseInt(idPasien);
		long idR = Integer.parseInt(idRujukan);
		
		RujukanRawatJalanModel rujukan = rujukanService.getRujukanById(idR);
		if(rujukan.getStatus() < 2) {
			rujukan.setStatus(rujukan.getStatus() + 1);
		
		List<PasienModel> draftPasien = web.getAllPasienRawatJalan();
		  for (PasienModel pasien : draftPasien) {
		   if (pasien.getId() == id) {
			   pasien.getStatusPasien().setId(rujukan.getStatus()+6);
			   System.out.println(web.updatePasien(pasien));
			   break;
		   }
		  }
		}
		model.addAttribute("listRujukan",rujukanService.listRujukan());
		return "update-status-success";
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