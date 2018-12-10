package com.apap.tugasakhir.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apap.tugasakhir.model.DokterModel;
import com.apap.tugasakhir.model.PasienModel;
import com.apap.tugasakhir.model.PenangananModel;
import com.apap.tugasakhir.wrapper.GetDokterWrapper;
import com.apap.tugasakhir.wrapper.GetJenisPemeriksaanWrapper;
import com.apap.tugasakhir.wrapper.GetPasienIdWrapper;
import com.apap.tugasakhir.wrapper.GetPasienWrapper;
import com.apap.tugasakhir.wrapper.PostLaboratoriumWrapper;

@Service
public class webService {
	
	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	//consumer Dokter SI Appointment
		public List<DokterModel> getAllDokter() {
			String path = Setting.siAppointment+"/getAllDokter";
			List<DokterModel> returnList = restTemplate.getForEntity(path, GetDokterWrapper.class).getBody().getResult();
			return returnList;
		}
		
		public DokterModel getDokterId(long id) {
			String path = Setting.siAppointmentJadwal+"/getDokter/"+id;
			DokterModel dokter = restTemplate.getForEntity(path, DokterModel.class).getBody();
			return dokter;
		}
		
		//consumer Pasien SI Appointment
		public List<PasienModel> getAllPasien() {
			String path = Setting.siAppointment+"/getAllPasien";
			List<PasienModel> returnList = restTemplate.getForEntity(path, GetPasienWrapper.class).getBody().getResult();
			return returnList;
		}
		
		public List<PasienModel> getPasienList(long[] id) {
			String path = Setting.siAppointment+"/getPasien?listId=";
			for (long i :id) {
				path+=i+",";
			}
			List<PasienModel> returnList = restTemplate.getForEntity(path, GetPasienWrapper.class).getBody().getResult();
			return returnList;
		}
		
		public PasienModel getPasien(long id) {
			String path = Setting.getPasien+id;
			GetPasienIdWrapper pasien = restTemplate.getForEntity(path, GetPasienIdWrapper.class).getBody();
			return pasien.getResult();
		}
		
		public String updatePasien(PasienModel pasien) {
			String path = Setting.siAppointment+"updatePasien/";
			String str = restTemplate.postForEntity(path, pasien, String.class).getBody();
			return str;
		}

		//post to si laboratorium 
		public String postLaboratoriumRequest(PenangananModel req) {
			PostLaboratoriumWrapper obj = new PostLaboratoriumWrapper();
			obj.setIdPasien(req.getIdPasienRawatJalan());
			GetJenisPemeriksaanWrapper jenis = new GetJenisPemeriksaanWrapper();
			jenis.setId(req.getJenisPemeriksaan());
			obj.setJenisPemeriksaan(jenis);
			obj.setTanggalPengajuan(req.getWaktu());
			String path =Setting.postLab;
			String str = restTemplate.postForEntity(path, req, String.class).getBody();
			System.out.println("SUCCESS");
			return str;
		}
		
		//get pasien rawat jalan
		public List<PasienModel> getAllPasienRawatJalan() {
			String path = Setting.siAppointment+"/getAllPasienRawatJalan/";
			List<PasienModel> returnList = restTemplate.getForEntity(path, GetPasienWrapper.class).getBody().getResult();
			return returnList;
		}
}