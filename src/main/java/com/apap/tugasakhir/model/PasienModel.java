package com.apap.tugasakhir.model;

import java.io.Serializable;


public class PasienModel implements Serializable {	

	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}


	private String nama;
	
	private StatusPasienModel statusPasien;
	
	private PoliRujukanModel poliRujukan;

}
